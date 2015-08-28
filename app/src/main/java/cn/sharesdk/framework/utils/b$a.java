package cn.sharesdk.framework.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class b$a
  implements ServiceConnection
{
  boolean a = false;
  private final BlockingQueue<IBinder> c = new LinkedBlockingQueue();
  
  private b$a(b paramb) {}
  
  public IBinder a()
  {
    if (this.a) {
      throw new IllegalStateException();
    }
    this.a = true;
    return (IBinder)this.c.poll(1500L, TimeUnit.MILLISECONDS);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.c.put(paramIBinder);
      return;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.b.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */