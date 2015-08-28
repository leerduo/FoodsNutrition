package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.xmpush.thrift.l;
import com.xiaomi.xmpush.thrift.m;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.t;
import com.xiaomi.xmpush.thrift.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class MiPushClient
{
  public static String a = "subscribe-topic";
  public static String b = "unsubscibe-topic";
  private static boolean c = true;
  private static Context d;
  private static long e = System.currentTimeMillis();
  
  static
  {
    if ((com.xiaomi.channel.commonutils.misc.a.b) || (com.xiaomi.channel.commonutils.misc.a.e) || (com.xiaomi.channel.commonutils.misc.a.c) || (com.xiaomi.channel.commonutils.misc.a.g)) {
      com.xiaomi.channel.commonutils.logger.b.a(0);
    }
  }
  
  protected static String a()
  {
    try
    {
      String str = com.xiaomi.channel.commonutils.string.d.a(4) + e;
      e = 1L + e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void a(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + paramString, System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void a(Context paramContext, String paramString, com.xiaomi.xmpush.thrift.d paramd)
  {
    if (!a.a(paramContext).b()) {
      return;
    }
    l locall = new l();
    locall.b(a.a(paramContext).c());
    locall.c("bar:click");
    locall.a(paramString);
    locall.a(false);
    e.a(paramContext).a(locall, com.xiaomi.xmpush.thrift.a.i, false, paramd);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, paramString2, null);
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2, MiPushClient.MiPushClientCallback paramMiPushClientCallback)
  {
    a(paramContext, "context");
    a(paramString1, "appID");
    a(paramString2, "appToken");
    for (;;)
    {
      boolean bool;
      try
      {
        d = paramContext.getApplicationContext();
        if (d == null) {
          d = paramContext;
        }
        if (paramMiPushClientCallback != null) {
          PushMessageHandler.a(paramMiPushClientCallback);
        }
        int i = a.a(d).m();
        int j = Constants.a();
        bool = false;
        if (i != j) {
          bool = true;
        }
        if ((!bool) && (a.a(d).a(paramString1, paramString2)) && (!a.a(d).n()))
        {
          if (1 == PushMessageHelper.a(paramContext))
          {
            a(paramMiPushClientCallback, "callback");
            paramMiPushClientCallback.a(0L, null, a.a(paramContext).e());
            e.a(paramContext).a();
            if (a.a(d).a())
            {
              l locall = new l();
              locall.b(a.a(paramContext).c());
              locall.c("client_info_update");
              locall.a(a());
              locall.h = new HashMap();
              locall.h.put("app_version", a.a(d, d.getPackageName()));
              String str2 = a.a(d).g();
              if (!TextUtils.isEmpty(str2)) {
                locall.h.put("deviceid", str2);
              }
              e.a(paramContext).a(locall, com.xiaomi.xmpush.thrift.a.i, false, null);
            }
            if (!c) {
              break;
            }
            f(d);
            return;
          }
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(a.a(paramContext).e());
          MiPushCommandMessage localMiPushCommandMessage = PushMessageHelper.a("register", localArrayList, 0L, null, null);
          PushMessageHelper.a(d, localMiPushCommandMessage);
          continue;
        }
        str1 = com.xiaomi.channel.commonutils.string.d.a(6);
      }
      catch (Throwable localThrowable)
      {
        com.xiaomi.channel.commonutils.logger.b.a(localThrowable);
        return;
      }
      String str1;
      a.a(d).h();
      a.a(d).a(Constants.a());
      a.a(d).a(paramString1, paramString2, str1);
      c(d);
      m localm = new m();
      localm.a(a());
      localm.b(paramString1);
      localm.e(paramString2);
      localm.d(paramContext.getPackageName());
      localm.f(str1);
      localm.c(a.a(paramContext, paramContext.getPackageName()));
      e.a(d).a(localm, bool);
    }
  }
  
  private static void a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("param " + paramString + " is not nullable");
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return e.a(paramContext).b();
  }
  
  public static List<String> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith("topic_")) {
        localArrayList.add(str.substring("topic_".length()));
      }
    }
    return localArrayList;
  }
  
  static void b(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + paramString).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(a.a(paramContext).c())) {
      return;
    }
    if (System.currentTimeMillis() - e(paramContext, paramString1) > 86400000L)
    {
      r localr = new r();
      localr.a(a());
      localr.b(a.a(paramContext).c());
      localr.c(paramString1);
      localr.d(paramContext.getPackageName());
      localr.e(paramString2);
      e.a(paramContext).a(localr, com.xiaomi.xmpush.thrift.a.c, null);
      return;
    }
    if (1 == PushMessageHelper.a(paramContext))
    {
      PushMessageHandler.a(paramContext, paramString2, 0L, null, paramString1);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    PushMessageHelper.a(paramContext, PushMessageHelper.a(a, localArrayList, 0L, null, null));
  }
  
  protected static void c(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    long l = localSharedPreferences.getLong("wake_up", 0L);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.clear();
    if (l > 0L) {
      localEditor.putLong("wake_up", l);
    }
    localEditor.commit();
  }
  
  static void c(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + paramString, System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    if (!a.a(paramContext).b()) {
      return;
    }
    if (e(paramContext, paramString1) < 0L)
    {
      com.xiaomi.channel.commonutils.logger.b.a("Don't cancel subscribe for " + paramString1 + " is unsubscribed");
      return;
    }
    v localv = new v();
    localv.a(a());
    localv.b(a.a(paramContext).c());
    localv.c(paramString1);
    localv.d(paramContext.getPackageName());
    localv.e(paramString2);
    e.a(paramContext).a(localv, com.xiaomi.xmpush.thrift.a.d, null);
  }
  
  static void d(Context paramContext)
  {
    if (!a.a(paramContext).i()) {
      return;
    }
    String str1 = com.xiaomi.channel.commonutils.string.d.a(6);
    String str2 = a.a(paramContext).c();
    String str3 = a.a(paramContext).d();
    a.a(paramContext).h();
    a.a(paramContext).a(str2, str3, str1);
    m localm = new m();
    localm.a(a());
    localm.b(str2);
    localm.e(str3);
    localm.f(str1);
    localm.d(paramContext.getPackageName());
    localm.c(a.a(paramContext, paramContext.getPackageName()));
    e.a(paramContext).a(localm, false);
  }
  
  static void d(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + paramString).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void d(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putString("accept_time", paramString1 + "," + paramString2).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static long e(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getLong("topic_" + paramString, -1L);
  }
  
  public static void e(Context paramContext)
  {
    if (!a.a(paramContext).b()) {
      return;
    }
    t localt = new t();
    localt.a(a());
    localt.b(a.a(paramContext).c());
    localt.c(a.a(paramContext).e());
    localt.e(a.a(paramContext).d());
    localt.d(paramContext.getPackageName());
    e.a(paramContext).a(localt);
    PushMessageHandler.a();
    a.a(paramContext).k();
    c(paramContext);
  }
  
  public static long f(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getLong("alias_" + paramString, -1L);
  }
  
  private static void f(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    if (System.currentTimeMillis() - 86400000L < localSharedPreferences.getLong("wake_up", 0L)) {
      return;
    }
    localSharedPreferences.edit().putLong("wake_up", System.currentTimeMillis()).commit();
    new Thread(new b(paramContext)).start();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.MiPushClient
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */