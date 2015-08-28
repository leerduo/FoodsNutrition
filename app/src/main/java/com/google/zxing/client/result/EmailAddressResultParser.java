package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;

public final class EmailAddressResultParser
  extends ResultParser
{
  public EmailAddressParsedResult a(Result paramResult)
  {
    String str1 = c(paramResult);
    String str3;
    Map localMap;
    String str4;
    String str5;
    if ((str1.startsWith("mailto:")) || (str1.startsWith("MAILTO:")))
    {
      String str2 = str1.substring(7);
      int i = str2.indexOf('?');
      if (i >= 0) {
        str2 = str2.substring(0, i);
      }
      str3 = e(str2);
      localMap = d(str1);
      if (localMap == null) {
        break label188;
      }
      if (!str3.isEmpty()) {
        break label181;
      }
      str4 = (String)localMap.get("to");
      str5 = (String)localMap.get("subject");
    }
    for (String str6 = (String)localMap.get("body");; str6 = null)
    {
      EmailAddressParsedResult localEmailAddressParsedResult = new EmailAddressParsedResult(str4, str5, str6, str1);
      boolean bool;
      do
      {
        return localEmailAddressParsedResult;
        bool = EmailDoCoMoResultParser.a(str1);
        localEmailAddressParsedResult = null;
      } while (!bool);
      return new EmailAddressParsedResult(str1, null, null, "mailto:" + str1);
      label181:
      str4 = str3;
      break;
      label188:
      str4 = str3;
      str5 = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.EmailAddressResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */