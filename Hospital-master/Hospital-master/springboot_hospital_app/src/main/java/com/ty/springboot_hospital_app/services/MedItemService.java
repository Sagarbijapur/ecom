package com.ty.springboot_hospital_app.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.Dao.MedItemDao;
import com.ty.springboot_hospital_app.Dto.MedItem;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStruture;

@Service
public class MedItemService {

	@Autowired
	private MedItemDao dao;

	public ResponseEntity<ResponseStruture<MedItem>> saveMedItem(MedItem item, int id) {
		ResponseStruture<MedItem> responseStruture = new ResponseStruture<>();
		responseStruture.setMessage("successfully saved");
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setData(dao.saveMedItem(item, id));
		return new ResponseEntity<ResponseStruture<MedItem>>(responseStruture, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStruture<MedItem>> deleteMedItem(int id) {
		MedItem item = dao.deleteMedItem(id);
		if (item != null) {
			ResponseStruture<MedItem> responseStruture = new ResponseStruture<>();
			responseStruture.setMessage("deleted");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(item);
			return new ResponseEntity<ResponseStruture<MedItem>>(responseStruture, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for MedItem");
		}
	}

	public ResponseEntity<ResponseStruture<MedItem>> getMedItemById(int id) {
		MedItem item = dao.getMedItemById(id);
		if (item != null) {
			ResponseStruture<MedItem> responseStruture = new ResponseStruture<>();
			responseStruture.setMessage("done");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(item);
			return new ResponseEntity<ResponseStruture<MedItem>>(responseStruture, HttpStatus.OK);
		} else {
			throw new NoSuchElementException("Id Not found for MedItem");
		}
	}

	public ResponseEntity<ResponseStruture<MedItem>> updateMedItemBYId(MedItem item, int id) {
		MedItem item2 = dao.getMedItemById(id);
		item.setMedOrder(item2.getMedOrder());
		MedItem item3=dao.updateMedItemById(item, id);
		if(item3!=null) {
			ResponseStruture<MedItem> responseStruture=new ResponseStruture<>();
			responseStruture.setMessage("updated");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(item3);
			
			return new ResponseEntity<ResponseStruture<MedItem>>(responseStruture,HttpStatus.OK);
		}else {
			throw new NoSuchElementException("Id Not found for MedItem");
		}
	}
}
