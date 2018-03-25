package com.pm.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pm.domain.PatientDetails;

public interface PatientInfoRepository extends MongoRepository<PatientDetails, String> {
	
}
