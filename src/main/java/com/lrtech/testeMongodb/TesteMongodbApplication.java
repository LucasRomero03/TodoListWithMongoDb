package com.lrtech.testeMongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = " Swagger OpenApi",version = "1",description = "API desenvolvida para Demandas internas do GTI"))
public class TesteMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteMongodbApplication.class, args);
	}

}
