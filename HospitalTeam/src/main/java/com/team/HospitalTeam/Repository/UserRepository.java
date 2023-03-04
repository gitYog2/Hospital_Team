package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.HospitalTeam.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{
	@Query("select u from user u where u.phone=?1 and u.password=?2")
	User verifyUser(long phone,String password); 
}
