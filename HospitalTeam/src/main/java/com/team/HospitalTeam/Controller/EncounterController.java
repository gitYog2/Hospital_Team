package com.team.HospitalTeam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.HospitalTeam.Service.EncounterService;
import com.team.HospitalTeam.dto.Encounter;
import com.team.HospitalTeam.dto.ResponseStructure;

@RestController
public class EncounterController {
	@Autowired
	EncounterService service;
	
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter){
		return service.saveEncounter(encounter);
	}
	
	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter){
		return service.saveEncounter(encounter);
	}
	
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<String>> deleteEncounterById(int id){
		return service.deleteEncounterById(id);
	}
	
	@GetMapping("/encounter/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> findEncounterById(int id){
		return service.findEncounterById(id);
	}
	
	
	
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<List<Encounter>>> findAllEncounter(){
		return service.findAllEncounter();			
	}
	
	
	
	
	
	
	
	
	
	
	
}
