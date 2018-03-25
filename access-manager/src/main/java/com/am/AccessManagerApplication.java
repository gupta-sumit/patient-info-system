package com.am;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages="com.am.repositories")
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class AccessManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessManagerApplication.class, args);
	}
}
