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
	
	public User saveUser(User user)
	{
		return repo.save(user);
	}
	
	public User updateUser(User user)
	{
		return repo.save(user);
	}
	
	public void deleteUserById(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<User> findUserById(int id)
	{
		return repo.findById(id);
	}
	
	public List<User> findAllUsers()
	{
		return repo.findAll();
	}
	public User verifyUser(long phone,String password) {
		return repo.verifyUser(phone, password);
	}
}
