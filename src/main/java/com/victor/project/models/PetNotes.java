package com.victor.project.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetNotes {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDate petNote;
	
	@NotEmpty
	String petNotes;
	
	@ManyToOne
	private Pet pet;
	
	@OneToOne	
	private Appointment appointment;
	
}
