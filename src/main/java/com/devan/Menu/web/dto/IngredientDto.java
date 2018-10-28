package com.devan.Menu.web.dto;

import com.devan.Menu.dao.enums.IngredientType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

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
}
