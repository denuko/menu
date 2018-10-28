package com.devan.Menu.web.mapper;

import com.devan.Menu.dao.model.Ingredient;
import com.devan.Menu.web.dto.IngredientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IngredientMapper extends MyMapper<Ingredient, IngredientDto> {

    @Mapping(target = "postedAt", ignore = true)
    void mapToExistingEntity(IngredientDto ingredientDto, @MappingTarget Ingredient ingredient);
}
