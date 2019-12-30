package com.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.model.Session;
@RepositoryRestResource
public interface SessionRepository extends MongoRepository<Session, Integer>{
}
