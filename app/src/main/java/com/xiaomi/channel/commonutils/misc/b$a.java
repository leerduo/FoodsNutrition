package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class b$a
  extends Thread
{
  private final LinkedBlockingQueue<b.b> b = new LinkedBlockingQueue();
  
  public b$a(b paramb)
  {
    super("PackageProcessor");
  }
  
  public void a(b.b paramb)
  {
    this.b.add(paramb);
  }
  
  public void run()
  {
    while (!b.a(this.a)) {
      try
      {
        b.a(this.a, (b.b)this.b.poll(1L, TimeUnit.SECONDS));
        if (b.b(this.a) != null)
        {
          Message localMessage1 = b.c(this.a).obtainMessage(0, b.b(this.a));
          b.c(this.a).sendMessage(localMessage1);
          b.b(this.a).b();
          Message localMessage2 = b.c(this.a).obtainMessage(1, b.b(this.a));
          b.c(this.a).sendMessage(localMessage2);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        com.xiaomi.channel.commonutils.logger.b.a(localInterruptedException);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.misc.b.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */