package map.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import map.service.MapSpotService;
import map.domain.MapSpot;
import map.repository.MapSpotRepository;

/*
 * @author Mark Pit
 */
@Service
@Transactional
public class MapSpotServiceImpl implements MapSpotService{
	
	@Autowired
	MapSpotRepository mapSpotRepository;
	
	public List<MapSpot> getAll(){
		return (List<MapSpot>) mapSpotRepository.findAll();
	}
	
	public MapSpot save(MapSpot spot){
		return mapSpotRepository.save(spot);
	}
	
	public MapSpot findMapSpot(Integer Id){
		return mapSpotRepository.findOne(Id);
	}
	
	public void deleteMapSpotById(Integer Id){
		MapSpot spot = mapSpotRepository.findOne(Id);
		spot.setMap(null);
		mapSpotRepository.delete(spot);
	}
}
