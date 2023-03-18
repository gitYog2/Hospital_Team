package com.team.HospitalTeam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.HospitalTeam.Dao.HospitalDao;
import com.team.HospitalTeam.dto.Hospital;
import com.team.HospitalTeam.dto.ResponseStructure;
import com.team.HospitalTeam.exception.IdNotFoundException;

@Service
public class HospitalService
{
	@Autowired
	HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hsp)
	{
		ResponseStructure<Hospital> rs=new ResponseStructure<Hospital>();
		rs.setBody(dao.save(hsp));
		rs.setMessage("Hospital saved Successfully");
		rs.setCode(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<Hospital>>(rs, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hsp)
	{
		ResponseStructure<Hospital> rs=new ResponseStructure<Hospital>();
		rs.setBody(dao.save(hsp));
		rs.setMessage("Hospital updated Successfully");
		rs.setCode(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<Hospital>>(rs, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id)
	{
		ResponseStructure<String> rs=new ResponseStructure<String>();
		Optional<Hospital> hsp=dao.findById(id);
		if(hsp.isPresent())
		{
			dao.delete(id);
			rs.setBody("Hospital found");
			rs.setMessage("Hospital deleted");
			rs.setCode(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(int id)
	{
		ResponseStructure<Hospital> rs=new ResponseStructure<Hospital>();
		Optional<Hospital> hsp=dao.findById(id);
		if(hsp.isPresent())
		{
			rs.setBody(hsp.get());
			rs.setMessage("Hospital found");
			rs.setCode(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Hospital>>(rs, HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospitals()
	{
		ResponseStructure<List<Hospital>> rs=new ResponseStructure<List<Hospital>>();
		rs.setBody(dao.findAll());
		rs.setMessage("found All Hospitals");
		rs.setCode(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(rs, HttpStatus.FOUND);
	}
}
