package com.mongosetup.mongosetup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class MongoSetupApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoSetupApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(StudentRepository repository)	{
//		return args -> {
//			Address address = new Address(
//				"India",
//				"Durgapur",
//				"713321"
//			);
//			Student student = new Student(
//				"Ahmed",
//				"Halim",
//				"ahmed@gmail.com",
//				Gender.MALE,
//				address,
//				List.of("Computer Science"),
//				BigDecimal.TEN,
//				LocalDateTime.now()
//			);
//
//			repository.insert(student);
//		};
//	}
}
