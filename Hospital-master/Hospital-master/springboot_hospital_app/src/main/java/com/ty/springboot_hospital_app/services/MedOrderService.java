package com.ty.springboot_hospital_app.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.Dao.MedOderDao;
import com.ty.springboot_hospital_app.Dto.MedOrder;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStruture;

@Service
public class MedOrderService {

	@Autowired
	private MedOderDao dao;
	
	public ResponseEntity<ResponseStruture<MedOrder>> saveMedOrder(MedOrder medOrder,int id){
		ResponseStruture<MedOrder> responseStruture=new ResponseStruture<>();
		responseStruture.setMessage("Successfully saved");
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setData(dao.saveMedOder(medOrder, id));
		return new ResponseEntity<ResponseStruture<MedOrder>>(responseStruture,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStruture<MedOrder>> updateMedOrder(MedOrder medOrder,int id){
		ResponseStruture<MedOrder> responseStruture=new ResponseStruture<>();
		MedOrder dbMedOder=dao.getMedOrderByID(id);
		medOrder.setEncounter(dbMedOder.getEncounter());
		MedOrder daoMedOrder=dao.updateMedOrder(medOrder, id);
		if(daoMedOrder!=null) {
			responseStruture.setMessage("updated succefully");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(daoMedOrder);
			return new ResponseEntity<ResponseStruture<MedOrder>>(responseStruture,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id Not found for MedOrder");
		}
	}
	public ResponseEntity<ResponseStruture<MedOrder>> deleteMedOrder(int id){
		MedOrder medOrder=dao.deleteMedOrder(id);
		if(medOrder!=null) {
			ResponseStruture<MedOrder> responseStruture=new ResponseStruture<>();
			responseStruture.setMessage("deleted");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(medOrder);
			return new ResponseEntity<ResponseStruture<MedOrder>>(responseStruture,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id Not found for MedOrder");
		}
	}

	public ResponseEntity<ResponseStruture<MedOrder>> getById(int id){
		MedOrder medOrder=dao.getMedOrderByID(id);
		if(medOrder!=null) {
			ResponseStruture<MedOrder> responseStruture=new ResponseStruture<>();
			responseStruture.setMessage("done");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(medOrder);
			return new ResponseEntity<ResponseStruture<MedOrder>>(responseStruture,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id Not found for MedOrder");
		}
	}
}
