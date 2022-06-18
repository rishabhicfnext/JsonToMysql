package com.jsontomysql.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsontomysql.contact.model.Contact;
import com.jsontomysql.contact.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	public Iterable<Contact> list(){
		return contactRepository.findAll();
	}

	public Contact save(Contact contacts) {
		return contactRepository.save(contacts);
	}

	public Iterable<Contact> save(List<Contact> contacts) {
		return contactRepository.saveAll(contacts);
	}

}