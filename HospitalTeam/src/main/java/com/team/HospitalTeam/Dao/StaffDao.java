package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.HospitalTeam.Repository.StaffRepository;
import com.team.HospitalTeam.dto.Staff;

@Repository
public class StaffDao {
	
	@Autowired
	StaffRepository repository;
	
	public Staff saveStaff(Staff staff) {
		return repository.save(staff);
	}
	
	public Staff updateStaff(Staff staff) {
		return repository.save(staff);
	}
	
	
	public void deleteStaffById(int id) {
		repository.deleteById(id);
	}
	
	public Optional<Staff> findStaffById(int id) {
		return repository.findById(id);
	}
	
	public List<Staff> findAllStaff() {
		return repository.findAll();
	}
	
	public Staff verifyStaff(long phone , String password) {
		return repository.verifyStaff(phone, password);
	}
}
