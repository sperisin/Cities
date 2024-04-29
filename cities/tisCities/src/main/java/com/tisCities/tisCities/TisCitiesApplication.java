package com.tisCities.tisCities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TisCitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TisCitiesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.allowedOriginPatterns("http://localhost:4200/*", "http://localhost:8080/*")
						.allowedMethods("*")
						.allowCredentials(false);
			}
		};
	}
}
