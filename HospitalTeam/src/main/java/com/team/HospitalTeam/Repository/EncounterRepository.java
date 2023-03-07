package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.HospitalTeam.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer>{

}
