package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ModernAsyncTask$1
  implements ThreadFactory
{
  private final AtomicInteger mCount = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */