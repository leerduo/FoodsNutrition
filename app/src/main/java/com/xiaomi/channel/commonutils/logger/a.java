package com.xiaomi.channel.commonutils.logger;

import android.util.Log;

public class a
  implements LoggerInterface
{
  private String a = "xiaomi";
  
  public void a(String paramString)
  {
    Log.v(this.a, paramString);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    Log.v(this.a, paramString, paramThrowable);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.logger.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */