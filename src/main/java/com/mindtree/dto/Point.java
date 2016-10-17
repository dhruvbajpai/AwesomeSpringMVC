package com.mindtree.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Point {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pId;
	double latitude;
	double longitude;
	@ManyToOne
	private User user;
	public Point()
	{
		
	}
	
	
	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Point(int pId, double latitude, double longitude) {
		super();
		this.pId = pId;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public Point(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
		

}
