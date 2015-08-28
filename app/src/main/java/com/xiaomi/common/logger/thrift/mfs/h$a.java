package com.xiaomi.common.logger.thrift.mfs;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum h$a
{
  private static final Map<String, a> d;
  private final short e;
  private final String f;
  
  static
  {
    a[] arrayOfa = new a[3];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    g = arrayOfa;
    d = new HashMap();
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      d.put(locala.a(), locala);
    }
  }
  
  private h$a(short paramShort, String paramString)
  {
    this.e = paramShort;
    this.f = paramString;
  }
  
  public String a()
  {
    return this.f;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.common.logger.thrift.mfs.h.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */