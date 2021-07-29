package com.amdocs.training.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.db.DatabaseConnection;
import com.amdocs.training.models.Admin;
import com.amdocs.training.models.User;

public class AdminDAOImpl implements AdminDAO {
	
	private Statement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;

	@Override
	public List<Admin> findAll() {
		List<Admin> admins = new ArrayList<>();
		String sql = "select * from admin";
		
		try {
			 conn = DatabaseConnection.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		int adminId = 0;
		String adminName = null;
		String email = null;
		String adminPassword = null;
		
		try {
			while (rs.next()) {
				
				adminId = rs.getInt("admin_id");
				adminName = rs.getString("admin_name");
				email = rs.getString("email");
				adminPassword = rs.getString("admin_password");
				
				Admin admin = new Admin(adminId,adminName,adminPassword,email);
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return admins;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		String sql = "insert into admin values (?,?,?,?)";
		
		int executeUpdate = 0;
		try {
			 conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,admin.getAdminID());
			ps.setString(2,admin.getAdminName());
			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getPassword());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(executeUpdate > 0) {
			System.out.println("Admin Inserted Successfully!");
			return true;
			}
		else
			System.out.println("Opps , please try again!");
		
		return false;

	}

	@Override
	public Admin getAdminById(Integer id) {
		String sql = "select * from admin where admin_id = ? ";
		try {
			 conn = DatabaseConnection.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 rs = ps.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
		int adminId = 0;
		String adminName = null;
		String email = null;
		String adminPassword = null;
		
		try {
			if (rs.next()) {
				
				adminId = rs.getInt("admin_id");
				adminName = rs.getString("admin_name");
				email = rs.getString("email");
				adminPassword = rs.getString("admin_password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Admin(adminId,adminName,adminPassword,email);
	}

	@Override
	public boolean deleteAdmin(Integer id) {
		String sql = "delete from admin where admin_id = ? ";
		int executeUpdate = 0;
		try {
			 conn = DatabaseConnection.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 executeUpdate = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if(executeUpdate > 0) {
			System.out.println("Admin Deleted Succesfully!");
		}
		else
			System.out.println("try Again!");
		
		return false;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		String sql = "update admin set admin_name = ?, email = ? , admin_password = ? where admin_id = ?";
		int executeUpdate = 0;
		
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,admin.getAdminName());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getPassword());
			ps.setInt(4,admin.getAdminID());
			executeUpdate = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(executeUpdate > 0) {
			System.out.println("Admin Updated Succesfully!!");
		}
		else
			System.out.println("try Again!");
		
		return false;
	}
	
	public void print(List<Admin> admins) {
		for(Admin admin : admins) {
			System.out.println(admin.toString());
		}
	}

}
