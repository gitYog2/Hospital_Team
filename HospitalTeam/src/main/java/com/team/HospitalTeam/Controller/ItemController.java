package com.team.HospitalTeam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.HospitalTeam.Service.ItemService;
import com.team.HospitalTeam.dto.Item;
import com.team.HospitalTeam.dto.ResponseStructure;

@RestController
public class ItemController {
	
	@Autowired
	ItemService service;
	
	
	@PostMapping("/item")
	public ResponseEntity<ResponseStructure<Item>> saveItem(Item item){
		return service.saveItem(item);
	}
	
	@PutMapping("/item")
	public ResponseEntity<ResponseStructure<Item>> updateItem(Item item){
		return service.updateItem(item);
	}
	
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteItemById(int id){
		return service.deleteItemById(id);
	}
	
	
	@GetMapping("/item/{id}")
	public ResponseEntity<ResponseStructure<Item>> findItemById(int id){
		return service.findItemByIfById(id);
	}
	
	@GetMapping("/item/all")
	public ResponseEntity<ResponseStructure<List<Item>>> findAllItems(){
		return service.findAllItems();
	}
	
	
	
	
	
	
	
	
	
	
}
