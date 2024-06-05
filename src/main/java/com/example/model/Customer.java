package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	private int id;
	private String userName;
	private String password;
	private String address;
	private String email;
	private String phoneNo;
	private int age;
	private double balance;
	
}	
