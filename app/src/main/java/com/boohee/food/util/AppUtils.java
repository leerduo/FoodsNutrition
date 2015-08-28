package com.boohee.food.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.boohee.food.FoodApplication;

public class AppUtils
{
  public static String a()
  {
    try
    {
      String str = FoodApplication.a().getPackageManager().getPackageInfo(FoodApplication.a().getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.AppUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */