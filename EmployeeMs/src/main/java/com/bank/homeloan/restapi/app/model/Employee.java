package com.bank.homeloan.restapi.app.model;

import java.io.Serializable;

import com.bank.homeloan.restapi.app.enumaration.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
    private Integer employeeId;
	
	private String employeeName;
	private String username;
	private String password;
	private String employeeEmail;
	private Integer employeeAge;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
}
