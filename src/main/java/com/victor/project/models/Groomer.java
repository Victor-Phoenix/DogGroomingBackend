package com.victor.project.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Groomer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Pattern(regexp = "\\d{10}" )
	private String phoneNumber;
	
//	Used to check if employee is still employeed, by default, should be set to true.
	private Boolean status;
	
	private LocalDate hireDate;
	
	@OneToMany
	private Set<DailyShiftLog> dailyShiftLog;
	
	@OneToMany(cascade =CascadeType.ALL, mappedBy = "groomer")
	private Set<WeeklyAvailability> weeklyAvailability;
	

}
