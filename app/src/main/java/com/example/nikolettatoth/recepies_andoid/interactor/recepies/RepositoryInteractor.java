package com.example.nikolettatoth.recepies_andoid.interactor.recepies;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.database.Repository;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;

import java.util.List;

import javax.inject.Inject;

public class RepositoryInteractor {
    @Inject
    Repository repository;

    public RepositoryInteractor() {
        RecepiesApplication.injector.inject(this);
    };

    public List<MealModel> getAllMeals(){
        return repository.getAllMeals();
    };

    public MealModel getMealById(final long id){return repository.getMealById(id);};

    public void saveMeal(MealModel meal){
        repository.saveMeal(meal);
    };

    public void saveAllMeals(List<MealModel> meals){
        repository.saveAllMeals(meals);
    };

    public void updateMeals(List<MealModel> newMeals){
        repository.updateMeals(newMeals);
    };

    public void removeMeal(MealModel meal){
        repository.removeMeal(meal);
    };

    public void removeAll(){
        repository.removeAll();
    };

    public boolean isInDB(MealModel meal){
        return repository.isInDB(meal);
    };


}
