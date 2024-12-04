package com.example.rest;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {
	public static void main(String[] args) {
	Dotenv dotenv = Dotenv.configure().load();

	dotenv.get("DB_URL");
	dotenv.get("DB_USER");
	dotenv.get("DB_PASSWORD");

	System.out.println(dotenv.get("DB_URL"));

	SpringApplication.run(RestApplication.class, args);
	}
}