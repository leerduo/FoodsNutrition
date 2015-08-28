package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.f;
import com.xiaomi.smack.util.h;
import java.util.Collection;
import java.util.Iterator;

public class b
{
  private k a = new k();
  
  public static String a(String paramString)
  {
    return paramString + ".permission.MIPUSH_RECEIVE";
  }
  
  private static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if ("com.xiaomi.xmsf".equals(paramContext.getPackageName()))
    {
      paramContext.sendBroadcast(paramIntent);
      return;
    }
    paramContext.sendBroadcast(paramIntent, a(paramString));
  }
  
  v.b a(d paramd)
  {
    Collection localCollection = v.a().c(paramd.l());
    v.b localb;
    if (localCollection.isEmpty())
    {
      localb = null;
      return localb;
    }
    Iterator localIterator = localCollection.iterator();
    if (localCollection.size() == 1) {
      return (v.b)localIterator.next();
    }
    String str1 = paramd.n();
    String str2 = paramd.m();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localb = (v.b)localIterator.next();
        if (TextUtils.equals(str1, localb.b)) {
          break;
        }
        if (TextUtils.equals(str2, localb.b)) {
          return localb;
        }
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.service_started");
    paramContext.sendBroadcast(localIntent);
  }
  
  public void a(Context paramContext, v.b paramb, int paramInt)
  {
    if ("5".equalsIgnoreCase(paramb.h)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.channel_closed");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra(x.n, paramb.h);
    localIntent.putExtra("ext_reason", paramInt);
    localIntent.putExtra(x.m, paramb.b);
    localIntent.putExtra(x.y, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }
  
  public void a(Context paramContext, v.b paramb, String paramString1, String paramString2)
  {
    if ("5".equalsIgnoreCase(paramb.h))
    {
      com.xiaomi.channel.commonutils.logger.b.c("mipush kicked by server");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.kicked");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra("ext_kick_type", paramString1);
    localIntent.putExtra("ext_kick_reason", paramString2);
    localIntent.putExtra("ext_chid", paramb.h);
    localIntent.putExtra(x.m, paramb.b);
    localIntent.putExtra(x.y, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }
  
  public void a(Context paramContext, v.b paramb, boolean paramBoolean, int paramInt, String paramString)
  {
    if ("5".equalsIgnoreCase(paramb.h))
    {
      this.a.a(paramContext, paramb, paramBoolean, paramInt, paramString);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.channel_opened");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra("ext_succeeded", paramBoolean);
    if (!paramBoolean) {
      localIntent.putExtra("ext_reason", paramInt);
    }
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("ext_reason_msg", paramString);
    }
    localIntent.putExtra("ext_chid", paramb.h);
    localIntent.putExtra(x.m, paramb.b);
    localIntent.putExtra(x.y, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }
  
  public void a(XMPushService paramXMPushService, String paramString, d paramd)
  {
    v.b localb = a(paramd);
    if (localb == null)
    {
      com.xiaomi.channel.commonutils.logger.b.c("error while notify channel closed! channel " + paramString + " not registered");
      return;
    }
    if ("5".equalsIgnoreCase(paramString))
    {
      this.a.a(paramXMPushService, paramd, localb);
      return;
    }
    String str1 = localb.a;
    String str2;
    if ((paramd instanceof c)) {
      str2 = "com.xiaomi.push.new_msg";
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(str2);
      localIntent.setPackage(str1);
      localIntent.putExtra("ext_chid", paramString);
      localIntent.putExtra("ext_packet", paramd.b());
      localIntent.putExtra(x.y, localb.j);
      localIntent.putExtra(x.r, localb.i);
      a(paramXMPushService, localIntent, str1);
      h.a(paramXMPushService, str1, h.a(paramd.c()), true, System.currentTimeMillis());
      return;
      if ((paramd instanceof com.xiaomi.smack.packet.b))
      {
        str2 = "com.xiaomi.push.new_iq";
      }
      else
      {
        if (!(paramd instanceof f)) {
          break;
        }
        str2 = "com.xiaomi.push.new_pres";
      }
    }
    com.xiaomi.channel.commonutils.logger.b.c("unknown packet type, drop it");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */