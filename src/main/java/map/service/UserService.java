package map.service;

import java.util.List;
import map.domain.User;

public interface UserService {
	public List<User> getAll();
	
	public void save(User d);
	
	public User findUser(Integer Id);
	
	public void deleteUserById(Integer Id);
	
	public long getUserByUsername(String username);
}
