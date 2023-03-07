package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.HospitalTeam.Repository.EncounterRepository;
import com.team.HospitalTeam.dto.Encounter;

@Repository
public class EncounterDao {
	
	@Autowired
	EncounterRepository repository;
	
	public Encounter saveEncounter(Encounter encounter) {
		return repository.save(encounter);
	}
	
	public Encounter updateEncounter(Encounter encounter) {
		return repository.save(encounter);
	}
	
	public void deleteEncounterById(int id) {
		repository.deleteById(id);
	}
	
	public Optional<Encounter> findEncounterById(int id) {
		return repository.findById(id);
	}
	
	public List<Encounter> findAllEncounter(){
		return repository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
}
