package com.activeandroid.util;

import java.util.Comparator;

public class NaturalOrderComparator
  implements Comparator<Object>
{
  static char a(String paramString, int paramInt)
  {
    if (paramInt >= paramString.length()) {
      return '\000';
    }
    return paramString.charAt(paramInt);
  }
  
  int a(String paramString1, String paramString2)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    char c1 = a(paramString1, j);
    char c2 = a(paramString2, i);
    if ((!Character.isDigit(c1)) && (!Character.isDigit(c2))) {
      return k;
    }
    if (!Character.isDigit(c1)) {
      return -1;
    }
    if (!Character.isDigit(c2)) {
      return 1;
    }
    if (c1 < c2) {
      if (k == 0) {
        k = -1;
      }
    }
    label104:
    do
    {
      for (;;)
      {
        j++;
        i++;
        break;
        if (c1 <= c2) {
          break label104;
        }
        if (k == 0) {
          k = 1;
        }
      }
    } while ((c1 != 0) || (c2 != 0));
    return k;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    String str1 = paramObject1.toString();
    String str2 = paramObject2.toString();
    int i = 0;
    int j = 0;
    char c1 = a(str1, j);
    char c2 = a(str2, i);
    int k = j;
    char c3 = c1;
    int m = 0;
    if ((Character.isSpaceChar(c3)) || (c3 == '0'))
    {
      if (c3 == '0') {
        m++;
      }
      for (;;)
      {
        k++;
        c3 = a(str1, k);
        break;
        m = 0;
      }
    }
    for (;;)
    {
      if ((Character.isSpaceChar(c4)) || (c4 == '0'))
      {
        if (c4 == '0') {
          i1++;
        }
        for (;;)
        {
          n++;
          c4 = a(str2, n);
          break;
          i1 = 0;
        }
      }
      if ((Character.isDigit(c3)) && (Character.isDigit(c4)))
      {
        int i2 = a(str1.substring(k), str2.substring(n));
        if (i2 != 0) {
          return i2;
        }
      }
      if ((c3 == 0) && (c4 == 0)) {
        return m - i1;
      }
      if (c3 < c4) {
        return -1;
      }
      if (c3 > c4) {
        return 1;
      }
      j = k + 1;
      i = n + 1;
      break;
      int n = i;
      char c4 = c2;
      int i1 = 0;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.util.NaturalOrderComparator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */