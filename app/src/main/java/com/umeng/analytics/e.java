package com.umeng.analytics;

public abstract class e
  implements Runnable
{
  public abstract void a();
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (localThrowable == null) {}
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */