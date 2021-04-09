package com.topi.meal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Meals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=true, unique=true)
	private String strMeal;
	
	@Column(nullable=true)
	private String strArea;
	
	@Column(nullable=true)
	private String strMealThumb;
	
	@Column(nullable=true)
	private String strInstructions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStrMeal() {
		return strMeal;
	}

	public void setStrMeal(String strMeal) {
		this.strMeal = strMeal;
	}

	public String getStrArea() {
		return strArea;
	}

	public void setStrArea(String strArea) {
		this.strArea = strArea;
	}

	public String getStrMealThumb() {
		return strMealThumb;
	}

	public void setStrMealThumb(String strMealThumb) {
		this.strMealThumb = strMealThumb;
	}

	public String getStrInstructions() {
		return strInstructions;
	}

	public void setStrInstructions(String strInstructions) {
		this.strInstructions = strInstructions;
	}
	
	
}
