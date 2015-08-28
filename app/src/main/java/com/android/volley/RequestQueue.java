package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue
{
  private AtomicInteger a = new AtomicInteger();
  private final Map<String, Queue<Request<?>>> b = new HashMap();
  private final Set<Request<?>> c = new HashSet();
  private final PriorityBlockingQueue<Request<?>> d = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<Request<?>> e = new PriorityBlockingQueue();
  private final Cache f;
  private final Network g;
  private final ResponseDelivery h;
  private NetworkDispatcher[] i;
  private CacheDispatcher j;
  
  public RequestQueue(Cache paramCache, Network paramNetwork)
  {
    this(paramCache, paramNetwork, 4);
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt)
  {
    this(paramCache, paramNetwork, paramInt, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt, ResponseDelivery paramResponseDelivery)
  {
    this.f = paramCache;
    this.g = paramNetwork;
    this.i = new NetworkDispatcher[paramInt];
    this.h = paramResponseDelivery;
  }
  
  public <T> Request<T> a(Request<T> paramRequest)
  {
    paramRequest.a(this);
    synchronized (this.c)
    {
      this.c.add(paramRequest);
      paramRequest.a(c());
      paramRequest.a("add-to-queue");
      if (!paramRequest.s())
      {
        this.e.add(paramRequest);
        return paramRequest;
      }
    }
    for (;;)
    {
      String str;
      synchronized (this.b)
      {
        str = paramRequest.f();
        if (this.b.containsKey(str))
        {
          Object localObject3 = (Queue)this.b.get(str);
          if (localObject3 == null) {
            localObject3 = new LinkedList();
          }
          ((Queue)localObject3).add(paramRequest);
          this.b.put(str, localObject3);
          if (VolleyLog.b) {
            VolleyLog.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return paramRequest;
        }
      }
      this.b.put(str, null);
      this.d.add(paramRequest);
    }
  }
  
  public void a()
  {
    b();
    this.j = new CacheDispatcher(this.d, this.e, this.f, this.h);
    this.j.start();
    for (int k = 0; k < this.i.length; k++)
    {
      NetworkDispatcher localNetworkDispatcher = new NetworkDispatcher(this.e, this.g, this.f, this.h);
      this.i[k] = localNetworkDispatcher;
      localNetworkDispatcher.start();
    }
  }
  
  public void a(RequestQueue.RequestFilter paramRequestFilter)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        Request localRequest = (Request)localIterator.next();
        if (paramRequestFilter.a(localRequest)) {
          localRequest.h();
        }
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }
    a(new RequestQueue.1(this, paramObject));
  }
  
  public void b()
  {
    if (this.j != null) {
      this.j.a();
    }
    for (int k = 0; k < this.i.length; k++) {
      if (this.i[k] != null) {
        this.i[k].a();
      }
    }
  }
  
  void b(Request<?> paramRequest)
  {
    synchronized (this.c)
    {
      this.c.remove(paramRequest);
      if (!paramRequest.s()) {}
    }
    synchronized (this.b)
    {
      String str = paramRequest.f();
      Queue localQueue = (Queue)this.b.remove(str);
      if (localQueue != null)
      {
        if (VolleyLog.b)
        {
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(localQueue.size());
          arrayOfObject[1] = str;
          VolleyLog.a("Releasing %d waiting requests for cacheKey=%s.", arrayOfObject);
        }
        this.d.addAll(localQueue);
      }
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public int c()
  {
    return this.a.incrementAndGet();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.RequestQueue
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */