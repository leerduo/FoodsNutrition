package com.google.zxing.client.androidlegacy.encode;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

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
    } while (str.length() == 0);
    return str;
  }
  
  static void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, String paramString, Iterable<String> paramIterable, int paramInt, Formatter paramFormatter1, Formatter paramFormatter2, char paramChar)
  {
    if (paramIterable == null) {
      return;
    }
    HashSet localHashSet = new HashSet(2);
    Iterator localIterator = paramIterable.iterator();
    int i = 0;
    label26:
    String str1;
    if (localIterator.hasNext())
    {
      str1 = a((String)localIterator.next());
      if ((str1 != null) && (str1.length() > 0) && (!localHashSet.contains(str1)))
      {
        paramStringBuilder1.append(paramString).append(':').append(paramFormatter2.a(str1)).append(paramChar);
        if (paramFormatter1 != null) {
          break label148;
        }
      }
    }
    label148:
    for (String str2 = str1;; str2 = paramFormatter1.a(str1))
    {
      paramStringBuilder2.append(str2).append('\n');
      i++;
      if (i == paramInt) {
        break;
      }
      localHashSet.add(str1);
      break label26;
      break;
    }
  }
  
  static void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, String paramString1, String paramString2, Formatter paramFormatter, char paramChar)
  {
    String str = a(paramString2);
    if (str != null)
    {
      paramStringBuilder1.append(paramString1).append(':').append(paramFormatter.a(str)).append(paramChar);
      paramStringBuilder2.append(str).append('\n');
    }
  }
  
  abstract String[] a(Iterable<String> paramIterable1, String paramString1, Iterable<String> paramIterable2, Iterable<String> paramIterable3, Iterable<String> paramIterable4, Iterable<String> paramIterable5, String paramString2);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.encode.ContactEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */