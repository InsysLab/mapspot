package map.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import map.domain.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Integer>{

}
