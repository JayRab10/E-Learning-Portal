package com.amdocs.training.models;

public class Course {
	
	private int courseId;
	private String courseName;
	private String courseDescription;
	private Long courseFees;
	private String courseResource;
	
	public Course(int courseId, String courseName, String courseDescription, Long courseFees, String courseResource) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseFees = courseFees;
		this.courseResource = courseResource;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Long getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(Long courseFees) {
		this.courseFees = courseFees;
	}

	public String getCourseResource() {
		return courseResource;
	}

	public void setCourseResource(String courseResource) {
		this.courseResource = courseResource;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", courseFees=" + courseFees + ", courseResource=" + courseResource + "]";
	}
	

}
