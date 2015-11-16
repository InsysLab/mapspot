package map.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import map.domain.User;
import map.repository.UserRepository;
import map.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;	
	
	public List<User> getAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public void save(User user){
		userRepository.save(user);
	}
	
	public User findUser(Integer Id){
		return userRepository.findOne(Id);
	}
	
	public void deleteUserById(Integer Id){
		User user = userRepository.findOne(Id);
		userRepository.delete(user);
	}
	
	public long getUserCountByUsername(String username){
		System.out.println("print");
		return userRepository.countByUsername(username);
	}
	
	public User findUserByUsername(String username){
		return userRepository.findUserByUsername(username);
	}	
}
