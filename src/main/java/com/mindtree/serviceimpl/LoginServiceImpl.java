package com.mindtree.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.dao.Dao;
import com.mindtree.dto.Point;
import com.mindtree.dto.User;
import com.mindtree.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Autowired
	Dao daoObject;
	@Override
	public void Login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveUser(User user) {
		
		// TODO Auto-generated method stub
		//User user = new User(username, pass);
		/*if(daoObject==null)
		daoObject = new Dao();*/
		daoObject.saveUser(user);
		//user.getListPoints().add(new Point(12.23,123.5));
		//user.getListPoints().add(new Point(78.34,67.34));
		
		//Dao daoObject = new Dao();
	
		// DAO LAYER HAS TO BE NON STATIC
		// make it non static..
		// make a dao service
		// make

	}

	public List<User> getUser(String username, String password)
	{
		
		List<User> users = (List<User>) daoObject.getUserByEmailAndPassword(username, password);
		return users;
	}

	public void setDaoObject(Dao daoObject) {
		this.daoObject = daoObject;
	}

	@Override
	public void addMessage(String message) {
		// TODO Auto-generated method stub
		daoObject.addMessage(message);
	}
	
	

}