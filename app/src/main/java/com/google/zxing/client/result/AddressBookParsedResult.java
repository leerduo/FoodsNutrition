package com.google.zxing.client.result;

public final class AddressBookParsedResult
  extends ParsedResult
{
  private final String[] a;
  private final String[] b;
  private final String c;
  private final String[] d;
  private final String[] e;
  private final String[] f;
  private final String[] g;
  private final String h;
  private final String i;
  private final String[] j;
  private final String[] k;
  private final String l;
  private final String m;
  private final String n;
  private final String[] o;
  private final String[] p;
  
  public AddressBookParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String[] paramArrayOfString3, String[] paramArrayOfString4, String[] paramArrayOfString5, String[] paramArrayOfString6, String paramString2, String paramString3, String[] paramArrayOfString7, String[] paramArrayOfString8, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString9, String[] paramArrayOfString10)
  {
    super(ParsedResultType.a);
    this.a = paramArrayOfString1;
    this.b = paramArrayOfString2;
    this.c = paramString1;
    this.d = paramArrayOfString3;
    this.e = paramArrayOfString4;
    this.f = paramArrayOfString5;
    this.g = paramArrayOfString6;
    this.h = paramString2;
    this.i = paramString3;
    this.j = paramArrayOfString7;
    this.k = paramArrayOfString8;
    this.l = paramString4;
    this.m = paramString5;
    this.n = paramString6;
    this.o = paramArrayOfString9;
    this.p = paramArrayOfString10;
  }
  
  public String[] a()
  {
    return this.a;
  }
  
  public String[] b()
  {
    return this.d;
  }
  
  public String[] c()
  {
    return this.f;
  }
  
  public String[] d()
  {
    return this.j;
  }
  
  public String e()
  {
    return this.l;
  }
  
  public String[] f()
  {
    return this.o;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(this.a, localStringBuilder);
    a(this.b, localStringBuilder);
    a(this.c, localStringBuilder);
    a(this.n, localStringBuilder);
    a(this.l, localStringBuilder);
    a(this.j, localStringBuilder);
    a(this.d, localStringBuilder);
    a(this.f, localStringBuilder);
    a(this.h, localStringBuilder);
    a(this.o, localStringBuilder);
    a(this.m, localStringBuilder);
    a(this.p, localStringBuilder);
    a(this.i, localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.AddressBookParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */