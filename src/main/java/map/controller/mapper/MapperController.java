package map.controller.mapper;

import java.util.List;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.security.Principal;

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
import org.springframework.web.bind.annotation.RequestBody;
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

import map.domain.User;
import map.domain.Map;
import map.domain.MapSpot;
import map.service.MapService;
import map.service.MapSpotService;
import map.service.UserService;

@Controller
public class MapperController {

	@Autowired
	MapService mapService;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	MapSpotService mapSpotService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"map-list"}, method = RequestMethod.GET)
	public String userMaps( Model model, Principal principal){
		User user = userService.findUserByUsername(principal.getName());
		List<Map> mapList = mapService.findMapByUserId(user.getPersonId());
		
		model.addAttribute("maps", mapList);
		return "mapper/mapList";
	}
	
	@RequestMapping(value={"create-map"}, method = RequestMethod.GET)
	public String createMap(Model model, HttpSession session, Principal principal){
		User user = userService.findUserByUsername(principal.getName());
		
		Map map = new Map();
		map.setCreator(user);
		map = mapService.save(map);
		
		session.setAttribute("map", map.getMapId());		
		return "redirect:map-upload"; 
	}
	
	@RequestMapping(value="map-edit/{id}", method = RequestMethod.GET)
	public String editMap(@PathVariable("id") Integer mapId, Model model){
		Map map = mapService.findMap(mapId);
		model.addAttribute("map", map);
		model.addAttribute("spots", map.getSpots());
		return "mapper/editmap";
	}

	@ResponseBody
	@RequestMapping(value="update-map/{mapId}", method=RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map updateMap(@PathVariable("mapId") Integer mapId, @RequestBody Map m) {
		Map map = mapService.findMap(mapId);
		
		map.setDescription(m.getDescription());
		mapService.save(map);
		map.setSpots(null);
		
		return map;
    }	
	
	@ResponseBody
	@RequestMapping(value="create-spot/{mapId}", method=RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public MapSpot createMapSpot(@PathVariable("mapId") Integer mapId, @RequestBody MapSpot spot) {
		Map map = mapService.findMap(mapId);
		
		spot.setMap(map);
		spot = mapSpotService.save(spot);
		spot.setMap(null);
		
		return spot;
    }
		
	@RequestMapping(value="view-map/{mapId}", method=RequestMethod.GET)
	public String viewPublicMap(@PathVariable("mapId") Integer mapId, Model model){
		Map map = mapService.findMap(mapId);
		model.addAttribute("map", map);
		model.addAttribute("spots", map.getSpots());
		
		return "mapper/viewPublicMap";
	}
}
