package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMSTOMMSTOResultParser
  extends ResultParser
{
  public SMSParsedResult a(Result paramResult)
  {
    String str1 = c(paramResult);
    if ((!str1.startsWith("smsto:")) && (!str1.startsWith("SMSTO:")) && (!str1.startsWith("mmsto:")) && (!str1.startsWith("MMSTO:"))) {
      return null;
    }
    String str2 = str1.substring(6);
    int i = str2.indexOf(':');
    String str3;
    if (i >= 0)
    {
      str3 = str2.substring(i + 1);
      str2 = str2.substring(0, i);
    }
    for (;;)
    {
      return new SMSParsedResult(str2, null, null, str3);
      str3 = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.SMSTOMMSTOResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */