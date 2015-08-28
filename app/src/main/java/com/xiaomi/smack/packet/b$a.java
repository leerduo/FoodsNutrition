package com.xiaomi.smack.packet;

public class b$a
{
  public static final a a = new a("get");
  public static final a b = new a("set");
  public static final a c = new a("result");
  public static final a d = new a("error");
  private String e;
  
  private b$a(String paramString)
  {
    this.e = paramString;
  }
  
  public static a a(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = paramString.toLowerCase();
      if (a.toString().equals(str)) {
        return a;
      }
      if (b.toString().equals(str)) {
        return b;
      }
      if (d.toString().equals(str)) {
        return d;
      }
    } while (!c.toString().equals(str));
    return c;
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.packet.b.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */