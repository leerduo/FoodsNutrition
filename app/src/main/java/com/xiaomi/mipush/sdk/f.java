package com.xiaomi.mipush.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.network.a;
import com.xiaomi.push.service.ac;

class f
  extends ContentObserver
{
  f(e parame, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    e.a(this.a, Integer.valueOf(ac.a(e.a(this.a)).b()));
    if (e.b(this.a).intValue() != 0)
    {
      e.a(this.a).getContentResolver().unregisterContentObserver(this);
      if (a.d(e.a(this.a))) {
        this.a.c();
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */