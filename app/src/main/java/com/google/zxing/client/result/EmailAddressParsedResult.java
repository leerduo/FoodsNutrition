package com.google.zxing.client.result;

public final class EmailAddressParsedResult
  extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  
  EmailAddressParsedResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(ParsedResultType.b);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    a(this.a, localStringBuilder);
    a(this.b, localStringBuilder);
    a(this.c, localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.EmailAddressParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */