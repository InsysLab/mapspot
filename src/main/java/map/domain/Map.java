package map.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;

@Entity
public class Map {

	@Id
	@GeneratedValue	
	private int id;
	
	private String description;
	private String permalink;
	
	@Column(name="public")
	private Boolean isPublic;
	
	@Column(name="blocked")
	private Boolean isBlocked;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="map_id")
	private List<MapSpot> spots = new ArrayList<MapSpot>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="map_id")
	private List<Comment> comments = new ArrayList<Comment>();

    @ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="shared_map_user", joinColumns=@JoinColumn(name="map_id"), inverseJoinColumns=@JoinColumn(name="user_id")) 
	private List<User> sharedUsers = new ArrayList<User>();
	
	@ManyToOne
	@JoinColumn(name="creator")
	private User creator;
	
	@Column(name="date_created")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public List<User> getSharedUsers() {
		return sharedUsers;
	}
	public void setSharedUsers(List<User> users) {
		this.sharedUsers = users;
	}
	public void addSharedUser(User user){
		this.sharedUsers.add(user);
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
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
