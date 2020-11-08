package com.simplee2ebackendE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplee2ebackendE.exception.ResourceNotFoundException;
import com.simplee2ebackendE.model.Contact;
import com.simplee2ebackendE.repository.ContactRepository;

import io.swagger.annotations.Api;

@RestController 
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@Api
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	@GetMapping(value="/contacts", produces={"application/json"})
	public List<Contact> getAllContacts()
	{
		return contactRepository.findAll();
	}
	@GetMapping(value="/contacts/{id}", produces={"application/json"})
    public ResponseEntity<Contact> getContactById(@PathVariable(value = "id") Long contactId) throws ResourceNotFoundException
  
	{
		Contact contact = contactRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));;
        return ResponseEntity.ok().body(contact);
    }
}
