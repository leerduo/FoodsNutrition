package com.boohee.food.fragment;

import android.app.Activity;
import com.alibaba.fastjson.JSON;
import com.boohee.food.model.Food;
import com.boohee.food.volley.JsonCallback;
import java.util.List;
import org.json.JSONObject;

class FoodListFragment$1
  extends JsonCallback
{
  FoodListFragment$1(FoodListFragment paramFoodListFragment, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.b();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    try
    {
      List localList = JSON.parseArray(paramJSONObject.optString("foods"), Food.class);
      FoodListFragment.a(this.a, localList);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.FoodListFragment.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */