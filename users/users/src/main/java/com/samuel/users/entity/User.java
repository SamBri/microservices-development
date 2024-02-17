package com.samuel.users.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.samuel.users.UserIdentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//User schema
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id; // record tracking
	
	@Column(name = "USER_ID")
	@NonNull
	private Integer userId; // user tracking
	
	@NonNull
	@Column(name = "NAME")
	private String name; // name of the user
	
	@NonNull
	@Column(name = "USER_NAME")
	private String userName;
	
	@NonNull
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber; // mobile number of the user
	
	@NonNull
	@Column(name = "USER_IDENTITY")
	private String userIdentity; // identity of the user
	
    @CreationTimestamp
    @Column(name = "DATE_CREATED")
	private LocalDateTime dateCreated; // date user was created
	
    @UpdateTimestamp
	@Column(name = "DATE_MODIFIED")
	private String dateModified; // date user record was modified.

	
	

}
