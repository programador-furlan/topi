package com.topi.meal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topi.meal.model.Meals;

@Repository
public interface MealsRepository extends JpaRepository<Meals, Long>{

}
