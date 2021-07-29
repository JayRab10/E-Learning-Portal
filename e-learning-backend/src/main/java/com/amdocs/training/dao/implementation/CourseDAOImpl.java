package com.amdocs.training.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.db.DatabaseConnection;
import com.amdocs.training.models.Course;
import com.amdocs.training.models.User;

public class CourseDAOImpl implements CourseDAO{
	
	private Statement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;

	@Override
	public List<Course> findAll()  {
		
		List<Course> courses = new ArrayList<>();
		String sql = "select * from course";
		try {
			conn = DatabaseConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		int courseId = 0;
		String courseName=null;
		String courseDescription = null;
		Long courseFees = 0L;
		String courseResource = null;
		
		
		try {
			while(rs.next()) {
				courseId = rs.getInt("course_id");
				courseName = rs.getString("course_name");
				courseDescription = rs.getString("course_description");
				courseFees = rs.getLong("course_fees");
				courseResource = rs.getString("course_resource");
				
				Course course = new Course(courseId , courseName,courseDescription,courseFees,courseResource);
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return courses;
	}

	@Override
	public Course getCourseById(int id) {

		String sql = "select * from course where course_id = ? ";
		try {
			 conn = DatabaseConnection.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 rs = ps.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		int courseId = 0;
		String courseName=null;
		String courseDescription = null;
		Long courseFees = 0L;
		String courseResource = null;
		
		
		try {
			if(rs.next()) {
				courseId = rs.getInt("course_id");
				courseName = rs.getString("course_name");
				courseDescription = rs.getString("course_description");
				courseFees = rs.getLong("course_fees");
				courseResource = rs.getString("course_resource");
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Course(courseId , courseName,courseDescription,courseFees,courseResource);
		
	}

	@Override
	public boolean addCourse(Course course) {
		
		String sql = "insert into course (COURSE_ID,COURSE_NAME,COURSE_DESCRIPTION,COURSE_FEES,COURSE_RESOURCE) values (?,?,?,?,?) ";
		
		int executeUpdate = 0;
		try {
			 conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,course.getCourseId());
			ps.setString(2,course.getCourseName());
			ps.setString(3, course.getCourseDescription());
			ps.setLong(4, course.getCourseFees());
			ps.setString(5,course.getCourseResource());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(executeUpdate > 0) {
			System.out.println("Course Inserted Successfully!");
			return true;
			}
		else
			System.out.println("Opps , please try again!");
		
		return false;
	}

	@Override
	public boolean deleteCourse(int id) {
		
		String sql = "delete from course where course_id = ? ";
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
			System.out.println("Course Deleted Succesfully!");
		}
		else
			System.out.println("try Again!");
		
		return false;
	}

	@Override
	public boolean updateCourse(Course course) {
		String sql = "update course set course_name = ?, course_description = ? , course_fees = ? , course_resource = ?  where course_id = ?";
		int executeUpdate = 0;
		
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,course.getCourseName());
			ps.setString(2, course.getCourseDescription());
			ps.setLong(3, course.getCourseFees());
			ps.setString(4,course.getCourseResource());
			ps.setInt(5,course.getCourseId());
			executeUpdate = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(executeUpdate > 0) {
			System.out.println("Course Updated Succesfully!!");
		}
		else
			System.out.println("try Again!");
		
		return false;
	}
	
	public void print(List<Course> courses) {
		for(Course course : courses) {
			System.out.println(course.toString());
		}
	}

}
