package com.xiaomi.kenai.jbosh;

import java.util.Collections;
import java.util.Map;

final class ap
  extends b
{
  private static final ac a = new ae();
  private final Map<ag, String> b;
  private final String c;
  
  private ap(Map<ag, String> paramMap, String paramString)
  {
    this.b = paramMap;
    this.c = paramString;
  }
  
  public static ap a(String paramString)
  {
    return new ap(a.a(paramString).a(), paramString);
  }
  
  public Map<ag, String> c()
  {
    return Collections.unmodifiableMap(this.b);
  }
  
  public String d()
  {
    return this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.ap
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */