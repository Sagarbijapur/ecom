package com.ty.springboot_hospital_app.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "name is mandory")
	private String name;
	@NotNull(message = "email cannot be null")
	private String email;
	@NotNull(message = "gst cannot be null")
	@NotBlank(message = "gst is mandotary")
	private String gst;
	
	
}
