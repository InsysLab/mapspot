package map.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import map.domain.AdminUser;

@Repository
public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {
	
	@Query("select count(u) from AdminUser u where u.username = :username")
	public long countByUsername(@Param("username") String username);

}
