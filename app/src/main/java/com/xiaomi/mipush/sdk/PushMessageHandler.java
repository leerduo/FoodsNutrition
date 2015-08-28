package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PushMessageHandler
  extends IntentService
{
  private static List<MiPushClient.MiPushClientCallback> a = new ArrayList();
  
  public PushMessageHandler()
  {
    super("mipush message handler");
  }
  
  protected static void a()
  {
    synchronized (a)
    {
      a.clear();
      return;
    }
  }
  
  public static void a(long paramLong, String paramString1, String paramString2)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      if (localIterator.hasNext()) {
        ((MiPushClient.MiPushClientCallback)localIterator.next()).a(paramLong, paramString1, paramString2);
      }
    }
  }
  
  public static void a(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramMiPushMessage.f(), localMiPushClientCallback.a()))
        {
          localMiPushClientCallback.a(paramMiPushMessage.b(), paramMiPushMessage.c(), paramMiPushMessage.d(), paramMiPushMessage.e());
          localMiPushClientCallback.a(paramMiPushMessage);
        }
      }
    }
  }
  
  public static void a(Context paramContext, PushMessageHandler.a parama)
  {
    if ((parama instanceof MiPushMessage)) {
      a(paramContext, (MiPushMessage)parama);
    }
    MiPushCommandMessage localMiPushCommandMessage;
    String str1;
    do
    {
      do
      {
        return;
      } while (!(parama instanceof MiPushCommandMessage));
      localMiPushCommandMessage = (MiPushCommandMessage)parama;
      str1 = localMiPushCommandMessage.a();
      if ("register".equals(str1))
      {
        List localList3 = localMiPushCommandMessage.b();
        String str4 = null;
        if (localList3 != null)
        {
          boolean bool = localList3.isEmpty();
          str4 = null;
          if (!bool) {
            str4 = (String)localList3.get(0);
          }
        }
        a(localMiPushCommandMessage.c(), localMiPushCommandMessage.d(), str4);
        return;
      }
      if (("set-alias".equals(str1)) || ("unset-alias".equals(str1)) || ("accept-time".equals(str1)))
      {
        a(paramContext, localMiPushCommandMessage.e(), str1, localMiPushCommandMessage.c(), localMiPushCommandMessage.d(), localMiPushCommandMessage.b());
        return;
      }
      if (MiPushClient.a.equals(str1))
      {
        List localList2 = localMiPushCommandMessage.b();
        if ((localList2 != null) && (!localList2.isEmpty())) {}
        for (String str3 = (String)localList2.get(0);; str3 = null)
        {
          a(paramContext, localMiPushCommandMessage.e(), localMiPushCommandMessage.c(), localMiPushCommandMessage.d(), str3);
          return;
        }
      }
    } while (!MiPushClient.b.equals(str1));
    List localList1 = localMiPushCommandMessage.b();
    if ((localList1 != null) && (!localList1.isEmpty())) {}
    for (String str2 = (String)localList1.get(0);; str2 = null)
    {
      b(paramContext, localMiPushCommandMessage.e(), localMiPushCommandMessage.c(), localMiPushCommandMessage.d(), str2);
      return;
    }
  }
  
  protected static void a(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.a())) {
          localMiPushClientCallback.b(paramLong, paramString2, paramString3);
        }
      }
    }
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3, List<String> paramList)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.a())) {
          localMiPushClientCallback.a(paramString2, paramLong, paramString3, paramList);
        }
      }
    }
  }
  
  protected static void a(MiPushClient.MiPushClientCallback paramMiPushClientCallback)
  {
    synchronized (a)
    {
      if (!a.contains(paramMiPushClientCallback)) {
        a.add(paramMiPushClientCallback);
      }
      return;
    }
  }
  
  protected static boolean a(String paramString1, String paramString2)
  {
    return ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.equals(paramString1, paramString2));
  }
  
  protected static void b(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.a())) {
          localMiPushClientCallback.c(paramLong, paramString2, paramString3);
        }
      }
    }
  }
  
  public static boolean b()
  {
    return a.isEmpty();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if ("com.xiaomi.mipush.sdk.WAKEUP".equals(paramIntent.getAction())) {
      if (a.a(this).i()) {
        e.a(this).a();
      }
    }
    PushMessageHandler.a locala;
    do
    {
      return;
      if (1 != PushMessageHelper.a(this)) {
        break;
      }
      if (b())
      {
        b.c("receive a message before application calling initialize");
        return;
      }
      locala = d.a(this).a(paramIntent);
    } while (locala == null);
    a(this, locala);
    return;
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage(getPackageName());
    localIntent.putExtras(paramIntent);
    sendBroadcast(localIntent);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.PushMessageHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */