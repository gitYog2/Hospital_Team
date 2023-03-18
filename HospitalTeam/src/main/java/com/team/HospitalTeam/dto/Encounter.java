package com.team.HospitalTeam.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Encounter {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	public int id;
	public String reason;
	public LocalDate date;
}
