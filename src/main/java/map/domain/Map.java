package map.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

@Entity
public class Map {

	@Id
	@GeneratedValue	
	@Column(name="id")
	private int mapId;
	
	private String description;
	private String permalink;
	private String photo;
	
	@Transient
	private int visits;
	
	@Column(name="published")
	private Boolean isPublished;
	
	@Column(name="blocked")
	private Boolean isBlocked;
	
	@OneToMany(mappedBy="map", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<MapSpot> spots = new ArrayList<MapSpot>();

	@OneToMany(mappedBy="map", cascade=CascadeType.ALL)
	private List<Comment> comments = new ArrayList<Comment>();

	@ManyToOne
	@JoinColumn(name="creator")
	private User creator;
	
	@Column(name="date_created")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	@PrePersist
	protected void onCreate() {
	    this.dateCreated = new Date();
	}
	
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
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

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}
	
}
