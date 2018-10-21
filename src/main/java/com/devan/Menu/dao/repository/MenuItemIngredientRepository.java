package com.devan.Menu.dao.repository;

import com.devan.Menu.dao.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemIngredientRepository extends JpaRepository<Ingredient, Long> {
}
