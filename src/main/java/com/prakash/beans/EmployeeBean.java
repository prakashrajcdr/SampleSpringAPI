package com.prakash.beans;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeBean implements Comparable<EmployeeBean>, Comparator<EmployeeBean> {

	private Integer id;
	private String name;
	private Short age;
	private String gender;
	private String designation;
	private Double salary;
	
	@Override
	public int compareTo(EmployeeBean e) {
		return this.id - e.id;
	}

	@Override
	public int compare(EmployeeBean e1, EmployeeBean e2) {
		return e1.id - e2.id;
	}
}
