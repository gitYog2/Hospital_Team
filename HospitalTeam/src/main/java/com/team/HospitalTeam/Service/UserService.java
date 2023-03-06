package com.team.HospitalTeam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.HospitalTeam.Dao.UserDao;
import com.team.HospitalTeam.dto.ResponseStructure;
import com.team.HospitalTeam.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User Added Successfully.!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	
	
	
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User Updated Successfully.!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.updateUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	
	
	
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int id){
		Optional<User> recUser=dao.findUserById(id);
		ResponseStructure<String> structure=new ResponseStructure<>();
		dao.deleteUserById(id);
		if(recUser.isPresent()) {
			structure.setMessage("User Found & Deletet Successfully");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setBody("User Deleted");
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.FOUND);
		}
		else{
			structure.setMessage("Unable to Delete User Who Is Not Present");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setBody("User Not-Found");
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id){
		Optional<User> recUser=dao.findUserById(id);
		ResponseStructure<User> structure=new ResponseStructure<>();
		
		if(recUser.isPresent()) {
			structure.setMessage("User Found Successfully.!!!");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setBody(recUser.get());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		else{
			structure.setMessage("Unable to Find User Who Is Not Present");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setBody(recUser.get());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
		}		
	}
	
	
	
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setMessage("Found All Users & Are Printed Below Successfully.!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody(dao.findAllUsers());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone, @RequestParam String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		User recUser=dao.verifyUser(phone, password);
		if(recUser!=null) {
			structure.setMessage("User Verified Successfully..!!!");
			structure.setCode(HttpStatus.OK.value());
			structure.setBody(recUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		else{
			structure.setMessage("Invalid Phone or Password..!!!");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setBody(recUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}	
	}
	
	
}
