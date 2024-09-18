package com.facebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facebook.entities.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	public User findByEmail(String email);
	public User findByUsername(String email);
}
