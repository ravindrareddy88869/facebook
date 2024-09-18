package com.facebook.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.entities.User;
import com.facebook.services.UserService;
@Controller
public class UserController 
{
	@Autowired
	UserService usserv;
	
	@PostMapping("signup")
	public String addUser(@ModelAttribute User us)
	{
		String username=us.getUsername();
		String email=us.getEmail();
		boolean status=usserv.userExists(username,email);
		if(status==false)
		{
			usserv.addUser(us);
		}
		return "index";
	}
	@PostMapping("login")
	public String login(@RequestParam String username,@RequestParam String password)
	{
		boolean status=usserv.validate(username,password);
		if(status==true)
		{
			return "home";
		}
		return "index";
	}
}
