package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class BookmarkDoCoMoResultParser
  extends AbstractDoCoMoResultParser
{
  public URIParsedResult a(Result paramResult)
  {
    String str1 = paramResult.a();
    if (!str1.startsWith("MEBKM:")) {}
    String str2;
    String str3;
    do
    {
      String[] arrayOfString;
      do
      {
        return null;
        str2 = b("TITLE:", str1, true);
        arrayOfString = a("URL:", str1, true);
      } while (arrayOfString == null);
      str3 = arrayOfString[0];
    } while (!URIResultParser.a(str3));
    return new URIParsedResult(str3, str2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.BookmarkDoCoMoResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */