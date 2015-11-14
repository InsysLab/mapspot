package map.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="map_visit")
public class MapVisit {
	@Id
	@GeneratedValue
	public int id;
	
	@Column(name="ip_address")
	public String ipAddress;
	
	@ManyToOne
	@JoinColumn(name="map_id")
	public Map map;
	
	@Column(name="date_visited")
	@Temporal(TemporalType.DATE)
	public Date dateVisited;
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getDateVisited() {
		return dateVisited;
	}
	public void setDateVisited(Date dateVisited) {
		this.dateVisited = dateVisited;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
}
