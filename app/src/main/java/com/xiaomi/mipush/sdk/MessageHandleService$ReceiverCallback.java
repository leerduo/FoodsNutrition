package com.xiaomi.mipush.sdk;

import android.content.Context;

public abstract interface MessageHandleService$ReceiverCallback
{
  public abstract void onCommandResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage);
  
  public abstract void onReceiveMessage(Context paramContext, MiPushMessage paramMiPushMessage);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.MessageHandleService.ReceiverCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */