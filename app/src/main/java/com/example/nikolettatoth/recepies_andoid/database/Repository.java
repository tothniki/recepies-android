package com.example.nikolettatoth.recepies_andoid.database;

import android.content.Context;

import com.example.nikolettatoth.recepies_andoid.model.MealModel;

import java.util.List;

public interface Repository {

    void open(Context context);

    void close();

    List<MealModel> getMeals();

    void saveMeal(MealModel meal);

    void updateMeals(List<MealModel> newMeals);

    void removeMeal(MealModel meal);

    boolean isInDB(MealModel meal);
}