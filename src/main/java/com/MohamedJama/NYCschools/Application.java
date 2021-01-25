package com.MohamedJama.NYCschools;

import com.MohamedJama.NYCschools.entity.Nyschool;
import com.MohamedJama.NYCschools.repository.NyschoolsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.URL;
import java.util.ArrayList;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("*")
						.allowedOrigins("http://localhost:8100");


			}
		};
	}

	/**
	 *
	 * @param nyschoolsRepository
	 * @return
	 * Loading data to mySQL database
	 */
	@Bean
	public CommandLineRunner run(NyschoolsRepository nyschoolsRepository) {
		return args -> {
			//loads data to the database only once
			if (nyschoolsRepository.count() < 1) {
				URL json = new URL("https://data.cityofnewyork.us/resource/f9bf-2cp4.json");
				ObjectMapper mapper = new ObjectMapper();
				ArrayList<Nyschool> school = mapper.readValue(json, new TypeReference<ArrayList<Nyschool>>() {
				});
				nyschoolsRepository.saveAll(school);
			}
		};

	}
}
