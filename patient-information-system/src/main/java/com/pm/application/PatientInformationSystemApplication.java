package com.pm.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages="com.pm")
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class PatientInformationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientInformationSystemApplication.class, args);
	}
}
