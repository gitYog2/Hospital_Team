package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.HospitalTeam.dto.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{
	
	@Query("select s from staff s where s.phone=?1 and s.password=?2")
	Staff verifyStaff(long phone, String password);
}
