package com.samuel.transactions.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.samuel.transactions.response.RootResponse;



@FeignClient("users") // sprin boot application name
public interface UserFeignClient {
	
	
	@GetMapping("/api/users/{userId}")
	public ResponseEntity<RootResponse<User>> fetchUserByUserId(@PathVariable Integer userId);

}
