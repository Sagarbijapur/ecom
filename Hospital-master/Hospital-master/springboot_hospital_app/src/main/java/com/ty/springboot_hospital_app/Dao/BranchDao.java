package com.ty.springboot_hospital_app.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.Dto.Address;
import com.ty.springboot_hospital_app.Dto.Branch;
import com.ty.springboot_hospital_app.Dto.Hospital;
import com.ty.springboot_hospital_app.Repo.BranchRepo;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepo repo;

	@Autowired
	private HospitalDao dao;

	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(Branch branch, int hid, int aid) {
		Hospital hospital = dao.getHospitalById(hid);
		branch.setHospital(hospital);
		Address address = addressDao.getAddressById(aid);
		branch.setAddress(address);
		return repo.save(branch);
	}

	public Branch deleteBranch(int hid) {
		if (repo.findById(hid).isPresent()) {
			Branch dbBranch = repo.findById(hid).get();
			repo.deleteById(hid);
			return dbBranch;
		} else {
			return null;
		}
	}

	public Branch getBranchById(int hid) {
		if (repo.findById(hid).isPresent()) {
			return repo.findById(hid).get();
		} else {
			return null;
		}
	}

	public Branch updateBranch(int bid, Branch branch) {
		Branch dbBranch = repo.findById(bid).get();
		if (dbBranch != null) {
			branch.setId(bid);
			branch.setHospital(dbBranch.getHospital());
			branch.setAddress(dbBranch.getAddress());
			return repo.save(branch);
		} else {
			return null;
		}
	}

	public List<Branch> getBranchByhospitalId(int hid) {
		Hospital hospital = dao.getHospitalById(hid);
		return repo.findBranchByhospital(hospital);
	}
}
