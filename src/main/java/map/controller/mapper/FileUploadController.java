package map.controller.mapper;

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

import map.domain.File;
import map.controller.validator.FileValidator;

@Controller
public class FileUploadController{
	
	@Autowired
	FileValidator validator;

//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

	@RequestMapping(value="upload", method = RequestMethod.GET)
	public String getForm(Model model) {
		File fileModel = new File();
		model.addAttribute("file", fileModel);
		return "mapper/create";
	}

	@RequestMapping(value="upload", method = RequestMethod.POST)
	public String fileUploaded(Model model, File file) {

		MultipartFile multipartFile = file.getFile();

		return "redirect: mapper/edit";
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
