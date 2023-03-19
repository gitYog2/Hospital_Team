package com.team.HospitalTeam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.HospitalTeam.Dao.PersonDao;
import com.team.HospitalTeam.dto.Person;
import com.team.HospitalTeam.dto.ResponseStructure;
import com.team.HospitalTeam.exception.IdNotFoundException;

@Service
public class PersonService
{
	@Autowired
	PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person prs)
	{
		ResponseStructure<Person> rs=new ResponseStructure<Person>();

		rs.setBody(prs);
		rs.setMessage("Person Saved Successfully");
		rs.setCode(HttpStatus.ACCEPTED.value());

		return  new ResponseEntity<ResponseStructure<Person>>(rs, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person prs)
	{
		ResponseStructure<Person> rs=new ResponseStructure<Person>();

		rs.setBody(prs);
		rs.setMessage("Person Updated Successfully");
		rs.setCode(HttpStatus.ACCEPTED.value());

		return  new ResponseEntity<ResponseStructure<Person>>(rs, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deletePerson(int id)
	{
		ResponseStructure<String> rs=new ResponseStructure<String>();
		Optional<Person> prs=dao.findById(id);

		if(prs.isPresent())
		{
			dao.deletePerson(id);
			rs.setBody("Person Found");
			rs.setMessage("Person Deleted");
			rs.setCode(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);
		}
		else{
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Person>> findPersonById(int id)
	{
		ResponseStructure<Person> rs=new ResponseStructure<Person>();
		Optional<Person> prs=dao.findById(id);

		if(prs.isPresent())
		{
			rs.setBody(prs.get());
			rs.setMessage("Person Deleted");
			rs.setCode(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<Person>>(rs, HttpStatus.FOUND);
		}
		else{
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> findAllPersons()
	{
		ResponseStructure<List<Person>> rs=new ResponseStructure<List<Person>>();

		rs.setBody(dao.findAll());
		rs.setMessage("Found All Persons");
		rs.setCode(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Person>>>(rs, HttpStatus.FOUND);
	}
}
