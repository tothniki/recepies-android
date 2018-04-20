package com.example.nikolettatoth.recepies_andoid.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;


/**
 * A meal listed in a category looks like this.
 **/

@ApiModel(description = "")
public class MealInCategory   {
  
  @SerializedName("strMeal")
  private String strMeal = null;
  
  @SerializedName("strMealThumb")
  private String strMealThumb = null;
  
  @SerializedName("idMeal")
  private String idMeal = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getStrMeal() {
    return strMeal;
  }
  public void setStrMeal(String strMeal) {
    this.strMeal = strMeal;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getStrMealThumb() {
    return strMealThumb;
  }
  public void setStrMealThumb(String strMealThumb) {
    this.strMealThumb = strMealThumb;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getIdMeal() {
    return idMeal;
  }
  public void setIdMeal(String idMeal) {
    this.idMeal = idMeal;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MealInCategory mealInCategory = (MealInCategory) o;
    return Objects.equals(strMeal, mealInCategory.strMeal) &&
        Objects.equals(strMealThumb, mealInCategory.strMealThumb) &&
        Objects.equals(idMeal, mealInCategory.idMeal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(strMeal, strMealThumb, idMeal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MealInCategory {\n");
    
    sb.append("    strMeal: ").append(toIndentedString(strMeal)).append("\n");
    sb.append("    strMealThumb: ").append(toIndentedString(strMealThumb)).append("\n");
    sb.append("    idMeal: ").append(toIndentedString(idMeal)).append("\n");
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
