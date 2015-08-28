package com.google.zxing.client.androidlegacy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.AsyncTask;
import com.google.zxing.client.androidlegacy.common.executor.AsyncTaskExecInterface;
import com.google.zxing.client.androidlegacy.common.executor.AsyncTaskExecManager;

final class InactivityTimer
{
  private static final String a = InactivityTimer.class.getSimpleName();
  private final Activity b;
  private final AsyncTaskExecInterface c;
  private final BroadcastReceiver d;
  private InactivityTimer.InactivityAsyncTask e;
  
  InactivityTimer(Activity paramActivity)
  {
    this.b = paramActivity;
    this.c = ((AsyncTaskExecInterface)new AsyncTaskExecManager().a());
    this.d = new InactivityTimer.PowerStatusReceiver(this, null);
    a();
  }
  
  private void f()
  {
    try
    {
      InactivityTimer.InactivityAsyncTask localInactivityAsyncTask = this.e;
      if (localInactivityAsyncTask != null)
      {
        localInactivityAsyncTask.cancel(true);
        this.e = null;
      }
      return;
    }
    finally {}
  }
  
  void a()
  {
    try
    {
      f();
      this.e = new InactivityTimer.InactivityAsyncTask(this, null);
      this.c.a(this.e, new Object[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    f();
    this.b.unregisterReceiver(this.d);
  }
  
  public void c()
  {
    this.b.registerReceiver(this.d, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    a();
  }
  
  void d()
  {
    f();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.InactivityTimer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */