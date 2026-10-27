package com.victor.project.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
	
	private String street ;
	private String postalCode;
	private String city;
	private String state;
	
}
