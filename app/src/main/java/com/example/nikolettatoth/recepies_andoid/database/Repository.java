package com.example.nikolettatoth.recepies_andoid.database;

import android.content.Context;

import com.example.nikolettatoth.recepies_andoid.model.MealModel;

import java.util.List;

import dagger.Module;
import dagger.Provides;

public interface Repository {

    void open(Context context);

    void close();

    List<MealModel> getAllMeals();

    MealModel getMealById(long id);

    void saveMeal(MealModel meal);

    void saveAllMeals (List<MealModel> meals);

    void updateMeals(List<MealModel> newMeals);

    void removeMeal(MealModel meal);

    void removeAll();

    boolean isInDB(MealModel meal);
}