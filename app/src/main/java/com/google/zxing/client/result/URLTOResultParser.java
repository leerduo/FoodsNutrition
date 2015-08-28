package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class URLTOResultParser
  extends ResultParser
{
  public URIParsedResult a(Result paramResult)
  {
    String str1 = c(paramResult);
    if ((!str1.startsWith("urlto:")) && (!str1.startsWith("URLTO:"))) {}
    int i;
    do
    {
      return null;
      i = str1.indexOf(':', 6);
    } while (i < 0);
    String str2 = null;
    if (i <= 6) {}
    for (;;)
    {
      return new URIParsedResult(str1.substring(i + 1), str2);
      str2 = str1.substring(6, i);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.URLTOResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */