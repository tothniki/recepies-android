package com.example.nikolettatoth.recepies_andoid.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.example.nikolettatoth.recepies_andoid.network.model.Meal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


/**
 * Based on the API, if you want to get a meal by id,
 * the get method return a meals[] array with 1 element, a Meal
 **/

@ApiModel(description = "")
public class Meals   {
  
  @SerializedName("meals")
  private List<Meal> meals = new ArrayList<Meal>();
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<Meal> getMeals() {
    return meals;
  }
  public void setMeals(List<Meal> meals) {
    this.meals = meals;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Meals meals = (Meals) o;
    return Objects.equals(meals, meals.meals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Meals {\n");
    
    sb.append("    meals: ").append(toIndentedString(meals)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
