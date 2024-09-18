package com.facebook.services;
import java.util.List;

import com.facebook.entities.Post;
public interface PostService 
{
	public void createPost(Post po);
	public List<Post> getAllPosts();
}
