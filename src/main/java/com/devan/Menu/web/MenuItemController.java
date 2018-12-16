package com.devan.Menu.web;

import com.devan.Menu.dao.enums.IngredientType;
import com.devan.Menu.service.MenuItemService;
import com.devan.Menu.web.dto.MenuItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        menuItemDto = service.createMenuItem(menuItemDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(menuItemDto.getId()).toUri();

        return ResponseEntity
                .created(location)
                .body(menuItemDto);
    }

    @GetMapping("{ingredientType}")
    public List<MenuItemDto> getMenuItemsByIngredientType(@PathVariable IngredientType ingredientType) {
        return service.findMenuItemsByIngredientType(ingredientType);
    }
}
