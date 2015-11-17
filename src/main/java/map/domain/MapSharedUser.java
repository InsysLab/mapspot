package map.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="map_shared_user")
public class MapSharedUser {
	@Id
	@GeneratedValue
	private int msId;
	
	@ManyToOne
	@JoinColumn(name="map_id")	
	private Map map;
	
	@ManyToOne
	@JoinColumn(name="user_id")	
	private User user;
	
	@ManyToOne
	@JoinColumn(name="creator_id")		
	private User creator;

	public MapSharedUser(){}
	
	public MapSharedUser(Map map, User user, User creator){
		this.map = map;
		this.user = user;
		this.creator = creator;
	}
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}
