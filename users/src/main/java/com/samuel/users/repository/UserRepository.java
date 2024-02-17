package com.samuel.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuel.users.entity.User;

@Repository  //my dao
public interface UserRepository extends JpaRepository<User, Integer> {

	
   User	findUserByUserId(Integer userId);
	
}
