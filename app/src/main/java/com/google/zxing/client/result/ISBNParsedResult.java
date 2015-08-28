package com.google.zxing.client.result;

public final class ISBNParsedResult
  extends ParsedResult
{
  private final String a;
  
  ISBNParsedResult(String paramString)
  {
    super(ParsedResultType.k);
    this.a = paramString;
  }
  
  public String g()
  {
    return this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ISBNParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */