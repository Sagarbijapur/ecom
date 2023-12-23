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

import com.ty.springboot_hospital_app.Dto.Address;
import com.ty.springboot_hospital_app.services.AddressService;
import com.ty.springboot_hospital_app.util.ResponseStruture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	private AddressService service;
	@ApiOperation(value = "Save Address",notes = "Api is used to save the Address Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Created"),
			@ApiResponse(code = 404,message = "Id Not Found for given Address Id")})
	@PostMapping("/address")
	public ResponseEntity<ResponseStruture<Address>> saveAddress(@Valid @RequestBody Address address) {
		return service.saveAddress(address);
	}
	@ApiOperation(value = "Updated Address",notes = "Api is used to Update the Address Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given Address Id")})
	@PutMapping("/address")
	public ResponseEntity<ResponseStruture<Address>> updateAddress(@Valid @RequestParam int id,
			@RequestBody Address address) {
		return service.updateAddress(id, address);
	}

	@ApiOperation(value = "Delete Address",notes = "Api is used to delete the Address Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Deleted"),
			@ApiResponse(code = 404,message = "Id Not Found for given Address Id")})
	@DeleteMapping("/address")
	public ResponseEntity<ResponseStruture<Address>> deleteAddress(@Valid @RequestParam int id) {
		return service.deleteAddress(id);
	}

	
	@ApiOperation(value = "Get Address",notes = "Api is used to Fetch the Address Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Fetched"),
			@ApiResponse(code = 404,message = "Id Not Found for given Address Id")})
	@GetMapping("/address")
	public ResponseEntity<ResponseStruture<Address>> getAddressById(@Valid @RequestParam int id) {
		return service.getAddressById(id);
	}

}
