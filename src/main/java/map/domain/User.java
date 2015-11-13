package map.domain;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;

@Entity
public class User extends Person{

	private Role role;

	private List<Map> maps = new ArrayList<Map>();
	
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
