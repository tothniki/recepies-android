package com.example.nikolettatoth.recepies_andoid.database;

import android.content.Context;

import com.example.nikolettatoth.recepies_andoid.model.MealModel;

import java.util.List;

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    public static List<MealModel> meals;

    @Override
    public void open(Context context) {
    }

    @Override
    public void close() {

    }

    @Override
    public List<MealModel> getMeals() {
        return meals;
    }

    @Override
    public void saveMeal(MealModel meal) {
        meals.add(meal);

    }

    @Override
    public void updateMeals(List<MealModel> newMeals) {
        for (int i = 0; i < this.meals.size(); i++) {
            MealModel oldmeal = this.meals.get(i);
            for (MealModel newmeal : newMeals) {
                if (newmeal.getId()==oldmeal.getId()) {
                    this.meals.set(i, newmeal);
                }
            }
        }
    }

    @Override
    public void removeMeal(MealModel meal) {
        meals.remove(meal);
    }

    @Override
    public boolean isInDB(MealModel meal) {
        return meals.contains(meal);
    }

}