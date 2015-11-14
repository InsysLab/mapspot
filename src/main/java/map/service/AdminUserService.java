package map.service;

import java.util.List;

import map.domain.AdminUser;

public interface AdminUserService {
	public List<AdminUser> getAll();

	public void save(AdminUser user);

	public AdminUser findUser(Integer Id);

	public void deleteUserById(Integer Id);
}
