package com.xiaomi.kenai.jbosh;

public final class ag
{
  private final an a;
  
  private ag(an paraman)
  {
    this.a = paraman;
  }
  
  public static ag a(String paramString)
  {
    return a("xm", paramString, null);
  }
  
  public static ag a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, null);
  }
  
  public static ag a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new IllegalArgumentException("URI is required and may not be null/empty");
    }
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      throw new IllegalArgumentException("Local arg is required and may not be null/empty");
    }
    if ((paramString3 == null) || (paramString3.length() == 0)) {
      return new ag(new an(paramString1, paramString2));
    }
    return new ag(new an(paramString1, paramString2, paramString3));
  }
  
  public String a()
  {
    return this.a.a();
  }
  
  boolean a(an paraman)
  {
    return this.a.equals(paraman);
  }
  
  public String b()
  {
    return this.a.b();
  }
  
  public String c()
  {
    return this.a.c();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ag))
    {
      ag localag = (ag)paramObject;
      return this.a.equals(localag.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.ag
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */