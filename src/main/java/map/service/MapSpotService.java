package map.service;

import java.util.List;

import map.domain.MapSpot;

public interface MapSpotService {
	public List<MapSpot> getAll();
	
	public MapSpot save(MapSpot d);
	
	public MapSpot findMapSpot(Integer Id);
	
	public void deleteMapSpotById(Integer Id);	
}
