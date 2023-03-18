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

import com.team.HospitalTeam.Service.BranchService;
import com.team.HospitalTeam.dto.Branch;
import com.team.HospitalTeam.dto.ResponseStructure;

@RestController
public class BranchController
{
	@Autowired
	BranchService serv;
	
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> m1(@RequestBody Branch b)
	{
		return serv.saveBranch(b);
	}
	
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> m2(@RequestBody Branch b)
	{
		return serv.updateBranch(b);
	}
	
	@DeleteMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<String>> m3(@PathVariable int id)
	{
		return serv.deleteBranch(id);
	}
	
	@GetMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> m4(@PathVariable int id)
	{
		return serv.findBranchById(id);
	}
	
	@GetMapping("/branch/all")
	public ResponseEntity<ResponseStructure<List<Branch>>> m5()
	{
		return serv.findAllBranches(); 
	}
}
