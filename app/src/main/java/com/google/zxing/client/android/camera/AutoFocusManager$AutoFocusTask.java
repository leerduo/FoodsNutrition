package com.google.zxing.client.android.camera;

import android.os.AsyncTask;

final class AutoFocusManager$AutoFocusTask
  extends AsyncTask<Object, Object, Object>
{
  private AutoFocusManager$AutoFocusTask(AutoFocusManager paramAutoFocusManager) {}
  
  protected Object doInBackground(Object... paramVarArgs)
  {
    try
    {
      Thread.sleep(2000L);
      label6:
      this.a.a();
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.camera.AutoFocusManager.AutoFocusTask
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */