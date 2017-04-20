package edu.learn;

import edu.learn.service.CharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner runner(final CharacterRepository repository) {
		return args -> System.out.println(repository.findAll());
	}

}