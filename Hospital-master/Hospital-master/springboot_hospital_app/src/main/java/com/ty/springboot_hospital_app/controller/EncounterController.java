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

import com.ty.springboot_hospital_app.Dto.Encounter;
import com.ty.springboot_hospital_app.services.EncounterService;
import com.ty.springboot_hospital_app.util.ResponseStruture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService encounterService;

	@ApiOperation(value = "Save Encounter", notes = "Api is used to save the encounter using with the person Id and branch id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Created"),
				@ApiResponse(code = 404,message = "Id Not Found for given person or branch")})
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStruture<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter,
			@RequestParam int pid, @RequestParam int bid) {
		return encounterService.saveEncounter(encounter, pid, bid);
	}
	
	@ApiOperation(value = "Save Encounter", notes = "Api is used to update the encounter using with the person Id and branch id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given person or branch")})
	@PutMapping("/encounter")
	public ResponseEntity<ResponseStruture<Encounter>> updateEncounter(@Valid @RequestBody Encounter encounter,
			@RequestParam int eid, @RequestParam int bid) {
		return encounterService.updateEncounter(encounter, eid, bid);
	}

	@ApiOperation(value = "Delete Encounter", notes = "Api is used to delete the encounter using with the Encounter Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully deleted"),
			@ApiResponse(code = 404,message = "Id Not Found for given person or branch")})
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStruture<Encounter>> deleteEncounter(@Valid @RequestParam int eid) {
		return encounterService.deleteEncounter(eid);

	}

	@ApiOperation(value = "Fetch Encounter", notes = "Api is used to Fetch the encounter using with the Encounter Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given person or branch")})
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStruture<Encounter>> getById(@Valid @RequestParam int eid) {
		return encounterService.getEncounterById(eid);
	}

}
