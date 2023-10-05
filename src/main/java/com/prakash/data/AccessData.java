package com.prakash.data;

import java.util.ArrayList;
import java.util.List;

import com.prakash.beans.EmployeeBean;

public class AccessData {

	public static List<EmployeeBean> EMPLOYEES = new ArrayList<>();
	
	public static void loadEmployee() {
		EMPLOYEES.add(EmployeeBean.builder().id(1).name("prakash").age((short)25).gender("male").designation("developer").salary(100D).build());
		EMPLOYEES.add(EmployeeBean.builder().id(2).name("raj").age((short)25).gender("male").designation("test").salary(200D).build());
	}
}
