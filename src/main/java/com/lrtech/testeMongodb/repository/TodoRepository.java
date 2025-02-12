package com.lrtech.testeMongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lrtech.testeMongodb.entities.Todo;

public interface TodoRepository extends MongoRepository<Todo,String> {
  List<Todo> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
}
