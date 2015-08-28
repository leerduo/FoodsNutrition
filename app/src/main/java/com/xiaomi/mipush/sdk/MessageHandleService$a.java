package com.xiaomi.mipush.sdk;

import android.content.Intent;

public class MessageHandleService$a
{
  private PushMessageReceiver a;
  private Intent b;
  
  public MessageHandleService$a(Intent paramIntent, PushMessageReceiver paramPushMessageReceiver)
  {
    this.a = paramPushMessageReceiver;
    this.b = paramIntent;
  }
  
  public PushMessageReceiver a()
  {
    return this.a;
  }
  
  public Intent b()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.MessageHandleService.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */