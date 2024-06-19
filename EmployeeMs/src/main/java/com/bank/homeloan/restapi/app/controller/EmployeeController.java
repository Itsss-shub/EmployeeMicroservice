package com.bank.homeloan.restapi.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.homeloan.restapi.app.model.Employee;
import com.bank.homeloan.restapi.app.servicei.EmployeeServiceI;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("bank/homeloan/restapi/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceI esi;
	
	
	@PostMapping("/saveemployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e) {
		Employee emp=esi.saveEmployee(e);
		log.info("employee data saved");
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getemployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> elist=esi.getAllEmployee();
		log.info("fetched all employee data");
		return new ResponseEntity<List<Employee>>(elist,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByUsernameAndPassword/{username}/{password}")
	public ResponseEntity<Employee> getByUsernameAndPassword(@PathVariable String username,@PathVariable String password) {
		System.err.println("login check");
		Employee emp=esi.getByUsernameAndPassword(username,password);
		log.info("fetched  employee data with username : "+username+" password : "+password);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
}
