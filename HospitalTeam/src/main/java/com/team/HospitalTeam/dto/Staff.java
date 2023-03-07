package com.team.HospitalTeam.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class Staff {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String designation;
	private String password;
	private String email;
	private long phone;
	private int branchId;
}
