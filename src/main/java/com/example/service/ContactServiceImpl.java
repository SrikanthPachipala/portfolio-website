package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Contact;
import com.example.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private final ContactRepository contactRepo;

    public ContactServiceImpl(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }
}
