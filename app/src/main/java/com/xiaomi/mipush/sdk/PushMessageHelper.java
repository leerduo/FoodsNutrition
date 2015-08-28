package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.xmpush.thrift.c;
import com.xiaomi.xmpush.thrift.d;
import com.xiaomi.xmpush.thrift.q;
import java.util.List;

public class PushMessageHelper
{
  private static int a = 0;
  
  public static int a(Context paramContext)
  {
    if (a == 0)
    {
      if (!b(paramContext)) {
        break label21;
      }
      a(1);
    }
    for (;;)
    {
      return a;
      label21:
      a(2);
    }
  }
  
  public static MiPushCommandMessage a(String paramString1, List<String> paramList, long paramLong, String paramString2, String paramString3)
  {
    MiPushCommandMessage localMiPushCommandMessage = new MiPushCommandMessage();
    localMiPushCommandMessage.a(paramString1);
    localMiPushCommandMessage.a(paramList);
    localMiPushCommandMessage.a(paramLong);
    localMiPushCommandMessage.b(paramString2);
    localMiPushCommandMessage.c(paramString3);
    return localMiPushCommandMessage;
  }
  
  public static MiPushMessage a(q paramq, d paramd, boolean paramBoolean)
  {
    MiPushMessage localMiPushMessage = new MiPushMessage();
    localMiPushMessage.a(paramq.c());
    if (!TextUtils.isEmpty(paramq.j()))
    {
      localMiPushMessage.a(1);
      localMiPushMessage.c(paramq.j());
    }
    for (;;)
    {
      localMiPushMessage.g(paramq.p());
      if (paramq.l() != null) {
        localMiPushMessage.b(paramq.l().e());
      }
      if (paramd != null)
      {
        if (TextUtils.isEmpty(localMiPushMessage.a())) {
          localMiPushMessage.a(paramd.b());
        }
        if (TextUtils.isEmpty(localMiPushMessage.d())) {
          localMiPushMessage.d(paramd.f());
        }
        localMiPushMessage.e(paramd.j());
        localMiPushMessage.f(paramd.h());
        localMiPushMessage.b(paramd.l());
        localMiPushMessage.c(paramd.q());
        localMiPushMessage.d(paramd.o());
        localMiPushMessage.a(paramd.s());
      }
      localMiPushMessage.a(paramBoolean);
      return localMiPushMessage;
      if (!TextUtils.isEmpty(paramq.h()))
      {
        localMiPushMessage.a(2);
        localMiPushMessage.d(paramq.h());
      }
      else
      {
        localMiPushMessage.a(0);
      }
    }
  }
  
  private static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static void a(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("message_type", 3);
    localIntent.putExtra("key_command", paramMiPushCommandMessage);
    paramContext.sendBroadcast(localIntent);
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
  
  public static boolean b(Context paramContext)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setClassName(paramContext.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
    return a(paramContext, localIntent);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.PushMessageHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */