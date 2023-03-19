package com.team.HospitalTeam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.team.HospitalTeam.dto.ResponseStructure;

@ControllerAdvice
public class IdExceptionHandler
{
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> Handler(IdNotFoundException inf)
	{
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setBody(inf.getMessage());
		rs.setMessage("Branch Not Found");
		rs.setCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NOT_FOUND);
	}
}
