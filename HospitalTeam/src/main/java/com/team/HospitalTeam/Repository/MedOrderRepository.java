package com.team.HospitalTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.HospitalTeam.dto.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder, Integer>{

}
