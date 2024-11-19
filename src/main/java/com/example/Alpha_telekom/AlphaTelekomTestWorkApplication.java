package com.example.Alpha_telekom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AlphaTelekomTestWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphaTelekomTestWorkApplication.class, args);
	}

}
