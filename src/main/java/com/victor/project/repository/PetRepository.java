package com.victor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.project.models.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
