package com.victor.project.models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer" )
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@NotBlank
	private String firstName;
	
	@NotEmpty
	@NotBlank
	private String lastName;
	
	@Email
	private String email;
	
	@Pattern(regexp="\\d{10}")
	String phoneNumber;

	@Embedded
	private Address address;
	
//	TODO Remove ToString to see what happens
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<Pet> pets;
	
	
//	TODO Remove ToString to see what happens
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	//By default OneToMany fetch is set to LAZY 
	@OneToMany(mappedBy = "customer" )
	private List<Appointment> appointment;
}
