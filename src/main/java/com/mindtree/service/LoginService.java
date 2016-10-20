package com.mindtree.service;

import java.util.List;

import com.mindtree.dto.User;

public interface LoginService {
	
	public void Login();
	public List<User> getUser(String user,String pass);
	public void saveUser(User user);
	public void addMessage(String message);

}
