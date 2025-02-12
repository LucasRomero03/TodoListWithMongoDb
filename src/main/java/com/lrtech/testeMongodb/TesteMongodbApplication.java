package com.lrtech.testeMongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TesteMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteMongodbApplication.class, args);
	}

}
