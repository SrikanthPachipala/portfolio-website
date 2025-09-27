package com.example.service;

import java.util.List;

import com.example.model.Contact;

public interface ContactService {
	Contact saveContact(Contact contact);
    List<Contact> getAllContacts();
}
