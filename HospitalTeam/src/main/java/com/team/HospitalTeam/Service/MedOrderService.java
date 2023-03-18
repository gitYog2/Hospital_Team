package com.team.HospitalTeam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.HospitalTeam.Dao.MedOrderDao;
import com.team.HospitalTeam.dto.MedOrder;
import com.team.HospitalTeam.dto.ResponseStructure;

@Service
public class MedOrderService {
	
	@Autowired
	MedOrderDao dao;
	
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medorder){
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		structure.setMessage("MedOrder Saved Successfully!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveModOrder(medorder));
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.ACCEPTED);
	}
	
	
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medorder){
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		structure.setMessage("MedOrder Updated Successfully!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveModOrder(medorder));
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.ACCEPTED);
	}
	
	
	public ResponseEntity<ResponseStructure<String>> deleteMedOrderById(int id){
		Optional<MedOrder> recMO=dao.findMedOrderById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		dao.deleteMedOrderById(id);
		if(recMO.isPresent()) {
		structure.setMessage("MedOrder Found & Deleted Successfully!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody("MedOrder Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
		}
		else {
		structure.setMessage("Unable to Delete MedOrder Which Is Not Present");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		structure.setBody("MedOrder Not  Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	public ResponseEntity<ResponseStructure<MedOrder>> findMedOrderById(int id){
		Optional<MedOrder> recMO=dao.findMedOrderById(id);
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		if(recMO.isPresent()) {
		structure.setMessage("MedOrder Found Successfully!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody(recMO.get());
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.FOUND);
		}
		else {
			structure.setMessage("Unable To Find MedOrder Which Is Not Present");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setBody(null);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<List<MedOrder>>> findAllMedOrders(){
		ResponseStructure<List<MedOrder>> structure=new ResponseStructure<List<MedOrder>>();
		structure.setMessage("List Of MedOrders Is Displayed Successfully!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody(dao.findAllMedOrder());
		return new ResponseEntity<ResponseStructure<List<MedOrder>>>(structure,HttpStatus.FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
