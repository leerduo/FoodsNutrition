package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public final class ISBNResultParser
  extends ResultParser
{
  public ISBNParsedResult a(Result paramResult)
  {
    if (paramResult.d() != BarcodeFormat.h) {}
    String str;
    do
    {
      return null;
      str = c(paramResult);
    } while ((str.length() != 13) || ((!str.startsWith("978")) && (!str.startsWith("979"))));
    return new ISBNParsedResult(str);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ISBNResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */