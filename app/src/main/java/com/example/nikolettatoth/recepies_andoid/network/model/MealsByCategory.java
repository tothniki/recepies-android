package com.example.nikolettatoth.recepies_andoid.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.example.nikolettatoth.recepies_andoid.network.model.MealInCategory;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


/**
 * Based on the API, if you want to get meals by category,
 * the get method return a meals[] array with MealInCategory elements
 **/
@ApiModel(description = "")
public class MealsByCategory   {
  
  @SerializedName("meals")
  private List<MealInCategory> meals = new ArrayList<MealInCategory>();
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<MealInCategory> getMeals() {
    return meals;
  }
  public void setMeals(List<MealInCategory> meals) {
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
    MealsByCategory mealsByCategory = (MealsByCategory) o;
    return Objects.equals(meals, mealsByCategory.meals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MealsByCategory {\n");
    
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
