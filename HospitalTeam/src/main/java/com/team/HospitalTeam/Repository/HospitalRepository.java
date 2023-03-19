package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.HospitalTeam.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
