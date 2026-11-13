package com.victor.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.project.exception.CustomerException;
import com.victor.project.models.Customer;
import com.victor.project.repository.CustomerRepository;


@Service
public class CustomerService {
	
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		
	}
	
	public List<Customer> findAllCustomer(){
		
		return customerRepository.findAll();
	}
	
	public Customer saveCustomer(Customer customer) {

		if( customerRepository.findByPhoneNumber(customer.getPhoneNumber()) != null) {
			throw new CustomerException("Duplciate found");
		}else {
			return customerRepository.save(customer);
		}
		
	}
	public List<Customer> findByPhoneNumber(String phoneNumber) {
		List<Customer>test = customerRepository.findDistinctByPhoneNumber(phoneNumber);
		test.size();
		
		
	}
	
	
}
