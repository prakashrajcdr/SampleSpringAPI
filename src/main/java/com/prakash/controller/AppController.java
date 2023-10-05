package com.prakash.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.beans.EmployeeBean;
import com.prakash.service.AppService;

@RestController
public class AppController {

	@Autowired
	AppService appService;
	
	@GetMapping(path = {"/getEmployees"})
	public ResponseEntity<Map<String,Object>> getEmployees() throws RuntimeException{
		Map<String,Object> result = new HashMap<>();
		result.put("data", appService.getEmployees());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(path = {"/getEmployees/{id}"})
	public ResponseEntity<Map<String,Object>> getEmployeeById(@PathVariable("id") Integer id) throws RuntimeException{
		Map<String,Object> result = new HashMap<>();
		result.put("data", appService.getEmployeeById(id));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(path = {"/addEmployee"})
	public ResponseEntity<Map<String,Object>> addOrupdateEmployee(@RequestBody EmployeeBean employee) throws RuntimeException{
		Map<String,Object> result = new HashMap<>();
		appService.addOrUpdateEmployee(employee);
		result.put("data", appService.getEmployees());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(path = {"/addEmployees"})
	public ResponseEntity<Map<String,Object>> addOrupdateEmployees(@RequestBody List<EmployeeBean> employees) throws RuntimeException{
		Map<String,Object> result = new HashMap<>();
		appService.addOrUpdateEmployees(employees);
		result.put("data", appService.getEmployees());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	

}
