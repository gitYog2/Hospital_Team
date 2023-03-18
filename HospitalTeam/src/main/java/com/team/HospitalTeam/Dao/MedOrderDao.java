package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.HospitalTeam.Repository.MedOrderRepository;
import com.team.HospitalTeam.dto.MedOrder;

@Repository
public class MedOrderDao {
	
	@Autowired
	MedOrderRepository repository;
	
	public MedOrder saveModOrder(MedOrder medorder) {
		return repository.save(medorder);
	}
	
	public MedOrder updateMedOrder(MedOrder medorder) {
		return repository.save(medorder);
	}
	
	public void deleteMedOrderById(int id) {
		repository.deleteById(id);
	}
	
	public Optional<MedOrder> findMedOrderById(int id) {
		return repository.findById(id);
	}
	
	public List<MedOrder> findAllMedOrder(){
		return repository.findAll();
	}
}
