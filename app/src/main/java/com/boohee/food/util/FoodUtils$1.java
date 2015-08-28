package com.boohee.food.util;

import com.boohee.food.model.IngredientInfo;
import java.util.Comparator;

final class FoodUtils$1
  implements Comparator<IngredientInfo>
{
  public int a(IngredientInfo paramIngredientInfo1, IngredientInfo paramIngredientInfo2)
  {
    return paramIngredientInfo1.order - paramIngredientInfo2.order;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.FoodUtils.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */