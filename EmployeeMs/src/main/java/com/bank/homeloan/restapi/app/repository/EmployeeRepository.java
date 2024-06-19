package com.bank.homeloan.restapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.homeloan.restapi.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee getByUsernameAndPassword(String username, String password);
	
	public Employee findByUsernameAndPassword(String username,String password);

}
