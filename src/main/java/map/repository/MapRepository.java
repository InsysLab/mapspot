package map.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import map.domain.Map;

@Repository
public interface MapRepository extends  CrudRepository<Map, Integer>{

}
