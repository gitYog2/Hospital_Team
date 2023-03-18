package com.team.HospitalTeam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.HospitalTeam.Dao.BranchDao;
import com.team.HospitalTeam.dto.Branch;
import com.team.HospitalTeam.dto.ResponseStructure;
import com.team.HospitalTeam.exception.IdNotFoundException;

@Service
public class BranchService 
{
	@Autowired
	BranchDao dao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch b)
	{
		ResponseStructure<Branch> rs=new ResponseStructure<Branch>();
		rs.setBody(dao.save(b));
		rs.setMessage("Branch Saved Successfully");
		rs.setCode(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<Branch>>(rs,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch b)
	{
		ResponseStructure<Branch> rs=new ResponseStructure<Branch>();
		rs.setBody(dao.save(b));
		rs.setMessage("Branch Updated Successfully");
		rs.setCode(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<Branch>>(rs,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id)
	{
		ResponseStructure<String> rs=new ResponseStructure<String>();
		Optional<Branch> b=dao.findById(id);
		
		if(b.isPresent())
		{
			dao.deleteById(id);
			rs.setBody("Branch found");
			rs.setMessage("Branch deleted");
			rs.setCode(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);
		}
		else{
			rs.setBody("Branch Not found");
			rs.setMessage("unable to delete");
			rs.setCode(HttpStatus.NOT_FOUND.value());
			
			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> findBranchById(int id)
	{
		ResponseStructure<Branch> rs=new ResponseStructure<Branch>();
		Optional<Branch> b=dao.findById(id);
		if(b.isPresent())
		{
			rs.setBody(b.get());
			rs.setMessage("Branch Found");
			rs.setCode(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.FOUND);
		}
		else{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranches()
	{
		ResponseStructure<List<Branch>> rs=new ResponseStructure<List<Branch>>();
		rs.setBody(dao.findAll());
		rs.setMessage("Branches Found");
		rs.setCode(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<Branch>>>(rs, HttpStatus.FOUND);
	}
}
