package com.team.HospitalTeam.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hospital 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String name;
   private String founder;
   private LocalDate yoe;
   private String gst;
   private List<Branch> branches;
}
