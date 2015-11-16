package map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.*;
import map.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select count(u) from User u where u.username = :username")
	public long countByUsername(@Param("username") String username);
	
	@Query("select u from User u where u.username =:username")
	User findUserByUsername(@Param("username") String username);
	
}
