package com.google.zxing.client.androidlegacy.camera;

import android.os.AsyncTask;

final class AutoFocusManager$AutoFocusTask
  extends AsyncTask<Object, Object, Object>
{
  private AutoFocusManager$AutoFocusTask(AutoFocusManager paramAutoFocusManager) {}
  
  /* Error */
  protected Object doInBackground(Object... paramVarArgs)
  {
    // Byte code:
    //   0: ldc2_w 22
    //   3: invokestatic 29	java/lang/Thread:sleep	(J)V
    //   6: aload_0
    //   7: getfield 11	com/google/zxing/client/androidlegacy/camera/AutoFocusManager$AutoFocusTask:a	Lcom/google/zxing/client/androidlegacy/camera/AutoFocusManager;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 11	com/google/zxing/client/androidlegacy/camera/AutoFocusManager$AutoFocusTask:a	Lcom/google/zxing/client/androidlegacy/camera/AutoFocusManager;
    //   17: invokestatic 34	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:a	(Lcom/google/zxing/client/androidlegacy/camera/AutoFocusManager;)Z
    //   20: ifeq +10 -> 30
    //   23: aload_0
    //   24: getfield 11	com/google/zxing/client/androidlegacy/camera/AutoFocusManager$AutoFocusTask:a	Lcom/google/zxing/client/androidlegacy/camera/AutoFocusManager;
    //   27: invokevirtual 36	com/google/zxing/client/androidlegacy/camera/AutoFocusManager:a	()V
    //   30: aload_3
    //   31: monitorexit
    //   32: aconst_null
    //   33: areturn
    //   34: astore 4
    //   36: aload_3
    //   37: monitorexit
    //   38: aload 4
    //   40: athrow
    //   41: astore_2
    //   42: goto -36 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	AutoFocusTask
    //   0	45	1	paramVarArgs	Object[]
    //   41	1	2	localInterruptedException	java.lang.InterruptedException
    //   34	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	30	34	finally
    //   30	32	34	finally
    //   36	38	34	finally
    //   0	6	41	java/lang/InterruptedException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.camera.AutoFocusManager.AutoFocusTask
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */