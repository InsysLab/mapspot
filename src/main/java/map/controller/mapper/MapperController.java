package map.controller.mapper;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapperController {

	public void userMaps(){}
	
	@RequestMapping(value={"create-map"}, method = RequestMethod.GET)
	public String createMap(){
		return "redirect:map-upload"; 
	}
	
	@RequestMapping(value="map-edit", method = RequestMethod.GET)
	public String editMap(Model model){

		return "mapper/editmap";
	}
	
}
