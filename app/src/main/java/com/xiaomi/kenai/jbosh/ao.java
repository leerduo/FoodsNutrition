package com.xiaomi.kenai.jbosh;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class ao
{
  private static final SecureRandom a = new SecureRandom();
  private static final Lock b = new ReentrantLock();
  private AtomicLong c = new AtomicLong();
  
  private long b()
  {
    b.lock();
    try
    {
      long l2;
      do
      {
        long l1 = a.nextLong();
        l2 = l1 & 0xFFFFFFFF;
      } while (l2 > 9007194959773696L);
      return l2;
    }
    finally
    {
      b.unlock();
    }
  }
  
  public long a()
  {
    return this.c.getAndIncrement();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.ao
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */