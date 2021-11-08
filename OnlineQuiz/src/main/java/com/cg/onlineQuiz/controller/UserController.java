package com.cg.onlineQuiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineQuiz.entity.UserDetails;
import com.cg.onlineQuiz.service.UserDetailsService;


@RestController
@RequestMapping("/user")

public class UserController 
{
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping(value="/{userId}",produces="application/json")
	public ResponseEntity<UserDetails> getUserDetails(@PathVariable int userId)
	{
		UserDetails user = userDetailsService.getUserDetails(userId);
		return new ResponseEntity<UserDetails>(user,HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public HttpStatus addUserDetails(@RequestBody int userId ,String userName,String userPassword ,String firstName ,String lastName,long mobileNo,String email) 
	{
		userDetailsService.addUserDetails(userId,userName,userPassword,firstName,lastName,mobileNo,email);
		return HttpStatus.OK;
		
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
		

}
