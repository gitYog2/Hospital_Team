package com.team.HospitalTeam.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.HospitalTeam.Dao.ItemDao;
import com.team.HospitalTeam.dto.Item;
import com.team.HospitalTeam.dto.ResponseStructure;

@Service
public class ItemService {
	
	@Autowired
	ItemDao  dao;
	
	public ResponseEntity<ResponseStructure<Item>> saveItem(Item item){
		ResponseStructure<Item> structure=new ResponseStructure<Item>();
		structure.setMessage("Item Saved Successfully!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveItem(item));
		return new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.ACCEPTED);
	}
	
	
	public ResponseEntity<ResponseStructure<Item>> updateItem(Item item){
		ResponseStructure<Item> structure=new ResponseStructure<Item>();
		structure.setMessage("Item Updateed Successfully!!!");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveItem(item));
		return new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteItemById(int id){
		Optional<Item> recItem=dao.findItemById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		if(recItem.isPresent()) {
		structure.setMessage("Item Has Been Deleted Successfully!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody("Item Found ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);

		}
		else {
			structure.setMessage("Unable To Delete Item Which Is Not Present");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setBody("Item Not Found");
		}
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	
	public ResponseEntity<ResponseStructure<Item>> findItemByIfById(int id){
		ResponseStructure<Item> structure=new ResponseStructure<Item>();
		Optional<Item> recItem=dao.findItemById(id);
		if(recItem.isPresent()) {
			structure.setMessage("Item Has Been Found Successfully!!!");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setBody(recItem.get());
			return new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.FOUND);
		}
		else {
			structure.setMessage("Unable To Find Item Which Is Not Present");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setBody(null);
		}
		return new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.NOT_FOUND);

	}
	
	public ResponseEntity<ResponseStructure<List<Item>>> findAllItems(){
		ResponseStructure<List<Item>> structure=new ResponseStructure<List<Item>>();
		structure.setMessage("The List Of Items Is Displayed Successfully!!!");
		structure.setCode(HttpStatus.FOUND.value());
		structure.setBody(dao.findAllItems());
		return new ResponseEntity<ResponseStructure<List<Item>>>(structure, HttpStatus.FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
