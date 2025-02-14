package com.lrtech.testeMongodb.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lrtech.testeMongodb.entities.User;
@Repository
public interface UserRepository extends MongoRepository<User,String> {

  Optional<User> findById(String id);

  Page<User> findAll(Pageable pageable);
  User findByNome(String nome);
  
}
