package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class g
{
  private static f a;
  private static String b = null;
  private static String c = null;
  private static String d = null;
  
  public static f a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (a != null)
        {
          localf = a;
          return localf;
        }
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_account", 0);
        String str1 = localSharedPreferences.getString("uuid", null);
        String str2 = localSharedPreferences.getString("token", null);
        String str3 = localSharedPreferences.getString("security", null);
        String str4 = localSharedPreferences.getString("app_id", null);
        String str5 = localSharedPreferences.getString("app_token", null);
        String str6 = localSharedPreferences.getString("package_name", null);
        String str7 = localSharedPreferences.getString("device_id", null);
        int i = localSharedPreferences.getInt("env_type", 1);
        if ((!TextUtils.isEmpty(str7)) && (str7.startsWith("a-")))
        {
          str7 = e(paramContext);
          localSharedPreferences.edit().putString("device_id", str7).commit();
        }
        boolean bool1 = TextUtils.isEmpty(str1);
        localf = null;
        if (bool1) {
          continue;
        }
        boolean bool2 = TextUtils.isEmpty(str2);
        localf = null;
        if (bool2) {
          continue;
        }
        boolean bool3 = TextUtils.isEmpty(str3);
        localf = null;
        if (bool3) {
          continue;
        }
        String str8 = e(paramContext);
        if ((!"com.xiaomi.xmsf".equals(paramContext.getPackageName())) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str7)) && (!str7.equals(str8)))
        {
          b.c("erase the old account.");
          f(paramContext);
          localf = null;
          continue;
        }
        a = new f(str1, str2, str3, str4, str5, str6, i);
      }
      finally {}
      f localf = a;
    }
  }
  
  public static f a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    label498:
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("devid", b(paramContext)));
        if (g(paramContext))
        {
          str1 = "1000271";
          if (!g(paramContext)) {
            continue;
          }
          str2 = "420100086271";
          if (!g(paramContext)) {
            continue;
          }
          str3 = "com.xiaomi.xmsf";
          localArrayList.add(new BasicNameValuePair("appid", str1));
          localArrayList.add(new BasicNameValuePair("apptoken", str2));
        }
        try
        {
          PackageInfo localPackageInfo2 = paramContext.getPackageManager().getPackageInfo(str3, 16384);
          localPackageInfo1 = localPackageInfo2;
          if (localPackageInfo1 == null) {
            break label498;
          }
          str4 = String.valueOf(localPackageInfo1.versionCode);
          localArrayList.add(new BasicNameValuePair("appversion", str4));
          localArrayList.add(new BasicNameValuePair("sdkversion", "2"));
          localArrayList.add(new BasicNameValuePair("packagename", str3));
          localArrayList.add(new BasicNameValuePair("model", Build.MODEL));
          localArrayList.add(new BasicNameValuePair("imei", c(paramContext)));
          localArrayList.add(new BasicNameValuePair("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL));
          str5 = com.xiaomi.channel.commonutils.network.a.a(paramContext, a(), localArrayList);
          boolean bool = TextUtils.isEmpty(str5);
          localf = null;
          if (!bool)
          {
            localJSONObject1 = new JSONObject(str5);
            if (localJSONObject1.getInt("code") != 0) {
              continue;
            }
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
            String str6 = localJSONObject2.getString("ssecurity");
            String str7 = localJSONObject2.getString("token");
            String str8 = localJSONObject2.getString("userId");
            localf = new f(str8 + "@xiaomi.com/an" + d.a(6), str7, str6, str1, str2, str3, com.xiaomi.channel.commonutils.misc.a.c());
            a(paramContext, localf);
            a = localf;
          }
          return localf;
        }
        catch (Exception localException)
        {
          String str5;
          JSONObject localJSONObject1;
          b.a(localException);
          PackageInfo localPackageInfo1 = null;
          continue;
          j.a(paramContext, localJSONObject1.getInt("code"), localJSONObject1.optString("description"));
          b.a(str5);
          f localf = null;
          continue;
        }
        String str1 = paramString2;
        continue;
        String str2 = paramString3;
        continue;
        String str3 = paramString1;
        continue;
        String str4 = "0";
      }
      finally {}
    }
  }
  
  public static String a()
  {
    if (com.xiaomi.channel.commonutils.misc.a.b()) {
      return "http://10.237.12.17:9085/pass/register";
    }
    StringBuilder localStringBuilder = new StringBuilder().append("https://");
    if (com.xiaomi.channel.commonutils.misc.a.a()) {}
    for (String str = "sandbox.xmpush.xiaomi.com";; str = "register.xmpush.xiaomi.com") {
      return str + "/pass/register";
    }
  }
  
  private static void a(Context paramContext, f paramf)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("mipush_account", 0).edit();
    localEditor.putString("uuid", paramf.a);
    localEditor.putString("security", paramf.c);
    localEditor.putString("token", paramf.b);
    localEditor.putString("app_id", paramf.d);
    localEditor.putString("package_name", paramf.f);
    localEditor.putString("app_token", paramf.e);
    localEditor.putString("device_id", e(paramContext));
    localEditor.putInt("env_type", paramf.g);
    localEditor.commit();
  }
  
  protected static String b(Context paramContext)
  {
    String str1;
    if (c == null) {
      str1 = c(paramContext);
    }
    try
    {
      String str4 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      str2 = str4;
      int i = Build.VERSION.SDK_INT;
      String str3 = null;
      if (i > 8) {
        str3 = Build.SERIAL;
      }
      c = "a-" + d.a(new StringBuilder().append(str1).append(str2).append(str3).toString());
      return c;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.a(localThrowable);
        String str2 = null;
      }
    }
  }
  
  public static String c(Context paramContext)
  {
    if (b != null) {
      return b;
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      String str1 = localTelephonyManager.getDeviceId();
      String str2 = str1;
      int i = 10;
      for (;;)
      {
        int j;
        if (str2 == null)
        {
          j = i - 1;
          if (i <= 0) {}
        }
        try
        {
          Thread.sleep(500L);
          label55:
          str2 = localTelephonyManager.getDeviceId();
          i = j;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label55;
        }
      }
      if (str2 != null) {
        b = str2;
      }
      return str2;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable);
      return null;
    }
  }
  
  public static String d(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperatorName();
  }
  
  public static String e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        String str3;
        if (d != null)
        {
          str3 = d;
          return str3;
        }
        try
        {
          String str4 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
          str1 = str4;
          if (Build.VERSION.SDK_INT > 8)
          {
            str2 = Build.SERIAL;
            d = d.a(str1 + str2);
            str3 = d;
          }
        }
        catch (Throwable localThrowable)
        {
          b.a(localThrowable);
          String str1 = null;
          continue;
        }
        String str2 = null;
      }
      finally {}
    }
  }
  
  public static void f(Context paramContext)
  {
    paramContext.getSharedPreferences("mipush_account", 0).edit().clear().commit();
    a = null;
  }
  
  private static boolean g(Context paramContext)
  {
    return paramContext.getPackageName().equals("com.xiaomi.xmsf");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.g
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */