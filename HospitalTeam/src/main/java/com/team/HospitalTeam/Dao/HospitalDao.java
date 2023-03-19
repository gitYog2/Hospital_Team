package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.HospitalTeam.Repository.HospitalRepository;
import com.team.HospitalTeam.dto.Hospital;

@Repository
public class HospitalDao 
{
	@Autowired
	HospitalRepository repo;
	
	public Hospital save(Hospital hsp)
	{
		return repo.save(hsp);
	}
	
	public Hospital update(Hospital hsp)
	{
		return repo.save(hsp);
	}
	
	public void delete(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<Hospital> findById(int id)
	{
		return repo.findById(id);
	}
	
	public List<Hospital> findAll()
	{
		return repo.findAll();
	}
}
