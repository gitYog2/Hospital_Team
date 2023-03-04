package com.team.HospitalTeam.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.team.HospitalTeam.Repository.UserRepository;
import com.team.HospitalTeam.dto.User;

public class UserDao
{
	@Autowired
   private UserRepository repo;
	
	public User save(User user)
	{
		return repo.save(user);
	}
	
	public User update(User user)
	{
		return repo.save(user);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<User> findById(int id)
	{
		return repo.findById(id);
	}
	
	public List<User> findAllUsers()
	{
		return repo.findAll();
	}
}
