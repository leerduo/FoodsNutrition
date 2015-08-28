package com.boohee.food.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.boohee.food.FoodApplication;

public class NetworkUtils
{
  public static boolean a()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)FoodApplication.a().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        return i == 1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.NetworkUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */