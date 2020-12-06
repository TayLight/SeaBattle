package com.seabattle.SeaBattle.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
		"com.seabattle.SeaBattle"
})
@EntityScan(basePackages = "com.seabattle.SeaBattle")
@EnableJpaRepositories(basePackages = "com.seabattle.SeaBattle.repo")
public class SeaBattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeaBattleApplication.class, args);
	}

}
