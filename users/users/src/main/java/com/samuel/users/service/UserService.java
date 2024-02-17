package com.samuel.users.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.samuel.users.UserIdentity;
import com.samuel.users.entity.User;
import com.samuel.users.repository.UserRepository;
import com.samuel.users.response.CreateUserResponse;
import com.samuel.users.schemas.CreateUserSchema;


@Service
public class UserService implements IUserService {

	
	private final UserRepository  userRepository;
	
	// inject the repository
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	

	@Override
	public CreateUserResponse createUser(CreateUserSchema userObject) {


		CreateUserResponse userResponse = new CreateUserResponse();
		
		int theUserId = LocalDateTime.now().getNano();
		String theMobileNumber = userObject.getMobileNumber();
		String theName = userObject.getName();
		String theUserName = userObject.getName() + "." + theMobileNumber;
		UserIdentity theUserIdentity = userObject.getMyIdentity();

		User tempUser = new User(theUserId, theMobileNumber, theName, theUserName, theUserIdentity.toString());

	    User theCreatedUser =  userRepository.save(tempUser);
		
		if(theCreatedUser != null) {
			
			
			userResponse.setMobileNumber(theCreatedUser.getMobileNumber());
			userResponse.setUserName(theCreatedUser.getUserName());
			userResponse.setUserPassword(theCreatedUser.getMobileNumber().substring(0, 5) + theUserId);
			userResponse.setDateCreated(theCreatedUser.getDateCreated().toString());
			userResponse.setUserId(theCreatedUser.getUserId());
			userResponse.setYourUserIdentity(theCreatedUser.getUserIdentity());			
		}
		
		
		return userResponse;
		


	}

 @Override
	public User fetchUserByUserId(Integer userId) {
		
		
	User tempUser =	userRepository.findUserByUserId(userId);
		
		return tempUser!= null ? tempUser : null;
	}
//
//	@Override
	public List<User> fetchAllUsers() {
		
	 List<User>	list = userRepository.findAll();
	 
	  return  !list.isEmpty() ? list : null;

		
	}
//
//	@Override
//	public void updateUserByUserId() {
//		
//	}
//
//	@Override
//	public void deleteUserByUserId() {
//		
//	}



	
	
	
	

}
