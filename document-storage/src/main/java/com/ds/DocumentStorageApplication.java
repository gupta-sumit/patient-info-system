package com.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages="com.ds.repositories")
@EnableAutoConfiguration
@EnableFeignClients(basePackages="com.ds")
@EnableDiscoveryClient
@SpringBootApplication
public class DocumentStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentStorageApplication.class, args);
	}
}
