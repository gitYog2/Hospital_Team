package com.team.HospitalTeam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.HospitalTeam.Dao.EncounterDao;
import com.team.HospitalTeam.dto.Encounter;
import com.team.HospitalTeam.dto.ResponseStructure;

@Service
public class EncounterService {
	
	@Autowired
	EncounterDao dao;
	
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter){
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		structure.setMessage("Encounter Saved Successfully!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveEncounter(encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter){
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		structure.setMessage("Encounter Updated Successfully!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveEncounter(encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteEncounterById(int id){
		Optional<Encounter> recEC=dao.findEncounterById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(recEC.isPresent()) {
		dao.deleteEncounterById(id);
		structure.setMessage("Encounter Found & Deleted Successfully!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody("Encounter Found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.FOUND);
		}
		else {
			structure.setMessage("Unable To Delete Encounter Which Is Not Predent");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setBody("Encounter Found");
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> findEncounterById(int id){
		Optional<Encounter> recEC=dao.findEncounterById(id);
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		if(recEC.isPresent()) {
		structure.setMessage("Encounter Found Successfully!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody(dao.saveEncounter(recEC.get()));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.FOUND);
		}
		else {
			structure.setMessage("Encounter Not Found Successfully!!!");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setBody(dao.saveEncounter(recEC.get()));
			return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	
	
	public ResponseEntity<ResponseStructure< List<Encounter>>> findAllEncounter(){
		ResponseStructure<List<Encounter>> structure=new ResponseStructure<List<Encounter>>();
		structure.setMessage("List Of Encounters Displayed Successfully!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody(dao.findAllEncounter());
		return new ResponseEntity<ResponseStructure<List<Encounter>>>(structure,HttpStatus.FOUND);
	}
	
}
