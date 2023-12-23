package com.ty.springboot_hospital_app.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
@Data
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "city cannot be null")
	private String city;
	@NotNull(message = "state cannot be null")
	private String state;
	@NotNull(message = "pincode cannot be null")
	@Pattern(regexp = "[5-9][0-9][9]")
	private int pincode;
	
	
	
}
