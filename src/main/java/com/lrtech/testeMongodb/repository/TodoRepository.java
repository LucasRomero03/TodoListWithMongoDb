package com.lrtech.testeMongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lrtech.testeMongodb.entities.Todo;
@Repository
public interface TodoRepository extends MongoRepository<Todo,String> {
  List<Todo> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
  @Query("{ 'user_nome': ?0 }")
    List<Todo> findByUserNome(String userNome);
  @Query("{ 'user_id': ?0 }")
  List<Todo> findByUser_id(String id);
}
