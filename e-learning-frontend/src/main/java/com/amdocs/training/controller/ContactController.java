
package com.amdocs.training.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.dao.implementation.ContactDAOImpl;
import com.amdocs.training.models.Contact;

@Controller
public class ContactController {

	ContactDAO contactDAO = new ContactDAOImpl();

	@GetMapping("/contact-list")
	public String contactPage(Model model) {

		List<Contact> contactList = contactDAO.findAll();
		model.addAttribute("list", contactList);
		return "contacts";
	}

	@GetMapping("/addContact")
	public String addContactForm(Model model) {
		model.addAttribute("contact", new Contact(1001, 101, "Jayendra", "jay@gmail.com", 8120221033L, "I am facing Issues"));
		return "add-contact";
	}

	@PostMapping("/registerContact")
	public String addContact(@ModelAttribute("contact") Contact contact) {
		contactDAO.addContact(contact);
		return "redirect:/contact-list";
	}

	@GetMapping("/delete-contact/{id}")
	public String deleteContact(@PathVariable("id") int id) {
		contactDAO.deleteContact(id);
		return "redirect:/contact-list";
	}

	@GetMapping("/update-contact/{id}")
	public String updateContactForm(@PathVariable("id") int id, Model model) {
		Contact contact = contactDAO.getContactById(id);
		model.addAttribute("contact", contact);
		return "update-contact";
	}

	@PostMapping("/update-contact")
	public String updateContact(@ModelAttribute("contact") Contact contact) {
		contactDAO.updateContact(contact);
		return "redirect:/contact-list";
	}

}
