package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.models.Course;


public interface CourseDAO {
	
	List<Course> findAll();
	
	Course getCourseById(int courseId);
	
	boolean addCourse(Course course);
	
	boolean deleteCourse(int courseId);
	
	boolean updateCourse(Course course);
	

}
