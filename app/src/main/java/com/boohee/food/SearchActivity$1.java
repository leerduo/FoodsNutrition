package com.boohee.food;

import android.app.Activity;
import com.alibaba.fastjson.JSON;
import com.boohee.food.model.Food;
import com.boohee.food.util.KeyBoardUtils;
import com.boohee.food.volley.JsonCallback;
import java.util.List;
import org.json.JSONObject;

class SearchActivity$1
  extends JsonCallback
{
  SearchActivity$1(SearchActivity paramSearchActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.d();
    KeyBoardUtils.a(this.a.a, this.a.c);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    try
    {
      List localList = JSON.parseArray(paramJSONObject.optString("foods"), Food.class);
      SearchActivity.a(this.a, localList);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.SearchActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */