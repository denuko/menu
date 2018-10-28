package com.devan.Menu.web;

import com.devan.Menu.service.MenuItemService;
import com.devan.Menu.web.dto.MenuItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/menu-item")
public class MenuItemController {

    private final MenuItemService service;

    public MenuItemController(MenuItemService menuItemService) {
        this.service = menuItemService;
    }


    // TODO: Add get, put, delete
    // TODO: Validate
    @PostMapping("post")
    public ResponseEntity<MenuItemDto> postMenuItem(@RequestBody MenuItemDto menuItemDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createMenuItem(menuItemDto));
    }
}
