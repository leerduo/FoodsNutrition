package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class URIParsedResult
  extends ParsedResult
{
  private static final Pattern a = Pattern.compile(":/*([^/@]+)@[^/]+");
  private final String b;
  private final String c;
  
  public URIParsedResult(String paramString1, String paramString2)
  {
    super(ParsedResultType.d);
    this.b = a(paramString1);
    this.c = paramString2;
  }
  
  private static String a(String paramString)
  {
    String str = paramString.trim();
    int i = str.indexOf(':');
    if (i < 0) {
      str = "http://" + str;
    }
    while (!a(str, i)) {
      return str;
    }
    return "http://" + str;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    int i = paramInt + 1;
    int j = paramString.indexOf('/', i);
    if (j < 0) {
      j = paramString.length();
    }
    return ResultParser.a(paramString, i, j - i);
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    a(this.c, localStringBuilder);
    a(this.b, localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.URIParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */