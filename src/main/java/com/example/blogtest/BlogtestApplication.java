package com.example.blogtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogtestApplication.class, args);
	}

}
