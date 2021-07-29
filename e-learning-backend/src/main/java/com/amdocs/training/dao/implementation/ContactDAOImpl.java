package com.amdocs.training.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.db.DatabaseConnection;
import com.amdocs.training.models.Contact;
import com.amdocs.training.models.User;

public class ContactDAOImpl implements ContactDAO {

	private Statement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;

	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = new ArrayList<>();
		String sql = "select * from contact";

		try {
			conn = DatabaseConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		int contactId = 0;
		int userId = 0;
		String userName = null;
		Long phone = null;
		String email = null;
		String message = null;

		try {
			while (rs.next()) {

				contactId = rs.getInt("contact_id");
				userId = rs.getInt("user_id");
				userName = rs.getString("user_name");
				phone = rs.getLong("phone");
				email = rs.getString("email");
				message = rs.getString("message");

				Contact contact = new Contact(contactId, userId, userName, email, phone, message);
				contacts.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contacts;
	}

	@Override
	public boolean addContact(Contact contact) {

		String sql = "insert into contact (contact_id,user_id,user_name,email,phone,message) values (?,?,?,?,?,?) ";

		int executeUpdate = 0;
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, contact.getContactID());
			ps.setInt(2, contact.getUserID());
			ps.setString(3, contact.getUserName());
			ps.setString(4, contact.getEmail());
			ps.setLong(5, contact.getPhone());
			ps.setString(6, contact.getMessage());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (executeUpdate > 0) {
			System.out.println("Contact Inserted Successfully!");
			return true;
		} else
			System.out.println("Opps , please try again!");

		return false;

	}

	@Override
	public Contact getContactById(Integer id) {
		String sql = "select * from contact where contact_id = ? ";
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		int contactId = 0;
		int userId = 0;
		String userName = null;
		Long phone = null;
		String email = null;
		String message = null;

		try {
			if (rs.next()) {

				contactId = rs.getInt("contact_id");
				userId = rs.getInt("user_id");
				userName = rs.getString("user_name");
				phone = rs.getLong("phone");
				email = rs.getString("email");
				message = rs.getString("message");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Contact(contactId, userId, userName, email, phone, message);

	}

	@Override
	public boolean deleteContact(Integer id) {
		String sql = "delete from contact where contact_id = ? ";
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
			System.out.println("Contact Deleted Succesfully!");
		}
		else
			System.out.println("try Again!");
		
		return false;
	}

	@Override
	public boolean updateContact(Contact contact) {
		String sql = "update contact set user_id = ?, user_name = ? , email = ? , phone = ? , message = ?  where contact_id = ?";
		int executeUpdate = 0;
		
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, contact.getUserID());
			ps.setString(2, contact.getUserName());
			ps.setString(3, contact.getEmail());
			ps.setLong(4, contact.getPhone());
			ps.setString(5, contact.getMessage());
			ps.setInt(6, contact.getContactID());
			executeUpdate = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(executeUpdate > 0) {
			System.out.println("Contact Updated Succesfully!!");
		}
		else
			System.out.println("try Again!");
		
		return false;
	}

	public void print(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}

}
