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

import com.team.HospitalTeam.Service.AddressService;
import com.team.HospitalTeam.dto.Address;
import com.team.HospitalTeam.dto.ResponseStructure;

public class AddressController 
{
	@Autowired
	AddressService serv;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseStructure<Address>> m1(@RequestBody Address add)
	{
		return serv.saveAddress(add);
	}
	
	@PutMapping("/add")
	public ResponseEntity<ResponseStructure<Address>> m2(@RequestBody Address add)
	{
		return serv.saveAddress(add);
	}
	
	@DeleteMapping("/add/id")
	public ResponseEntity<ResponseStructure<String>> m3(@PathVariable int id)
	{
		return serv.deleteAddress(id);
	}
	
	@GetMapping("/add/id")
	public ResponseEntity<ResponseStructure<Address>> m4(@PathVariable int id)
	{
		return serv.findAddressById(id);
	}
	
	@GetMapping("/add/all")
	public ResponseEntity<ResponseStructure<List<Address>>> m5()
	{
		return serv.findAllAddresses();
	}
}









