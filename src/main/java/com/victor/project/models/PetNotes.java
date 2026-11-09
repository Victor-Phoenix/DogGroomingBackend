package com.victor.project.models;

import java.time.LocalDate;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

public class PetNotes {

	private LocalDate petNote;
	
	@NotEmpty
	String petNotes;
	
	@ManyToOne
	private Pet pet;
	
}
