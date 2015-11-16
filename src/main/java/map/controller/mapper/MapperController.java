package map.controller.mapper;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.apache.commons.io.IOUtils;

import map.domain.Map;
import map.service.MapService;

@Controller
public class MapperController {

	@Autowired
	MapService mapService;
	
	@Autowired
	ServletContext servletContext;
	
	public void userMaps(){}
	
	@RequestMapping(value={"create-map"}, method = RequestMethod.GET)
	public String createMap(Model model, HttpSession session){
		Map map = new Map();
		map = mapService.save(map);
		session.setAttribute("map", map.getMapId());		
		return "redirect:map-upload"; 
	}
	
	@RequestMapping(value="map-edit/{id}", method = RequestMethod.GET)
	public String editMap(@PathVariable("id") Integer mapId, Model model, HttpSession session){
		Map map = mapService.findMap(mapId);
		model.addAttribute("map", map);
		return "mapper/editmap";
	}

}
