package com.team.HospitalTeam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.HospitalTeam.Service.HospitalService;
import com.team.HospitalTeam.dto.Hospital;
import com.team.HospitalTeam.dto.ResponseStructure;

@RestController
public class HospitalController 
{
	@Autowired
	HospitalService serv;
	
  @PostMapping("/hsp")
  public ResponseEntity<ResponseStructure<Hospital>> m1(@RequestBody Hospital hsp)
  {
	  return serv.saveHospital(hsp);
  }
  
  @PutMapping("/hsp")
  public ResponseEntity<ResponseStructure<Hospital>> m2(@RequestBody Hospital hsp)
  {
	  return serv.saveHospital(hsp);
  }
  
  @DeleteMapping("/hsp/{id}")
  public ResponseEntity<ResponseStructure<String>> m3(@PathVariable int id)
  {
	  return serv.deleteHospital(id);
  }
  
  @GetMapping("/hsp/{id}")
  public ResponseEntity<ResponseStructure<Hospital>> m4(@PathVariable int id)
  {
	  return serv.findHospitalById(id);
  }
  
  @GetMapping("/hsp/all")
  public ResponseEntity<ResponseStructure<List<Hospital>>> m5()
  {
	  return serv.findAllHospitals();
  }
}