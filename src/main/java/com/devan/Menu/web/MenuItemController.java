package com.devan.Menu.web;

import com.devan.Menu.dao.enums.IngredientType;
import com.devan.Menu.service.MenuItemService;
import com.devan.Menu.web.dto.MenuItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/menu-item")
public class MenuItemController {

    private final MenuItemService service;

    public MenuItemController(MenuItemService menuItemService) {
        this.service = menuItemService;
    }


    // TODO: Add get, put, delete
    // TODO: Validate
    @PostMapping("")
    public ResponseEntity<MenuItemDto> postMenuItem(@RequestBody MenuItemDto menuItemDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createMenuItem(menuItemDto));
    }

    @GetMapping("{ingredientType}")
    public List<MenuItemDto> getMenuItemsByIngredientType(@PathVariable IngredientType ingredientType) {
        return service.findMenuItemsByIngredientType(ingredientType);
    }
}
