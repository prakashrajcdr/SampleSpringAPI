package com.prakash.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prakash.beans.EmployeeBean;
import com.prakash.data.AccessData;

@Component
public class AppService {

	public List<EmployeeBean> getEmployees(){
		Collections.sort(AccessData.EMPLOYEES);
		return AccessData.EMPLOYEES;
	}
	
	public EmployeeBean getEmployeeById(Integer id) {
		return AccessData.EMPLOYEES.stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
	}
	
	public void addOrUpdateEmployee(final EmployeeBean employee) {
		if(employee.getId() < 1) {
			throw new RuntimeException("Id should be greate than zero");
		}
		removeEmployee(employee);
		AccessData.EMPLOYEES.add(employee);
	}
	
	public void addOrUpdateEmployees(final List<EmployeeBean> employees) {
		for(EmployeeBean employee : employees) {
			addOrUpdateEmployee(employee);
		}
	}
	
	
	public void removeEmployee(EmployeeBean employee) {
		try {
			AccessData.EMPLOYEES.removeIf(emp -> emp.getId().equals(employee.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
