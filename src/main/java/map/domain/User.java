package map.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User extends Person{

	private String username;
	private String password;
	private Role role;

	public User(){
		this.role = Role.ROLE_USER;
	}
	
	public User(String name, String photo, Date birth, String username, String password){
		this.setName(name);
		this.setPhoto(photo);
		this.setDateOfBirth(birth);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
