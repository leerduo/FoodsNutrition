package com.xiaomi.push.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.a;
import com.xiaomi.channel.commonutils.string.d;

public class ac
{
  private static ac a;
  private static String d = d.a(6);
  private Context b;
  private boolean c = false;
  private int e = 0;
  
  private ac(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if (d())
    {
      b.b("use miui push service");
      this.c = true;
    }
  }
  
  public static ac a(Context paramContext)
  {
    if (a == null) {
      a = new ac(paramContext);
    }
    return a;
  }
  
  private boolean d()
  {
    if (a.e) {}
    for (;;)
    {
      return false;
      PackageManager localPackageManager = this.b.getPackageManager();
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.xiaomi.xmsf", 4);
        if (localPackageInfo != null)
        {
          int i = localPackageInfo.versionCode;
          if (i >= 104) {
            return true;
          }
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public boolean a()
  {
    return ("sdk".contains("xmsf")) || ("sdk".contains("xiaomi")) || ("sdk".contains("miui"));
  }
  
  public int b()
  {
    if (this.e != 0) {
      return this.e;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.e = Settings.Global.getInt(this.b.getContentResolver(), "device_provisioned", 0);
      return this.e;
    }
    this.e = Settings.Secure.getInt(this.b.getContentResolver(), "device_provisioned", 0);
    return this.e;
  }
  
  public Uri c()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Settings.Global.getUriFor("device_provisioned");
    }
    return Settings.Secure.getUriFor("device_provisioned");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ac
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */