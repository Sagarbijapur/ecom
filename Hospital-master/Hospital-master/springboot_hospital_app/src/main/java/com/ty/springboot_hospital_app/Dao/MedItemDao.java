package com.ty.springboot_hospital_app.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.Dto.MedItem;
import com.ty.springboot_hospital_app.Dto.MedOrder;
import com.ty.springboot_hospital_app.Repo.MedItemRepo;

@Repository
public class MedItemDao {

	@Autowired
	private MedItemRepo repo;
	
	@Autowired 
	private MedOderDao dao;
	
	public MedItem saveMedItem(MedItem item,int mid) {
		MedOrder medOrder=dao.getMedOrderByID(mid);
		item.setMedOrder(medOrder);
		return repo.save(item);
	}
	
	public MedItem deleteMedItem(int id) {
		if(repo.findById(id).isPresent()) {
			MedItem item=repo.findById(id).get();
			repo.deleteById(id);
			return item;
		}else {
			return null;
		}
	}
	
	public MedItem getMedItemById(int id) {
		return repo.findById(id).get();
	}
	public MedItem updateMedItemById(MedItem item,int id) {
		if(repo.findById(id).isPresent()) {
			item.setId(id);
			return repo.save(item);
		}else {
			return null;
		}
	}
}
