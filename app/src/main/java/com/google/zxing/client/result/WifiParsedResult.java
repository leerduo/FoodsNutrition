package com.google.zxing.client.result;

public final class WifiParsedResult
  extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;
  private final boolean d;
  
  public WifiParsedResult(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(ParsedResultType.j);
    this.a = paramString2;
    this.b = paramString1;
    this.c = paramString3;
    this.d = paramBoolean;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    a(this.a, localStringBuilder);
    a(this.b, localStringBuilder);
    a(this.c, localStringBuilder);
    a(Boolean.toString(this.d), localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.WifiParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */