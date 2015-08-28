package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class PushMessageReceiver
  extends BroadcastReceiver
  implements MessageHandleService.ReceiverCallback
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    MessageHandleService.a(new MessageHandleService.a(paramIntent, this));
    Intent localIntent = new Intent(paramContext, MessageHandleService.class);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.PushMessageReceiver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */