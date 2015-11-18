package map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import map.domain.MapVisit;

@Repository
public interface MapVisitRepository extends  CrudRepository<MapVisit, Integer>{

	@Query("SELECT v FROM MapVisit v WHERE v.map.mapId = :mapId")
	List<MapVisit> findMapVisitsByMapId(@Param(value = "mapId") Integer mapId);

}
