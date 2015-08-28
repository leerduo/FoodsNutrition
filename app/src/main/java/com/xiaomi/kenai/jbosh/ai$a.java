package com.xiaomi.kenai.jbosh;

import java.util.HashMap;
import java.util.Map;

public final class ai$a
{
  private Map<ag, String> a;
  private boolean b;
  private String c;
  
  private static a b(ai paramai)
  {
    a locala = new a();
    locala.a = paramai.c();
    locala.b = true;
    locala.c = ai.a(paramai);
    return locala;
  }
  
  public a a(ag paramag, String paramString)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    while (paramString == null)
    {
      this.a.remove(paramag);
      return this;
      if (this.b)
      {
        this.a = new HashMap(this.a);
        this.b = false;
      }
    }
    this.a.put(paramag, paramString);
    return this;
  }
  
  public a a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("payload XML argument cannot be null");
    }
    this.c = paramString;
    return this;
  }
  
  public a a(String paramString1, String paramString2)
  {
    return a(ag.a("http://www.w3.org/XML/1998/namespace", paramString1, "xmlns"), paramString2);
  }
  
  public ai a()
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    if (this.c == null) {
      this.c = "";
    }
    return new ai(this.a, this.c, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.ai.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */