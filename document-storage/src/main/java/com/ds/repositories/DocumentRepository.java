package com.ds.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ds.domain.Document;

public interface DocumentRepository extends MongoRepository<Document, String> {

	
	
}
