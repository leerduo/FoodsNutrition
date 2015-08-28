package com.google.zxing.client.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.os.AsyncTask;

final class InactivityTimer
{
  private static final String a = InactivityTimer.class.getSimpleName();
  private final Activity b;
  private final BroadcastReceiver c;
  private boolean d;
  private AsyncTask<Object, Object, Object> e;
  
  InactivityTimer(Activity paramActivity)
  {
    this.b = paramActivity;
    this.c = new InactivityTimer.PowerStatusReceiver(this, null);
    this.d = false;
    a();
  }
  
  private void f()
  {
    try
    {
      AsyncTask localAsyncTask = this.e;
      if (localAsyncTask != null)
      {
        localAsyncTask.cancel(true);
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
      this.e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 46	com/google/zxing/client/android/InactivityTimer:f	()V
    //   6: aload_0
    //   7: getfield 40	com/google/zxing/client/android/InactivityTimer:d	Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 31	com/google/zxing/client/android/InactivityTimer:b	Landroid/app/Activity;
    //   17: aload_0
    //   18: getfield 38	com/google/zxing/client/android/InactivityTimer:c	Landroid/content/BroadcastReceiver;
    //   21: invokevirtual 72	android/app/Activity:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 40	com/google/zxing/client/android/InactivityTimer:d	Z
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: getstatic 25	com/google/zxing/client/android/InactivityTimer:a	Ljava/lang/String;
    //   35: ldc 74
    //   37: invokestatic 80	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: goto -12 -> 29
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	InactivityTimer
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   32	41	44	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/google/zxing/client/android/InactivityTimer:d	Z
    //   6: ifeq +19 -> 25
    //   9: getstatic 25	com/google/zxing/client/android/InactivityTimer:a	Ljava/lang/String;
    //   12: ldc 82
    //   14: invokestatic 80	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   17: pop
    //   18: aload_0
    //   19: invokevirtual 42	com/google/zxing/client/android/InactivityTimer:a	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 31	com/google/zxing/client/android/InactivityTimer:b	Landroid/app/Activity;
    //   29: aload_0
    //   30: getfield 38	com/google/zxing/client/android/InactivityTimer:c	Landroid/content/BroadcastReceiver;
    //   33: new 84	android/content/IntentFilter
    //   36: dup
    //   37: ldc 86
    //   39: invokespecial 89	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 93	android/app/Activity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   45: pop
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 40	com/google/zxing/client/android/InactivityTimer:d	Z
    //   51: goto -33 -> 18
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	InactivityTimer
    //   54	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	54	finally
    //   18	22	54	finally
    //   25	51	54	finally
  }
  
  void d()
  {
    f();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.InactivityTimer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */