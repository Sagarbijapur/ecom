package com.ty.springboot_hospital_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.Dto.Person;
import com.ty.springboot_hospital_app.services.PersonService;
import com.ty.springboot_hospital_app.util.ResponseStruture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	@ApiOperation(value = "Save Person", notes = "Api is used to save the Person using with the Person Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Saved"),
			@ApiResponse(code = 404,message = "Id Not Found for given Person")})
	@PostMapping("/person")
	public ResponseEntity< ResponseStruture<Person>> savePerson(@Valid @RequestBody Person person){
		return service.savePerson(person);
	}
	
	@ApiOperation(value = "Update Person", notes = "Api is used to update the Person using with the Person Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given Person")})
	@PutMapping("/person")
	public ResponseEntity<ResponseStruture<Person>> updatePerson(@Valid @RequestBody Person person,@RequestParam int id){
		return service.updatePerson(id, person);
	}
	@ApiOperation(value = "Delete Person", notes = "Api is used to delete the Person using with the Person Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Deleted"),
			@ApiResponse(code = 404,message = "Id Not Found for given Person")})
	@DeleteMapping("/person")
	public ResponseEntity<ResponseStruture<Person>> deletePerson(@Valid @RequestParam int id){
		return service.deletePerson(id);
	}
	@ApiOperation(value = "Get the Person", notes = "Api is used to Get the Person using with the Person Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Fetched"),
			@ApiResponse(code = 404,message = "Id Not Found for given Person")})
	@GetMapping("/person")
	public ResponseEntity<ResponseStruture<Person>> getPersonById(@Valid @RequestParam int id){
		return service.getPersonById(id);
	}
}
