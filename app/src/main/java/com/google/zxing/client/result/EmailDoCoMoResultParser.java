package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EmailDoCoMoResultParser
  extends AbstractDoCoMoResultParser
{
  private static final Pattern a = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");
  
  static boolean a(String paramString)
  {
    return (paramString != null) && (a.matcher(paramString).matches()) && (paramString.indexOf('@') >= 0);
  }
  
  public EmailAddressParsedResult a(Result paramResult)
  {
    String str1 = c(paramResult);
    if (!str1.startsWith("MATMSG:")) {}
    String str2;
    do
    {
      String[] arrayOfString;
      do
      {
        return null;
        arrayOfString = a("TO:", str1, true);
      } while (arrayOfString == null);
      str2 = arrayOfString[0];
    } while (!a(str2));
    return new EmailAddressParsedResult(str2, b("SUB:", str1, false), b("BODY:", str1, false), "mailto:" + str2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.EmailDoCoMoResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */