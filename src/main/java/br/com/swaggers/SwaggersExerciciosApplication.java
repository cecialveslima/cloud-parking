package br.com.swaggers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@SpringBootApplication(scanBasePackages = "br.com.swaggers.controller")
public class SwaggersExerciciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggersExerciciosApplication.class, args);
	}

}
