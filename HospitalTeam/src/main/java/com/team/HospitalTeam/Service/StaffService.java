package com.team.HospitalTeam.Service;

import java.sql.Struct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.HospitalTeam.Dao.StaffDao;
import com.team.HospitalTeam.dto.ResponseStructure;
import com.team.HospitalTeam.dto.Staff;

@Service
public class StaffService {
	
	@Autowired
	StaffDao dao;
	
	
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff){
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		structure.setMessage("Staff Saved Successfully!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveStaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff){
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		structure.setMessage("Staff Updated successfully!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.ACCEPTED);
	}
	
	
}
