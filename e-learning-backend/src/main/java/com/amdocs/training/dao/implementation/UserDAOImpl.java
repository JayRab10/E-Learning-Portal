package com.amdocs.training.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.db.DatabaseConnection;
import com.amdocs.training.models.User;

public class UserDAOImpl implements UserDAO{

	private Statement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		String sql = "select * from user";
		
		try {
			 conn = DatabaseConnection.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		int id = 0;
		String name = null;
		String password = null;
		String date = null;
		Long phone = null;
		String email = null;
		String photo = null;
		String address = null;
		
		try {
			while (rs.next()) {
				
					id = rs.getInt("user_id");
					name = rs.getString("user_name");
					password = rs.getString("user_password");
					date = rs.getString("date_register");
					phone = rs.getLong("phone");
					email = rs.getString("email");
					photo = rs.getString("photo");
					address = rs.getString("address");
				
				User user = new User(id,name,password,date,phone,email,photo,address);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	
	@Override
	public boolean addUser(User user) {
		
		String sql = "insert into user (USER_NAME,USER_PASSWORD,DATE_REGISTER,PHONE,EMAIL,PHOTO,ADDRESS) values (?,?,?,?,?,?,?) ";
		
		int executeUpdate = 0;
		try {
			 conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getPassword());
			ps.setString(3, user.getDateRegister());
			ps.setLong(4, user.getPhoneNumber());
			ps.setString(5,user.getEmail());
			ps.setString(6, user.getUserPhoto());
			ps.setString(7, user.getAddress());
			
			
			executeUpdate = ps.executeUpdate();
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(executeUpdate > 0) {
			System.out.println("User Inserted Successfully!");
			return true;
			}
		else
			System.out.println("Opps , please try again!");
		
		return false;
	}

	@Override
	public User getUserById(Integer id) {
		
		String sql = "select * from user where user_id = ? ";
		try {
			 conn = DatabaseConnection.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 rs = ps.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
		int Id = 0;
		String name = null;
		String password = null;
		String date = null;
		Long phone = null;
		String email = null;
		String photo = null;
		String address = null;
		try {
			if(rs.next()) {
				Id = rs.getInt("user_id");
				name = rs.getString("user_name");
				password = rs.getString("user_password");
				date = rs.getString("date_register");
				phone = rs.getLong("phone");
				email = rs.getString("email");
				photo = rs.getString("photo");
				address = rs.getString("address");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new User(Id,name,password,date,phone,email,photo,address);
	}

	@Override
	public boolean deleteUser(Integer id) {
		String sql = "delete from user where user_id = ? ";
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
			System.out.println("Deleted Succesfully!");
		}
		else
			System.out.println("try Again!");
		
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update user set user_name = ?, user_password = ? , date_register = ? , phone = ? , email = ? , photo = ? , address = ?  where user_id = ?";
		int executeUpdate = 0;
		
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getDateRegister());
			ps.setLong(4, user.getPhoneNumber());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getUserPhoto());
			ps.setString(7, user.getAddress());
			ps.setInt(8, user.getUserID());
			executeUpdate = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(executeUpdate > 0) {
			System.out.println("User Updated Succesfully!!");
		}
		else
			System.out.println("try Again!");
		
		return false;
	}
	
	public void print(List<User> users) {
		for(User user : users) {
			System.out.println(user.toString());
		}
	}
	 
}
