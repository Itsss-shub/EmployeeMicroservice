package com.bank.homeloan.restapi.app.servicei;

import java.util.List;

import com.bank.homeloan.restapi.app.model.Employee;

public interface EmployeeServiceI {

	Employee saveEmployee(Employee e);

	List<Employee> getAllEmployee();

	Employee getByUsernameAndPassword(String username, String password);


}
