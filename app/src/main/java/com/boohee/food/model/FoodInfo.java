package com.boohee.food.model;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;

public class FoodInfo
{
  public String appraise;
  public String calory;
  public String carbohydrate;
  public String code;
  public FoodCompare compare;
  public String fat;
  public String fiber_dietary;
  public int health_light;
  public int id;
  public FoodIngredient ingredient;
  public boolean is_liquid;
  public String large_image_url;
  public FoodLights lights;
  public String name;
  public String protein;
  public String thumb_image_url;
  public String weight;
  
  public static FoodInfo parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      localFoodInfo = (FoodInfo)JSONObject.parseObject(paramString, FoodInfo.class);
      return localFoodInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        FoodInfo localFoodInfo = null;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.FoodInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */