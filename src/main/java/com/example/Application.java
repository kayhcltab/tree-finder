package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.config.AppConfig;

/**
 * This is the starting point of tree-finder service
 * 
 * @author KP
 *
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}
