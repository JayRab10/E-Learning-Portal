package com.amdocs.training.Controller;

import java.sql.SQLException;
import java.util.List;

import com.amdocs.training.dao.implementation.UserDAOImpl;
import com.amdocs.training.models.User;

public class UserController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDAOImpl  userDAO = new UserDAOImpl();
		
		// Testing of FindAll Method (working fine)
		//List<User> users = userDAO.findAll();
		//userDAO.print(users);
		
		//Testing of addUser (working fine)
		//User user = new User(103, "Gulshan Patel","amdocs123",new Date(2021,07,20) ,8120349022L, "abc@gmail.com", null, "patna");
		//userDAO.addUser(user);
		
		//// Testing of getUserById (working fine)
		User user = userDAO.getUserById(103);
		System.out.println(user.toString());
		
		//Testing of deleteUser(Working Fine)
		//for(int i=101;i<=109;i++)
			//userDAO.deleteUser(i);
		//
		
		// Testing of updateUser (working fine)
		//User user = new User(103, "Golu","12345",new Date(2021,07,20) ,8120349022L, "abc@gmail.com", null, "patna");
		//userDAO.updateUser(user);
		
	}
}
