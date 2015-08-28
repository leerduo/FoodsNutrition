package com.android.volley;

import java.util.concurrent.BlockingQueue;

class CacheDispatcher$1
  implements Runnable
{
  CacheDispatcher$1(CacheDispatcher paramCacheDispatcher, Request paramRequest) {}
  
  public void run()
  {
    try
    {
      CacheDispatcher.a(this.b).put(this.a);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.CacheDispatcher.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */