package com.mtec.philosopher_api;

import com.mtec.philosopher_api.repository.PhilosopherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PhilosopherApiApplication {
	private static final Logger log = LoggerFactory.getLogger(PhilosopherApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PhilosopherApiApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(PhilosopherRepository repository) {
		return (args) -> {
			log.info("Philosophers in database:");
			repository.findAll().forEach(philosopher -> {
				log.info(philosopher.getName() + " - " + philosopher.getCountry() + " - " + philosopher.getPhilosophicalCurrent());
			});
			if (repository.count() == 0) {
				log.warn("No philosophers found in the database!");
			}
		};
	}
}
