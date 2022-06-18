package com.jsontomysql.contact;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsontomysql.contact.model.Contact;
import com.jsontomysql.contact.service.ContactService;

@SpringBootApplication
public class ContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactService contactService) {
		return args -> {
			// read json to write db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Contact>> typeReference = new TypeReference<List<Contact>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/contacts.json");
			try {
				List<Contact> contacts = mapper.readValue(inputStream, typeReference);
				contactService.save(contacts);
				System.out.println("Contacts Saved to the database !!");
				
			} catch (IOException e) {
				System.out.println("Unable to save Contacts : "+e.getMessage());
			}
		};
	}

}