package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VINResultParser
  extends ResultParser
{
  private static final Pattern a = Pattern.compile("[IOQ]");
  private static final Pattern b = Pattern.compile("[A-Z0-9]{17}");
  
  private static int a(int paramInt)
  {
    int i = 10;
    if ((paramInt >= 1) && (paramInt <= 7)) {
      i = 9 - paramInt;
    }
    while (paramInt == 8) {
      return i;
    }
    if (paramInt == 9) {
      return 0;
    }
    if ((paramInt >= i) && (paramInt <= 17)) {
      return 19 - paramInt;
    }
    throw new IllegalArgumentException();
  }
  
  private static boolean a(CharSequence paramCharSequence)
  {
    int i = 0;
    int j = 0;
    while (i < paramCharSequence.length())
    {
      j += a(i + 1) * b(paramCharSequence.charAt(i));
      i++;
    }
    int k = paramCharSequence.charAt(8);
    int m = b(j % 11);
    boolean bool = false;
    if (k == m) {
      bool = true;
    }
    return bool;
  }
  
  private static char b(int paramInt)
  {
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    if (paramInt == 10) {
      return 'X';
    }
    throw new IllegalArgumentException();
  }
  
  private static int b(char paramChar)
  {
    if ((paramChar >= 'A') && (paramChar <= 'I')) {
      return 1 + (paramChar - 'A');
    }
    if ((paramChar >= 'J') && (paramChar <= 'R')) {
      return 1 + (paramChar - 'J');
    }
    if ((paramChar >= 'S') && (paramChar <= 'Z')) {
      return 2 + (paramChar - 'S');
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    throw new IllegalArgumentException();
  }
  
  private static String b(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.charAt(0);
    int j = paramCharSequence.charAt(1);
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return null;
                      return "US";
                      return "CA";
                    } while ((j < 65) || (j > 87));
                    return "MX";
                  } while (((j < 65) || (j > 69)) && ((j < 51) || (j > 57)));
                  return "BR";
                } while ((j < 65) || (j > 84));
                return "JP";
              } while ((j < 76) || (j > 82));
              return "KO";
              return "CN";
            } while ((j < 65) || (j > 69));
            return "IN";
            if ((j >= 65) && (j <= 77)) {
              return "UK";
            }
          } while ((j < 78) || (j > 84));
          return "DE";
          if ((j >= 70) && (j <= 82)) {
            return "FR";
          }
        } while ((j < 83) || (j > 87));
        return "ES";
        return "DE";
      } while ((j != 48) && ((j < 51) || (j > 57)));
      return "RU";
    } while ((j < 65) || (j > 82));
    return "IT";
  }
  
  private static int c(char paramChar)
  {
    if ((paramChar >= 'E') && (paramChar <= 'H')) {
      return 1984 + (paramChar - 'E');
    }
    if ((paramChar >= 'J') && (paramChar <= 'N')) {
      return 1988 + (paramChar - 'J');
    }
    if (paramChar == 'P') {
      return 1993;
    }
    if ((paramChar >= 'R') && (paramChar <= 'T')) {
      return 1994 + (paramChar - 'R');
    }
    if ((paramChar >= 'V') && (paramChar <= 'Y')) {
      return 1997 + (paramChar - 'V');
    }
    if ((paramChar >= '1') && (paramChar <= '9')) {
      return 2001 + (paramChar - '1');
    }
    if ((paramChar >= 'A') && (paramChar <= 'D')) {
      return 2010 + (paramChar - 'A');
    }
    throw new IllegalArgumentException();
  }
  
  public VINParsedResult a(Result paramResult)
  {
    if (paramResult.d() != BarcodeFormat.c) {
      return null;
    }
    String str1 = paramResult.a();
    String str2 = a.matcher(str1).replaceAll("").trim();
    if (!b.matcher(str2).matches()) {
      return null;
    }
    try
    {
      if (!a(str2)) {
        return null;
      }
      String str3 = str2.substring(0, 3);
      VINParsedResult localVINParsedResult = new VINParsedResult(str2, str3, str2.substring(3, 9), str2.substring(9, 17), b(str3), str2.substring(3, 8), c(str2.charAt(9)), str2.charAt(10), str2.substring(11));
      return localVINParsedResult;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.VINResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */