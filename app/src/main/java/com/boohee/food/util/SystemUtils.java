package com.boohee.food.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.boohee.food.FoodApplication;

public class SystemUtils
{
  public static String a()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      Exception localException2;
      localException2.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        if (TextUtils.isEmpty(str)) {
          str = "";
        }
        return str;
      }
      catch (Exception localException3)
      {
        String str;
        break label34;
      }
      localException1 = localException1;
      str = "";
      localException2 = localException1;
    }
    label34:
    return str;
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  public static int c()
  {
    Context localContext = FoodApplication.a();
    try
    {
      int i = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.SystemUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */