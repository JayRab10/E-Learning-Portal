package com.amdocs.training.models;

public class Contact {
	private int contactID;
	private int userID;
	private String userName;
	private String email;
	private long phone;
	private String message;
	
	public Contact(int contactID, int userID, String userName, String email, long phone, String message) {
		super();
		this.contactID = contactID;
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.message = message;
	}

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact [contactID=" + contactID + ", userID=" + userID + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", message=" + message + "]";
	}
	
	
	
}
