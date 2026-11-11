package com.victor.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.project.models.Customer;
import com.victor.project.repository.CustomerRepository;


@Service
public class CustomerService {
	
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		
	}
	
	public List<Customer> findAllCustomer(){
		return customerRepository.findAll();
	}
	
	
	
	
}
