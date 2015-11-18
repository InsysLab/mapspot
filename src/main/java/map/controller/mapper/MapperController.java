package map.controller.mapper;

import java.security.Principal;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

import map.domain.User;
import map.domain.Map;
import map.domain.MapVisit;
import map.domain.MapSpot;
import map.service.MapService;
import map.service.MapSpotService;
import map.service.UserService;
import map.service.MapVisitService;

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
	@Autowired
	MapVisitService mapVisitService;
	
	@RequestMapping(value={"create-map"}, method = RequestMethod.GET)
	public String createMap(Model model, HttpSession session, Principal principal){
		User user = userService.findUserByUsername(principal.getName());
		
		Map map = new Map();
		map.setCreator(user);
		map.setIsBlocked(false);
		map.setIsPublished(true);
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
	public String viewPublicMap(@PathVariable("mapId") Integer mapId, Model model, HttpServletRequest request){
		Map map = mapService.findMap(mapId);
		
		if( map == null || map.getIsBlocked() || ! map.getIsPublished() ){
			return "mapper/errorMap";
		} else {
			
			MapVisit visit = new MapVisit();
			visit.setMap(map);
			visit.setIpAddress(request.getRemoteAddr());
			mapVisitService.save(visit);
			
			model.addAttribute("map", map);
			model.addAttribute("spots", map.getSpots());
			
			return "mapper/viewPublicMap";
		}
	}
	
}
