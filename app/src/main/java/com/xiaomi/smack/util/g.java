package com.xiaomi.smack.util;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.string.a;
import java.util.Random;

public class g
{
  private static final char[] a = "&quot;".toCharArray();
  private static final char[] b = "&apos;".toCharArray();
  private static final char[] c = "&amp;".toCharArray();
  private static final char[] d = "&lt;".toCharArray();
  private static final char[] e = "&gt;".toCharArray();
  private static Random f = new Random();
  private static char[] g = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  
  public static String a(int paramInt)
  {
    if (paramInt < 1) {
      return null;
    }
    char[] arrayOfChar = new char[paramInt];
    for (int i = 0; i < arrayOfChar.length; i++) {
      arrayOfChar[i] = g[f.nextInt(71)];
    }
    return new String(arrayOfChar);
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      paramString = null;
    }
    char[] arrayOfChar;
    StringBuilder localStringBuilder;
    int k;
    do
    {
      return paramString;
      arrayOfChar = paramString.toCharArray();
      int j = arrayOfChar.length;
      localStringBuilder = new StringBuilder((int)(1.3D * j));
      k = 0;
      if (k < j)
      {
        int m = arrayOfChar[k];
        if (m > 62) {}
        for (;;)
        {
          k++;
          break;
          if (m == 60)
          {
            if (k > i) {
              localStringBuilder.append(arrayOfChar, i, k - i);
            }
            i = k + 1;
            localStringBuilder.append(d);
          }
          else if (m == 62)
          {
            if (k > i) {
              localStringBuilder.append(arrayOfChar, i, k - i);
            }
            i = k + 1;
            localStringBuilder.append(e);
          }
          else if (m == 38)
          {
            if (k > i) {
              localStringBuilder.append(arrayOfChar, i, k - i);
            }
            if ((j <= k + 5) || (arrayOfChar[(k + 1)] != '#') || (!Character.isDigit(arrayOfChar[(k + 2)])) || (!Character.isDigit(arrayOfChar[(k + 3)])) || (!Character.isDigit(arrayOfChar[(k + 4)])) || (arrayOfChar[(k + 5)] != ';'))
            {
              i = k + 1;
              localStringBuilder.append(c);
            }
          }
          else if (m == 34)
          {
            if (k > i) {
              localStringBuilder.append(arrayOfChar, i, k - i);
            }
            i = k + 1;
            localStringBuilder.append(a);
          }
          else if (m == 39)
          {
            if (k > i) {
              localStringBuilder.append(arrayOfChar, i, k - i);
            }
            i = k + 1;
            localStringBuilder.append(b);
          }
        }
      }
    } while (i == 0);
    if (k > i) {
      localStringBuilder.append(arrayOfChar, i, k - i);
    }
    return localStringBuilder.toString();
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      paramString1 = null;
    }
    int i;
    do
    {
      return paramString1;
      i = paramString1.indexOf(paramString2, 0);
    } while (i < 0);
    char[] arrayOfChar1 = paramString1.toCharArray();
    char[] arrayOfChar2 = paramString3.toCharArray();
    int j = paramString2.length();
    StringBuilder localStringBuilder = new StringBuilder(arrayOfChar1.length);
    localStringBuilder.append(arrayOfChar1, 0, i).append(arrayOfChar2);
    int k = i + j;
    for (int m = k;; m = k)
    {
      int n = paramString1.indexOf(paramString2, m);
      if (n <= 0) {
        break;
      }
      localStringBuilder.append(arrayOfChar1, k, n - k).append(arrayOfChar2);
      k = n + j;
    }
    localStringBuilder.append(arrayOfChar1, k, arrayOfChar1.length - k);
    return localStringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return String.valueOf(a.a(paramArrayOfByte));
  }
  
  public static boolean a(char paramChar)
  {
    return ((paramChar >= ' ') && (paramChar <= 55295)) || ((paramChar >= 57344) && (paramChar <= 65533)) || ((paramChar >= 65536) && (paramChar <= 1114111)) || (paramChar == '\t') || (paramChar == '\n') || (paramChar == '\r');
  }
  
  public static final String b(String paramString)
  {
    return a(a(a(a(a(paramString, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    for (int i = 0; i < paramString.length(); i++)
    {
      char c1 = paramString.charAt(i);
      if (a(c1)) {
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.util.g
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */