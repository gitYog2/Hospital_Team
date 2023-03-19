package com.team.HospitalTeam.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.HospitalTeam.Dao.AddressDao;
import com.team.HospitalTeam.dto.Address;
import com.team.HospitalTeam.dto.ResponseStructure;
import com.team.HospitalTeam.exception.IdNotFoundException;

@Service
public class AddressService
{
	@Autowired
	AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address add)
	{
		ResponseStructure<Address> rs=new ResponseStructure<Address>();
		rs.setBody(dao.save(add));
		rs.setMessage("Address saved Successfully");
		rs.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address add)
	{
		ResponseStructure<Address> rs=new ResponseStructure<Address>();
		rs.setBody(dao.save(add));
		rs.setMessage("Address saved Successfully");
		rs.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAddress(int id)
	{
		ResponseStructure<String> rs=new ResponseStructure<String>();
		Optional<Address> add=dao.findById(id);
		if(add.isPresent())
		{
			dao.deleteById(id);
			rs.setBody("Address Found");
			rs.setMessage("Address Deleted");
			rs.setCode(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> findAddressById(int id)
	{
		ResponseStructure<Address> rs=new ResponseStructure<Address>();
		Optional<Address> add=dao.findById(id);
		if(add.isPresent())
		{
			rs.setBody(add.get());
			rs.setMessage("Address found");
			rs.setCode(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.FOUND);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddresses()
	{
		ResponseStructure<List<Address>> rs=new ResponseStructure<List<Address>>();

		rs.setBody(dao.findAll());
		rs.setMessage("Addresses found");
		rs.setCode(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Address>>>(rs, HttpStatus.FOUND);
	}
}










