package com.example.nikolettatoth.recepies_andoid.model;

import com.orm.dsl.Table;

import java.util.ArrayList;
import java.util.List;

@Table
public class MealModel {
    private long id;
    private String name;
    private List<String> ingredients = new ArrayList<String>();
    private String instructions;
    private String picture;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

