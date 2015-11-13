package map.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Map {

	@Id
	@GeneratedValue	
	private int id;
	
	private String description;
	private String permalink;
	private Boolean isPublic;
	private Boolean isBlocked;
	
	private List<User> users = new ArrayList<User>();
	private List<Comment> comments = new ArrayList<Comment>();
	private List<MapSpot> spots = new ArrayList<MapSpot>();
	
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public Boolean getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public void addComment(Comment comment){
		this.comments.add(comment);
	}
	public void addUser(User user){
		this.users.add(user);
	}
	public List<MapSpot> getSpots() {
		return spots;
	}
	public void setSpots(List<MapSpot> spots) {
		this.spots = spots;
	}
	public void addSpot(MapSpot spot){
		this.spots.add(spot);
	}
}
