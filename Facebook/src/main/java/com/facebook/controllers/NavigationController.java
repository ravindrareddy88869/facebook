package com.facebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavigationController 
{
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	@GetMapping("signup")
	public String signup()
	{
		return"signup";
	}
	@GetMapping("createpost")
	public String createPost()
	{
		return "createpost";
	}
}