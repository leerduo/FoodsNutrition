package com.google.zxing.client.result;

public final class SMSParsedResult
  extends ParsedResult
{
  private final String[] a;
  private final String[] b;
  private final String c;
  private final String d;
  
  public SMSParsedResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(ParsedResultType.h);
    this.a = new String[] { paramString1 };
    this.b = new String[] { paramString2 };
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public SMSParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2)
  {
    super(ParsedResultType.h);
    this.a = paramArrayOfString1;
    this.b = paramArrayOfString2;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(this.a, localStringBuilder);
    a(this.c, localStringBuilder);
    a(this.d, localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.SMSParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */