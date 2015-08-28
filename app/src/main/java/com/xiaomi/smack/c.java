package com.xiaomi.smack;

import java.util.concurrent.ThreadFactory;

class c
  implements ThreadFactory
{
  c(b paramb) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "Smack Listener Processor (" + this.a.l + ")");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */