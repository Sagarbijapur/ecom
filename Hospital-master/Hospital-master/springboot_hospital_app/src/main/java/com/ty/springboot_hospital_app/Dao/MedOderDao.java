package com.ty.springboot_hospital_app.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.Dto.Encounter;
import com.ty.springboot_hospital_app.Dto.MedOrder;
import com.ty.springboot_hospital_app.Repo.MedOrderRepo;

@Repository
public class MedOderDao {

	@Autowired
	private MedOrderRepo repo;

	@Autowired
	private EncounterDao dao;

	public MedOrder saveMedOder(MedOrder medOrder, int eid) {
		Encounter encounter = dao.getById(eid);
		medOrder.setEncounter(encounter);
		return repo.save(medOrder);
	}

	public MedOrder updateMedOrder(MedOrder medOrder, int id) {
		if (repo.findById(id).isPresent()) {
			medOrder.setId(id);
			return repo.save(medOrder);
		} else {
			return null;
		}
	}

	public MedOrder getMedOrderByID(int id) {
		return repo.findById(id).get();
	}

	public MedOrder deleteMedOrder(int id) {
		if (repo.findById(id).isPresent()) {
			MedOrder medOrder = repo.findById(id).get();
			repo.deleteById(id);
			return medOrder;
		} else {
			return null;
		}
	}
}
