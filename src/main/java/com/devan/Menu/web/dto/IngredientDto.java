package com.devan.Menu.web.dto;

import com.devan.Menu.dao.enums.IngredientType;
import com.devan.Menu.dao.model.Ingredient;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class IngredientDto implements Serializable {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private IngredientType type;

    private Instant postedAt;

    private Instant lastUpdatedAt;

    private List<IngredientQuantityDto> menuItemsDto;

    public IngredientDto fromEntity(Ingredient ingredient) {
        setId(ingredient.getId());
        setName(ingredient.getName());
        setType(ingredient.getType());
        setPostedAt(ingredient.getPostedAt());
        setLastUpdatedAt(ingredient.getLastUpdatedAt());

        return this;
    }

    public Ingredient toEntity() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(getId());
        ingredient.setName(getName());
        ingredient.setType(getType());

        return ingredient;
    }

    public Ingredient toEntity(Ingredient ingredient) {
        ingredient.setName(getName());
        ingredient.setType(getType());

        return ingredient;
    }
}
