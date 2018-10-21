package com.devan.Menu.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class MenuItemIngredient implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "MENU_ITEM_ID", nullable = false)
    private MenuItem menuItem;

    @Id
    @ManyToOne
    @JoinColumn(name = "INGREDIENT_ID", nullable = false)
    private Ingredient ingredient;

    @Column(nullable = false)
    private Double quantity;

}
