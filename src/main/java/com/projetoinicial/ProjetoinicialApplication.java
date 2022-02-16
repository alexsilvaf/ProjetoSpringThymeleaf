package com.projetoinicial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjetoinicialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoinicialApplication.class, args);
	}

}
