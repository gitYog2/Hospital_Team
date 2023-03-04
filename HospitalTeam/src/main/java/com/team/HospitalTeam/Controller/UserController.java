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

import com.team.HospitalTeam.Service.UserService;
import com.team.HospitalTeam.dto.ResponseStructure;
import com.team.HospitalTeam.dto.User;

@RestController
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int id){
		return service.deleteUserById(id);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id){
		return service.findUserById(id);
	}
	@GetMapping("/user/all")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
		return service.findAllUser();
	}
	@GetMapping("/user/verify")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone, @RequestParam String password){
		return service.verifyUser(phone, password);
	}
	
	
	
}
