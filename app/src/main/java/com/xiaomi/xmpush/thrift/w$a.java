package com.xiaomi.xmpush.thrift;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum w$a
{
  private static final Map<String, a> k;
  private final short l;
  private final String m;
  
  static
  {
    a[] arrayOfa = new a[10];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    arrayOfa[5] = f;
    arrayOfa[6] = g;
    arrayOfa[7] = h;
    arrayOfa[8] = i;
    arrayOfa[9] = j;
    n = arrayOfa;
    k = new HashMap();
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      k.put(locala.a(), locala);
    }
  }
  
  private w$a(short paramShort, String paramString)
  {
    this.l = paramShort;
    this.m = paramString;
  }
  
  public String a()
  {
    return this.m;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.w.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */