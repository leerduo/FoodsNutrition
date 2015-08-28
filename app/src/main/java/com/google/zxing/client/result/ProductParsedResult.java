package com.google.zxing.client.result;

public final class ProductParsedResult
  extends ParsedResult
{
  private final String a;
  private final String b;
  
  ProductParsedResult(String paramString1, String paramString2)
  {
    super(ParsedResultType.c);
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String g()
  {
    return this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ProductParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */