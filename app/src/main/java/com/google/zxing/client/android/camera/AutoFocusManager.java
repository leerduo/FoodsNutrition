package com.google.zxing.client.android.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

final class AutoFocusManager
  implements Camera.AutoFocusCallback
{
  private static final String a = AutoFocusManager.class.getSimpleName();
  private static final Collection<String> b = new ArrayList(2);
  private boolean c;
  private boolean d;
  private final boolean e;
  private final Camera f;
  private AsyncTask<?, ?, ?> g;
  
  static
  {
    b.add("auto");
    b.add("macro");
  }
  
  AutoFocusManager(Context paramContext, Camera paramCamera)
  {
    this.f = paramCamera;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str = paramCamera.getParameters().getFocusMode();
    if ((localSharedPreferences.getBoolean("zxing_preferences_auto_focus", bool)) && (b.contains(str))) {}
    for (;;)
    {
      this.e = bool;
      Log.i(a, "Current focus mode '" + str + "'; use auto focus? " + this.e);
      a();
      return;
      bool = false;
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/google/zxing/client/android/camera/AutoFocusManager:c	Z
    //   6: ifne +37 -> 43
    //   9: aload_0
    //   10: getfield 114	com/google/zxing/client/android/camera/AutoFocusManager:g	Landroid/os/AsyncTask;
    //   13: ifnonnull +30 -> 43
    //   16: new 116	com/google/zxing/client/android/camera/AutoFocusManager$AutoFocusTask
    //   19: dup
    //   20: aload_0
    //   21: aconst_null
    //   22: invokespecial 119	com/google/zxing/client/android/camera/AutoFocusManager$AutoFocusTask:<init>	(Lcom/google/zxing/client/android/camera/AutoFocusManager;Lcom/google/zxing/client/android/camera/AutoFocusManager$1;)V
    //   25: astore_2
    //   26: aload_2
    //   27: getstatic 125	android/os/AsyncTask:THREAD_POOL_EXECUTOR	Ljava/util/concurrent/Executor;
    //   30: iconst_0
    //   31: anewarray 4	java/lang/Object
    //   34: invokevirtual 129	com/google/zxing/client/android/camera/AutoFocusManager$AutoFocusTask:executeOnExecutor	(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   37: pop
    //   38: aload_0
    //   39: aload_2
    //   40: putfield 114	com/google/zxing/client/android/camera/AutoFocusManager:g	Landroid/os/AsyncTask;
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_3
    //   47: getstatic 30	com/google/zxing/client/android/camera/AutoFocusManager:a	Ljava/lang/String;
    //   50: ldc 131
    //   52: aload_3
    //   53: invokestatic 135	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   56: pop
    //   57: goto -14 -> 43
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	AutoFocusManager
    //   60	4	1	localObject	Object
    //   25	15	2	localAutoFocusTask	AutoFocusManager.AutoFocusTask
    //   46	7	3	localRejectedExecutionException	java.util.concurrent.RejectedExecutionException
    // Exception table:
    //   from	to	target	type
    //   26	43	46	java/util/concurrent/RejectedExecutionException
    //   2	26	60	finally
    //   26	43	60	finally
    //   47	57	60	finally
  }
  
  private void d()
  {
    try
    {
      if (this.g != null)
      {
        if (this.g.getStatus() != AsyncTask.Status.FINISHED) {
          this.g.cancel(true);
        }
        this.g = null;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/google/zxing/client/android/camera/AutoFocusManager:e	Z
    //   6: ifeq +37 -> 43
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 114	com/google/zxing/client/android/camera/AutoFocusManager:g	Landroid/os/AsyncTask;
    //   14: aload_0
    //   15: getfield 112	com/google/zxing/client/android/camera/AutoFocusManager:c	Z
    //   18: ifne +25 -> 43
    //   21: aload_0
    //   22: getfield 153	com/google/zxing/client/android/camera/AutoFocusManager:d	Z
    //   25: istore_2
    //   26: iload_2
    //   27: ifne +16 -> 43
    //   30: aload_0
    //   31: getfield 53	com/google/zxing/client/android/camera/AutoFocusManager:f	Landroid/hardware/Camera;
    //   34: aload_0
    //   35: invokevirtual 157	android/hardware/Camera:autoFocus	(Landroid/hardware/Camera$AutoFocusCallback;)V
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 153	com/google/zxing/client/android/camera/AutoFocusManager:d	Z
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_3
    //   47: getstatic 30	com/google/zxing/client/android/camera/AutoFocusManager:a	Ljava/lang/String;
    //   50: ldc 159
    //   52: aload_3
    //   53: invokestatic 135	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   56: pop
    //   57: aload_0
    //   58: invokespecial 161	com/google/zxing/client/android/camera/AutoFocusManager:c	()V
    //   61: goto -18 -> 43
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	AutoFocusManager
    //   64	4	1	localObject	Object
    //   25	2	2	bool	boolean
    //   46	7	3	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   30	43	46	java/lang/RuntimeException
    //   2	26	64	finally
    //   30	43	64	finally
    //   47	61	64	finally
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 112	com/google/zxing/client/android/camera/AutoFocusManager:c	Z
    //   7: aload_0
    //   8: getfield 83	com/google/zxing/client/android/camera/AutoFocusManager:e	Z
    //   11: ifeq +14 -> 25
    //   14: aload_0
    //   15: invokespecial 163	com/google/zxing/client/android/camera/AutoFocusManager:d	()V
    //   18: aload_0
    //   19: getfield 53	com/google/zxing/client/android/camera/AutoFocusManager:f	Landroid/hardware/Camera;
    //   22: invokevirtual 166	android/hardware/Camera:cancelAutoFocus	()V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_2
    //   29: getstatic 30	com/google/zxing/client/android/camera/AutoFocusManager:a	Ljava/lang/String;
    //   32: ldc 168
    //   34: aload_2
    //   35: invokestatic 135	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   38: pop
    //   39: goto -14 -> 25
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	AutoFocusManager
    //   42	4	1	localObject	Object
    //   28	7	2	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   18	25	28	java/lang/RuntimeException
    //   2	18	42	finally
    //   18	25	42	finally
    //   29	39	42	finally
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    try
    {
      this.d = false;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.camera.AutoFocusManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */