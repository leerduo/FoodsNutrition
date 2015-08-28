package com.xiaomi.kenai.jbosh;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ak
{
  private static final Logger a = Logger.getLogger(ak.class.getName());
  private final b b;
  private final Lock c = new ReentrantLock();
  private final Condition d = this.c.newCondition();
  private al e;
  
  ak(b paramb)
  {
    if (paramb == null) {
      throw new IllegalArgumentException("Request body cannot be null");
    }
    this.b = paramb;
  }
  
  b a()
  {
    return this.b;
  }
  
  void a(al paramal)
  {
    this.c.lock();
    try
    {
      if (this.e != null) {
        throw new IllegalStateException("HTTPResponse was already set");
      }
    }
    finally
    {
      this.c.unlock();
    }
    this.e = paramal;
    this.d.signalAll();
    this.c.unlock();
  }
  
  al b()
  {
    this.c.lock();
    try
    {
      for (;;)
      {
        al localal1 = this.e;
        if (localal1 != null) {
          break;
        }
        try
        {
          this.d.await();
        }
        catch (InterruptedException localInterruptedException)
        {
          a.log(Level.FINEST, "Interrupted", localInterruptedException);
        }
      }
      localal2 = this.e;
    }
    finally
    {
      this.c.unlock();
    }
    al localal2;
    this.c.unlock();
    return localal2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.ak
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */