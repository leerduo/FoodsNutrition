package com.xiaomi.common.logger.thrift.mfs;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum c$a
{
  private static final Map<String, a> e;
  private final short f;
  private final String g;
  
  static
  {
    a[] arrayOfa = new a[4];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    h = arrayOfa;
    e = new HashMap();
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      e.put(locala.a(), locala);
    }
  }
  
  private c$a(short paramShort, String paramString)
  {
    this.f = paramShort;
    this.g = paramString;
  }
  
  public String a()
  {
    return this.g;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.common.logger.thrift.mfs.c.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */