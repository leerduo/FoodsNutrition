package com.qiniu.android.utils;

import android.os.Handler;
import android.os.Looper;

public class AsyncRun
{
  public static void run(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.utils.AsyncRun
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */