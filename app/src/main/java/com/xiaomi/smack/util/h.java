package com.xiaomi.smack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.b;
import com.xiaomi.push.providers.a;
import com.xiaomi.push.service.XMPushService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class h
{
  private static b a = new b(true);
  private static int b = -1;
  private static final Object c = new Object();
  private static List<h.a> d = Collections.synchronizedList(new ArrayList());
  private static String e = "";
  private static a f = null;
  
  private static int a(Context paramContext)
  {
    if (b == -1) {
      b = b(paramContext);
    }
    return b;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString.getBytes().length;
  }
  
  public static void a(XMPushService paramXMPushService, String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if ((paramXMPushService == null) || (TextUtils.isEmpty(paramString)) || (!"com.xiaomi.xmsf".equals(paramXMPushService.getPackageName())) || ("com.xiaomi.xmsf".equals(paramString))) {}
    for (;;)
    {
      return;
      int i = a(paramXMPushService);
      if (-1 == i) {
        continue;
      }
      synchronized (c)
      {
        boolean bool = d.isEmpty();
        if (paramBoolean) {}
        for (int j = 1;; j = 0)
        {
          if (i != 0) {
            break label134;
          }
          str = c(paramXMPushService);
          a(new h.a(paramString, paramLong2, i, j, str, paramLong1));
          if (!bool) {
            break;
          }
          a.a(new i(paramXMPushService), 5000L);
          return;
        }
        label134:
        String str = "";
      }
    }
  }
  
  private static void a(h.a parama)
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.a(parama))
      {
        locala.f += parama.f;
        return;
      }
    }
    d.add(parama);
  }
  
  private static int b(Context paramContext)
  {
    ConnectivityManager localConnectivityManager;
    try
    {
      localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null) {
        return -1;
      }
    }
    catch (Exception localException1)
    {
      return -1;
    }
    NetworkInfo localNetworkInfo;
    try
    {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return -1;
      }
    }
    catch (Exception localException2)
    {
      return -1;
    }
    return localNetworkInfo.getType();
  }
  
  private static void b(Context paramContext, List<h.a> paramList)
  {
    SQLiteDatabase localSQLiteDatabase;
    synchronized (a.a)
    {
      localSQLiteDatabase = d(paramContext).getWritableDatabase();
      localSQLiteDatabase.beginTransaction();
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          h.a locala = (h.a)localIterator.next();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("package_name", locala.a);
          localContentValues.put("message_ts", Long.valueOf(locala.b));
          localContentValues.put("network_type", Integer.valueOf(locala.c));
          localContentValues.put("bytes", Long.valueOf(locala.f));
          localContentValues.put("rcv", Integer.valueOf(locala.d));
          localContentValues.put("imsi", locala.e);
          localSQLiteDatabase.insert("traffic", null, localContentValues);
          continue;
          localObject2 = finally;
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  /* Error */
  private static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 48	com/xiaomi/smack/util/h:e	Ljava/lang/String;
    //   6: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +12 -> 21
    //   12: getstatic 48	com/xiaomi/smack/util/h:e	Ljava/lang/String;
    //   15: astore_3
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_3
    //   20: areturn
    //   21: aload_0
    //   22: ldc 237
    //   24: invokevirtual 149	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   27: checkcast 239	android/telephony/TelephonyManager
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +11 -> 45
    //   37: aload 4
    //   39: invokevirtual 242	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   42: putstatic 48	com/xiaomi/smack/util/h:e	Ljava/lang/String;
    //   45: getstatic 48	com/xiaomi/smack/util/h:e	Ljava/lang/String;
    //   48: astore_3
    //   49: goto -33 -> 16
    //   52: astore_1
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_2
    //   59: goto -14 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramContext	Context
    //   52	5	1	localObject	Object
    //   58	1	2	localException	Exception
    //   15	34	3	str	String
    //   30	8	4	localTelephonyManager	android.telephony.TelephonyManager
    // Exception table:
    //   from	to	target	type
    //   3	16	52	finally
    //   21	32	52	finally
    //   37	45	52	finally
    //   45	49	52	finally
    //   21	32	58	java/lang/Exception
    //   37	45	58	java/lang/Exception
  }
  
  private static a d(Context paramContext)
  {
    if (f != null) {
      return f;
    }
    f = new a(paramContext);
    return f;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.util.h
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */