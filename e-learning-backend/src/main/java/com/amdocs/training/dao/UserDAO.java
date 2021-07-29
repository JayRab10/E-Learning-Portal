package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.models.User;

public interface UserDAO {

	List<User> findAll();

	boolean addUser(User user);

	User getUserById(Integer id);

	boolean deleteUser(Integer id);
	
	boolean updateUser(User user);
}
