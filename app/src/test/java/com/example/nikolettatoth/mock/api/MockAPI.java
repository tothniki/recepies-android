package com.example.nikolettatoth.mock.api;

import com.example.nikolettatoth.recepies_andoid.network.api.MealApi;
import com.example.nikolettatoth.recepies_andoid.network.model.Meal;
import com.example.nikolettatoth.recepies_andoid.network.model.MealInCategory;
import com.example.nikolettatoth.recepies_andoid.network.model.Meals;
import com.example.nikolettatoth.recepies_andoid.network.model.MealsByCategory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockAPI implements MealApi{

    @Override
    public Call<MealsByCategory> getMealsByCategory(String c) {
        final MealsByCategory mealbycat = new MealsByCategory(){{
            setMeals(new ArrayList<MealInCategory>() {{
                add(new MealInCategory(){{
                    setIdMeal("1");
                    setStrMeal("a");
                    setStrMealThumb("b");
                }});
                add(new MealInCategory(){{
                    setIdMeal("2");
                    setStrMeal("c");
                    setStrMealThumb("d");
                }});
            }});
        }};

        Call<MealsByCategory> call = new Call<MealsByCategory>() {
            @Override
            public Response<MealsByCategory> execute() throws IOException {
                return Response.success(mealbycat);
            }

            @Override
            public void enqueue(Callback<MealsByCategory> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<MealsByCategory> clone() {
                return null;
            }

        };
        return call;
    }

    @Override
    public Call<Meals> getMealById(String i) {
        Meal meal1 = null;
        if(i.equals("1")){
            meal1=new Meal(){{
               setIdMeal("1");
               setStrIngredient1("i0");
               setStrMeasure1("m0");
               setStrInstructions("e");
               setStrMeal("name0");
               setStrMealThumb("url0");
            }};
        }else if(i.equals("2")){
            meal1=new Meal(){{
                setIdMeal("2");
                setStrIngredient1("i");
                setStrMeasure1("m");
                setStrInstructions("j");
                setStrMeal("name");
                setStrMealThumb("url");
            }};
        }

        final Meal finalMeal = meal1;
        final Meals meals = new Meals(){{
           setMeals(new ArrayList<Meal>(){{
             add(finalMeal);
           }});
        }};
        Call<Meals> call = new Call<Meals>() {
            @Override
            public Response<Meals> execute() throws IOException {
                return Response.success(meals);
            }

            @Override
            public void enqueue(Callback<Meals> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Meals> clone() {
                return null;
            }
        };
        return call;
    }
}
