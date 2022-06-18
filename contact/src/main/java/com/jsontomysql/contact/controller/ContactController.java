package com.jsontomysql.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsontomysql.contact.model.Contact;
import com.jsontomysql.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/list")
	public Iterable<Contact> list() {
		return contactService.list();
	}

}