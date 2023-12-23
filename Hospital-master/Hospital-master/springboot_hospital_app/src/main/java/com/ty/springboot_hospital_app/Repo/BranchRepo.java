package com.ty.springboot_hospital_app.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hospital_app.Dto.Branch;
import com.ty.springboot_hospital_app.Dto.Hospital;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
	@Query("select b from  Branch b where b.hospital=?1")
	public List<Branch> findBranchByhospital(Hospital hospital);

}
