package com.xiaomi.push.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  extends HandlerThread
{
  private volatile long a = 0L;
  private volatile boolean b = false;
  private volatile Handler c;
  private List<Pair<XMPushService.e, Long>> d = new ArrayList();
  
  public d(String paramString)
  {
    super(paramString);
  }
  
  public void a()
  {
    for (int i = 1; i < 15; i++) {
      a(i);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c != null) {
      this.c.removeMessages(paramInt);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.c != null) {
      this.c.removeMessages(paramInt, paramObject);
    }
  }
  
  public void a(XMPushService.e parame, long paramLong)
  {
    synchronized (this.d)
    {
      if (this.c != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = parame.d;
        localMessage.obj = parame;
        this.c.sendMessageDelayed(localMessage, paramLong);
        return;
      }
      b.a("the job is pended, the controller is not ready.");
      this.d.add(new Pair(parame, Long.valueOf(paramLong)));
    }
  }
  
  public boolean b()
  {
    return (this.b) && (System.currentTimeMillis() - this.a > 600000L);
  }
  
  public boolean b(int paramInt)
  {
    if (this.c != null) {
      return this.c.hasMessages(paramInt);
    }
    return false;
  }
  
  protected void onLooperPrepared()
  {
    this.c = new e(this, getLooper());
    synchronized (this.d)
    {
      Iterator localIterator = this.d.iterator();
      if (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        b.a("executing the pending job.");
        a((XMPushService.e)localPair.first, ((Long)localPair.second).longValue());
      }
    }
    this.d.clear();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */