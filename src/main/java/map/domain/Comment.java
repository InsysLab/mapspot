package map.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.JoinColumn;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int commentId;
	
	@Column(name="comment")
	private String commentText;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="map_id")
	private Map map;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Person user;
	
	@Column(name="date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@PrePersist
	protected void onCreate() {
	    this.dateCreated = new Date();
	}	
	
	public Comment(){}
	
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Person getUser() {
		return user;
	}
	public void setUser(Person user) {
		this.user = user;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
