package map.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
@DiscriminatorValue(value="normal")
public class User extends Person{

	private String username;
	private String password;
	private Role role;
	
    @OneToMany(cascade=CascadeType.ALL)  
    @JoinColumn(name="map_id")
	private List<Map> maps = new ArrayList<Map>();

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

	public List<Map> getMaps() {
		return maps;
	}

	public void setMaps(List<Map> maps) {
		this.maps = maps;
	}
	
}
