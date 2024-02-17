package com.samuel.transactions.service.clients;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	
	

	private Integer id; // record tracking
	
	private Integer userId; // user tracking
	
	private String name; // name of the user
	
	private String userName;
	
	private String mobileNumber; // mobile number of the user
	
	private String userIdentity; // identity of the user
	
  
	private LocalDateTime dateCreated; // date user was created
	
	private String dateModified; // date user record was modified.

	
	
	

}
