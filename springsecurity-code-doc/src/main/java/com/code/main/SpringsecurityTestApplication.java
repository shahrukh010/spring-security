package com.code.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScans({@ComponentScan("com.code.main.controller"),@ComponentScan("com.code.main.security")})
//@EnableJpaRepositories
//@EntityScan("com.code.main.entity")
public class SpringsecurityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityTestApplication.class, args);
	}

}
