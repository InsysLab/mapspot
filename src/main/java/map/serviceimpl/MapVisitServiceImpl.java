package map.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import map.service.MapVisitService;
import map.domain.MapVisit;
import map.repository.MapVisitRepository;

@Service
@Transactional
public class MapVisitServiceImpl implements MapVisitService{
	
	@Autowired
	MapVisitRepository mapVisitRepository;

	public MapVisit save(MapVisit visit){
		return mapVisitRepository.save(visit);
	}
	
	public List<MapVisit> findMapVisitsByMapId(Integer mapId){
		return mapVisitRepository.findMapVisitsByMapId(mapId);
	}
}
