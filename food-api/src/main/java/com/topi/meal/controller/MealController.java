package com.topi.meal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.topi.meal.model.Meals;
import com.topi.meal.repository.MealsRepository;

@RestController
@RequestMapping("/meals")
public class MealController {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*")
					.allowedOrigins("*")
					.allowedMethods("*")
					.maxAge(3600);
			}
			
		};
	}
	
	@Autowired
	private MealsRepository mealsRepository;
	
	@CrossOrigin
	@GetMapping
	public List<Meals> listMeals() {
		return mealsRepository.findAll();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	public Meals createMeal(@RequestBody Meals meal) {
		Meals meals = mealsRepository.save(meal);
		return meals;
	}
	
}
