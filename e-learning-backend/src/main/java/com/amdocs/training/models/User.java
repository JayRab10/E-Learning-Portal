package com.amdocs.training.models;

import java.sql.Date;

public class User {

	private Integer userID;
	private String userName;
	private String password;
	private String dateRegister;
	private Long phoneNumber;
	private String email;
	private String userPhoto;
	private String address;
	public User(Integer userID, String userName, String password, String dateRegister, Long phoneNumber, String email,
			String userPhoto, String address) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.dateRegister = dateRegister;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userPhoto = userPhoto;
		this.address = address;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", dateRegister="
				+ dateRegister + ", phoneNumber=" + phoneNumber + ", email=" + email + ", userPhoto=" + userPhoto
				+ ", address=" + address + "]";
	}
	
	
	
	
}
