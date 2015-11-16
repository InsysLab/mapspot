package map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import map.domain.Map;

@Repository
public interface MapRepository extends  CrudRepository<Map, Integer>{

	@Query("SELECT m FROM Map m WHERE m.creator = :userId")
	List<Map> findMapByCreator(@Param(value = "userId") Integer userId);
	
}
