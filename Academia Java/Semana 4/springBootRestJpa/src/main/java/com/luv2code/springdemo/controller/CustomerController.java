package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/rest")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/pilots")
	public List<Customer> findAll() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/pilots/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) throws Exception {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new Exception("Customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	
	@PostMapping("/pilots")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
			
		theCustomer.setId(0);
		
		Customer addCustomer = customerService.saveCustomer(theCustomer);
		
		return addCustomer;
	}
	
	@PutMapping("/pilots")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		Customer Customer = customerService.saveCustomer(theCustomer);
		
		return Customer;
	}
	
	@DeleteMapping("/pilots/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempEmployee = customerService.getCustomer(customerId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id - " + customerId;
	}
	
	
}










