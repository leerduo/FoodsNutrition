package com.umeng.analytics;

import u.aly.w;

public class ReportPolicy$b
  extends ReportPolicy.e
{
  private long a = 10000L;
  private long b;
  private w c;
  
  public ReportPolicy$b(w paramw, long paramLong)
  {
    this.c = paramw;
    if (paramLong < this.a) {
      paramLong = this.a;
    }
    this.b = paramLong;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return System.currentTimeMillis() - this.c.c >= this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.ReportPolicy.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */