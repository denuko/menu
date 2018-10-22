package com.devan.Menu.web;

import com.devan.Menu.service.IngredientService;
import com.devan.Menu.web.dto.IngredientDto;
import com.devan.Menu.web.exception.ValidationException;
import com.devan.Menu.web.validator.IngredientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/ingredient")
public class IngredientController {

    // TODO: Replace it with constructor injection
    @Autowired
    IngredientService ingredientService;
    private final IngredientValidator validator;

    public IngredientController(IngredientValidator validator) {
        this.validator = validator;
    }

    @PostMapping("post")
    public ResponseEntity<IngredientDto> postIngredient(@Valid @RequestBody IngredientDto ingredientDto, BindingResult result) throws ValidationException {
//        validator.validate(ingredientDto, result);
//
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ingredientService.createIngredient(ingredientDto));
    }

    //
//    @GetMapping("get")
//    public List<IngredientDto> getIngredients() {
//
//    }
//
    @PutMapping("put/{id}")
    public ResponseEntity<IngredientDto> putIngredient(@Valid @RequestBody IngredientDto ingredientDto, @PathVariable Long id, BindingResult result) throws ValidationException {
        ingredientDto.setId(id);
        validator.validate(ingredientDto, result);

        if (result.hasErrors()) {
            throw new ValidationException(result);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredientService.updateIngredient(ingredientDto, id));
    }
//
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Ingredient id " + id + " deleted successfully.");
    }
}
