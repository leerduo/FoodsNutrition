package com.xiaomi.kenai.jbosh;

final class f
  extends a<String>
{
  private final String[] a;
  
  private f(String paramString)
  {
    super(paramString);
    this.a = paramString.split("[\\s,]+");
  }
  
  static f a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new f(paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */