package com.devan.Menu.service;

import com.devan.Menu.dao.model.Ingredient;
import com.devan.Menu.dao.model.MenuItem;
import com.devan.Menu.dao.model.MenuItemIngredient;
import com.devan.Menu.dao.repository.MenuItemRepository;
import com.devan.Menu.web.dto.MenuItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;

@Service
@Transactional
public class MenuItemService {

    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    IngredientService ingredientService;

    public MenuItemDto createMenuItem(MenuItemDto menuItemDto) {

        MenuItem menuItem = menuItemDto.toEntity();

        menuItemDto.getIngredients()
                .forEach(ingredientQuantityDto -> {
                    Ingredient ingredient = ingredientService.findById(ingredientQuantityDto.getId());
                    MenuItemIngredient menuItemIngredient = new MenuItemIngredient();
                    menuItemIngredient.setQuantity(ingredientQuantityDto.getQuantity());
                    menuItemIngredient.setIngredient(ingredient);
                    menuItemIngredient.setMenuItem(menuItem);
                    menuItem.setIngredients(new ArrayList<>());
                    menuItem.getIngredients().add(menuItemIngredient);
                });

        menuItem.setPostedAt(Instant.now());
        menuItemRepository.save(menuItem);

        return new MenuItemDto().fromEntity(menuItem);
    }
}
