package com.ty.springboot_hospital_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.Dao.BranchDao;
import com.ty.springboot_hospital_app.Dao.EncounterDao;
import com.ty.springboot_hospital_app.Dao.PersonDao;
import com.ty.springboot_hospital_app.Dto.Branch;
import com.ty.springboot_hospital_app.Dto.Encounter;
import com.ty.springboot_hospital_app.Dto.Person;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStruture;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStruture<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = personDao.getPersonById(pid);
		Branch branch = branchDao.getBranchById(bid);

		encounter.setPerson(person);
		List<Branch> list = new ArrayList<Branch>();
		list.add(branch);
		encounter.setBranches(list);

		ResponseStruture<Encounter> responseStruture = new ResponseStruture<>();
		responseStruture.setMessage("saved");
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setData(encounterDao.saveEncounter(encounter));

		return new ResponseEntity<ResponseStruture<Encounter>>(responseStruture, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStruture<Encounter>> updateEncounter(Encounter encounter, int id, int bid) {
		Encounter daoEncounter = encounterDao.getById(id);
		Branch branch = branchDao.getBranchById(bid);
		List<Branch> list = daoEncounter.getBranches();
		list.add(branch);
		encounter.setBranches(list);
		encounter.setPerson(daoEncounter.getPerson());

		ResponseStruture<Encounter> responseStruture = new ResponseStruture<>();
		responseStruture.setMessage("updated");
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setData(encounterDao.updateEncounter(encounter, bid));

		return new ResponseEntity<ResponseStruture<Encounter>>(responseStruture, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStruture<Encounter>> deleteEncounter(int id){
		ResponseStruture<Encounter> responseStruture=new ResponseStruture<>();
		Encounter encounter=encounterDao.deleteEncounterById(id);
		if(encounter!=null) {
			responseStruture.setMessage("deleted");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(encounter);
			return new ResponseEntity<ResponseStruture<Encounter>>(responseStruture,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id Not found for Encounter");
		}
	}
	public ResponseEntity<ResponseStruture<Encounter>> getEncounterById(int id){
		ResponseStruture<Encounter> responseStruture=new ResponseStruture<>();
		Encounter encounter=encounterDao.getById(id);
		if(encounter!=null) {
			responseStruture.setMessage("done");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(encounter);
			return new ResponseEntity<ResponseStruture<Encounter>>(responseStruture,HttpStatus.OK);
		}else {
			throw new NoSuchElementException("Id Not found for Encounterg");
		}
		
	}
}
