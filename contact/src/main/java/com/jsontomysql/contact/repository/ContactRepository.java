package com.jsontomysql.contact.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jsontomysql.contact.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
