package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.HospitalTeam.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>
{
   
}
