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
import org.springframework.web.bind.annotation.RestController;

import com.team.HospitalTeam.Service.PersonService;
import com.team.HospitalTeam.dto.Person;
import com.team.HospitalTeam.dto.ResponseStructure;

@RestController
public class PersonController
{
	@Autowired
	PersonService serv;
	
	@PostMapping("/prs")
	public ResponseEntity<ResponseStructure<Person>> m1(@RequestBody Person prs)
	{
		return serv.savePerson(prs);
	}
	
	@PutMapping("/prs")
	public ResponseEntity<ResponseStructure<Person>> m2(@RequestBody Person prs)
	{
		return serv.updatePerson(prs);
	}
	
	@DeleteMapping("/prs/{id}")
	public void m3(@PathVariable int id)
	{
		serv.deletePerson(id);
	}
	
	@GetMapping("/prs/{id}")
	public ResponseEntity<ResponseStructure<Person>> m4(@PathVariable int id)
	{
		return serv.findPersonById(id);
	}
	
	@GetMapping("/prs/all")
	public ResponseEntity<ResponseStructure<List<Person>>> m5()
	{
		return serv.findAllPersons();
	}
}
