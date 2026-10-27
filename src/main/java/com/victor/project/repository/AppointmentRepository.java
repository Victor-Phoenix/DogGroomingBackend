package com.victor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.project.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
