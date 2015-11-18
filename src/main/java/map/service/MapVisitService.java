package map.service;

import java.util.List;

import map.domain.MapVisit;

public interface MapVisitService {
	
	public MapVisit save(MapVisit v);
	
	public List<MapVisit> findMapVisitsByMapId(Integer mapId);

}
