package com.facebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.entities.User;
import com.facebook.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	UserRepository usrepo;

	@Override
	public void addUser(User us) 
	{
		usrepo.save(us);
	}

	@Override
	public boolean userExists(String username, String email) 
	{
		User u1=usrepo.findByEmail(email);
		User u2=usrepo.findByUsername(username);
		if(u1!=null || u2!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean validate(String username, String password) 
	{
		String dbusername=usrepo.findByUsername(username).getUsername();
		String dbpassword=usrepo.findByUsername(username).getPassword();
		if(password.equals(dbpassword) && username.equals(dbusername))
		{
			return true;
		}
		return false;
	}
}
