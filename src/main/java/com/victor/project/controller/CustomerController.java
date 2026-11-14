package com.victor.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victor.project.models.Customer;
import com.victor.project.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomer() {
		return customerService.findAllCustomer();
	}
	@GetMapping("/getByEmail")
	public Boolean getByEmail(@RequestParam String email){
		return customerService.findByEmail(email);
	}
	
}
