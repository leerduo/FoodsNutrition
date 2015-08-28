package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class c
  extends Handler
{
  c(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    b.b localb = (b.b)paramMessage.obj;
    if (paramMessage.what == 0) {
      localb.a();
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (paramMessage.what == 1) {
        localb.c();
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.misc.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */