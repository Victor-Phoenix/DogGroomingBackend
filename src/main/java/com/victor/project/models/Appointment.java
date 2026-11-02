package com.victor.project.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Groomer groomer;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Pet pet;
	
	@ManyToOne
	private GroomingPackage groomingPackage;
	
/*
 * TODO: Create own validation to make sure it is a valid Date. 
 * https://jakarta.ee/learn/docs/jakartaee-tutorial/current/beanvalidation/bean-validation-advanced/bean-validation-advanced.html
 */
	@NotNull
	private LocalDateTime localDateTime;
}
