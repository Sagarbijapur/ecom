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
import com.ty.springboot_hospital_app.Dto.MedOrder;
import com.ty.springboot_hospital_app.services.MedOrderService;
import com.ty.springboot_hospital_app.util.ResponseStruture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrderService service;

	@ApiOperation(value = "Save MedOrder", notes = "Api is used to save the MedOrder using with the MedOrder Id ")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully saved"),
			@ApiResponse(code = 404,message = "Id Not Found for given MedOrder")})
	@PostMapping("/medorder")
	public ResponseEntity<ResponseStruture<MedOrder>> saveMedOrder(@Valid @RequestBody MedOrder medOrder,
			@RequestParam int eid) {
		return service.saveMedOrder(medOrder, eid);
	}

	@ApiOperation(value = "Update MedOrder", notes = "Api is used to update MedOrder the  using with the MedOrder Id ")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given MedOder")})
	@PutMapping("/medorder")
	public ResponseEntity<ResponseStruture<MedOrder>> updateMedOrder(@Valid @RequestBody MedOrder medOrder,
			@RequestParam int id) {
		return service.updateMedOrder(medOrder, id);
	}

	@ApiOperation(value = "Delete MedOrder", notes = "Api is used to delete the MedOrder using with the MedOrder Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully deleted"),
			@ApiResponse(code = 404,message = "Id Not Found for given MedOrder")})
	@DeleteMapping("/medorder")
	public ResponseEntity<ResponseStruture<MedOrder>> deleteMedOrder(@Valid @RequestParam int id) {
		return service.deleteMedOrder(id);
	}

	@ApiOperation(value = "Fetch MedOrder", notes = "Api is used to Fetch the MedOrder using with the MedOrder Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully fetched"),
			@ApiResponse(code = 404,message = "Id Not Found for given MedOrder")})
	@GetMapping("/medorder")
	public ResponseEntity<ResponseStruture<MedOrder>> getByIdMedOrder(@Valid @RequestParam int id) {
		return service.getById(id);
	}

}
