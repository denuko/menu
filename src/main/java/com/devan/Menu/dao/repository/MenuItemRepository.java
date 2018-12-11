package com.devan.Menu.dao.repository;

import com.devan.Menu.dao.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long>, QuerydslPredicateExecutor<MenuItem> {
}
