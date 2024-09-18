package com.facebook.services;
import com.facebook.entities.User;
public interface UserService 
{
	public void addUser(User us);
	public boolean userExists(String username,String email);
	public boolean validate(String username,String password);
}
