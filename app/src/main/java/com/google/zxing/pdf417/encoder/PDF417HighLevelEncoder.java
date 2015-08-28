package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class PDF417HighLevelEncoder
{
  private static final byte[] a;
  private static final byte[] b;
  private static final byte[] c;
  private static final byte[] d;
  private static final List<String> e;
  
  static
  {
    int i = 0;
    a = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0 };
    b = new byte[] { 59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0 };
    c = new byte[''];
    d = new byte[''];
    e = Arrays.asList(new String[] { "Cp437", "IBM437" });
    Arrays.fill(c, (byte)-1);
    for (int j = 0; j < a.length; j = (byte)(j + 1))
    {
      int m = a[j];
      if (m > 0) {
        c[m] = j;
      }
    }
    Arrays.fill(d, (byte)-1);
    while (i < b.length)
    {
      int k = b[i];
      if (k > 0) {
        d[k] = i;
      }
      i = (byte)(i + 1);
    }
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    int j = 0;
    if (paramInt < i)
    {
      char c1 = paramCharSequence.charAt(paramInt);
      while ((a(c1)) && (paramInt < i))
      {
        j++;
        paramInt++;
        if (paramInt < i) {
          c1 = paramCharSequence.charAt(paramInt);
        }
      }
    }
    return j;
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt2);
    int i = 0;
    char c1;
    label73:
    do
    {
      c1 = paramCharSequence.charAt(paramInt1 + i);
      switch (paramInt3)
      {
      default: 
        if (!e(c1)) {
          break label511;
        }
        localStringBuilder.append((char)d[c1]);
        i++;
      }
    } while (i < paramInt2);
    int j = localStringBuilder.length();
    int k = 0;
    int m = 0;
    label95:
    if (k < j)
    {
      int n;
      label112:
      char c2;
      if (k % 2 != 0)
      {
        n = 1;
        if (n == 0) {
          break label531;
        }
        c2 = (char)(m * 30 + localStringBuilder.charAt(k));
        paramStringBuilder.append(c2);
      }
      for (;;)
      {
        k++;
        m = c2;
        break label95;
        if (b(c1))
        {
          if (c1 == ' ')
          {
            localStringBuilder.append('\032');
            break label73;
          }
          localStringBuilder.append((char)(c1 - 'A'));
          break label73;
        }
        if (c(c1))
        {
          localStringBuilder.append('\033');
          paramInt3 = 1;
          break;
        }
        if (d(c1))
        {
          paramInt3 = 2;
          localStringBuilder.append('\034');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)d[c1]);
        break label73;
        if (c(c1))
        {
          if (c1 == ' ')
          {
            localStringBuilder.append('\032');
            break label73;
          }
          localStringBuilder.append((char)(c1 - 'a'));
          break label73;
        }
        if (b(c1))
        {
          localStringBuilder.append('\033');
          localStringBuilder.append((char)(c1 - 'A'));
          break label73;
        }
        if (d(c1))
        {
          paramInt3 = 2;
          localStringBuilder.append('\034');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)d[c1]);
        break label73;
        if (d(c1))
        {
          localStringBuilder.append((char)c[c1]);
          break label73;
        }
        if (b(c1))
        {
          localStringBuilder.append('\034');
          paramInt3 = 0;
          break;
        }
        if (c(c1))
        {
          localStringBuilder.append('\033');
          paramInt3 = 1;
          break;
        }
        if ((1 + (paramInt1 + i) < paramInt2) && (e(paramCharSequence.charAt(1 + (paramInt1 + i)))))
        {
          paramInt3 = 3;
          localStringBuilder.append('\031');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)d[c1]);
        break label73;
        label511:
        localStringBuilder.append('\035');
        paramInt3 = 0;
        break;
        n = 0;
        break label112;
        c2 = localStringBuilder.charAt(k);
      }
    }
    label531:
    if (j % 2 != 0) {
      paramStringBuilder.append((char)(29 + m * 30));
    }
    return paramInt3;
  }
  
  private static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramCharSequence.length();
    for (int j = paramInt; j < i; j++)
    {
      char c1 = paramCharSequence.charAt(j);
      int k = 0;
      for (;;)
      {
        int i1;
        if ((k < 13) && (a(c1)))
        {
          k++;
          i1 = j + k;
          if (i1 < i) {}
        }
        else
        {
          if (k < 13) {
            break;
          }
          return j - paramInt;
        }
        c1 = paramCharSequence.charAt(i1);
      }
      char c2 = c1;
      int m = 0;
      for (;;)
      {
        int n;
        if ((m < 5) && (f(c2)))
        {
          m++;
          n = j + m;
          if (n < i) {}
        }
        else
        {
          if (m < 5) {
            break;
          }
          return j - paramInt;
        }
        c2 = paramCharSequence.charAt(n);
      }
      char c3 = paramCharSequence.charAt(j);
      if ((paramArrayOfByte[j] == 63) && (c3 != '?')) {
        throw new WriterException("Non-encodable character detected: " + c3 + " (Unicode: " + c3 + ')');
      }
    }
    return j - paramInt;
  }
  
  static String a(String paramString, Compaction paramCompaction, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    if ((paramCharset != null) || (!e.contains(paramCharset.name())))
    {
      CharacterSetECI localCharacterSetECI = CharacterSetECI.a(paramCharset.name());
      if (localCharacterSetECI != null) {
        a(localCharacterSetECI.a(), localStringBuilder);
      }
    }
    int i = paramString.length();
    byte[] arrayOfByte1 = null;
    if (paramCompaction == Compaction.b) {
      a(paramString, 0, i, localStringBuilder, 0);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramCompaction == Compaction.c)
      {
        byte[] arrayOfByte2 = a(paramString, paramCharset);
        a(arrayOfByte2, 0, arrayOfByte2.length, 1, localStringBuilder);
      }
      else
      {
        if (paramCompaction != Compaction.d) {
          break;
        }
        localStringBuilder.append('Ά');
        a(paramString, 0, i, localStringBuilder);
      }
    }
    int j = 0;
    int k = 0;
    int m = 0;
    label148:
    int i2;
    while (m < i)
    {
      int n = a(paramString, m);
      if (n >= 13)
      {
        localStringBuilder.append('Ά');
        j = 2;
        a(paramString, m, n, localStringBuilder);
        m += n;
        k = 0;
      }
      else
      {
        int i1 = b(paramString, m);
        if ((i1 >= 5) || (n == i))
        {
          if (j != 0)
          {
            localStringBuilder.append('΄');
            j = 0;
            k = 0;
          }
          k = a(paramString, m, i1, localStringBuilder, k);
          m += i1;
        }
        else
        {
          if (arrayOfByte1 == null) {
            arrayOfByte1 = a(paramString, paramCharset);
          }
          i2 = a(paramString, arrayOfByte1, m);
          if (i2 == 0) {
            i2 = 1;
          }
          if ((i2 != 1) || (j != 0)) {
            break label327;
          }
          a(arrayOfByte1, m, 1, 0, localStringBuilder);
        }
      }
    }
    for (;;)
    {
      m += i2;
      break label148;
      break;
      label327:
      a(arrayOfByte1, m, i2, j, localStringBuilder);
      j = 1;
      k = 0;
    }
  }
  
  private static void a(int paramInt, StringBuilder paramStringBuilder)
  {
    if ((paramInt >= 0) && (paramInt < 900))
    {
      paramStringBuilder.append('Ο');
      paramStringBuilder.append((char)paramInt);
      return;
    }
    if (paramInt < 810900)
    {
      paramStringBuilder.append('Ξ');
      paramStringBuilder.append((char)(-1 + paramInt / 900));
      paramStringBuilder.append((char)(paramInt % 900));
      return;
    }
    if (paramInt < 811800)
    {
      paramStringBuilder.append('Ν');
      paramStringBuilder.append((char)(810900 - paramInt));
      return;
    }
    throw new WriterException("ECI number not in valid range from 0..811799, but was " + paramInt);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder(1 + paramInt2 / 3);
    BigInteger localBigInteger1 = BigInteger.valueOf(900L);
    BigInteger localBigInteger2 = BigInteger.valueOf(0L);
    int i = 0;
    while (i < paramInt2 - 1)
    {
      localStringBuilder.setLength(0);
      int j = Math.min(44, paramInt2 - i);
      BigInteger localBigInteger3 = new BigInteger('1' + paramString.substring(paramInt1 + i, j + (paramInt1 + i)));
      do
      {
        localStringBuilder.append((char)localBigInteger3.mod(localBigInteger1).intValue());
        localBigInteger3 = localBigInteger3.divide(localBigInteger1);
      } while (!localBigInteger3.equals(localBigInteger2));
      for (int k = -1 + localStringBuilder.length(); k >= 0; k--) {
        paramStringBuilder.append(localStringBuilder.charAt(k));
      }
      i += j;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    char[] arrayOfChar;
    int j;
    if ((paramInt2 == 1) && (paramInt3 == 0))
    {
      paramStringBuilder.append('Α');
      if (paramInt2 >= 6) {
        arrayOfChar = new char[5];
      }
    }
    else
    {
      for (j = paramInt1;; j += 6)
      {
        if (paramInt1 + paramInt2 - j < 6) {
          break label198;
        }
        long l = 0L;
        int k = 0;
        for (;;)
        {
          if (k < 6)
          {
            l = (l << 8) + (0xFF & paramArrayOfByte[(j + k)]);
            k++;
            continue;
            if (paramInt2 % 6 == 0) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label115;
              }
              paramStringBuilder.append('Μ');
              break;
            }
            label115:
            paramStringBuilder.append('΅');
            break;
          }
        }
        for (int m = 0; m < 5; m++)
        {
          arrayOfChar[m] = ((char)(int)(l % 900L));
          l /= 900L;
        }
        for (int n = -1 + arrayOfChar.length; n >= 0; n--) {
          paramStringBuilder.append(arrayOfChar[n]);
        }
      }
    }
    for (;;)
    {
      label198:
      if (j < paramInt1 + paramInt2)
      {
        paramStringBuilder.append((char)(0xFF & paramArrayOfByte[j]));
        j++;
      }
      else
      {
        return;
        j = paramInt1;
      }
    }
  }
  
  private static boolean a(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static byte[] a(String paramString, Charset paramCharset)
  {
    Iterator localIterator;
    if (paramCharset == null) {
      localIterator = e.iterator();
    }
    for (;;)
    {
      String str;
      if (localIterator.hasNext()) {
        str = (String)localIterator.next();
      }
      try
      {
        Charset localCharset = Charset.forName(str);
        paramCharset = localCharset;
      }
      catch (UnsupportedCharsetException localUnsupportedCharsetException) {}
      if (paramCharset == null) {
        throw new WriterException("No support for any encoding: " + e);
      }
      return paramString.getBytes(paramCharset);
    }
  }
  
  private static int b(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    int j = paramInt;
    char c1;
    int k;
    if (j < i)
    {
      c1 = paramCharSequence.charAt(j);
      k = 0;
    }
    for (;;)
    {
      int m;
      if ((k < 13) && (a(c1)) && (j < i))
      {
        k++;
        m = j + 1;
        if (m < i)
        {
          c1 = paramCharSequence.charAt(m);
          j = m;
        }
      }
      else
      {
        if (k >= 13) {
          return j - paramInt - k;
        }
        if (k > 0) {
          break;
        }
        if (!f(paramCharSequence.charAt(j))) {
          return j - paramInt;
        }
        j++;
        break;
        j = m;
      }
    }
  }
  
  private static boolean b(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean c(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  private static boolean d(char paramChar)
  {
    return c[paramChar] != -1;
  }
  
  private static boolean e(char paramChar)
  {
    return d[paramChar] != -1;
  }
  
  private static boolean f(char paramChar)
  {
    return (paramChar == '\t') || (paramChar == '\n') || (paramChar == '\r') || ((paramChar >= ' ') && (paramChar <= '~'));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */