package com.facebook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.facebook.entities.Post;
import com.facebook.services.PostService;
@Controller
public class PostController 
{
	@Autowired
	PostService poserv;
	@PostMapping("createpost")
	public String createPost(@RequestParam("caption") String caption,@RequestParam("photo") MultipartFile photo)
	{
		Post post=new Post();
		post.setCaption(caption);
		try
		{
			post.setPhoto(photo.getBytes());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		poserv.createPost(post);
		return "home";
	}
	@GetMapping("showposts")
	public String showposts(Model model)
	{
		List<Post> posts=poserv.getAllPosts();
		model.addAttribute("posts",posts);
		return "newsfeed";
	}
}