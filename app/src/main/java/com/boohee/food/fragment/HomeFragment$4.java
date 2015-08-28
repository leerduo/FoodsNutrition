package com.boohee.food.fragment;

import android.app.Activity;
import com.boohee.food.cache.FileCache;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

class HomeFragment$4
  extends JsonCallback
{
  HomeFragment$4(HomeFragment paramHomeFragment, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.b();
    HomeFragment.e(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      HomeFragment.b(this.a, paramJSONObject);
      HomeFragment.c(this.a).a("CACHE_HOME_TOPICS", paramJSONObject.toString());
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeFragment.4
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */