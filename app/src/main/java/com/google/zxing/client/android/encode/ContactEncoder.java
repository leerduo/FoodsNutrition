package com.google.zxing.client.android.encode;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

abstract class ContactEncoder
{
  static String a(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = paramString.trim();
    } while (str.isEmpty());
    return str;
  }
  
  static void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, String paramString1, String paramString2, Formatter paramFormatter, char paramChar)
  {
    String str = a(paramString2);
    if (str != null)
    {
      paramStringBuilder1.append(paramString1).append(paramFormatter.a(str, 0)).append(paramChar);
      paramStringBuilder2.append(str).append('\n');
    }
  }
  
  static void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, String paramString, List<String> paramList, int paramInt, Formatter paramFormatter1, Formatter paramFormatter2, char paramChar)
  {
    if (paramList == null) {
      return;
    }
    HashSet localHashSet = new HashSet(2);
    int i = 0;
    int j = 0;
    label21:
    String str;
    if (i < paramList.size())
    {
      str = a((String)paramList.get(i));
      if ((str != null) && (!str.isEmpty()) && (!localHashSet.contains(str)))
      {
        paramStringBuilder1.append(paramString).append(paramFormatter2.a(str, i)).append(paramChar);
        if (paramFormatter1 != null) {
          break label145;
        }
      }
    }
    label145:
    for (Object localObject = str;; localObject = paramFormatter1.a(str, i))
    {
      paramStringBuilder2.append((CharSequence)localObject).append('\n');
      j++;
      if (j == paramInt) {
        break;
      }
      localHashSet.add(str);
      i++;
      break label21;
      break;
    }
  }
  
  abstract String[] a(List<String> paramList1, String paramString1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5, List<String> paramList6, String paramString2);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.ContactEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */