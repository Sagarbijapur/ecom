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
import com.ty.springboot_hospital_app.Dto.MedItem;
import com.ty.springboot_hospital_app.services.MedItemService;
import com.ty.springboot_hospital_app.util.ResponseStruture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemController {

	@Autowired
	private MedItemService service;

	@ApiOperation(value = "Save MedItem", notes = "Api is used to save the MedItem using with the MedItem id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given MedItem")})
	@PostMapping("/meditem")
	public ResponseEntity<ResponseStruture<MedItem>> saveMedItem(@Valid @RequestBody MedItem item,
			@RequestParam int id) {
		return service.saveMedItem(item, id);
	}

	@ApiOperation(value = "Delete MedItem", notes = "Api is used to delete the MedItem using with the MedItem id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given person or branch")})
	@DeleteMapping("/meditem")
	public ResponseEntity<ResponseStruture<MedItem>> deleteMedItem(@Valid @RequestParam int id) {
		return service.deleteMedItem(id);
	}

	@ApiOperation(value = "Fetch MedItem", notes = "Api is used to Fetch the MedItem using with the MedItem Id")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given person or branch")})
	@GetMapping("/meditem")
	public ResponseEntity<ResponseStruture<MedItem>> getMedItemById(@Valid @RequestParam int id) {
		return service.getMedItemById(id);
	}

	@ApiOperation(value = "Update MedItem", notes = "Api is used to update the MedItem using with the MedItem Id ")
	@ApiResponses(value= {@ApiResponse(code = 201,message = "successfully updated"),
			@ApiResponse(code = 404,message = "Id Not Found for given person or branch")})
	@PutMapping("/meditem")
	public ResponseEntity<ResponseStruture<MedItem>> updateMedItem(@Valid @RequestBody MedItem item,
			@RequestParam int id) {
		return service.updateMedItemBYId(item, id);
	}

}
