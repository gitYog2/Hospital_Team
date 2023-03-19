package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.HospitalTeam.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>
{
}
