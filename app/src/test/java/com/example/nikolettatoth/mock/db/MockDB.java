package com.example.nikolettatoth.mock.db;

import android.content.Context;

import com.example.nikolettatoth.recepies_andoid.database.Repository;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.network.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MockDB implements Repository {
    List<MealModel> meals = new ArrayList<MealModel>();

    public MockDB(){
        this.meals.add(new MealModel(){{
            setPicture("pic");
            setInstructions("ins");
            setName("name");
            setId(1);
            setIngredients("ingr");
        }});
        this.meals.add(new MealModel(){{
            setPicture("pic1");
            setInstructions("ins1");
            setName("name1");
            setId(2);
            setIngredients("ingr1");
        }});
    }

    @Override
    public void open(Context context) {

    }

    @Override
    public void close() {

    }

    @Override
    public List<MealModel> getAllMeals() {
        return meals;
    }

    @Override
    public MealModel getMealById(long id) {
        for(MealModel m : meals){
            if(m.getId()== id){
                return m;
            }
        }
        return null;
    }

    @Override
    public void saveMeal(MealModel meal) {
        this.meals.add(meal);
    }

    @Override
    public void saveAllMeals(List<MealModel> meals) {
        this.meals.addAll(meals);
    }

    @Override
    public void updateMeals(List<MealModel> newMeals) {
        List<MealModel> oldList = this.meals;
        List<MealModel> toUpdate = new ArrayList<MealModel>(oldList.size());
        for(MealModel om : oldList){
            for(MealModel im : newMeals){
                if(om.getId() == im.getId()){
                    toUpdate.add(im);
                }
            }
        }
        this.meals = toUpdate;
    }

    @Override
    public void removeMeal(MealModel meal) {

    }

    @Override
    public void removeAll() {
        this.meals =new ArrayList<MealModel>();

    }

    @Override
    public boolean isInDB(MealModel meal) {
        for(MealModel m : this.meals){
            if(m.getId()==meal.getId()){
                return true;
            }
        }
        return false;
    }
}
