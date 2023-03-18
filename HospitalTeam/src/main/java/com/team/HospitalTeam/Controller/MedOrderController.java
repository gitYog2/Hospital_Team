package com.team.HospitalTeam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.HospitalTeam.Service.MedOrderService;
import com.team.HospitalTeam.dto.MedOrder;
import com.team.HospitalTeam.dto.ResponseStructure;

@RestController
public class MedOrderController {
	
	@Autowired
	MedOrderService service;
	@PostMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medorder){
		return service.saveMedOrder(medorder);
	}
	
	@PutMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder modorder){
		return service.updateMedOrder(modorder);
	}
	
	@DeleteMapping("/medorder/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteMedOrderById(int id){
		return service.deleteMedOrderById(id);
	}
	
	@GetMapping("/medorder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> findMedOrderById(int id){
		return service.findMedOrderById(id);
	}
	
	@GetMapping("/medorder/all")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> findAllMedOrders(){
		return service.findAllMedOrders();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
