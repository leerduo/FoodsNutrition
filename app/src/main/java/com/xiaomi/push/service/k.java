package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.smack.packet.c;
import com.xiaomi.xmpush.thrift.x;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.thrift.e;
import org.json.JSONException;

public class k
{
  private static void a(XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk, String paramString)
  {
    paramXMPushService.a(new p(4, paramXMPushService, paramk, paramString));
  }
  
  private static void a(XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk, String paramString1, String paramString2)
  {
    paramXMPushService.a(new q(4, paramXMPushService, paramk, paramString1, paramString2));
  }
  
  private static void a(XMPushService paramXMPushService, byte[] paramArrayOfByte, long paramLong)
  {
    com.xiaomi.xmpush.thrift.k localk = new com.xiaomi.xmpush.thrift.k();
    Intent localIntent;
    String str1;
    com.xiaomi.xmpush.thrift.d locald;
    try
    {
      x.a(localk, paramArrayOfByte);
      if (TextUtils.isEmpty(localk.f)) {
        break label684;
      }
      localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
      localIntent.putExtra("mipush_payload", paramArrayOfByte);
      localIntent.setPackage(localk.f);
      str1 = r.a(localk);
      com.xiaomi.smack.util.h.a(paramXMPushService, str1, paramLong, true, System.currentTimeMillis());
      locald = localk.m();
      if ((com.xiaomi.xmpush.thrift.a.e == localk.a()) && (h.a(paramXMPushService).a(localk.f)))
      {
        String str4 = "";
        if (locald != null) {
          str4 = locald.b();
        }
        com.xiaomi.channel.commonutils.logger.b.a("Drop a message for unregistered, msgid=" + str4);
        a(paramXMPushService, localk, localk.f);
        return;
      }
      if ((com.xiaomi.xmpush.thrift.a.e == localk.a()) && (!TextUtils.equals(paramXMPushService.getPackageName(), "com.xiaomi.xmsf")) && (!TextUtils.equals(paramXMPushService.getPackageName(), localk.f)))
      {
        com.xiaomi.channel.commonutils.logger.b.a("Receive a message with wrong package name, expect " + paramXMPushService.getPackageName() + ", received " + localk.f);
        a(paramXMPushService, localk, "unmatched_package", "package should be " + paramXMPushService.getPackageName() + ", but got " + localk.f);
        return;
      }
    }
    catch (e locale)
    {
      com.xiaomi.channel.commonutils.logger.b.a(locale);
      return;
    }
    if ((locald != null) && (locald.b() != null))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localk.h();
      arrayOfObject[1] = locald.b();
      com.xiaomi.channel.commonutils.logger.b.a(String.format("receive a message, appid=%1$s, msgid= %2$s", arrayOfObject));
    }
    if ((c(localk)) && (a(paramXMPushService, str1)))
    {
      c(paramXMPushService, localk);
      return;
    }
    if ((a(localk)) && (!a(paramXMPushService, str1)) && (!b(localk)))
    {
      d(paramXMPushService, localk);
      return;
    }
    String str2;
    if (a(paramXMPushService, localIntent))
    {
      if (com.xiaomi.xmpush.thrift.a.a == localk.a())
      {
        String str3 = localk.j();
        SharedPreferences.Editor localEditor = paramXMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
        localEditor.putString(str3, localk.e);
        localEditor.commit();
      }
      if ((locald == null) || (TextUtils.isEmpty(locald.h())) || (TextUtils.isEmpty(locald.j())) || (locald.h == 1) || ((!a(locald.s())) && (r.a(paramXMPushService, localk.f))))
      {
        paramXMPushService.sendBroadcast(localIntent, b.a(localk.f));
        if ((localk.a() != com.xiaomi.xmpush.thrift.a.b) || ("com.xiaomi.xmsf".equals(paramXMPushService.getPackageName()))) {
          return;
        }
        paramXMPushService.stopSelf();
        return;
      }
      if (locald == null) {
        break label691;
      }
      Map localMap = locald.j;
      str2 = null;
      if (localMap != null) {
        str2 = (String)locald.j.get("jobkey");
      }
      if (TextUtils.isEmpty(str2)) {
        str2 = locald.b();
      }
    }
    for (boolean bool = s.a(paramXMPushService, localk.f, str2);; bool = false)
    {
      if (bool) {
        com.xiaomi.channel.commonutils.logger.b.a("drop a duplicate message, key=" + str2);
      }
      for (;;)
      {
        b(paramXMPushService, localk);
        break;
        r.a(paramXMPushService, localk, paramArrayOfByte);
      }
      paramXMPushService.a(new l(4, paramXMPushService, localk));
      return;
      label684:
      com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message without package name");
      return;
      label691:
      str2 = null;
    }
  }
  
  private static boolean a(Context paramContext, Intent paramIntent)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      List localList = localPackageManager.queryBroadcastReceivers(paramIntent, 32);
      if (localList != null)
      {
        boolean bool = localList.isEmpty();
        if (!bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return true;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    Intent localIntent1 = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
    localIntent1.setPackage(paramString);
    Intent localIntent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
    localIntent2.setPackage(paramString);
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      List localList1 = localPackageManager.queryBroadcastReceivers(localIntent2, 32);
      List localList2 = localPackageManager.queryIntentServices(localIntent1, 32);
      boolean bool1;
      if (localList1.isEmpty())
      {
        boolean bool2 = localList2.isEmpty();
        bool1 = false;
        if (bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localException);
    }
    return false;
  }
  
  private static boolean a(com.xiaomi.xmpush.thrift.k paramk)
  {
    return ("com.xiaomi.xmsf".equals(paramk.f)) && (paramk.m() != null) && (paramk.m().s() != null) && (paramk.m().s().containsKey("miui_package_name"));
  }
  
  public static boolean a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (!paramMap.containsKey("notify_foreground"))) {
      return true;
    }
    return "1".equals((String)paramMap.get("notify_foreground"));
  }
  
  private static void b(XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk)
  {
    paramXMPushService.a(new m(4, paramXMPushService, paramk));
  }
  
  private static boolean b(com.xiaomi.xmpush.thrift.k paramk)
  {
    return paramk.m().s().containsKey("notify_effect");
  }
  
  private static void c(XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk)
  {
    paramXMPushService.a(new n(4, paramXMPushService, paramk));
  }
  
  private static boolean c(com.xiaomi.xmpush.thrift.k paramk)
  {
    if ((paramk.m() == null) || (paramk.m().s() == null)) {
      return false;
    }
    return "1".equals(paramk.m().s().get("obslete_ads_message"));
  }
  
  private static void d(XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk)
  {
    paramXMPushService.a(new o(4, paramXMPushService, paramk));
  }
  
  private static com.xiaomi.xmpush.thrift.k e(XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.k paramk)
  {
    com.xiaomi.xmpush.thrift.h localh = new com.xiaomi.xmpush.thrift.h();
    localh.b(paramk.h());
    com.xiaomi.xmpush.thrift.d locald = paramk.m();
    if (locald != null)
    {
      localh.a(locald.b());
      localh.a(locald.d());
      if (!TextUtils.isEmpty(locald.f())) {
        localh.c(locald.f());
      }
    }
    com.xiaomi.xmpush.thrift.k localk = paramXMPushService.a(paramk.j(), paramk.h(), localh, com.xiaomi.xmpush.thrift.a.f);
    localk.a(paramk.m().a());
    return localk;
  }
  
  public void a(Context paramContext, v.b paramb, boolean paramBoolean, int paramInt, String paramString)
  {
    f localf;
    if (!paramBoolean)
    {
      localf = g.a(paramContext);
      if ((localf == null) || (!"token-expired".equals(paramString))) {}
    }
    try
    {
      g.a(paramContext, localf.d, localf.e, localf.f);
      return;
    }
    catch (IOException localIOException)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localIOException);
      return;
    }
    catch (JSONException localJSONException)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localJSONException);
    }
  }
  
  public void a(XMPushService paramXMPushService, com.xiaomi.smack.packet.d paramd, v.b paramb)
  {
    if ((paramd instanceof c))
    {
      c localc = (c)paramd;
      com.xiaomi.smack.packet.a locala = localc.p("s");
      if (locala != null) {}
      try
      {
        a(paramXMPushService, z.b(z.a(paramb.i, localc.k()), locala.c()), com.xiaomi.smack.util.h.a(paramd.c()));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        com.xiaomi.channel.commonutils.logger.b.a(localIllegalArgumentException);
        return;
      }
    }
    com.xiaomi.channel.commonutils.logger.b.a("not a mipush message");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.k
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */