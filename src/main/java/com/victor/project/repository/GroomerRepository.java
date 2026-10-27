package com.victor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.project.models.Groomer;

public interface GroomerRepository extends JpaRepository<Groomer, Long>{
	
}
