package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

class ExecutorDelivery$1
  implements Executor
{
  ExecutorDelivery$1(ExecutorDelivery paramExecutorDelivery, Handler paramHandler) {}
  
  public void execute(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.ExecutorDelivery.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */