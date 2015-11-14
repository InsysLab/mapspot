package map.repository;

import org.springframework.data.repository.CrudRepository;

import map.domain.AdminUser;

public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {

}
