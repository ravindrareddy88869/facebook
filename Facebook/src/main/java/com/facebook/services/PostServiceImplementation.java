package com.facebook.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.entities.Post;
import com.facebook.repositories.PostRepository;
@Service
public class PostServiceImplementation implements PostService
{
	@Autowired
	PostRepository porepo;

	@Override
	public void createPost(Post po) 
	{
		porepo.save(po);
	}

	@Override
	public List<Post> getAllPosts() 
	{
		List<Post> posts=porepo.findAll();
		return posts;
	}
}
