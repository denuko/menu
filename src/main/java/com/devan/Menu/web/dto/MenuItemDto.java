package com.devan.Menu.web.dto;

import com.devan.Menu.dao.enums.MenuItemCategory;
import com.devan.Menu.dao.model.MenuItem;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class MenuItemDto {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private MenuItemCategory type;

    private List<IngredientQuantityDto> ingredients;

    private Instant postedAt;

    private Instant lastUpdatedAt;

    public MenuItemDto fromEntity(MenuItem menuItem) {
        setId(menuItem.getId());
        setName(menuItem.getName());
        setDescription(menuItem.getDescription());
        setPrice(menuItem.getPrice());
        setPostedAt(menuItem.getPostedAt());
        setLastUpdatedAt(menuItem.getLastUpdatedAt());
        setType(menuItem.getType());

        return this;
    }

    public MenuItem toEntity() {
        MenuItem menuItem = new MenuItem();
        menuItem.setId(getId());
        menuItem.setName(getName());
        menuItem.setDescription(getDescription());
        menuItem.setPrice(getPrice());
        menuItem.setType(getType());

        return menuItem;
    }
}
