package com.samuel.users.service;

import java.util.List;

import com.samuel.users.entity.User;
import com.samuel.users.response.CreateUserResponse;
import com.samuel.users.schemas.CreateUserSchema;

public interface IUserService {
	
//	
	User fetchUserByUserId(Integer userId);
//	
	List<User> fetchAllUsers();
//	
//	void updateUserByUserId();
//	
//	void deleteUserByUserId();

	CreateUserResponse createUser(CreateUserSchema schema);

}
