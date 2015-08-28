package com.umeng.analytics;

import u.aly.q;

public class ReportPolicy$c
  extends ReportPolicy.e
{
  private final int a;
  private q b;
  
  public ReportPolicy$c(q paramq, int paramInt)
  {
    this.a = paramInt;
    this.b = paramq;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return this.b.a() > this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.ReportPolicy.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */