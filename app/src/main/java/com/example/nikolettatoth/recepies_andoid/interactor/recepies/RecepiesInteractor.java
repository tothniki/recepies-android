package com.example.nikolettatoth.recepies_andoid.interactor.recepies;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.database.Repository;
import com.example.nikolettatoth.recepies_andoid.network.api.MealApi;
import com.example.nikolettatoth.recepies_andoid.network.model.Meals;
import com.example.nikolettatoth.recepies_andoid.network.model.MealsByCategory;

import java.io.IOException;

import javax.inject.Inject;

public class RecepiesInteractor {

    @Inject
    MealApi mealApi;

    //@Inject
    //Repository repository;

    public RecepiesInteractor(){
        RecepiesApplication.injector.inject(this);
    }

    public MealsByCategory getMealsByCategory(String category) throws IOException{
        return this.mealApi.getMealsByCategory(category).execute().body();
    }

    public Meals getMealById(String id) throws IOException{
        return this.mealApi.getMealById(id).execute().body();
    }

    //TODO Meals modelből a MealModel-re váltani !

}
