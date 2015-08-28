package com.xiaomi.xmpush.thrift;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum v$a
{
  private static final Map<String, a> h;
  private final short i;
  private final String j;
  
  static
  {
    a[] arrayOfa = new a[7];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    arrayOfa[5] = f;
    arrayOfa[6] = g;
    k = arrayOfa;
    h = new HashMap();
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      h.put(locala.a(), locala);
    }
  }
  
  private v$a(short paramShort, String paramString)
  {
    this.i = paramShort;
    this.j = paramString;
  }
  
  public String a()
  {
    return this.j;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.v.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */