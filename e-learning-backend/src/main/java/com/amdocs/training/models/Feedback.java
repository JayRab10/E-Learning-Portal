package com.amdocs.training.models;

public class Feedback {

	private int feedbackID;
	private int userID;
	private String userName;
	private String email;
	private String feedbackMessage;
	
	public Feedback(int feedbackID, int userID, String userName, String email, String feedbackMessage) {
		super();
		this.feedbackID = feedbackID;
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.feedbackMessage = feedbackMessage;
	}
	
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
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
	public String getFeedbackMessage() {
		return feedbackMessage;
	}
	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}
	
	@Override
	public String toString() {
		return "Feedback [feedbackID=" + feedbackID + ", userID=" + userID + ", userName=" + userName + ", email="
				+ email + ", feedbackMessage=" + feedbackMessage + "]";
	}
	
	
	
}
