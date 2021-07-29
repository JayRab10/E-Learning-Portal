package com.amdocs.training.Controller;

import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.implementation.CourseDAOImpl;
import com.amdocs.training.models.Course;

public class CourseController {
	
	public static void main(String[] args) {
		
		CourseDAOImpl courseDAO = new CourseDAOImpl();
		List<Course> courses = new ArrayList<>();
		
		// Get All Course
		courses = courseDAO.findAll();
		courseDAO.print(courses);
		
		// get user by id
		//Course course = courseDAO.getCourseById(112);
		//System.out.println(course.toString());
		
		
		// add course
		//Course course = new Course(113,"Python","ML and AI",999L,"videos");
		//courseDAO.addCourse(course);
		
		// delete course
		//courseDAO.deleteCourse(112);
		
		// update course
		//Course course = new Course(111,"C++","Objective",799L,"videos");
		//courseDAO.updateCourse(course);
	}
	
}
