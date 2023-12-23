package com.ty.springboot_hospital_app.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.Dao.HospitalDao;
import com.ty.springboot_hospital_app.Dto.Hospital;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStruture;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStruture<Hospital>> saveHospital(Hospital hospital) {
//		Hospital hospital2=dao.saveHospital(hospital);
		ResponseStruture<Hospital> responseStruture = new ResponseStruture<Hospital>();
		responseStruture.setMessage("Successfully saved");
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setData(dao.saveHospital(hospital));

		return new ResponseEntity<ResponseStruture<Hospital>>(responseStruture, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStruture<Hospital>> updateHospital(int id, Hospital hospital) {
		Hospital daoHospital = dao.updaHospital(id, hospital);
		if (daoHospital != null) {
			ResponseStruture<Hospital> responseStruture = new ResponseStruture<Hospital>();
			responseStruture.setMessage("Successfully updated");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(daoHospital);
			return new ResponseEntity<ResponseStruture<Hospital>>(responseStruture, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for Hospital");
		}

	}

	public ResponseEntity<ResponseStruture<Hospital>> getHospitalById(int id) {
		ResponseStruture<Hospital> responseStruture = new ResponseStruture<>();
		Hospital hospital = dao.getHospitalById(id);
		if (hospital != null) {
			responseStruture.setMessage("done");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(hospital);

			return new ResponseEntity<ResponseStruture<Hospital>>(responseStruture, HttpStatus.OK);
		} else {
			throw new NoSuchElementException("Id Not found for Hospital");
		}
	}

	public ResponseEntity<ResponseStruture<Hospital>> deleteHospitalById(int id) {
		ResponseStruture<Hospital> responseStruture = new ResponseStruture<>();
		Hospital hospital = dao.deleteHospital(id);
		if (hospital != null) {
			responseStruture.setMessage("deleted");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(hospital);

			return new ResponseEntity<ResponseStruture<Hospital>>(responseStruture, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for Hospital");
		}
	}

}
