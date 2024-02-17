package com.samuel.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author user
 *
 * @param <T>
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RootResponse<T> {
	String status;
	String code;
	String message;
	T response;
	
}
