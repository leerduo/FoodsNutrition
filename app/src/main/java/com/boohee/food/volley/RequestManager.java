package com.boohee.food.volley;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.boohee.food.FoodApplication;

public class RequestManager
{
  public static RequestQueue a = Volley.a(FoodApplication.a());
  
  public static void a(Request<?> paramRequest, Object paramObject)
  {
    if (paramObject != null) {
      paramRequest.a(paramObject);
    }
    a.a(paramRequest);
  }
  
  public static void a(Object paramObject)
  {
    a.a(paramObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.volley.RequestManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */