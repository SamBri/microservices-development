package com.samuel.users.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.users.entity.User;
import com.samuel.users.exception.UserExecutionException;
import com.samuel.users.response.CreateUserResponse;
import com.samuel.users.response.RootResponse;
import com.samuel.users.schemas.CreateUserSchema;
import com.samuel.users.service.IUserService;

import jakarta.validation.Valid;

//
@RestController
@RequestMapping("/api")
public class UserController {
	
	
	@Autowired
	private IUserService dbUserService;
	
	
	// Create a User 
	@PostMapping("/users")
	public ResponseEntity<RootResponse<CreateUserResponse>> createUser( @Valid @RequestBody CreateUserSchema request) {
		
		 RootResponse<CreateUserResponse> rootResponse; 

		  CreateUserResponse theCreateUserResponse = null;

		try {
			

			theCreateUserResponse	= dbUserService.createUser(request);
			  
			  if(theCreateUserResponse == null) {
				  
				  		  
				  rootResponse = new RootResponse<CreateUserResponse>("error","-400","User creation failed.",theCreateUserResponse);
				  
				  
			  } else {
				  
					 rootResponse = new RootResponse<CreateUserResponse>("success","200","User creation was successful.",theCreateUserResponse);
 
				  
			  }
				
			 
			 
		} catch (Exception e) {

			throw new UserExecutionException(e.getMessage());
		
		}
		
		  
		  return new ResponseEntity<RootResponse<CreateUserResponse>>(rootResponse, HttpStatus.CREATED);
		  
	}
	
////	
//	// Fetch a User by userId
	@GetMapping("/users/{userId}")
	public ResponseEntity<RootResponse<User>> fetchUserByUserId(@PathVariable Integer userId) {
		
		
	 RootResponse<User> rootResponse; 
		 
		 ResponseEntity<RootResponse<User>> usersResponseEntity;

		  
		 
		   User tempUser = dbUserService.fetchUserByUserId(userId);
		  if(tempUser != null) {
			  
			  			  
			  rootResponse = new RootResponse<User>("success","200","User successfully retrieved", tempUser);
			  
			  usersResponseEntity= new ResponseEntity<RootResponse<User>>(rootResponse, HttpStatus.OK);
			  
		  }
		  else {
		  
		  rootResponse = new RootResponse<User>("error","400","user could not be sucessfully retrieved",tempUser);
		  
		  usersResponseEntity= new ResponseEntity<RootResponse<User>>(rootResponse, HttpStatus.OK);
		  }
		
		return usersResponseEntity;
	}
//	
//    // Fetch all Users
	@GetMapping("/users")
	public ResponseEntity<RootResponse<List<User>>> fetchAllUsers() {
	
		 RootResponse<List<User>> rootResponse; 
		 
		 ResponseEntity<RootResponse<List<User>>> usersResponseEntity;

		  
		  List<User> list = dbUserService.fetchAllUsers();
		  if(list != null) {
			  
			  			  
			  rootResponse = new RootResponse<List<User>>("success","200","Users successfully retrieved", list);
			  
			  usersResponseEntity= new ResponseEntity<RootResponse<List<User>>>(rootResponse, HttpStatus.OK);
			  
		  } else {
			
		  
		  rootResponse = new RootResponse<List<User>>("error","400","users could not be sucessfully retrieved",list);
		  
		  usersResponseEntity= new ResponseEntity<RootResponse<List<User>>>(rootResponse, HttpStatus.OK);
		  }
		
		return usersResponseEntity;
		
	}
//	
//	// Update a User
//	@PutMapping("/user")
//	public ResponseEntity<T> updateUser(@RequestParam Integer userId,  @RequestBody UpdateUserSchema request) {
//		
//		dbUserService.updateUserByUserId(request);
//		
//	}
//	
//	// Delete a User
//	@DeleteMapping("/user")
//	public ResponseEntity<T> deleteUser(@RequestParam Integer userId) {
//	
//		dbUserService.deleteUserByUserId(userId);
//		
//	}
//	
//	
//	
	
	

}
