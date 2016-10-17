package com.mindtree.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
// why are we going with javax instead of hibernate.annotation
@Entity(name="User")
//@Table(name="Users") table and Entitiy is different
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="pass")
	private String password;
//	@OneToMany
//	private Collection<Point> listPoints;
	@Transient // this wont be added to the table
	private int notAdded;
	
	//@Embedded , @Embeddeable
	//Use @AttributeOverrides({@AttributeOverride(name="street",column=
	//@Column(name="HOME_STREET_NAME"))})
	public User()
	{
		
	}
	
	
	public User(int userId, String userName, String password/*, Collection<Point> listPoints*/, int notAdded) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		//this.listPoints = listPoints;
		this.notAdded = notAdded;
		
	}


	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		//listPoints = new ArrayList<Point>();
		
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString()
	{
		return "Username: "+ userName + " Password: " + password;
	}
//	public Collection<Point> getListPoints() {
//		return listPoints;
//	}
//	public void setListPoints(ArrayList<Point> listPoints) {
//		this.listPoints = listPoints;
//	}
	

}
