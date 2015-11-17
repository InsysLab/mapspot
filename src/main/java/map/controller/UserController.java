package map.controller;

import java.security.Principal;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import map.domain.Map;
import map.domain.User;
import map.domain.MapSharedUser;
import map.domain.Comment;
import map.service.MapService;
import map.service.UserService;
import map.service.MapSharedUserService;
import map.service.MapCommentService;

@Controller
public class UserController {

	@Autowired
	MapService mapService;	
	@Autowired
	UserService userService;	
	@Autowired
	MapSharedUserService mapSharedUserService;
	@Autowired
	MapCommentService mapCommentService;
	
	@RequestMapping(value={"map-list"}, method = RequestMethod.GET)
	public String userMaps( Model model, Principal principal, HttpServletRequest request){
		User user = userService.findUserByUsername(principal.getName());
		List<Map> mapList = mapService.findMapByUserId(user.getPersonId());
		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		
		List<MapSharedUser> sharedMapUsers = mapSharedUserService.findMapSharedUsersByUserId(user.getPersonId());
		
		model.addAttribute("maps", mapList);
		model.addAttribute("sharedMaps", sharedMapUsers);
		model.addAttribute("baseUrl", baseUrl);
		
		return "mapList";
	}	
	
	@RequestMapping(value="delete-map/{mapId}", method=RequestMethod.GET)
	public String deleteMap(@PathVariable("mapId") Integer mapId){
		Map map = mapService.findMap(mapId);
		mapService.deleteMapById(map.getMapId());
		
		return "redirect:/map-list";
	}
	
	@RequestMapping(value="publish-map/{mapId}", method=RequestMethod.GET)
	public String publishMap(@PathVariable("mapId") Integer mapId){
		Map map = mapService.findMap(mapId);
		map.setIsPublished(true);
		mapService.save(map);
		
		return "redirect:/map-list";
	}	
	
	@RequestMapping(value="unpublish-map/{mapId}", method=RequestMethod.GET)
	public String unpublishMap(@PathVariable("mapId") Integer mapId){
		Map map = mapService.findMap(mapId);
		map.setIsPublished(false);
		mapService.save(map);
		
		return "redirect:/map-list";
	}		
	
	@RequestMapping(value="block-map/{mapId}", method=RequestMethod.GET)
	public String blockMap(@PathVariable("mapId") Integer mapId){
		Map map = mapService.findMap(mapId);
		map.setIsBlocked(true);
		mapService.save(map);
		
		return "redirect:/map-list";
	}	
	
	@RequestMapping(value="unblock-map/{mapId}", method=RequestMethod.GET)
	public String unblockMap(@PathVariable("mapId") Integer mapId){
		Map map = mapService.findMap(mapId);
		map.setIsBlocked(false);
		mapService.save(map);
		
		return "redirect:/map-list";
	}			
	
	@RequestMapping(value="share-map/{mapId}", method=RequestMethod.GET)
	public String shareMap(@PathVariable("mapId") Integer mapId, Model model, Principal principal){
		User user = userService.findUserByUsername(principal.getName());
		model.addAttribute("cUser", user);
		
		Map map = mapService.findMap(mapId);
		model.addAttribute("map", map);
		
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		
		return "shareMap";
	}	
	
	@RequestMapping(value="share-map/{mapId}", method=RequestMethod.POST)
	public String saveMapUsers(@PathVariable("mapId") Integer mapId, HttpServletRequest request, Model model, Principal principal){
		Map map = mapService.findMap(mapId);
		User creator = userService.findUserByUsername(principal.getName());
		String[] users = request.getParameterValues("users");
		
		if( users.length > 0 ){
			User user;
			for(int i = 0; i < users.length; i++){
				user = userService.findUser(Integer.parseInt(users[i]));
				mapSharedUserService.save(new MapSharedUser(map, user, creator));
			}
		}
		
		return "redirect:/map-list";
	}
	
	@RequestMapping(value="map-comments/{mapId}", method=RequestMethod.GET)
	public String mapComments(@PathVariable("mapId") Integer mapId, Model model, Principal principal){
		Map map = mapService.findMap(mapId);
		List<Comment> comments = mapCommentService.findCommentsByMapId(mapId);
		
		model.addAttribute("map", map);
		model.addAttribute("comments", comments);
		
		return "mapComments";
	}

	@RequestMapping(value="map-comments/{mapId}", method=RequestMethod.POST)
	public String saveComments(@PathVariable("mapId") Integer mapId, HttpServletRequest request, Model model, Principal principal){
		String commentText = request.getParameter("comment");

		if( ! commentText.isEmpty() ){
			Comment comment = new Comment();
			comment.setCommentText(commentText);
			comment.setMap(mapService.findMap(mapId));
			comment.setUser(userService.findUserByUsername(principal.getName()));
			mapCommentService.save(comment);
		}
		
		return "redirect:/map-comments/" + mapId;
	}
}