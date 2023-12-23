package com.ty.springboot_hospital_app.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.Dto.Encounter;
import com.ty.springboot_hospital_app.Repo.EncounterRepo;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepo repo;
	
	public Encounter saveEncounter(Encounter encounter) {
	return	repo.save(encounter);
	}
	
	public Encounter updateEncounter(Encounter encounter,int id) {
		if(repo.findById(id).isPresent()) {
			encounter.setId(id);
			return repo.save(encounter);
		}else {
			return null;
		}
	}

	public Encounter getById(int id) {
		return repo.findById(id).get();
	}
	
	public Encounter deleteEncounterById(int id) {
		if(repo.findById(id).isPresent()) {
			Encounter encounter=repo.findById(id).get();
			repo.deleteById(id);
			return encounter;
		}else {
			return null;
		}
	}
	
}
