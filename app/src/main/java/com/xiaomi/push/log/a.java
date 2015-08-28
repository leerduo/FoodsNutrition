package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

public class a
  implements LoggerInterface
{
  private LoggerInterface a = null;
  private LoggerInterface b = null;
  
  public a(LoggerInterface paramLoggerInterface1, LoggerInterface paramLoggerInterface2)
  {
    this.a = paramLoggerInterface1;
    this.b = paramLoggerInterface2;
  }
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.a(paramString);
    }
    if (this.b != null) {
      this.b.a(paramString);
    }
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    if (this.a != null) {
      this.a.a(paramString, paramThrowable);
    }
    if (this.b != null) {
      this.b.a(paramString, paramThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.log.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */