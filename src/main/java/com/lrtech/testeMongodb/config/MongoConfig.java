package com.lrtech.testeMongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
  //  TODO passar como variavel de ambiente 
  private  String uri = "mongodb://localhost:27017/testeMongo";
  @Bean
  public MongoDatabaseFactory mongoConfigure(){
    return new SimpleMongoClientDatabaseFactory(uri);
  }
  @Bean
  public MongoTemplate mongoTemplate(){
    return new MongoTemplate(mongoConfigure());
  }
}
