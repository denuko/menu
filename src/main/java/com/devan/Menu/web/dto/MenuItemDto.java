package com.devan.Menu.web.dto;

import com.devan.Menu.dao.enums.MenuItemCategory;
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
}
