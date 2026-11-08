package com.victor.project.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.victor.project.models.Address;
import com.victor.project.models.Customer;
import com.victor.project.models.Groomer;
import com.victor.project.models.Pet;
import com.victor.project.repository.AppointmentRepository;
import com.victor.project.repository.CustomerRepository;
import com.victor.project.repository.GroomerRepository;
import com.victor.project.repository.PetRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	private final CustomerRepository customerRepository;
	private final PetRepository petRepository;
	private final GroomerRepository groomerRepository;
	private final AppointmentRepository appointmentRepository;
	public DataSeeder(CustomerRepository customerRepository, PetRepository petRepository, GroomerRepository groomerRepository, AppointmentRepository appointmentRepository) {
		this.customerRepository = customerRepository;
		this.petRepository = petRepository;
		this.groomerRepository = groomerRepository;
		this.appointmentRepository = appointmentRepository;

	}

	@Override
	public void run(String... args) throws Exception {
		Long custSize= customerRepository.count();
		if (custSize <= 0) {

			Address firstAddy = new Address("Candy", "Lane", "CandyCity", "CandyKingdom");

			// Create demo pet 
			Pet firstPet = new Pet();
			firstPet.setName("Bella");
			firstPet.setDateOfBirth(LocalDate.parse("2017-01-28"));
			firstPet.setRabiesVacExperation(LocalDate.parse("2027-06-01"));
			firstPet.setWeight(14);

			//Create demo customer
			Customer firstCustomer = new Customer();
			firstCustomer.setFirstName("Victor");
			firstCustomer.setLastName("Tran");
			firstCustomer.setEmail("email@email.net");
			firstCustomer.setPhoneNumber("5552224444");
			firstCustomer.setAddress(firstAddy);
			Set<Pet> petSet = new HashSet<>();
			petSet.add(firstPet);
			
			//Create Groomer
			Groomer firstGroomer = new Groomer();
			firstGroomer.setFirstName("Kristina");
			firstGroomer.setLastName("Smith");
			firstGroomer.setPhoneNumber("1112223333");
			firstGroomer.setHireDate(LocalDate.now());
			
			//Create First Appointment	
			
			
			
			firstCustomer.setPets(petSet);
			firstPet.setCustomer(firstCustomer);
			
			customerRepository.save(firstCustomer);
			groomerRepository.save(firstGroomer);
		}

	}

}
