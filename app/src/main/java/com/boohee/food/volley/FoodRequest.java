package com.boohee.food.volley;

import android.content.Context;

public class FoodRequest
  extends BaseJsonRequest
{
  public FoodRequest(int paramInt, String paramString, JsonParams paramJsonParams, JsonCallback paramJsonCallback)
  {
    super(paramInt, paramString, paramJsonParams, paramJsonCallback, paramJsonCallback);
  }
  
  public static void a(int paramInt, String paramString, JsonParams paramJsonParams, JsonCallback paramJsonCallback, Context paramContext)
  {
    RequestManager.a(new FoodRequest(paramInt, y() + paramString, paramJsonParams, paramJsonCallback), paramContext);
  }
  
  public static void a(String paramString, JsonCallback paramJsonCallback, Context paramContext)
  {
    a(0, paramString, null, paramJsonCallback, paramContext);
  }
  
  public static void a(String paramString, JsonParams paramJsonParams, JsonCallback paramJsonCallback, Context paramContext)
  {
    a(1, paramString, paramJsonParams, paramJsonCallback, paramContext);
  }
  
  public static String y()
  {
    return "http://food.boohee.com";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.volley.FoodRequest
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */