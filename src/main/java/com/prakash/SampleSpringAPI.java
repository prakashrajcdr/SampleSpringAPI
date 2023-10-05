package com.prakash;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prakash.data.AccessData;



@SpringBootApplication
public class SampleSpringAPI {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringAPI.class, args);
	}

	@PostConstruct
	public void generateData() {
		AccessData.loadEmployee();
	}
}	
