package map.repository;

import org.springframework.data.repository.CrudRepository;
import map.domain.Map;

public interface MapRepository extends  CrudRepository<Map, Integer>{

}
