package com.ty.springboot_hospital_app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.Dto.Branch;
import com.ty.springboot_hospital_app.services.BranchService;
import com.ty.springboot_hospital_app.util.ResponseStruture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService service;

	
	@ApiOperation(value = "Save Branch", notes = "Api is used to save the Branch using with the Hospital Id and Address id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Created"),
				@ApiResponse(code = 404,message = "Id Not Found for given Branch")})
	@PostMapping("/branch")
	public ResponseEntity<ResponseStruture<Branch>> saveBranch(@Valid @RequestBody Branch branch, @RequestParam int hid,
			@RequestParam int aid) {
		return service.saveBranch(branch, hid, aid);
	}

	@ApiOperation(value = "Get Branch", notes = "Api is used to get the Branch using with the Branch Id ")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Fetched"),
				@ApiResponse(code = 404,message = "Id Not Found for given Branch")})
	@GetMapping("/branch")
	public ResponseEntity<ResponseStruture<Branch>> getBranch(@Valid @RequestParam int hid) {
		return service.getBranchById(hid);
	}

	@ApiOperation(value = "Update Branch", notes = "Api is used to Update the Branch using with the Branch id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Updated"),
				@ApiResponse(code = 404,message = "Id Not Found for given Branch")})
	@PutMapping("/branch")
	public ResponseEntity<ResponseStruture<Branch>> updateBranch(@Valid @RequestParam int bid,
			@RequestBody Branch branch) {
		return service.updateBrach(bid, branch);
	}

	@ApiOperation(value = "Delete Branch", notes = "Api is used to delete the Branch using with the Branch Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Deleted"),
				@ApiResponse(code = 404,message = "Id Not Found for given Branch")})
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStruture<Branch>> deleteBranch(@Valid @RequestParam int hid) {
		return service.deleteBranch(hid);
	}

	@ApiOperation(value = "Get Branch By Hospital", notes = "Api is used to Get the Branch using with the Hospital Id and Branch id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully Fetched By Hospital"),
				@ApiResponse(code = 404,message = "Id Not Found for given Branch")})
	@GetMapping("/branch/{hid}")
	public ResponseEntity<ResponseStruture<List<Branch>>> getbranchByHospital(@Valid @PathVariable int hid) {
		return service.getBranchByhospitalId(hid);
	}
}
