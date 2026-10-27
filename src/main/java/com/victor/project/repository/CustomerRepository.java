package com.victor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.project.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
