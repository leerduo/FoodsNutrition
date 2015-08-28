package com.xiaomi.kenai.jbosh;

import java.util.concurrent.TimeUnit;

final class m
  extends c
{
  private m(String paramString)
  {
    super(paramString);
    a(0);
  }
  
  static m a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new m(paramString);
  }
  
  public int c()
  {
    return (int)TimeUnit.MILLISECONDS.convert(b(), TimeUnit.SECONDS);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.m
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */