package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.log.a;

public class Logger
{
  private static boolean a = false;
  private static LoggerInterface b = null;
  
  private static void a(Context paramContext)
  {
    if (b != null) {}
    com.xiaomi.push.log.b localb;
    for (int i = 1;; i = 0)
    {
      localb = new com.xiaomi.push.log.b(paramContext);
      if ((a) || (!b(paramContext)) || (i == 0)) {
        break;
      }
      com.xiaomi.channel.commonutils.logger.b.a(new a(b, localb));
      return;
    }
    if ((!a) && (b(paramContext)))
    {
      com.xiaomi.channel.commonutils.logger.b.a(localb);
      return;
    }
    if (i != 0)
    {
      com.xiaomi.channel.commonutils.logger.b.a(b);
      return;
    }
    com.xiaomi.channel.commonutils.logger.b.a(new a(null, null));
  }
  
  public static void a(Context paramContext, LoggerInterface paramLoggerInterface)
  {
    b = paramLoggerInterface;
    a(paramContext);
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      String[] arrayOfString = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
      boolean bool1 = false;
      int i;
      if (arrayOfString != null) {
        i = arrayOfString.length;
      }
      for (int j = 0;; j++)
      {
        bool1 = false;
        if (j < i)
        {
          boolean bool2 = "android.permission.WRITE_EXTERNAL_STORAGE".equals(arrayOfString[j]);
          if (bool2) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.Logger
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */