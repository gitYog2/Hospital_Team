package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.HospitalTeam.Repository.BranchRepository;
import com.team.HospitalTeam.dto.Branch;

@Repository
public class BranchDao 
{
	@Autowired
	BranchRepository repo;
	
	public Branch save(Branch b)
	{
		return repo.save(b);
	}
	
	public Branch update(Branch b)
	{
		return repo.save(b);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<Branch> findById(int id)
	{
		return repo.findById(id);
	}
	
	public List<Branch> findAll()
	{
		return repo.findAll();
	}
}
