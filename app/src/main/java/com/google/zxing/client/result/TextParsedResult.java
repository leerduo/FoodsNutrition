package com.google.zxing.client.result;

public final class TextParsedResult
  extends ParsedResult
{
  private final String a;
  private final String b;
  
  public TextParsedResult(String paramString1, String paramString2)
  {
    super(ParsedResultType.e);
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String g()
  {
    return this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.TextParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */