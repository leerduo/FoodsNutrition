package com.boohee.food.util;

import android.content.Context;
import android.widget.Toast;
import com.boohee.food.FoodApplication;

public class ToastUtils
{
  public static void a(int paramInt)
  {
    a(FoodApplication.a().getString(paramInt));
  }
  
  public static void a(String paramString)
  {
    Toast.makeText(FoodApplication.a(), paramString, 0).show();
  }
  
  public static void b(int paramInt)
  {
    b(FoodApplication.a().getString(paramInt));
  }
  
  public static void b(String paramString)
  {
    Toast.makeText(FoodApplication.a(), paramString, 1).show();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.ToastUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */