package com.example.nikolettatoth.recepies_andoid.ui.main;

import com.example.nikolettatoth.recepies_andoid.RecepiesApplication;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RecepiesInteractor;
import com.example.nikolettatoth.recepies_andoid.interactor.recepies.RepositoryInteractor;
import com.example.nikolettatoth.recepies_andoid.model.MealModel;
import com.example.nikolettatoth.recepies_andoid.network.model.Meal;
import com.example.nikolettatoth.recepies_andoid.network.model.MealInCategory;
import com.example.nikolettatoth.recepies_andoid.network.model.Meals;
import com.example.nikolettatoth.recepies_andoid.network.model.MealsByCategory;
import com.example.nikolettatoth.recepies_andoid.ui.Presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    RecepiesInteractor recepiesInteractor;

    @Inject
    RepositoryInteractor repositoryInteractor;

    Executor executor;

   // public MainPresenter(){
   //     RecepiesApplication.injector.inject(this);
   // }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        RecepiesApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void downloadMeals(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    MealsByCategory mealsByCategory = recepiesInteractor.getMealsByCategory("Desert");
                    List<MealInCategory> mealIDs = mealsByCategory.getMeals();
                    List<Meal> mealList = new ArrayList<Meal>();
                    for (MealInCategory mealId : mealIDs) {
                        Meals meals = recepiesInteractor.getMealById(mealId.getIdMeal()); //return a list with 1 element
                        mealList.add(meals.getMeals().get(0));
                    }
                    List<MealModel> reducedMealList = saveMeals(mealList);
                    screen.showMeals(reducedMealList);
                }catch(IOException e){
                    e.printStackTrace();
                }

            }
        });
    }

    private List<MealModel> saveMeals(final List<Meal> mealList){
        Meal[] meals= new Meal[mealList.size()];
        meals = mealList.toArray(meals);

        MealModel meal = new MealModel();
        List<MealModel> newList = new ArrayList<MealModel>();

        for (Meal m : meals) {
            meal.setId(Integer.parseInt(m.getIdMeal()));
            meal.setName(m.getStrMeal());
            meal.setInstructions(m.getStrInstructions());
            meal.setPicture(m.getStrMealThumb());
            meal.setIngredients(createIngredientsList(m));
            newList.add(meal);
        }

        repositoryInteractor.removeAll();
        repositoryInteractor.saveAllMeals(newList);
        return newList;
    }

    private List<String> createIngredientsList(Meal m){
        List<String> ingredients = new ArrayList<String>();
        ingredients.add(m.getStrIngredient1()+' ' + m.getStrMeasure1());
        ingredients.add(m.getStrIngredient2()+' ' + m.getStrMeasure2());
        ingredients.add(m.getStrIngredient3()+' ' + m.getStrMeasure3());
        ingredients.add(m.getStrIngredient4()+' ' + m.getStrMeasure4());
        ingredients.add(m.getStrIngredient5()+' ' + m.getStrMeasure5());
        ingredients.add(m.getStrIngredient6()+' ' + m.getStrMeasure6());
        ingredients.add(m.getStrIngredient7()+' ' + m.getStrMeasure7());
        ingredients.add(m.getStrIngredient8()+' ' + m.getStrMeasure8());
        ingredients.add(m.getStrIngredient9()+' ' + m.getStrMeasure9());
        ingredients.add(m.getStrIngredient10()+' ' + m.getStrMeasure10());
        ingredients.add(m.getStrIngredient11()+' ' + m.getStrMeasure11());
        ingredients.add(m.getStrIngredient12()+' ' + m.getStrMeasure12());
        ingredients.add(m.getStrIngredient13()+' ' + m.getStrMeasure13());
        ingredients.add(m.getStrIngredient14()+' ' + m.getStrMeasure14());
        ingredients.add(m.getStrIngredient15()+' ' + m.getStrMeasure15());
        ingredients.add(m.getStrIngredient16()+' ' + m.getStrMeasure16());
        ingredients.add(m.getStrIngredient17()+' ' + m.getStrMeasure17());
        ingredients.add(m.getStrIngredient18()+' ' + m.getStrMeasure18());
        ingredients.add(m.getStrIngredient19()+' ' + m.getStrMeasure19());
        ingredients.add(m.getStrIngredient20()+' ' + m.getStrMeasure20());
        return ingredients;
    }

    public void loadMealsFromRepo(){
        executor.execute(new Runnable(){
            @Override
            public void run(){
                List<MealModel> mealList = repositoryInteractor.getAllMeals();
                screen.showMeals(mealList);
            }
        });
    }

}
