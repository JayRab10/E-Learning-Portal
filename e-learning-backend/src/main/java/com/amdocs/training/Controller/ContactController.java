package com.amdocs.training.Controller;

import java.util.List;

import com.amdocs.training.dao.implementation.ContactDAOImpl;
import com.amdocs.training.models.Contact;

public class ContactController {

	public static void main(String[] args) {
		
		ContactDAOImpl contactDAO = new ContactDAOImpl();
		
		// findall
		//List<Contact> contacts =  contactDAO.findAll();
		//contactDAO.print(contacts);
		
		
		// add contact
		//Contact contact = new Contact(3,101,"Aayush","aayush333@gmail.com",9584361274L,"Impressive");
		//contactDAO.addContact(contact);
		
		//get contact by id
		//Contact contact = contactDAO.getContactById(1);
		//System.out.println(contact.toString());
		
		// delete contact
		//contactDAO.deleteContact(1);
		
		// contact update
		//Contact contact = new Contact(2,101,"Aayush","aayush333@gmail.com",9584361274L,"worst");
		//contactDAO.updateContact(contact);
		

	}

}
