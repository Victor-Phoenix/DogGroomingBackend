package com.victor.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.project.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public List<Customer>findDistinctByPhoneNumber(String phoneNumber);
	public Boolean findByPhoneNumber(String phoneNumber);
	
}
