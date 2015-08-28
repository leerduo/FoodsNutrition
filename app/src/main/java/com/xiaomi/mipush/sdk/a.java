package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.g;

public class a
{
  private static a a;
  private Context b;
  private a.a c;
  
  private a(Context paramContext)
  {
    this.b = paramContext;
    o();
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      a = new a(paramContext);
    }
    return a;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo2 = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
      localPackageInfo1 = localPackageInfo2;
      if (localPackageInfo1 != null) {
        return localPackageInfo1.versionName;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a(localException);
        PackageInfo localPackageInfo1 = null;
      }
    }
    return "1.0";
  }
  
  private void o()
  {
    this.c = new a.a(this, null);
    SharedPreferences localSharedPreferences = j();
    this.c.a = localSharedPreferences.getString("appId", null);
    this.c.b = localSharedPreferences.getString("appToken", null);
    this.c.c = localSharedPreferences.getString("regId", null);
    this.c.d = localSharedPreferences.getString("regSec", null);
    this.c.f = localSharedPreferences.getString("devId", null);
    if ((!TextUtils.isEmpty(this.c.f)) && (this.c.f.startsWith("a-")))
    {
      this.c.f = g.e(this.b);
      localSharedPreferences.edit().putString("devId", this.c.f).commit();
    }
    this.c.e = localSharedPreferences.getString("vName", null);
    this.c.h = localSharedPreferences.getBoolean("valid", true);
    this.c.i = localSharedPreferences.getBoolean("paused", false);
    this.c.j = localSharedPreferences.getInt("envType", 1);
    this.c.g = localSharedPreferences.getString("regResource", null);
  }
  
  public void a(int paramInt)
  {
    this.c.a(paramInt);
    j().edit().putInt("envType", paramInt).commit();
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = j().edit();
    localEditor.putString("vName", paramString);
    localEditor.commit();
    this.c.e = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramString1, paramString2, paramString3);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
    j().edit().putBoolean("paused", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return !TextUtils.equals(a(this.b, this.b.getPackageName()), this.c.e);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.c.b(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    if (!this.c.a())
    {
      b.a("Don't send message before initialization succeeded!");
      return false;
    }
    return true;
  }
  
  public String c()
  {
    return this.c.a;
  }
  
  public String d()
  {
    return this.c.b;
  }
  
  public String e()
  {
    return this.c.c;
  }
  
  public String f()
  {
    return this.c.d;
  }
  
  public String g()
  {
    return this.c.g;
  }
  
  public void h()
  {
    this.c.b();
  }
  
  public boolean i()
  {
    return this.c.a();
  }
  
  public SharedPreferences j()
  {
    return this.b.getSharedPreferences("mipush", 0);
  }
  
  public void k()
  {
    this.c.c();
  }
  
  public boolean l()
  {
    return this.c.i;
  }
  
  public int m()
  {
    return this.c.j;
  }
  
  public boolean n()
  {
    return !this.c.h;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */