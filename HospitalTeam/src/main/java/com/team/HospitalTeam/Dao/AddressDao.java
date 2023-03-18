package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.HospitalTeam.Repository.AddressRepository;
import com.team.HospitalTeam.dto.Address;

@Repository
public class AddressDao
{
	@Autowired
	AddressRepository repo;
	
	public Address save(Address add)
	{
		return repo.save(add);
	}
	
	public Address update(Address add)
	{
		return repo.save(add);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<Address> findById(int id)
	{
		return repo.findById(id);
	}
	
	public List<Address> findAll()
	{
		return repo.findAll();
	}
}

















