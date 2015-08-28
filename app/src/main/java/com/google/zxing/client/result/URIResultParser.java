package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIResultParser
  extends ResultParser
{
  private static final Pattern a = Pattern.compile("[a-zA-Z0-9]{2,}:");
  private static final Pattern b = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
  
  static boolean a(String paramString)
  {
    boolean bool = true;
    if (paramString.contains(" ")) {
      bool = false;
    }
    Matcher localMatcher2;
    do
    {
      Matcher localMatcher1;
      do
      {
        return bool;
        localMatcher1 = a.matcher(paramString);
      } while ((localMatcher1.find()) && (localMatcher1.start() == 0));
      localMatcher2 = b.matcher(paramString);
    } while ((localMatcher2.find()) && (localMatcher2.start() == 0));
    return false;
  }
  
  public URIParsedResult a(Result paramResult)
  {
    String str1 = c(paramResult);
    if ((str1.startsWith("URL:")) || (str1.startsWith("URI:"))) {
      return new URIParsedResult(str1.substring(4).trim(), null);
    }
    String str2 = str1.trim();
    if (a(str2)) {
      return new URIParsedResult(str2, null);
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.URIResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */