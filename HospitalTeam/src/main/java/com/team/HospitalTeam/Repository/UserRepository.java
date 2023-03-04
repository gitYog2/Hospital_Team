package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.HospitalTeam.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{

}
