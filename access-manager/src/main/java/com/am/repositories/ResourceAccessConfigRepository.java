package com.am.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.am.domain.ResourceAccessConfig;

public interface ResourceAccessConfigRepository extends MongoRepository<ResourceAccessConfig, String> {

}
