package com.ty.springboot_hospital_app.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.Dao.PersonDao;
import com.ty.springboot_hospital_app.Dto.Person;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStruture;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;
	
	public ResponseEntity<ResponseStruture<Person>>savePerson(Person person){
		ResponseStruture<Person> responseStruture=new ResponseStruture<>();
		responseStruture.setMessage("saved");
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setData(dao.savePerson(person));
		return new ResponseEntity<ResponseStruture<Person>>(responseStruture,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStruture<Person>> updatePerson(int id,Person person){
		ResponseStruture<Person> responseStruture=new ResponseStruture<>();
		Person person2=dao.updatePerson(id, person);
		if(person2!=null) {
			responseStruture.setMessage("updated");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(person2);
			return new ResponseEntity<ResponseStruture<Person>>(responseStruture,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id Not found for Person");
		}
	}
	public ResponseEntity<ResponseStruture<Person>> deletePerson(int id){
		ResponseStruture<Person> responseStruture=new ResponseStruture<>();
		Person person=dao.deletePerson(id);
		if(person!=null) {
			responseStruture.setMessage("deleted");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(person);
			return new ResponseEntity<ResponseStruture<Person>>(responseStruture,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id Not found for Person");
		}
	}
	
	public ResponseEntity<ResponseStruture<Person>> getPersonById(int id){
		ResponseStruture< Person> responseStruture=new ResponseStruture<>();
		Person person=dao.getPersonById(id);
		if(person!=null) {
			responseStruture.setMessage("done");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(person);
			return new ResponseEntity<ResponseStruture<Person>>(responseStruture,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id Not found for Person");
		}
	}
}
