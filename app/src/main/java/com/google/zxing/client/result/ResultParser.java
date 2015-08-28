package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ResultParser
{
  private static final ResultParser[] a = arrayOfResultParser;
  private static final Pattern b = Pattern.compile("\\d+");
  private static final Pattern c = Pattern.compile("&");
  private static final Pattern d = Pattern.compile("=");
  
  static
  {
    ResultParser[] arrayOfResultParser = new ResultParser[20];
    arrayOfResultParser[0] = new BookmarkDoCoMoResultParser();
    arrayOfResultParser[1] = new AddressBookDoCoMoResultParser();
    arrayOfResultParser[2] = new EmailDoCoMoResultParser();
    arrayOfResultParser[3] = new AddressBookAUResultParser();
    arrayOfResultParser[4] = new VCardResultParser();
    arrayOfResultParser[5] = new BizcardResultParser();
    arrayOfResultParser[6] = new VEventResultParser();
    arrayOfResultParser[7] = new EmailAddressResultParser();
    arrayOfResultParser[8] = new SMTPResultParser();
    arrayOfResultParser[9] = new TelResultParser();
    arrayOfResultParser[10] = new SMSMMSResultParser();
    arrayOfResultParser[11] = new SMSTOMMSTOResultParser();
    arrayOfResultParser[12] = new GeoResultParser();
    arrayOfResultParser[13] = new WifiResultParser();
    arrayOfResultParser[14] = new URLTOResultParser();
    arrayOfResultParser[15] = new URIResultParser();
    arrayOfResultParser[16] = new ISBNResultParser();
    arrayOfResultParser[17] = new ProductResultParser();
    arrayOfResultParser[18] = new ExpandedProductResultParser();
    arrayOfResultParser[19] = new VINResultParser();
  }
  
  protected static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return 10 + (paramChar - 'a');
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return 10 + (paramChar - 'A');
    }
    return -1;
  }
  
  private static void a(CharSequence paramCharSequence, Map<String, String> paramMap)
  {
    String[] arrayOfString = d.split(paramCharSequence, 2);
    String str1;
    String str2;
    if (arrayOfString.length == 2)
    {
      str1 = arrayOfString[0];
      str2 = arrayOfString[1];
    }
    try
    {
      paramMap.put(str1, e(str2));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  protected static boolean a(CharSequence paramCharSequence, int paramInt)
  {
    return (paramCharSequence != null) && (paramInt > 0) && (paramInt == paramCharSequence.length()) && (b.matcher(paramCharSequence).matches());
  }
  
  protected static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence == null) || (paramInt2 <= 0)) {}
    int i;
    do
    {
      return false;
      i = paramInt1 + paramInt2;
    } while ((paramCharSequence.length() < i) || (!b.matcher(paramCharSequence.subSequence(paramInt1, i)).matches()));
    return true;
  }
  
  static String[] a(String paramString1, String paramString2, char paramChar, boolean paramBoolean)
  {
    int i = paramString2.length();
    int j = 0;
    Object localObject1 = null;
    for (;;)
    {
      int k;
      if (j < i)
      {
        k = paramString2.indexOf(paramString1, j);
        if (k >= 0) {}
      }
      else
      {
        if ((localObject1 != null) && (!localObject1.isEmpty())) {
          break;
        }
        return null;
      }
      int m = k + paramString1.length();
      int n = 1;
      Object localObject2 = localObject1;
      int i1 = m;
      while (n != 0)
      {
        int i3 = paramString2.indexOf(paramChar, i1);
        if (i3 < 0)
        {
          i1 = paramString2.length();
          n = 0;
        }
        else if (paramString2.charAt(i3 - 1) == '\\')
        {
          i1 = i3 + 1;
        }
        else
        {
          if (localObject2 == null) {
            localObject2 = new ArrayList(3);
          }
          String str = c(paramString2.substring(m, i3));
          if (paramBoolean) {
            str = str.trim();
          }
          if (!str.isEmpty()) {
            ((List)localObject2).add(str);
          }
          i1 = i3 + 1;
          n = 0;
        }
      }
      int i2 = i1;
      localObject1 = localObject2;
      j = i2;
    }
    return (String[])localObject1.toArray(new String[localObject1.size()]);
  }
  
  static String b(String paramString1, String paramString2, char paramChar, boolean paramBoolean)
  {
    String[] arrayOfString = a(paramString1, paramString2, paramChar, paramBoolean);
    if (arrayOfString == null) {
      return null;
    }
    return arrayOfString[0];
  }
  
  protected static String[] b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new String[] { paramString };
  }
  
  protected static String c(Result paramResult)
  {
    String str = paramResult.a();
    if (str.startsWith("﻿")) {
      str = str.substring(1);
    }
    return str;
  }
  
  protected static String c(String paramString)
  {
    int i = paramString.indexOf('\\');
    if (i < 0) {
      return paramString;
    }
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j - 1);
    localStringBuilder.append(paramString.toCharArray(), 0, i);
    int k = i;
    int m = 0;
    if (k < j)
    {
      char c1 = paramString.charAt(k);
      if ((m != 0) || (c1 != '\\')) {
        localStringBuilder.append(c1);
      }
      for (m = 0;; m = 1)
      {
        k++;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static ParsedResult d(Result paramResult)
  {
    ResultParser[] arrayOfResultParser = a;
    int i = arrayOfResultParser.length;
    for (int j = 0; j < i; j++)
    {
      ParsedResult localParsedResult = arrayOfResultParser[j].b(paramResult);
      if (localParsedResult != null) {
        return localParsedResult;
      }
    }
    return new TextParsedResult(paramResult.a(), null);
  }
  
  static Map<String, String> d(String paramString)
  {
    int i = paramString.indexOf('?');
    Object localObject;
    if (i < 0) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = new HashMap(3);
      String[] arrayOfString = c.split(paramString.substring(i + 1));
      int j = arrayOfString.length;
      for (int k = 0; k < j; k++) {
        a(arrayOfString[k], (Map)localObject);
      }
    }
  }
  
  static String e(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException(localUnsupportedEncodingException);
    }
  }
  
  public abstract ParsedResult b(Result paramResult);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */