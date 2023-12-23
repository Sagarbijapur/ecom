package com.ty.springboot_hospital_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.Dao.BranchDao;
import com.ty.springboot_hospital_app.Dto.Branch;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStruture;

@Service
public class BranchService {

	@Autowired
	private BranchDao dao;

	public ResponseEntity<ResponseStruture<Branch>> saveBranch(Branch branch, int hid,int aid) {
		ResponseStruture<Branch> responseStruture = new ResponseStruture<Branch>();

		responseStruture.setMessage("successfully saved");
		responseStruture.setStatus(HttpStatus.CREATED.value());
		responseStruture.setData(dao.saveBranch(branch, hid,aid));

		return new ResponseEntity<ResponseStruture<Branch>>(responseStruture, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStruture<Branch>> deleteBranch(int hid) {
		Branch branch = dao.deleteBranch(hid);
		if (branch != null) {
			ResponseStruture<Branch> responseStruture = new ResponseStruture<>();
			responseStruture.setMessage("deleted");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(branch);
			return new ResponseEntity<ResponseStruture<Branch>>(responseStruture, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for Branch");
		}

	}

	public ResponseEntity<ResponseStruture<Branch>> updateBrach(int bid, Branch branch) {
		Branch dbBranch = dao.updateBranch(bid, branch);
		if (dbBranch != null) {
			ResponseStruture<Branch> responseStruture = new ResponseStruture<>();
			responseStruture.setMessage("updated");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(dbBranch);

			return new ResponseEntity<ResponseStruture<Branch>>(responseStruture, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for Branch");
		}
	}

	public ResponseEntity<ResponseStruture<Branch>> getBranchById(int hid) {
		Branch branch = dao.getBranchById(hid);
		if (branch != null) {
			ResponseStruture<Branch> responseStruture = new ResponseStruture<>();
			responseStruture.setMessage("fetched");
			responseStruture.setStatus(HttpStatus.OK.value());
			responseStruture.setData(branch);
			return new ResponseEntity<ResponseStruture<Branch>>(responseStruture, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not found for Branch");
		}
	}

	public ResponseEntity<ResponseStruture<List<Branch>>> getBranchByhospitalId(int hid) {

		ResponseStruture<List<Branch>> responseStruture = new ResponseStruture<>();
		responseStruture.setMessage("fetched");
		responseStruture.setStatus(HttpStatus.OK.value());
		responseStruture.setData(dao.getBranchByhospitalId(hid));
		return new ResponseEntity<ResponseStruture<List<Branch>>>(responseStruture, HttpStatus.OK);

	}

}
