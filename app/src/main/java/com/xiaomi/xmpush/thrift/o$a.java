package com.xiaomi.xmpush.thrift;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum o$a
{
  private static final Map<String, a> g;
  private final short h;
  private final String i;
  
  static
  {
    a[] arrayOfa = new a[6];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    arrayOfa[5] = f;
    j = arrayOfa;
    g = new HashMap();
    Iterator localIterator = EnumSet.allOf(a.class).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      g.put(locala.a(), locala);
    }
  }
  
  private o$a(short paramShort, String paramString)
  {
    this.h = paramShort;
    this.i = paramString;
  }
  
  public String a()
  {
    return this.i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.o.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */