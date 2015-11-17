package map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.*;
import map.domain.MapSharedUser;

@Repository
public interface MapSharedUserRepository extends CrudRepository<MapSharedUser, Integer> {

	@Query("SELECT DISTINCT m FROM MapSharedUser m WHERE m.user.personId =:userId")
	List<MapSharedUser> findMapSharedUsersByUserId(@Param("userId") Integer userId);
	
}
