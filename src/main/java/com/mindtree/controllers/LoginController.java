package com.mindtree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.dto.User;
import com.mindtree.service.LoginService;
import com.mindtree.serviceimpl.LoginServiceImpl;

@Controller
public class LoginController {

	@Autowired
	LoginService loginServiceImpl ;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String handleFalseRequset()
	{
		return "Cannot Login...Wrong Credentials";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ResponseBody
	public String registerUser(@RequestParam String userName, @RequestParam String password)
	{	
		loginServiceImpl.saveUser(new User(userName, password));
		return "New User Registered";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	//@ResponseBody
	public String handleLogin(@RequestParam String user, @RequestParam String pass) {
		/**
		 * This method handles the 
		 * login authentication for the application.
		 * @author Dhruv Bajpai
		 * @version 1.0
		 * @return String returns the object.
		 */
		//loginServiceImpl = new LoginServiceImpl();
		// loginServiceImpl.saveUser(username.trim(), password.trim());
		String output;
		List<User> userList = (List<User>) loginServiceImpl.getUser(user.trim(), pass.trim());
		if (userList.isEmpty()) {
			output =  "User does not exist";
			System.out.println("FAiled Authentication");
			return "fail";
		} else {
			String username = userList.get(0).getUserName();
			String password = userList.get(0).getPassword();
			output = "Authenticated User..Congrats..!!.\n\n" + "Username" + user + " Password:" + pass;
			return "main";
		}
		/*if(loginServiceImpl==null)
		*/
		//loginServiceImpl =  new LoginServiceImpl();
	//	loginServiceImpl.saveUser(user, pass);
		//return "main";
		// String output = "User:"+username +" Pass: "+ password;
		//out.println("<html>" + output + "</html>");
		//return "login successfull" + user + "  " + pass;
		//return output;
		
	}
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}
	

}
