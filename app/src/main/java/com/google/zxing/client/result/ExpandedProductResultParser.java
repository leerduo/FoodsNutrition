package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;
import java.util.Map;

public final class ExpandedProductResultParser
  extends ResultParser
{
  private static String a(int paramInt, String paramString)
  {
    if (paramString.charAt(paramInt) != '(') {
      return null;
    }
    String str = paramString.substring(paramInt + 1);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < str.length())
    {
      char c = str.charAt(i);
      if (c == ')') {
        return localStringBuilder.toString();
      }
      if ((c >= '0') && (c <= '9'))
      {
        localStringBuilder.append(c);
        i++;
      }
      else
      {
        return null;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString.substring(paramInt);
    int i = 0;
    if (i < str.length())
    {
      char c = str.charAt(i);
      if (c == '(')
      {
        if (a(i, str) == null) {
          localStringBuilder.append('(');
        }
      }
      else {
        for (;;)
        {
          i++;
          break;
          localStringBuilder.append(c);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public ExpandedProductParsedResult a(Result paramResult)
  {
    if (paramResult.d() != BarcodeFormat.n) {
      return null;
    }
    String str1 = c(paramResult);
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    String str2 = null;
    String str3 = null;
    Object localObject9 = null;
    String str4 = null;
    String str5 = null;
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < str1.length())
    {
      String str6 = a(i, str1);
      if (str6 == null) {
        return null;
      }
      int j = i + (2 + str6.length());
      String str7 = b(j, str1);
      int k = j + str7.length();
      int m = -1;
      switch (str6.hashCode())
      {
      default: 
        switch (m)
        {
        default: 
          label420:
          localHashMap.put(str6, str7);
        }
        break;
      }
      for (;;)
      {
        i = k;
        break;
        if (!str6.equals("00")) {
          break label420;
        }
        m = 0;
        break label420;
        if (!str6.equals("01")) {
          break label420;
        }
        m = 1;
        break label420;
        if (!str6.equals("10")) {
          break label420;
        }
        m = 2;
        break label420;
        if (!str6.equals("11")) {
          break label420;
        }
        m = 3;
        break label420;
        if (!str6.equals("13")) {
          break label420;
        }
        m = 4;
        break label420;
        if (!str6.equals("15")) {
          break label420;
        }
        m = 5;
        break label420;
        if (!str6.equals("17")) {
          break label420;
        }
        m = 6;
        break label420;
        if (!str6.equals("3100")) {
          break label420;
        }
        m = 7;
        break label420;
        if (!str6.equals("3101")) {
          break label420;
        }
        m = 8;
        break label420;
        if (!str6.equals("3102")) {
          break label420;
        }
        m = 9;
        break label420;
        if (!str6.equals("3103")) {
          break label420;
        }
        m = 10;
        break label420;
        if (!str6.equals("3104")) {
          break label420;
        }
        m = 11;
        break label420;
        if (!str6.equals("3105")) {
          break label420;
        }
        m = 12;
        break label420;
        if (!str6.equals("3106")) {
          break label420;
        }
        m = 13;
        break label420;
        if (!str6.equals("3107")) {
          break label420;
        }
        m = 14;
        break label420;
        if (!str6.equals("3108")) {
          break label420;
        }
        m = 15;
        break label420;
        if (!str6.equals("3109")) {
          break label420;
        }
        m = 16;
        break label420;
        if (!str6.equals("3200")) {
          break label420;
        }
        m = 17;
        break label420;
        if (!str6.equals("3201")) {
          break label420;
        }
        m = 18;
        break label420;
        if (!str6.equals("3202")) {
          break label420;
        }
        m = 19;
        break label420;
        if (!str6.equals("3203")) {
          break label420;
        }
        m = 20;
        break label420;
        if (!str6.equals("3204")) {
          break label420;
        }
        m = 21;
        break label420;
        if (!str6.equals("3205")) {
          break label420;
        }
        m = 22;
        break label420;
        if (!str6.equals("3206")) {
          break label420;
        }
        m = 23;
        break label420;
        if (!str6.equals("3207")) {
          break label420;
        }
        m = 24;
        break label420;
        if (!str6.equals("3208")) {
          break label420;
        }
        m = 25;
        break label420;
        if (!str6.equals("3209")) {
          break label420;
        }
        m = 26;
        break label420;
        if (!str6.equals("3920")) {
          break label420;
        }
        m = 27;
        break label420;
        if (!str6.equals("3921")) {
          break label420;
        }
        m = 28;
        break label420;
        if (!str6.equals("3922")) {
          break label420;
        }
        m = 29;
        break label420;
        if (!str6.equals("3923")) {
          break label420;
        }
        m = 30;
        break label420;
        if (!str6.equals("3930")) {
          break label420;
        }
        m = 31;
        break label420;
        if (!str6.equals("3931")) {
          break label420;
        }
        m = 32;
        break label420;
        if (!str6.equals("3932")) {
          break label420;
        }
        m = 33;
        break label420;
        if (!str6.equals("3933")) {
          break label420;
        }
        m = 34;
        break label420;
        localObject2 = str7;
        continue;
        localObject1 = str7;
        continue;
        localObject3 = str7;
        continue;
        localObject4 = str7;
        continue;
        localObject5 = str7;
        continue;
        localObject6 = str7;
        continue;
        localObject7 = str7;
        continue;
        str2 = "KG";
        str3 = str6.substring(3);
        localObject8 = str7;
        continue;
        str2 = "LB";
        str3 = str6.substring(3);
        localObject8 = str7;
        continue;
        str4 = str6.substring(3);
        localObject9 = str7;
        continue;
        if (str7.length() < 4) {
          return null;
        }
        localObject9 = str7.substring(3);
        str5 = str7.substring(0, 3);
        str4 = str6.substring(3);
      }
    }
    return new ExpandedProductParsedResult(str1, localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, str2, str3, (String)localObject9, str4, str5, localHashMap);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ExpandedProductResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */