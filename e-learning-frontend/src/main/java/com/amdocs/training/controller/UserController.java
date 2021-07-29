package com.amdocs.training.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.implementation.UserDAOImpl;
import com.amdocs.training.models.User;

@Controller
public class UserController {

	UserDAO userDAO = new UserDAOImpl();

	@GetMapping("/user-list")
	public String usersPage(Model model) {

		List<User> userList = userDAO.findAll();
		
//		List<User> userList = new ArrayList<>();
//		User user = new User(101, "Jay", "12345", "12/02/2021", 1033L, "jayendra@gmail.com", "C:jat.png", "Bhopal");
//	userList.add(user);
		model.addAttribute("list", userList);
		return "users";
	}

	@GetMapping("/addUser")
	public String addUserForm(Model model) {
		model.addAttribute("user", new User(0,"your name","12345","01/01/2021",0L,"abc@gmail.com","C:","Address"));
		return "add-user";
	}

	@PostMapping("/register")
	public String addUser(@ModelAttribute("user") User u) {
		userDAO.addUser(u);
		return "redirect:/user-list";
	}

	@GetMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userDAO.deleteUser(id);
		return "redirect:/user-list";
	}

	@GetMapping("/update-user/{id}")
	public String updateUserForm(@PathVariable("id") int id, Model model) {
		User user = userDAO.getUserById(id);
		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("/update-user")
	public String updateUser(@ModelAttribute("user") User user) {
		userDAO.updateUser(user);
		return "redirect:/user-list";
	}

}
