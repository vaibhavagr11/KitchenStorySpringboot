package com.User.User.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User.User.Entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

    User findByEmail(String email);

}
