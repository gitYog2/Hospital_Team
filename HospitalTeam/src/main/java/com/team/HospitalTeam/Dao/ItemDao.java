package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.HospitalTeam.Repository.ItemRepository;
import com.team.HospitalTeam.dto.Item;

@Repository
public class ItemDao {
	
	@Autowired
	ItemRepository repository;
	
	public Item saveItem(Item item) {
		return repository.save(item);
	}
	
	public Item updateItem(Item item) {
		return repository.save(item);
	}
	
	public void deleteItemById(int id) {
		repository.deleteById(id);
	}
	
	public Optional<Item> findItemById(int id) {
		return repository.findById(id);
	}
	public List<Item> findAllItems(){
		return repository.findAll();
	}
}
