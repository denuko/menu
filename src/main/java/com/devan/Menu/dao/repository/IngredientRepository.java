package com.devan.Menu.dao.repository;

import com.devan.Menu.dao.enums.IngredientType;
import com.devan.Menu.dao.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByType(IngredientType type);
}
