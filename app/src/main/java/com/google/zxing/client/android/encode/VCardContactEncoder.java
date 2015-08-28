package com.google.zxing.client.android.encode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class VCardContactEncoder
  extends ContactEncoder
{
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 4: 
    case 5: 
    case 13: 
      return "fax";
    case 6: 
    case 18: 
      return "pager";
    case 16: 
      return "textphone";
    }
    return "text";
  }
  
  static List<Map<String, Set<String>>> a(Collection<String> paramCollection, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramCollection.size())
    {
      if (paramList.size() <= i) {
        localArrayList.add(null);
      }
      for (;;)
      {
        i++;
        break;
        HashMap localHashMap = new HashMap();
        localArrayList.add(localHashMap);
        HashSet localHashSet = new HashSet();
        localHashMap.put("TYPE", localHashSet);
        String str1 = (String)paramList.get(i);
        Integer localInteger = b(str1);
        if (localInteger == null)
        {
          localHashSet.add(str1);
        }
        else
        {
          String str2 = a(localInteger.intValue());
          String str3 = b(localInteger.intValue());
          if (str2 != null) {
            localHashSet.add(str2);
          }
          if (str3 != null) {
            localHashSet.add(str3);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static Integer b(String paramString)
  {
    try
    {
      Integer localInteger = Integer.valueOf(paramString);
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return null;
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    default: 
      return null;
    case 1: 
    case 2: 
    case 5: 
    case 6: 
      return "home";
    }
    return "work";
  }
  
  public String[] a(List<String> paramList1, String paramString1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5, List<String> paramList6, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    localStringBuilder1.append("BEGIN:VCARD").append('\n');
    localStringBuilder1.append("VERSION:3.0").append('\n');
    StringBuilder localStringBuilder2 = new StringBuilder(100);
    VCardFieldFormatter localVCardFieldFormatter = new VCardFieldFormatter();
    a(localStringBuilder1, localStringBuilder2, "N", paramList1, 1, null, localVCardFieldFormatter, '\n');
    a(localStringBuilder1, localStringBuilder2, "ORG", paramString1, localVCardFieldFormatter, '\n');
    a(localStringBuilder1, localStringBuilder2, "ADR", paramList2, 1, null, localVCardFieldFormatter, '\n');
    List localList = a(paramList3, paramList4);
    a(localStringBuilder1, localStringBuilder2, "TEL", paramList3, 2147483647, new VCardTelDisplayFormatter(localList), new VCardFieldFormatter(localList), '\n');
    a(localStringBuilder1, localStringBuilder2, "EMAIL", paramList5, 2147483647, null, localVCardFieldFormatter, '\n');
    a(localStringBuilder1, localStringBuilder2, "URL", paramList6, 2147483647, null, localVCardFieldFormatter, '\n');
    a(localStringBuilder1, localStringBuilder2, "NOTE", paramString2, localVCardFieldFormatter, '\n');
    localStringBuilder1.append("END:VCARD").append('\n');
    String[] arrayOfString = new String[2];
    arrayOfString[0] = localStringBuilder1.toString();
    arrayOfString[1] = localStringBuilder2.toString();
    return arrayOfString;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.VCardContactEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */