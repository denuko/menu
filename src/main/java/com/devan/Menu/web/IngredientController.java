package com.devan.Menu.web;

import com.devan.Menu.dao.enums.IngredientType;
import com.devan.Menu.service.IngredientService;
import com.devan.Menu.web.dto.IngredientDto;
import com.devan.Menu.web.exception.ValidationException;
import com.devan.Menu.web.validator.IngredientValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/ingredient")
public class IngredientController {

    private final IngredientValidator validator;
    private final IngredientService service;

    public IngredientController(IngredientValidator validator,  IngredientService ingredientService) {
        this.validator = validator;
        this.service = ingredientService;
    }

    // TODO: Not working
    @PostMapping("")
    public ResponseEntity<IngredientDto> postIngredient(@Valid @RequestBody IngredientDto ingredientDto, BindingResult result) throws ValidationException {
//        validator.validate(ingredientDto, result);
//
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }

        ingredientDto = service.createIngredient(ingredientDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ingredientDto.getId()).toUri();

        return ResponseEntity
                .created(location)
                .body(ingredientDto);
    }


    @GetMapping("{type}")
    public List<IngredientDto> getIngredients(@PathVariable IngredientType type) {
        return service.findIngredientsByType(type);
    }

    @PutMapping("{id}")
    public ResponseEntity<IngredientDto> putIngredient(@Valid @RequestBody IngredientDto ingredientDto, @PathVariable Long id, BindingResult result) throws ValidationException {
        ingredientDto.setId(id);
        validator.validate(ingredientDto, result);

        if (result.hasErrors()) {
            throw new ValidationException(result);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateIngredient(ingredientDto, id));
    }
//
    @DeleteMapping("{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id) {
        service.deleteIngredient(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Ingredient id " + id + " deleted successfully.");
    }
}
