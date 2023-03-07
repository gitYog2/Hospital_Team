package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.HospitalTeam.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
}
