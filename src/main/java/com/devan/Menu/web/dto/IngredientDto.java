package com.devan.Menu.web.dto;

import com.devan.Menu.dao.enums.IngredientType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@ApiModel(description = "Ingredient details")
@Getter
@Setter
public class IngredientDto implements Serializable {

    private Long id;

    @NotBlank
    @ApiModelProperty(notes = "Required", example = "Bacon", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(notes = "Required", example = "MEAT", required = true)
    private IngredientType type;

    private Instant postedAt;

    private Instant lastUpdatedAt;
}
