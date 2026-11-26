package com.victor.project.models;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@NotNull
//	TODO Create enum for current state of appointment. Booked, confirmed, in-service, canceled, reffed out
	private AppointmentEnum appointmentStatus;
	
	@ManyToOne
	private Groomer groomer;
	
	@ManyToOne
	@JsonBackReference
	private Customer customer;
	
	@ManyToOne
	private Pet pet;
	
	@OneToMany
	private Set<AppointmentLineItem> appointmentLineItem;
	
/*
 * TODO: Create own validation to make sure it is a valid Date. 
 * https://jakarta.ee/learn/docs/jakartaee-tutorial/current/beanvalidation/bean-validation-advanced/bean-validation-advanced.html
 */
	@NotNull
	private LocalDateTime localDateTime;

}
