package com.example.jerseryspring.persistence;


public interface UserDao extends Dao<User>{

	User findByUserName(String username);
	
}
