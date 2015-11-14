package map.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue(value="admin")
public class AdminUser extends User{
	
	public AdminUser(){
		this.setRole(Role.ROLE_ADMIN);
	}

}
