package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.push.service.XMPushService;

public class NetworkStatusReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!e.a(paramContext).b()) && (com.xiaomi.mipush.sdk.a.a(paramContext).i()) && (!com.xiaomi.mipush.sdk.a.a(paramContext).n())) {}
    try
    {
      Intent localIntent = new Intent(paramContext, XMPushService.class);
      localIntent.setAction("com.xiaomi.push.network_status_changed");
      paramContext.startService(localIntent);
      if ((com.xiaomi.channel.commonutils.network.a.d(paramContext)) && (e.a(paramContext).e())) {
        e.a(paramContext).c();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a(localException);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.receivers.NetworkStatusReceiver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */