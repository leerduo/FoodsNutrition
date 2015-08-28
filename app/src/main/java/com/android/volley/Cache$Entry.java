package com.android.volley;

import java.util.Collections;
import java.util.Map;

public class Cache$Entry
{
  public byte[] a;
  public String b;
  public long c;
  public long d;
  public long e;
  public Map<String, String> f = Collections.emptyMap();
  
  public boolean a()
  {
    return this.d < System.currentTimeMillis();
  }
  
  public boolean b()
  {
    return this.e < System.currentTimeMillis();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.Cache.Entry
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */