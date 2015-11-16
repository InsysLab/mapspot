package map.controller.mapper;
 
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import map.domain.FileUpload;
import map.controller.validator.FileValidator;

import map.domain.Map;
import map.service.MapService;

@Controller
public class FileUploadController{

	@Autowired
	MapService mapService;
	
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
	public String fileUploaded(FileUpload file, HttpSession session) {
		
		MultipartFile multipartFile = file.getFile();
		String fileName = multipartFile.getOriginalFilename();
		String location = "C:/mapspot/" + session.getAttribute("map") + "/";
		File newDir = new File(location);
		location = newDir.getPath() + "/" + fileName;
		
		try{
			if( ! newDir.exists() ){			
				if( newDir.mkdir() ){
					//TODO: convert to PNG
					multipartFile.transferTo(new File(location));
				}
			} else {
				multipartFile.transferTo(new File(location));  	
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		Map map = mapService.findMap((Integer)session.getAttribute("map"));
		map.setPhoto(fileName);
		mapService.save(map);
		
		return "redirect:map-edit/" + session.getAttribute("map");
	}	
	
	@ResponseBody	
	@RequestMapping(value = "/map-image/{mapId}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage(@PathVariable("mapId") Integer mapId, HttpServletRequest request)  throws Exception {
		Map map = mapService.findMap(mapId);
		Path path = Paths.get("C:/mapspot/" + mapId + "/" + map.getPhoto());
		byte[] data = Files.readAllBytes(path); 
		return data;
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
