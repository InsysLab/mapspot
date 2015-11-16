package map.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
public class User extends Person {
	@OneToMany(cascade = CascadeType.ALL)	
	@JoinColumn(name = "map_id")
	private List<Map> maps = new ArrayList<Map>();

	public User() {
		this.setRole(Role.ROLE_USER);
		this.setEnabled(true);
	}

	public User(String name, String photo, Date birth, String username, String password) {
		this.setName(name);
		this.setPhoto(photo);
		this.setDateOfBirth(birth);
		this.setUsername(username);
		this.setPassword(password);
	}

	public List<Map> getMaps() {
		return maps;
	}

	public void setMaps(List<Map> maps) {
		this.maps = maps;
	}

	

}
