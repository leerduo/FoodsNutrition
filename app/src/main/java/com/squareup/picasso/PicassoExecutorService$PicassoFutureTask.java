package com.squareup.picasso;

import java.util.concurrent.FutureTask;

final class PicassoExecutorService$PicassoFutureTask
  extends FutureTask<BitmapHunter>
  implements Comparable<PicassoFutureTask>
{
  private final BitmapHunter a;
  
  public PicassoExecutorService$PicassoFutureTask(BitmapHunter paramBitmapHunter)
  {
    super(paramBitmapHunter, null);
    this.a = paramBitmapHunter;
  }
  
  public int a(PicassoFutureTask paramPicassoFutureTask)
  {
    Picasso.Priority localPriority1 = this.a.n();
    Picasso.Priority localPriority2 = paramPicassoFutureTask.a.n();
    if (localPriority1 == localPriority2) {
      return this.a.a - paramPicassoFutureTask.a.a;
    }
    return localPriority2.ordinal() - localPriority1.ordinal();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.PicassoExecutorService.PicassoFutureTask
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */