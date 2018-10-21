package com.devan.Menu.web;

import com.devan.Menu.dao.model.Ingredient;
import com.devan.Menu.service.IngredientService;
import com.devan.Menu.web.dto.IngredientDto;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ingredient")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @PostMapping("post")
    public ResponseEntity<IngredientDto> postIngredient(@RequestBody IngredientDto ingredientDto) {
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
    public ResponseEntity<IngredientDto> putIngredient(@RequestBody IngredientDto ingredientDto, @PathVariable Long id) {
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
