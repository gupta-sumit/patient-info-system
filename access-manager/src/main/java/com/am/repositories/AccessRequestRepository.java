package com.am.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.am.domain.AccessRequest;

public interface AccessRequestRepository extends MongoRepository<AccessRequest, String>{

}
