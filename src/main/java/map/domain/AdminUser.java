package map.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue(value = "admin")
public class AdminUser extends Person {

	public AdminUser() {
		this.setRole(Role.ROLE_ADMIN);
		this.setEnabled(true);
	}

	public AdminUser(String name, String photo, Date birth, String username, String password) {
		this.setName(name);
		this.setPhoto(photo);
		this.setDateOfBirth(birth);
		this.setUsername(username);
		this.setPassword(password);
	}

}
