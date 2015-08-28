package com.squareup.picasso;

import android.os.Process;

class Utils$PicassoThread
  extends Thread
{
  public Utils$PicassoThread(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    super.run();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Utils.PicassoThread
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */