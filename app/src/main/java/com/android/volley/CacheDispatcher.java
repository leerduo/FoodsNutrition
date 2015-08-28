package com.android.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher
  extends Thread
{
  private static final boolean a = VolleyLog.b;
  private final BlockingQueue<Request<?>> b;
  private final BlockingQueue<Request<?>> c;
  private final Cache d;
  private final ResponseDelivery e;
  private volatile boolean f = false;
  
  public CacheDispatcher(BlockingQueue<Request<?>> paramBlockingQueue1, BlockingQueue<Request<?>> paramBlockingQueue2, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = paramCache;
    this.e = paramResponseDelivery;
  }
  
  public void a()
  {
    this.f = true;
    interrupt();
  }
  
  public void run()
  {
    if (a) {
      VolleyLog.a("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.d.a();
    for (;;)
    {
      Request localRequest;
      try
      {
        localRequest = (Request)this.b.take();
        localRequest.a("cache-queue-take");
        if (!localRequest.i()) {
          break label73;
        }
        localRequest.b("cache-discard-canceled");
        continue;
        if (!this.f) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      label73:
      Cache.Entry localEntry = this.d.a(localRequest.f());
      if (localEntry == null)
      {
        localRequest.a("cache-miss");
        this.c.put(localRequest);
      }
      else if (localEntry.a())
      {
        localRequest.a("cache-hit-expired");
        localRequest.a(localEntry);
        this.c.put(localRequest);
      }
      else
      {
        localRequest.a("cache-hit");
        Response localResponse = localRequest.a(new NetworkResponse(localEntry.a, localEntry.f));
        localRequest.a("cache-hit-parsed");
        if (!localEntry.b())
        {
          this.e.a(localRequest, localResponse);
        }
        else
        {
          localRequest.a("cache-hit-refresh-needed");
          localRequest.a(localEntry);
          localResponse.d = true;
          this.e.a(localRequest, localResponse, new CacheDispatcher.1(this, localRequest));
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.CacheDispatcher
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */