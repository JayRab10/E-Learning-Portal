
package com.amdocs.training.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.dao.implementation.CourseDAOImpl;
import com.amdocs.training.models.Course;

@Controller
public class CourseController {

	CourseDAO courseDAO = new CourseDAOImpl();

	@GetMapping("/course-list")
	public String usersPage(Model model) {

		List<Course> courseList = courseDAO.findAll();
		model.addAttribute("list", courseList);
		return "courses";
	}

	@GetMapping("/addCourse")
	public String addCourseForm(Model model) {
		model.addAttribute("course", new Course(333, "C", "Objective", 299L, "Drive:D"));
		return "add-course";
	}

	@PostMapping("/registerCourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		courseDAO.addCourse(course);
		return "redirect:/course-list";
	}

	@GetMapping("/delete-course/{id}")
	public String deleteCourse(@PathVariable("id") int id) {
		courseDAO.deleteCourse(id);
		return "redirect:/course-list";
	}

	@GetMapping("/update-course/{id}")
	public String updateCourseForm(@PathVariable("id") int id, Model model) {
		Course course = courseDAO.getCourseById(id);
		model.addAttribute("course", course);
		return "update-course";
	}

	@PostMapping("/update-course")
	public String updateUser(@ModelAttribute("user") Course course) {
		courseDAO.updateCourse(course);
		return "redirect:/course-list";
	}

}
