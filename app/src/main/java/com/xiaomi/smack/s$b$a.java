package com.xiaomi.smack;

public class s$b$a
{
  public static final a a = new a("result");
  public static final a b = new a("error");
  private String c;
  
  private s$b$a(String paramString)
  {
    this.c = paramString;
  }
  
  public static a a(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = paramString.toLowerCase();
      if (b.toString().equals(str)) {
        return b;
      }
    } while (!a.toString().equals(str));
    return a;
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.s.b.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */