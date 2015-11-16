package map.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import map.domain.AdminUser;

@Repository
public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {

}
