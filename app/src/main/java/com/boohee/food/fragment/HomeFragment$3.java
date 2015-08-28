package com.boohee.food.fragment;

import android.app.Activity;
import com.boohee.food.cache.FileCache;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

class HomeFragment$3
  extends JsonCallback
{
  HomeFragment$3(HomeFragment paramHomeFragment, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.b();
    HomeFragment.d(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    HomeFragment.a(this.a, paramJSONObject);
    HomeFragment.c(this.a).a("CACHE_HOME_BANNER", paramJSONObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeFragment.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */