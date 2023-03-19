package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.team.HospitalTeam.Repository.PersonRepository;
import com.team.HospitalTeam.dto.Person;

@Repository
public class PersonDao 
{
	@Autowired
	PersonRepository repo;

	public Person save(Person prs)
	{
		return repo.save(prs);
	}

	public Person update(Person prs)
	{
		return repo.save(prs);
	}

	public void deletePerson(int id)
	{
		repo.deleteById(id);
	}

	public Optional<Person> findById(int id)
	{
		return repo.findById(id);
	}
	
	public List<Person> findAll()
	{
		return repo.findAll();
	}
}
