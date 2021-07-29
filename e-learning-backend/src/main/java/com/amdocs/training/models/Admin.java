package com.amdocs.training.models;

public class Admin {

	private int adminID;
	private String adminName;
	private String password;
	private String email;
	
	public Admin(int adminID, String adminName, String password, String email) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.password = password;
		this.email = email;
	}
	
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminName=" + adminName + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	
}
