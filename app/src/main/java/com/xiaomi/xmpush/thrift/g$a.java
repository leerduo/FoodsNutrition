package com.xiaomi.xmpush.thrift;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum g$a
{
  private static final Map<String, a> f;
  private final short g;
  private final String h;
  
  static
  {
    a[] arrayOfa = new a[5];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    i = arrayOfa;
    f = new HashMap();
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      f.put(locala.a(), locala);
    }
  }
  
  private g$a(short paramShort, String paramString)
  {
    this.g = paramShort;
    this.h = paramString;
  }
  
  public String a()
  {
    return this.h;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.g.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */