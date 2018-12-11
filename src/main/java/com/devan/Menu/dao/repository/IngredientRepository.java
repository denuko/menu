package com.devan.Menu.dao.repository;

import com.devan.Menu.dao.enums.IngredientType;
import com.devan.Menu.dao.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>, QuerydslPredicateExecutor<Ingredient> {
    List<Ingredient> findByType(IngredientType type);
}
