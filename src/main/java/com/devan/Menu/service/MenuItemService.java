package com.devan.Menu.service;

import com.devan.Menu.dao.model.Ingredient;
import com.devan.Menu.dao.model.MenuItem;
import com.devan.Menu.dao.model.MenuItemIngredient;
import com.devan.Menu.dao.repository.MenuItemRepository;
import com.devan.Menu.web.dto.MenuItemDto;
import com.devan.Menu.web.mapper.MenuItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;

@Service
@Transactional
public class MenuItemService {

    private final MenuItemRepository repository;

    private final MenuItemMapper mapper;

    private final IngredientService ingredientService;

    public MenuItemService(MenuItemRepository menuItemRepository, MenuItemMapper menuItemMapper, IngredientService ingredientService) {
        this.repository = menuItemRepository;
        this.mapper = menuItemMapper;
        this.ingredientService = ingredientService;
    }

    public MenuItemDto createMenuItem(MenuItemDto menuItemDto) {

        MenuItem menuItem = mapper.mapToEntity(menuItemDto);

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
        repository.save(menuItem);

        return mapper.mapToDto(menuItem);
    }
}
