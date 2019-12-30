package com.journaldev.bootifulmongodb.dal;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.bootifulmongodb.model.Session;

@Repository
public interface SessionRepository extends MongoRepository<Session, Long>{
}
