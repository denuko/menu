package com.devan.Menu.service;

import com.devan.Menu.dao.enums.ErrorMessage;
import com.devan.Menu.dao.enums.IngredientType;
import com.devan.Menu.dao.model.Ingredient;
import com.devan.Menu.dao.repository.IngredientRepository;
import com.devan.Menu.web.dto.IngredientDto;
import com.devan.Menu.web.mapper.IngredientMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientService {

    private final IngredientRepository repository;

    private final IngredientMapper mapper;

    public IngredientService(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.repository = ingredientRepository;
        this.mapper = ingredientMapper;
    }

    public IngredientDto createIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = mapper.mapToEntity(ingredientDto);
        ingredient.setPostedAt(Instant.now());
        ingredient = repository.save(ingredient);

        return mapper.mapToDto(ingredient);
    }

//    public List<IngredientDto> findIngredients() {
//
//        return repository.findByType()
//                .stream()
//                .map(ingredient -> new IngredientDto().fromEntity(ingredient))
//                .collect(Collectors.toList());
//    }

    public Ingredient findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ErrorMessage.NOT_FOUND.getMessage() + id));
    }

    public List<IngredientDto> findIngredientsByType(IngredientType type) {

        return repository.findByType(type)
                .stream()
                .map(ingredient -> mapper.mapToDto(ingredient))
                .collect(Collectors.toList());
    }

    public IngredientDto updateIngredient(IngredientDto ingredientDto, Long id) {
        Ingredient ingredient = findById(id);
        mapper.mapToExistingEntity(ingredientDto, ingredient);

        ingredient.setLastUpdatedAt(Instant.now());

        return mapper.mapToDto(ingredient);
    }

    public void deleteIngredient(Long id) {
        Ingredient ingredient = findById(id);
        repository.delete(ingredient);
    }
}
