package com.victor.project.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.victor.project.models.Address;
import com.victor.project.models.Appointment;
import com.victor.project.models.Customer;
import com.victor.project.models.Groomer;
import com.victor.project.models.GroomingPackage;
import com.victor.project.models.Pet;
import com.victor.project.repository.*;

@Component
public class DataSeeder implements CommandLineRunner {

    private final GroomingPackageRepository groomingPackageRepository;

	private final CustomerRepository customerRepository;
	private final PetRepository petRepository;
	private final GroomerRepository groomerRepository;
	private final AppointmentRepository appointmentRepository;
	public DataSeeder(CustomerRepository customerRepository, PetRepository petRepository, GroomerRepository groomerRepository, AppointmentRepository appointmentRepository, GroomingPackageRepository groomingPackageRepository) {
		this.customerRepository = customerRepository;
		this.petRepository = petRepository;
		this.groomerRepository = groomerRepository;
		this.appointmentRepository = appointmentRepository;
		this.groomingPackageRepository = groomingPackageRepository;

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

			// Create demo groomingPackage
			GroomingPackage firstPackage = new GroomingPackage();
			firstPackage.setName("Demo Package");
			firstPackage.setPrice(new BigDecimal(20.99));
			
			GroomingPackage secondPackage = new GroomingPackage();
			secondPackage.setName("Demo Package");
			secondPackage .setPrice(new BigDecimal(20.99));
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
			Appointment firstAppointment = new Appointment();
			firstAppointment.setCustomer(firstCustomer);
			firstAppointment.setGroomer(firstGroomer);
			firstAppointment.setPet(firstPet);
			firstAppointment.setGroomingPackage(firstPackage);
			firstAppointment.setLocalDateTime(LocalDateTime.now());
			
			Appointment secondAppointment = new Appointment();
			secondAppointment.setCustomer(firstCustomer);
			secondAppointment.setGroomer(firstGroomer);
			secondAppointment.setPet(firstPet);
			secondAppointment.setGroomingPackage(secondPackage);
			secondAppointment.setLocalDateTime(LocalDateTime.now());
			
			firstCustomer.setPets(petSet);
			firstPet.setCustomer(firstCustomer);
			
			customerRepository.save(firstCustomer);
			groomerRepository.save(firstGroomer);
			groomingPackageRepository.save(firstPackage);
			groomingPackageRepository.save(secondPackage);
			appointmentRepository.save(firstAppointment);
			appointmentRepository.save(secondAppointment);
		}

	}

}
