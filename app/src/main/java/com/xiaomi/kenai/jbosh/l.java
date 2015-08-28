package com.xiaomi.kenai.jbosh;

import java.util.concurrent.TimeUnit;

final class l
  extends c
{
  private l(String paramString)
  {
    super(paramString);
    a(1);
  }
  
  static l a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new l(paramString);
  }
  
  public int c()
  {
    return (int)TimeUnit.MILLISECONDS.convert(b(), TimeUnit.SECONDS);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */