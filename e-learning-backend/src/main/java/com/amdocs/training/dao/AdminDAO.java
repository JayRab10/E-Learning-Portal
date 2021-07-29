package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.models.Admin;

public interface AdminDAO {
	
	List<Admin> findAll();

	boolean addAdmin(Admin admin);

	Admin getAdminById(Integer id);

	boolean deleteAdmin(Integer id);
	
	boolean updateAdmin(Admin admin);

}
