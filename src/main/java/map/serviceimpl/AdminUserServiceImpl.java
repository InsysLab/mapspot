package map.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import map.domain.AdminUser;
import map.repository.AdminUserRepository;
import map.service.AdminUserService;
import map.utils.Utility;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserRepository repository;

	@Override
	public List<AdminUser> getAll() {
		// TODO Auto-generated method stub
		return (List<AdminUser>) repository.findAll();
	}

	@Override
	public void save(AdminUser user) {
		String encodedPassword = Utility.hashPassword(user.getPassword()); 
		user.setPassword(encodedPassword); 

		repository.save(user);
	}

	@Override
	public AdminUser findUser(Integer id) {
		// TODO Auto-generated method stub
		return (AdminUser) repository.findOne(id);
	}

	@Override
	public void deleteUserById(Integer id) {
		repository.delete(repository.findOne(id));
	}
	
	@Override
	public long getUserByUsername(String username){
		return repository.countByUsername(username);
	}

}
