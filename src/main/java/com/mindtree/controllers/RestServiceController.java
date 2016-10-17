package com.mindtree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.dto.User;
import com.mindtree.service.LoginService;

/*import org.springframework.web.bind.annotation.*;*/

@RestController
public class RestServiceController {
	
	@Autowired
	LoginService loginServiceImpl ;

	@RequestMapping(value= "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@RequestBody User user)
	{
		//System.out.println(user);
		loginServiceImpl.saveUser(user);
		//return user.toString();
		return new ResponseEntity(user,HttpStatus.OK);
	}
	
	@RequestMapping(value= "/tester", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String test(@RequestBody User user)
	{
		//System.out.println(user);
		loginServiceImpl.saveUser(user);
		//return user.toString();
		System.out.println(user);
		return "data:hello";
	}
	
	
	
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}
	
	

}
