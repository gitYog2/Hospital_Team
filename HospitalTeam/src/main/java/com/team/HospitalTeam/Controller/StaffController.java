package com.team.HospitalTeam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.HospitalTeam.Service.StaffService;
import com.team.HospitalTeam.dto.ResponseStructure;
import com.team.HospitalTeam.dto.Staff;

@RestController
public class StaffController {
	
	@Autowired
	StaffService service;
	
	
	@PostMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff){
		return service.saveStaff(staff);
	}
	@PutMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff){
		return service.updateStaff(staff);
	}
	
	@DeleteMapping("/staff")
	public ResponseEntity<ResponseStructure<String>> deleteStaffById(@PathVariable int id){
		return service.deleteStaffById(id);
	}
	
	@GetMapping("/staff/{id}")
	public void findStaffById(@PathVariable int id){
		service.deleteStaffById(id);
	}
	
	@GetMapping("/staff/all")
	public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaff(){
		return service.findAllStaff();
	}
	
	
	@GetMapping("/staff/verify")
	public ResponseEntity<ResponseStructure<Staff>> verifyStaff(@RequestParam long phone, @RequestParam String password){
		return service.verifyStaff(phone, password);
	}
	
	
	
	
	
	
	
}
