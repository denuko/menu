package com.devan.Menu.dao.repository;

import com.devan.Menu.dao.model.Ingredient;
import com.devan.Menu.dao.model.MenuItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MenuItemIngredientRepository extends JpaRepository<Ingredient, Long>, QuerydslPredicateExecutor<MenuItemIngredient> {
}
