package com.google.zxing.client.androidlegacy.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.zxing.client.androidlegacy.common.executor.AsyncTaskExecInterface;
import com.google.zxing.client.androidlegacy.common.executor.AsyncTaskExecManager;
import java.util.ArrayList;
import java.util.Collection;

final class AutoFocusManager
  implements Camera.AutoFocusCallback
{
  private static final String a = AutoFocusManager.class.getSimpleName();
  private static final Collection<String> b = new ArrayList(2);
  private boolean c;
  private final boolean d;
  private final Camera e;
  private AutoFocusManager.AutoFocusTask f;
  private final AsyncTaskExecInterface g;
  
  static
  {
    b.add("auto");
    b.add("macro");
  }
  
  AutoFocusManager(Context paramContext, Camera paramCamera)
  {
    this.e = paramCamera;
    this.g = ((AsyncTaskExecInterface)new AsyncTaskExecManager().a());
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str = paramCamera.getParameters().getFocusMode();
    if ((localSharedPreferences.getBoolean("preferences_auto_focus", true)) && (b.contains(str))) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      Log.i(a, "Current focus mode '" + str + "'; use auto focus? " + this.d);
      a();
      return;
    }
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:d	Z
    //   6: ifeq +16 -> 22
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 121	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:c	Z
    //   14: aload_0
    //   15: getfield 53	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:e	Landroid/hardware/Camera;
    //   18: aload_0
    //   19: invokevirtual 127	android/hardware/Camera:autoFocus	(Landroid/hardware/Camera$AutoFocusCallback;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_2
    //   26: getstatic 30	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:a	Ljava/lang/String;
    //   29: ldc 129
    //   31: aload_2
    //   32: invokestatic 133	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   35: pop
    //   36: goto -14 -> 22
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	AutoFocusManager
    //   39	4	1	localObject	Object
    //   25	7	2	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   14	22	25	java/lang/RuntimeException
    //   2	14	39	finally
    //   14	22	39	finally
    //   26	36	39	finally
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:d	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: getfield 53	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:e	Landroid/hardware/Camera;
    //   15: invokevirtual 136	android/hardware/Camera:cancelAutoFocus	()V
    //   18: aload_0
    //   19: getfield 138	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:f	Lcom/google/zxing/client/androidlegacy/camera/AutoFocusManager$AutoFocusTask;
    //   22: ifnull +17 -> 39
    //   25: aload_0
    //   26: getfield 138	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:f	Lcom/google/zxing/client/androidlegacy/camera/AutoFocusManager$AutoFocusTask;
    //   29: iconst_1
    //   30: invokevirtual 144	com/google/zxing/client/androidlegacy/camera/AutoFocusManager$AutoFocusTask:cancel	(Z)Z
    //   33: pop
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 138	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:f	Lcom/google/zxing/client/androidlegacy/camera/AutoFocusManager$AutoFocusTask;
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 121	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:c	Z
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore 4
    //   49: getstatic 30	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:a	Ljava/lang/String;
    //   52: ldc 146
    //   54: aload 4
    //   56: invokestatic 133	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   59: pop
    //   60: goto -42 -> 18
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	AutoFocusManager
    //   63	4	1	localObject	Object
    //   6	2	2	bool	boolean
    //   47	8	4	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   11	18	47	java/lang/RuntimeException
    //   2	7	63	finally
    //   11	18	63	finally
    //   18	39	63	finally
    //   39	44	63	finally
    //   49	60	63	finally
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    try
    {
      if (this.c)
      {
        this.f = new AutoFocusManager.AutoFocusTask(this, null);
        this.g.a(this.f, new Object[0]);
      }
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
 * Qualified Name:     com.google.zxing.client.androidlegacy.camera.AutoFocusManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */