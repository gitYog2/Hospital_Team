package com.team.HospitalTeam.exception;

public class IdNotFoundException extends RuntimeException
{
	@Override
	public String getMessage()
	{
		return "Id Not Found";
	}
}
