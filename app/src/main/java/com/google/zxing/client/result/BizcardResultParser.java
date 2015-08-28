package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.List;

public final class BizcardResultParser
  extends AbstractDoCoMoResultParser
{
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    if (paramString2 == null) {}
    for (;;)
    {
      return paramString1;
      paramString1 = paramString1 + ' ' + paramString2;
    }
  }
  
  private static String[] a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList(3);
    if (paramString1 != null) {
      localArrayList.add(paramString1);
    }
    if (paramString2 != null) {
      localArrayList.add(paramString2);
    }
    if (paramString3 != null) {
      localArrayList.add(paramString3);
    }
    int i = localArrayList.size();
    if (i == 0) {
      return null;
    }
    return (String[])localArrayList.toArray(new String[i]);
  }
  
  public AddressBookParsedResult a(Result paramResult)
  {
    String str1 = c(paramResult);
    if (!str1.startsWith("BIZCARD:")) {
      return null;
    }
    String str2 = a(b("N:", str1, true), b("X:", str1, true));
    String str3 = b("T:", str1, true);
    String str4 = b("C:", str1, true);
    String[] arrayOfString = a("A:", str1, true);
    String str5 = b("B:", str1, true);
    String str6 = b("M:", str1, true);
    String str7 = b("F:", str1, true);
    String str8 = b("E:", str1, true);
    return new AddressBookParsedResult(b(str2), null, null, a(str5, str6, str7), null, b(str8), null, null, null, arrayOfString, null, str4, null, str3, null, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.BizcardResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */