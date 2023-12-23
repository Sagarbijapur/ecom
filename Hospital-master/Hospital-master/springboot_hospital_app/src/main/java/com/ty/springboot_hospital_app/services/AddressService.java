package com.ty.springboot_hospital_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.Dao.AddressDao;
import com.ty.springboot_hospital_app.Dto.Address;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStruture;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStruture<Address>> saveAddress(Address address) {
		ResponseStruture<Address> structure = new ResponseStruture<>();
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAddress(address));
		return new ResponseEntity<ResponseStruture<Address>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStruture<Address>> updateAddress(int id, Address address) {
		Address dbAddress = dao.updateAddress(id, address);
		if (dbAddress != null) {
			ResponseStruture<Address> structure = new ResponseStruture<>();
			structure.setMessage("Successfully Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStruture<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for Address");
		}
	}

	public ResponseEntity<ResponseStruture<Address>> deleteAddress(int id) {
		Address address = dao.deleteAddress(id);
		if (address != null) {
			ResponseStruture<Address> structure = new ResponseStruture<>();
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStruture<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for Address");
		}
	}
	
	public ResponseEntity<ResponseStruture<Address>> getAddressById(int id) {
		Address address=dao.getAddressById(id);
		if (address != null) {
			ResponseStruture<Address> structure = new ResponseStruture<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStruture<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for Address");
		}
	}

}
