package com.ty.springboot_hospital_app.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
@Data
@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name cannot be null")
	private String name;
	@NotNull(message = "phone number cannot be null")
	@Pattern(regexp = "[{6-9][0-9]{9}")
	private long phone;
	@NotNull(message = "manager name cannot be null")
	private String manager;

	@ManyToOne
	private Hospital hospital;
	
	@OneToOne
	private Address address;

	
}
