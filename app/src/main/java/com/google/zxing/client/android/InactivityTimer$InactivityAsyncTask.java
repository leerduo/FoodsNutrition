package com.google.zxing.client.android;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

final class InactivityTimer$InactivityAsyncTask
  extends AsyncTask<Object, Object, Object>
{
  private InactivityTimer$InactivityAsyncTask(InactivityTimer paramInactivityTimer) {}
  
  protected Object doInBackground(Object... paramVarArgs)
  {
    try
    {
      Thread.sleep(300000L);
      Log.i(InactivityTimer.e(), "Finishing activity due to inactivity");
      InactivityTimer.b(this.a).finish();
      label25:
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label25;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.InactivityTimer.InactivityAsyncTask
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */