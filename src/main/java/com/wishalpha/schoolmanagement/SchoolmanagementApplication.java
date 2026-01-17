package com.wishalpha.schoolmanagement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SchoolmanagementApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SchoolmanagementApplication.class);

    @Value("${app.url}")
    private String applicationURL;
    @Value("${app.spring.url}")
    private String swaggerUI;
	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagementApplication.class, args);
	}

    @Override
    public void run(String... args){
        logger.info("Application URL:  {}",applicationURL);
        logger.info("Swagger UI URL:  {}",swaggerUI);
    }
}
