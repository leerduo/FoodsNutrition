package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.smack.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class j
{
  private static final Map<String, byte[]> a = new HashMap();
  private static final ArrayList<Pair<String, byte[]>> b = new ArrayList();
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    synchronized (a)
    {
      Iterator localIterator = a.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(paramContext, str, (byte[])a.get(str), paramInt, paramString);
      }
    }
    a.clear();
  }
  
  public static void a(Context paramContext, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.ERROR");
    localIntent.setPackage(paramString1);
    localIntent.putExtra("mipush_payload", paramArrayOfByte);
    localIntent.putExtra("mipush_error_code", paramInt);
    localIntent.putExtra("mipush_error_msg", paramString2);
    paramContext.sendBroadcast(localIntent, b.a(paramString1));
  }
  
  public static void a(XMPushService paramXMPushService)
  {
    try
    {
      synchronized (a)
      {
        Iterator localIterator = a.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramXMPushService.a(str, (byte[])a.get(str));
        }
      }
      a.clear();
    }
    catch (w localw)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localw);
      paramXMPushService.b(10, localw);
      return;
    }
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    synchronized (a)
    {
      a.put(paramString, paramArrayOfByte);
      return;
    }
  }
  
  public static void b(XMPushService paramXMPushService)
  {
    try
    {
      synchronized (b)
      {
        Iterator localIterator = b.iterator();
        if (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          paramXMPushService.a((String)localPair.first, (byte[])localPair.second);
        }
      }
      b.clear();
    }
    catch (w localw)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localw);
      paramXMPushService.b(10, localw);
      return;
    }
  }
  
  public static void b(String paramString, byte[] paramArrayOfByte)
  {
    synchronized (b)
    {
      b.add(new Pair(paramString, paramArrayOfByte));
      return;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */