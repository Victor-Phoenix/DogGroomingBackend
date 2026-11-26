package com.victor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.project.models.WeeklyAvailability;

public interface WeeklyAvailabilityRepository extends JpaRepository<WeeklyAvailability, Long>{

}
