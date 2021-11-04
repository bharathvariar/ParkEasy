package com.parkeasy.parkeasy;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository<userModel, String> {

    userModel findByUsername (String username);
    
}
