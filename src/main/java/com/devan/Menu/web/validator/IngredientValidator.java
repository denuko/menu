package com.devan.Menu.web.validator;

import com.devan.Menu.web.dto.IngredientDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class IngredientValidator {

    public void validate(IngredientDto dto, BindingResult result) {
        if (!(dto.getId() > 0)) {
            result.rejectValue("id", "INVALID_ID", "id must be positive integer");
        }
    }
}
