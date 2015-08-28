package com.xiaomi.kenai.jbosh;

final class h
  extends a<String>
{
  private final String[] a;
  
  private h(String paramString)
  {
    super(paramString);
    this.a = paramString.split("\\ +");
  }
  
  static h a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new h(paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.h
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */