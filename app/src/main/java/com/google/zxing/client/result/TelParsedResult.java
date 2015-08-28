package com.google.zxing.client.result;

public final class TelParsedResult
  extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;
  
  public TelParsedResult(String paramString1, String paramString2, String paramString3)
  {
    super(ParsedResultType.g);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    a(this.a, localStringBuilder);
    a(this.c, localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.TelParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */