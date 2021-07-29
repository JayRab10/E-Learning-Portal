package com.amdocs.training.Controller;

import java.util.List;

import com.amdocs.training.dao.implementation.AdminDAOImpl;
import com.amdocs.training.models.Admin;

public class AdminController {

	public static void main(String[] args) {
		
		AdminDAOImpl adminDAO = new AdminDAOImpl();
		
		// find all admin
		//List<Admin> admins = adminDAO.findAll();
		//adminDAO.print(admins);
		
		// add admin
		//Admin admin = new Admin(3,"Jayendra Sthapak","jayendrasthapak@gmail.com","god123");
		//adminDAO.addAdmin(admin);
		
		// get admin by id
		//Admin admin = adminDAO.getAdminById(3);
		//System.out.println(admin.toString());
		
		// delete admin 
		//adminDAO.deleteAdmin(3);
		
		//update admin
		//Admin admin = new Admin(2,"Jayendra Sthapak","jayendrasthapak@gmail.com","god123");
		//adminDAO.updateAdmin(admin);
		
	}

}
