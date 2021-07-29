package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.models.Contact;

public interface ContactDAO {

	List<Contact> findAll();

	boolean addContact(Contact contact);

	Contact getContactById(Integer id);

	boolean deleteContact(Integer id);
	
	boolean updateContact(Contact contact);
	
}
