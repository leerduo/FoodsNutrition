package com.boohee.food.volley;

import android.content.Context;

public class IFoodRequest
  extends BaseJsonRequest
{
  public IFoodRequest(int paramInt, String paramString, JsonParams paramJsonParams, JsonCallback paramJsonCallback)
  {
    super(paramInt, paramString, paramJsonParams, paramJsonCallback, paramJsonCallback);
  }
  
  public static void a(int paramInt, String paramString, JsonParams paramJsonParams, JsonCallback paramJsonCallback, Context paramContext)
  {
    RequestManager.a(new IFoodRequest(paramInt, y() + paramString, paramJsonParams, paramJsonCallback), paramContext);
  }
  
  public static void a(String paramString, JsonCallback paramJsonCallback, Context paramContext)
  {
    a(0, paramString, null, paramJsonCallback, paramContext);
  }
  
  public static String y()
  {
    return "http://ifood.boohee.com";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.volley.IFoodRequest
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */