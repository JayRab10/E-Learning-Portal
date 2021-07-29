package com.amdocs.training.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.implementation.AdminDAOImpl;
import com.amdocs.training.models.Admin;

@Controller
public class AdminController {

	AdminDAO adminDAO = new AdminDAOImpl();
	
//	@GetMapping("/login-admin")
//	public String AdminLoginForm(Model model) {
//		model.addAttribute("adminlogin", new AdminLogin());
//		return "login-admin";
//	}
	
//	 @PostMapping(value = "/admin-loginProcess")
//	  public String loginProcess(@ModelAttribute("adminlogin") AdminLogin al) {
//	    Admin admin = adminDAO.validateAdmin(al);
////	    if (null != admin) {	    	
////			return "admin-welcome";
////	    } else {
////	    	return "redirect:/login-admin";
////	    }
//		 return "admin-welcome";
//	  }
	
	 
	@GetMapping("/admin-list")
	public String adminPage(Model model) {

		List<Admin> adminList = adminDAO.findAll();
		model.addAttribute("list", adminList);
		return "admin";
	}

	@GetMapping("/addAdmin")
	public String addAdminForm(Model model) {
		model.addAttribute("admin", new Admin(0, "", "", ""));
		return "add-admin";
	}

	@PostMapping("/admin-register")
	public String addAdmin(@ModelAttribute("admin") Admin a) {
		adminDAO.addAdmin(a);
		return "redirect:/admin-list";
	}

	@GetMapping("/delete-admin/{id}")
	public String deleteAdmin(@PathVariable("id") Integer id) {
		adminDAO.deleteAdmin(id);
		return "redirect:/admin-list";
	}

	@GetMapping("/update-admin/{id}")
	public String updateAdminForm(@PathVariable("id") Integer id, Model model) {
		Admin admin = adminDAO.getAdminById(id);
		model.addAttribute("admin", admin);
		return "update-admin";
	}

	@PostMapping("/update-admin")
	public String updateAdmin(@ModelAttribute("admin") Admin admin) {
		adminDAO.updateAdmin(admin);
		return "redirect:/admin-list";
	}

}
