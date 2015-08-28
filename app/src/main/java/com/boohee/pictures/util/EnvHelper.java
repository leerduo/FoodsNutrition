package com.boohee.pictures.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public class EnvHelper
{
  public static int getApiVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static EnvHelper.NetType getNetworkType(Context paramContext)
  {
    EnvHelper.NetType localNetType = EnvHelper.NetType.NO_NET;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return EnvHelper.NetType.NO_NET;
    }
    int i = localNetworkInfo.getType();
    if (i == 0)
    {
      if (localNetworkInfo.getExtraInfo().toLowerCase().contains("wap")) {
        return EnvHelper.NetType.WAP;
      }
      return EnvHelper.NetType.NET;
    }
    if (i == 1) {
      return EnvHelper.NetType.WIFI;
    }
    return localNetType;
  }
  
  public static String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return 0;
  }
  
  public static String getVersionName(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.util.EnvHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */