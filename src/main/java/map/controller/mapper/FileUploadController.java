package map.controller.mapper;
 
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import map.domain.FileUpload;
import map.controller.validator.FileValidator;

@Controller
public class FileUploadController{
	
	@Autowired
	FileValidator validator;

//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

	@RequestMapping(value="map-upload", method = RequestMethod.GET)
	public String getForm(Model model) {
		FileUpload fileModel = new FileUpload();
		model.addAttribute("file", fileModel);
		return "mapper/create";
	}

	@RequestMapping(value="map-upload", method = RequestMethod.POST)
	public String fileUploaded(Model model, FileUpload file, RedirectAttributes redirectAttrs) {

		MultipartFile multipartFile = file.getFile();
		String fileName = multipartFile.getOriginalFilename();
		String location = "C:/mapspot/1/";
		File newDir = new File(location);
		location = newDir.getPath() + "/" + fileName;
		
		try{
			if( ! newDir.exists() ){			
				if( newDir.mkdir() ){
					multipartFile.transferTo(new File(location));
				}
			} else {
				multipartFile.transferTo(new File(location));  	
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		redirectAttrs.addAttribute("filePath", location);
		
		return "redirect:map-edit";
	}	
	
//	public String fileUploaded(Model model, @Validated File file, BindingResult result) {
//
//		String returnVal = "redirect: mapper/edit";
//		if (result.hasErrors()) {
//			returnVal = "upload";
//		} else {			
//			MultipartFile multipartFile = file.getFile();
//		}
//		return returnVal;
//	}
	
}
