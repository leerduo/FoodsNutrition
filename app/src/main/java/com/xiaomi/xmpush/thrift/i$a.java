package com.xiaomi.xmpush.thrift;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum i$a
{
  private static final Map<String, a> i;
  private final short j;
  private final String k;
  
  static
  {
    a[] arrayOfa = new a[8];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    arrayOfa[5] = f;
    arrayOfa[6] = g;
    arrayOfa[7] = h;
    l = arrayOfa;
    i = new HashMap();
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      i.put(locala.a(), locala);
    }
  }
  
  private i$a(short paramShort, String paramString)
  {
    this.j = paramShort;
    this.k = paramString;
  }
  
  public String a()
  {
    return this.k;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.i.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */