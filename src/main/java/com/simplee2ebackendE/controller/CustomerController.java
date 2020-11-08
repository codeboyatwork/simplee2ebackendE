package com.simplee2ebackendE.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplee2ebackendE.exception.ResourceNotFoundException;
import com.simplee2ebackendE.model.Customer;
import com.simplee2ebackendE.repository.CustomerRepository;

import io.swagger.annotations.Api;

@RestController 
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@Api
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	@GetMapping(value="/customers", produces={"application/json"})
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	@GetMapping(value="/customers/{id}", produces={"application/json"})
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable(value = "id") Long customerId)
  
	{
		Optional<Customer> customer = customerRepository.findById(customerId);
        return ResponseEntity.ok().body(customer);
    }
	
	@PostMapping("/customers")
    public Customer createCustomer( @RequestBody Customer customer) {
        return customerRepository.save(customer);
        
    }
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
         @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        
        customer.setAddress(customerDetails.getAddress());
        customer.setCreditLimit(customerDetails.getCreditLimit());
        customer.setName(customerDetails.getName());
        customer.setWebsite(customerDetails.getWebsite());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
	
	@DeleteMapping("/customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
         throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
       .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
