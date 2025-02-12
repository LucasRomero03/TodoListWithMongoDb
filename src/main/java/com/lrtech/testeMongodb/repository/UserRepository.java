package com.lrtech.testeMongodb.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.lrtech.testeMongodb.entities.User;

public interface UserRepository extends MongoRepository<User,String> {

  Optional<User> findById(String id);

  Page<User> findAll(Pageable pageable);
  
}
