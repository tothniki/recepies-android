package com.example.nikolettatoth.recepies_andoid.model;

import java.util.ArrayList;
import java.util.List;

public class MealModel {
    private String id;
    private String name;
    private List<String> ingredients = new ArrayList<String>();
    private String instructions;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructions() {
        return instructions;
    }
}
