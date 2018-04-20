package com.example.nikolettatoth.recepies_andoid.network.api;

import com.example.nikolettatoth.recepies_andoid.network.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.example.nikolettatoth.recepies_andoid.network.model.MealsByCategory;
import com.example.nikolettatoth.recepies_andoid.network.model.Meals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MealApi {
  
  /**
   * 
   * 
   * @param c Category
   * @return Call<MealsByCategory>
   */
  
  @GET("filter.php")
  Call<MealsByCategory> getMealsByCategory(
          @Query("c") String c
  );

  
  /**
   * 
   * 
   * @param i ID
   * @return Call<Meals>
   */
  
  @GET("lookup.php")
  Call<Meals> getMealById(
          @Query("i") String i
  );

  
}
