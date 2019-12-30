package com.Repository;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;



import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.model.User;

@Configuration
@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, Long> {




	
}
