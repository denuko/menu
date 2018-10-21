package com.devan.Menu.service;

import com.devan.Menu.dao.model.Ingredient;
import com.devan.Menu.dao.repository.IngredientRepository;
import com.devan.Menu.web.dto.IngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public IngredientDto createIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientDto.toEntity();
        ingredient.setPostedAt(Instant.now());
        ingredient = ingredientRepository.save(ingredient);

        return new IngredientDto().fromEntity(ingredient);
    }

//    public List<IngredientDto> findIngredients() {
//
//        return ingredientRepository.findByType()
//                .stream()
//                .map(ingredient -> new IngredientDto().fromEntity(ingredient))
//                .collect(Collectors.toList());
//    }

    public Ingredient findById(Long id) {
        return ingredientRepository.getOne(id);
    }

    public List<IngredientDto> findIngredientsByType(String type) {

        return ingredientRepository.findByType(type)
                .stream()
                .map(ingredient -> new IngredientDto().fromEntity(ingredient))
                .collect(Collectors.toList());
    }

    public IngredientDto updateIngredient(IngredientDto ingredientDto, Long id) {
        Ingredient ingredient = ingredientRepository.getOne(id);
        ingredient = ingredientDto.toEntity(ingredient);
        ingredient.setLastUpdatedAt(Instant.now());
        ingredient = ingredientRepository.save(ingredient);

        return new IngredientDto().fromEntity(ingredient);
    }

    public void deleteIngredient(Long id) {
        Ingredient ingredient = ingredientRepository.getOne(id);
        ingredientRepository.delete(ingredient);
    }
}
