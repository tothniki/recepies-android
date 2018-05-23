package com.example.nikolettatoth.recepies_andoid.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import java.util.ArrayList;
import java.util.List;

@Table
public class MealModel{
    private long id;
    private String name;
    private String ingredients;
    private String instructions;
    private String picture;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
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

