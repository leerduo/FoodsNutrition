package com.squareup.picasso;

import java.util.concurrent.ThreadFactory;

class Utils$PicassoThreadFactory
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Utils.PicassoThread(paramRunnable);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Utils.PicassoThreadFactory
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */