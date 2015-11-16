package map.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import map.domain.MapSpot;

@Repository
public interface MapSpotRepository extends CrudRepository<MapSpot, Integer>{
	
}
