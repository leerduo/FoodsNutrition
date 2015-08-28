package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.push.service.r;
import com.xiaomi.xmpush.thrift.h;
import com.xiaomi.xmpush.thrift.j;
import com.xiaomi.xmpush.thrift.l;
import com.xiaomi.xmpush.thrift.n;
import com.xiaomi.xmpush.thrift.q;
import com.xiaomi.xmpush.thrift.s;
import com.xiaomi.xmpush.thrift.u;
import com.xiaomi.xmpush.thrift.w;
import com.xiaomi.xmpush.thrift.x;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class d
{
  private static d a = null;
  private static Queue<String> c;
  private static String d = "1";
  private static String e = "2";
  private static String f = "3";
  private static Object g = new Object();
  private Context b;
  
  private d(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
  }
  
  private PushMessageHandler.a a(com.xiaomi.xmpush.thrift.k paramk, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    org.apache.thrift.b localb;
    try
    {
      localb = c.a(this.b, paramk);
      if (localb == null)
      {
        com.xiaomi.channel.commonutils.logger.b.c("receiving an un-recognized message. " + paramk.a);
        return null;
      }
      com.xiaomi.channel.commonutils.logger.b.b("receive a message." + localb);
      com.xiaomi.xmpush.thrift.a locala = paramk.a();
      com.xiaomi.channel.commonutils.logger.b.a("processing a message, action=" + locala);
      switch (d.1.a[locala.ordinal()])
      {
      default: 
        return null;
      }
    }
    catch (org.apache.thrift.e locale)
    {
      n localn;
      com.xiaomi.channel.commonutils.logger.b.a(locale);
      com.xiaomi.channel.commonutils.logger.b.c("receive a message which action string is not valid. is the reg expired?");
      return null;
    }
    localn = (n)localb;
    if (localn.f == 0L) {
      a.a(this.b).b(localn.h, localn.i);
    }
    ArrayList localArrayList3;
    if (!TextUtils.isEmpty(localn.h))
    {
      localArrayList3 = new ArrayList();
      localArrayList3.add(localn.h);
    }
    for (;;)
    {
      MiPushCommandMessage localMiPushCommandMessage = PushMessageHelper.a("register", localArrayList3, localn.f, localn.g, null);
      e.a(this.b).d();
      return localMiPushCommandMessage;
      if (((u)localb).f == 0L)
      {
        a.a(this.b).h();
        MiPushClient.c(this.b);
      }
      PushMessageHandler.a();
      return null;
      if (a.a(this.b).l())
      {
        com.xiaomi.channel.commonutils.logger.b.a("receive a message in pause state. drop it");
        return null;
      }
      q localq = (q)localb;
      com.xiaomi.xmpush.thrift.c localc = localq.l();
      if (localc == null)
      {
        com.xiaomi.channel.commonutils.logger.b.c("receive an empty message without push content, drop it");
        return null;
      }
      if (paramBoolean) {
        MiPushClient.a(this.b, localc.b(), paramk.m());
      }
      if ((!TextUtils.isEmpty(localq.j())) && (MiPushClient.f(this.b, localq.j()) < 0L))
      {
        MiPushClient.a(this.b, localq.j());
        if ((paramk.h == null) || (paramk.h.s() == null)) {
          break label1831;
        }
      }
      label1546:
      label1831:
      for (String str3 = (String)paramk.h.j.get("jobkey");; str3 = null)
      {
        if (TextUtils.isEmpty(str3)) {
          str3 = localc.b();
        }
        if ((!paramBoolean) && (a(this.b, str3))) {
          com.xiaomi.channel.commonutils.logger.b.a("drop a duplicate message, key=" + str3);
        }
        for (;;)
        {
          if ((paramk.m() != null) || (paramBoolean)) {
            break label1843;
          }
          a(localq, paramk.m());
          return localObject1;
          if ((TextUtils.isEmpty(localq.h())) || (MiPushClient.e(this.b, localq.h()) >= 0L)) {
            break;
          }
          MiPushClient.c(this.b, localq.h());
          break;
          MiPushMessage localMiPushMessage = PushMessageHelper.a(localq, paramk.m(), paramBoolean);
          if ((localMiPushMessage.g() == 0) && (!paramBoolean) && (com.xiaomi.push.service.k.a(localMiPushMessage.h())))
          {
            r.a(this.b, paramk, paramArrayOfByte);
            return null;
          }
          com.xiaomi.channel.commonutils.logger.b.a("receive a message, msgid=" + localc.b());
          if ((paramBoolean) && (localMiPushMessage.h() != null) && (localMiPushMessage.h().containsKey("notify_effect")))
          {
            Map localMap2 = localMiPushMessage.h();
            String str4 = (String)localMap2.get("notify_effect");
            if ("com.xiaomi.xmsf".equals(this.b.getPackageName())) {}
            for (String str5 = (String)localMap2.get("miui_package_name");; str5 = null)
            {
              if (d.equals(str4)) {}
              for (;;)
              {
                Object localObject2;
                try
                {
                  PackageManager localPackageManager = this.b.getPackageManager();
                  if (TextUtils.isEmpty(str5)) {
                    str5 = this.b.getPackageName();
                  }
                  Intent localIntent2 = localPackageManager.getLaunchIntentForPackage(str5);
                  localObject2 = localIntent2;
                  localObject1 = null;
                  if (localObject2 == null) {
                    break;
                  }
                  if (!str4.equals(f)) {
                    ((Intent)localObject2).putExtra("key_message", localMiPushMessage);
                  }
                  ((Intent)localObject2).addFlags(268435456);
                  try
                  {
                    ResolveInfo localResolveInfo = this.b.getPackageManager().resolveActivity((Intent)localObject2, 65536);
                    localObject1 = null;
                    if (localResolveInfo == null) {
                      break;
                    }
                    this.b.startActivity((Intent)localObject2);
                    return null;
                  }
                  catch (Exception localException1)
                  {
                    com.xiaomi.channel.commonutils.logger.b.c("Cause: " + localException1.getMessage());
                    return null;
                  }
                  if (!e.equals(str4)) {
                    break label1013;
                  }
                }
                catch (Exception localException2)
                {
                  com.xiaomi.channel.commonutils.logger.b.c("Cause: " + localException2.getMessage());
                  localObject2 = null;
                  continue;
                }
                String str10 = (String)localMap2.get("intent_uri");
                if (str10 != null)
                {
                  try
                  {
                    Intent localIntent1 = Intent.parseUri(str10, 1);
                    localObject2 = localIntent1;
                    try
                    {
                      if (TextUtils.isEmpty(str5)) {
                        str5 = this.b.getPackageName();
                      }
                      ((Intent)localObject2).setPackage(str5);
                    }
                    catch (URISyntaxException localURISyntaxException2) {}
                    com.xiaomi.channel.commonutils.logger.b.c("Cause: " + localURISyntaxException2.getMessage());
                  }
                  catch (URISyntaxException localURISyntaxException1)
                  {
                    for (;;)
                    {
                      label1013:
                      String str6;
                      label1532:
                      localObject4 = localURISyntaxException1;
                      localObject2 = null;
                      continue;
                      localArrayList1 = null;
                      continue;
                      localArrayList2 = null;
                    }
                    localObject2 = null;
                  }
                  if (f.equals(str4))
                  {
                    str6 = (String)localMap2.get("web_uri");
                    if (str6 != null)
                    {
                      String str7 = str6.trim().toLowerCase();
                      if ((!str7.startsWith("http://")) && (!str7.startsWith("https://"))) {}
                      for (String str8 = "http://" + str7;; str8 = str7)
                      {
                        ArrayList localArrayList2;
                        ArrayList localArrayList1;
                        try
                        {
                          MalformedURLException localMalformedURLException1;
                          for (;;)
                          {
                            String str9 = new URL(str8).getProtocol();
                            if ((!"http".equals(str9)) && (!"https".equals(str9))) {
                              break label1793;
                            }
                            localObject2 = new Intent("android.intent.action.VIEW");
                            try
                            {
                              ((Intent)localObject2).setData(Uri.parse(str8));
                            }
                            catch (MalformedURLException localMalformedURLException3)
                            {
                              localObject3 = localObject2;
                              localMalformedURLException1 = localMalformedURLException3;
                            }
                          }
                          com.xiaomi.channel.commonutils.logger.b.c("Cause: " + localMalformedURLException1.getMessage());
                          localObject2 = localObject3;
                        }
                        catch (MalformedURLException localMalformedURLException2)
                        {
                          for (;;)
                          {
                            s locals;
                            w localw;
                            j localj;
                            String str2;
                            List localList;
                            l locall;
                            boolean bool1;
                            Map localMap1;
                            boolean bool2;
                            String str1;
                            Object localObject3 = null;
                          }
                        }
                        locals = (s)localb;
                        if (locals.f == 0L) {
                          MiPushClient.c(this.b, locals.h());
                        }
                        if (!TextUtils.isEmpty(locals.h()))
                        {
                          localArrayList2 = new ArrayList();
                          localArrayList2.add(locals.h());
                          return PushMessageHelper.a(MiPushClient.a, localArrayList2, locals.f, locals.g, locals.k());
                          localw = (w)localb;
                          if (localw.f == 0L) {
                            MiPushClient.d(this.b, localw.h());
                          }
                          if (!TextUtils.isEmpty(localw.h()))
                          {
                            localArrayList1 = new ArrayList();
                            localArrayList1.add(localw.h());
                            return PushMessageHelper.a(MiPushClient.b, localArrayList1, localw.f, localw.g, localw.k());
                            localj = (j)localb;
                            str2 = localj.e();
                            localList = localj.k();
                            if (localj.g == 0L)
                            {
                              if ((!TextUtils.equals(str2, "accept-time")) || (localList == null) || (localList.size() <= 1)) {
                                break label1546;
                              }
                              MiPushClient.d(this.b, (String)localList.get(0), (String)localList.get(1));
                              if ((!"00:00".equals(localList.get(0))) || (!"00:00".equals(localList.get(1)))) {
                                break label1532;
                              }
                              a.a(this.b).a(true);
                            }
                            for (;;)
                            {
                              return PushMessageHelper.a(str2, localList, localj.g, localj.h, localj.m());
                              a.a(this.b).a(false);
                              continue;
                              if ((TextUtils.equals(str2, "set-alias")) && (localList != null) && (localList.size() > 0)) {
                                MiPushClient.a(this.b, (String)localList.get(0));
                              } else if ((TextUtils.equals(str2, "unset-alias")) && (localList != null) && (localList.size() > 0)) {
                                MiPushClient.b(this.b, (String)localList.get(0));
                              }
                            }
                            locall = (l)localb;
                            if ("registration id expired".equalsIgnoreCase(locall.e))
                            {
                              MiPushClient.d(this.b);
                              return null;
                            }
                            bool1 = "client_info_update_ok".equalsIgnoreCase(locall.e);
                            localObject1 = null;
                            if (!bool1) {
                              break label1843;
                            }
                            localMap1 = locall.h();
                            localObject1 = null;
                            if (localMap1 == null) {
                              break label1843;
                            }
                            bool2 = locall.h().containsKey("app_version");
                            localObject1 = null;
                            if (!bool2) {
                              break label1843;
                            }
                            str1 = (String)locall.h().get("app_version");
                            a.a(this.b).a(str1);
                            return null;
                          }
                        }
                        Object localObject4;
                        break;
                      }
                    }
                  }
                  localObject2 = null;
                }
                else
                {
                  localObject2 = null;
                }
              }
            }
          }
          localObject1 = localMiPushMessage;
        }
      }
      label1793:
      localArrayList3 = null;
    }
    label1843:
    return localObject1;
  }
  
  public static d a(Context paramContext)
  {
    if (a == null) {
      a = new d(paramContext);
    }
    return a;
  }
  
  private void a(com.xiaomi.xmpush.thrift.k paramk)
  {
    com.xiaomi.xmpush.thrift.d locald = paramk.m();
    h localh = new h();
    localh.b(paramk.h());
    localh.a(locald.b());
    localh.a(locald.d());
    if (!TextUtils.isEmpty(locald.f())) {
      localh.c(locald.f());
    }
    e.a(this.b).a(localh, com.xiaomi.xmpush.thrift.a.f, false, paramk.m());
  }
  
  private void a(q paramq, com.xiaomi.xmpush.thrift.d paramd)
  {
    h localh = new h();
    localh.b(paramq.e());
    localh.a(paramq.c());
    localh.a(paramq.l().g());
    if (!TextUtils.isEmpty(paramq.h())) {
      localh.c(paramq.h());
    }
    if (!TextUtils.isEmpty(paramq.j())) {
      localh.d(paramq.j());
    }
    e.a(this.b).a(localh, com.xiaomi.xmpush.thrift.a.f, paramd);
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    synchronized (g)
    {
      SharedPreferences localSharedPreferences = a.a(paramContext).j();
      if (c == null)
      {
        String[] arrayOfString = localSharedPreferences.getString("pref_msg_ids", "").split(",");
        c = new LinkedList();
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
        {
          String str2 = arrayOfString[j];
          c.add(str2);
        }
      }
      if (c.contains(paramString)) {
        return true;
      }
      c.add(paramString);
      if (c.size() > 10) {
        c.poll();
      }
      String str1 = com.xiaomi.channel.commonutils.string.d.a(c, ",");
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString("pref_msg_ids", str1);
      localEditor.commit();
      return false;
    }
  }
  
  public PushMessageHandler.a a(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    com.xiaomi.channel.commonutils.logger.b.a("receive an intent from server, action=" + str);
    if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(str))
    {
      arrayOfByte2 = paramIntent.getByteArrayExtra("mipush_payload");
      bool = paramIntent.getBooleanExtra("mipush_notified", false);
      if (arrayOfByte2 == null) {
        com.xiaomi.channel.commonutils.logger.b.c("receiving an empty message, drop");
      }
    }
    label231:
    while (!"com.xiaomi.mipush.ERROR".equals(str))
    {
      byte[] arrayOfByte2;
      boolean bool;
      return null;
      com.xiaomi.xmpush.thrift.k localk2 = new com.xiaomi.xmpush.thrift.k();
      try
      {
        x.a(localk2, arrayOfByte2);
        locala = a.a(this.b);
        if ((localk2.a() == com.xiaomi.xmpush.thrift.a.e) && (localk2.m() != null) && (!locala.l()) && (!bool)) {
          a(localk2);
        }
        if ((!locala.i()) && (localk2.a != com.xiaomi.xmpush.thrift.a.a))
        {
          com.xiaomi.channel.commonutils.logger.b.c("receive message without registration. need unregister or re-register!");
          return null;
        }
      }
      catch (org.apache.thrift.e locale2)
      {
        a locala;
        com.xiaomi.channel.commonutils.logger.b.a(locale2);
        return null;
        if ((!locala.i()) || (!locala.n())) {
          break label231;
        }
        if (localk2.a == com.xiaomi.xmpush.thrift.a.b)
        {
          locala.h();
          MiPushClient.c(this.b);
          PushMessageHandler.a();
          return null;
        }
      }
      catch (Exception localException)
      {
        com.xiaomi.channel.commonutils.logger.b.a(localException);
        return null;
      }
      MiPushClient.e(this.b);
      return null;
      PushMessageHandler.a locala1 = a(localk2, bool, arrayOfByte2);
      return locala1;
    }
    MiPushCommandMessage localMiPushCommandMessage = new MiPushCommandMessage();
    com.xiaomi.xmpush.thrift.k localk1 = new com.xiaomi.xmpush.thrift.k();
    try
    {
      byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("mipush_payload");
      if (arrayOfByte1 != null) {
        x.a(localk1, arrayOfByte1);
      }
      label294:
      localMiPushCommandMessage.a(String.valueOf(localk1.a()));
      localMiPushCommandMessage.a(paramIntent.getIntExtra("mipush_error_code", 0));
      localMiPushCommandMessage.b(paramIntent.getStringExtra("mipush_error_msg"));
      com.xiaomi.channel.commonutils.logger.b.c("receive a error message. code = " + paramIntent.getIntExtra("mipush_error_code", 0) + ", msg= " + paramIntent.getStringExtra("mipush_error_msg"));
      return localMiPushCommandMessage;
    }
    catch (org.apache.thrift.e locale1)
    {
      break label294;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */