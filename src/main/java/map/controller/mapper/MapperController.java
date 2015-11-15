package map.controller.mapper;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import map.domain.Map;
import map.service.MapService;

@Controller
public class MapperController {

	@Autowired
	MapService mapService;

	public void userMaps() {
	}

	@RequestMapping(value = { "create-map" }, method = RequestMethod.GET)
	public String createMap() {
		return "redirect:map-upload";
	}

	@RequestMapping(value = "map-edit", method = RequestMethod.GET)
	public String editMap(Model model) {

		return "mapper/editmap";
	}

	@RequestMapping(value = "/mapblock/{id}", method = RequestMethod.POST)
	public String blockMap(@PathVariable("id") int id) {
		Map map = mapService.findMap(id);
		map.setIsBlocked(true);
		mapService.save(map);
		return "/admin/maps";
	}

}
