package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class AddressBookDoCoMoResultParser
  extends AbstractDoCoMoResultParser
{
  private static String a(String paramString)
  {
    int i = paramString.indexOf(',');
    if (i >= 0) {
      paramString = paramString.substring(i + 1) + ' ' + paramString.substring(0, i);
    }
    return paramString;
  }
  
  public AddressBookParsedResult a(Result paramResult)
  {
    String str1 = c(paramResult);
    if (!str1.startsWith("MECARD:")) {
      return null;
    }
    String[] arrayOfString1 = a("N:", str1, true);
    if (arrayOfString1 == null) {
      return null;
    }
    String str2 = a(arrayOfString1[0]);
    String str3 = b("SOUND:", str1, true);
    String[] arrayOfString2 = a("TEL:", str1, true);
    String[] arrayOfString3 = a("EMAIL:", str1, true);
    String str4 = b("NOTE:", str1, false);
    String[] arrayOfString4 = a("ADR:", str1, true);
    String str5 = b("BDAY:", str1, true);
    if (!a(str5, 8)) {
      str5 = null;
    }
    String[] arrayOfString5 = a("URL:", str1, true);
    String str6 = b("ORG:", str1, true);
    return new AddressBookParsedResult(b(str2), null, str3, arrayOfString2, null, arrayOfString3, null, null, str4, arrayOfString4, null, str6, str5, null, arrayOfString5, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.AddressBookDoCoMoResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */