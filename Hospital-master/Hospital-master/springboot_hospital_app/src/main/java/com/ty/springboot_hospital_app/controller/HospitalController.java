package com.ty.springboot_hospital_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.Dto.Hospital;
import com.ty.springboot_hospital_app.services.HospitalService;
import com.ty.springboot_hospital_app.util.ResponseStruture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;

	@ApiOperation(value = "Save Hospital", notes = "Api is used to save the Hospital Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Succefully Created") })
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStruture<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}

	@ApiOperation(value = "Updated Hospital",notes = "Api is used to Update the Hospital Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Succefully Updated ") })
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStruture<Hospital>> updateHospital(@Valid @RequestParam int id,
			@RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);

	}
	@ApiOperation(value = "Delete Hospital",notes = "Api is used to Delete the Hospital Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Succefully Deleted ") })
	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStruture<Hospital>> deleteHospital(@Valid @RequestParam int id) {
		return service.deleteHospitalById(id);
	}

	@ApiOperation(value = "Fetch Hospital",notes = "Api is used to Fetch the Hospital Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Succefully Fetched") })
	@GetMapping("/hospital")
	public ResponseEntity<ResponseStruture<Hospital>> getHospital(@Valid @RequestParam int id) {
		return service.getHospitalById(id);
	}
}
