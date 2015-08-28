package com.xiaomi.push.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class e
  extends Handler
{
  e(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    d.a(this.a, true);
    d.a(this.a, System.currentTimeMillis());
    if ((paramMessage.obj instanceof XMPushService.e)) {
      ((XMPushService.e)paramMessage.obj).c();
    }
    d.a(this.a, false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */