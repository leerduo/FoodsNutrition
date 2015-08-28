package com.squareup.picasso;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

class Picasso$CleanupThread
  extends Thread
{
  private final ReferenceQueue<?> a;
  private final Handler b;
  
  Picasso$CleanupThread(ReferenceQueue<?> paramReferenceQueue, Handler paramHandler)
  {
    this.a = paramReferenceQueue;
    this.b = paramHandler;
    setDaemon(true);
    setName("Picasso-refQueue");
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      for (;;)
      {
        Action.RequestWeakReference localRequestWeakReference = (Action.RequestWeakReference)this.a.remove();
        this.b.sendMessage(this.b.obtainMessage(3, localRequestWeakReference.a));
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      return;
    }
    catch (Exception localException)
    {
      this.b.post(new Picasso.CleanupThread.1(this, localException));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso.CleanupThread
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */