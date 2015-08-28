package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class DecodedBitStreamParser
{
  private static final char[] a = { 42, 42, 42, 32, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
  private static final char[] b = { 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95 };
  private static final char[] c = { 42, 42, 42, 32, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final char[] d = { 96, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 123, 124, 125, 126, 127 };
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - (1 + paramInt2 * 149 % 255);
    if (i >= 0) {
      return i;
    }
    return i + 256;
  }
  
  static DecoderResult a(byte[] paramArrayOfByte)
  {
    BitSource localBitSource = new BitSource(paramArrayOfByte);
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    StringBuilder localStringBuilder2 = new StringBuilder(0);
    ArrayList localArrayList = new ArrayList(1);
    DecodedBitStreamParser.Mode localMode = DecodedBitStreamParser.Mode.b;
    String str;
    while (localMode == DecodedBitStreamParser.Mode.b)
    {
      localMode = a(localBitSource, localStringBuilder1, localStringBuilder2);
      if ((localMode == DecodedBitStreamParser.Mode.a) || (localBitSource.c() <= 0))
      {
        if (localStringBuilder2.length() > 0) {
          localStringBuilder1.append(localStringBuilder2);
        }
        str = localStringBuilder1.toString();
        if (!localArrayList.isEmpty()) {
          break label215;
        }
      }
    }
    label215:
    for (Object localObject = null;; localObject = localArrayList)
    {
      return new DecoderResult(paramArrayOfByte, str, (List)localObject, null);
      switch (DecodedBitStreamParser.1.a[localMode.ordinal()])
      {
      default: 
        throw FormatException.a();
      case 1: 
        a(localBitSource, localStringBuilder1);
      }
      for (;;)
      {
        localMode = DecodedBitStreamParser.Mode.b;
        break;
        b(localBitSource, localStringBuilder1);
        continue;
        c(localBitSource, localStringBuilder1);
        continue;
        d(localBitSource, localStringBuilder1);
        continue;
        a(localBitSource, localStringBuilder1, localArrayList);
      }
    }
  }
  
  private static DecodedBitStreamParser.Mode a(BitSource paramBitSource, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    int i = 0;
    break label102;
    label2:
    int j = paramBitSource.a(8);
    if (j == 0) {
      throw FormatException.a();
    }
    if (j <= 128) {
      if (i == 0) {
        break label307;
      }
    }
    label307:
    for (int m = j + 128;; m = j)
    {
      paramStringBuilder1.append((char)(m - 1));
      return DecodedBitStreamParser.Mode.b;
      if (j == 129) {
        return DecodedBitStreamParser.Mode.a;
      }
      if (j <= 229)
      {
        int k = j - 130;
        if (k < 10) {
          paramStringBuilder1.append('0');
        }
        paramStringBuilder1.append(k);
      }
      label102:
      while (paramBitSource.c() <= 0)
      {
        return DecodedBitStreamParser.Mode.b;
        if (j == 230) {
          return DecodedBitStreamParser.Mode.c;
        }
        if (j == 231) {
          return DecodedBitStreamParser.Mode.g;
        }
        if (j == 232) {
          paramStringBuilder1.append('\035');
        } else if ((j != 233) && (j != 234)) {
          if (j == 235)
          {
            i = 1;
          }
          else if (j == 236)
          {
            paramStringBuilder1.append("[)>\03605\035");
            paramStringBuilder2.insert(0, "\036\004");
          }
          else
          {
            if (j != 237) {
              break label236;
            }
            paramStringBuilder1.append("[)>\03606\035");
            paramStringBuilder2.insert(0, "\036\004");
          }
        }
      }
      break label2;
      label236:
      if (j == 238) {
        return DecodedBitStreamParser.Mode.e;
      }
      if (j == 239) {
        return DecodedBitStreamParser.Mode.d;
      }
      if (j == 240) {
        return DecodedBitStreamParser.Mode.f;
      }
      if ((j == 241) || (j < 242) || ((j == 254) && (paramBitSource.c() == 0))) {
        break;
      }
      throw FormatException.a();
    }
  }
  
  private static void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = -1 + (paramInt2 + (paramInt1 << 8));
    int j = i / 1600;
    paramArrayOfInt[0] = j;
    int k = i - j * 1600;
    int m = k / 40;
    paramArrayOfInt[1] = m;
    paramArrayOfInt[2] = (k - m * 40);
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = new int[3];
    int i = 0;
    int j = 0;
    label163:
    do
    {
      if (paramBitSource.c() == 8) {}
      int k;
      do
      {
        return;
        k = paramBitSource.a(8);
      } while (k == 254);
      a(k, paramBitSource.a(8), arrayOfInt);
      int m = 0;
      if (m < 3)
      {
        int n = arrayOfInt[m];
        switch (i)
        {
        default: 
          throw FormatException.a();
        case 0: 
          if (n < 3) {
            i = n + 1;
          }
          for (;;)
          {
            m++;
            break;
            if (n >= a.length) {
              break label163;
            }
            char c2 = a[n];
            if (j != 0)
            {
              paramStringBuilder.append((char)(c2 + ''));
              j = 0;
            }
            else
            {
              paramStringBuilder.append(c2);
            }
          }
          throw FormatException.a();
        case 1: 
          if (j != 0)
          {
            paramStringBuilder.append((char)(n + 128));
            j = 0;
          }
          for (;;)
          {
            i = 0;
            break;
            paramStringBuilder.append((char)n);
          }
        case 2: 
          char c1;
          if (n < b.length)
          {
            c1 = b[n];
            if (j != 0)
            {
              paramStringBuilder.append((char)(c1 + ''));
              j = 0;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramStringBuilder.append(c1);
            continue;
            if (n == 27)
            {
              paramStringBuilder.append('\035');
            }
            else
            {
              if (n != 30) {
                break label285;
              }
              j = 1;
            }
          }
          throw FormatException.a();
        }
        if (j != 0)
        {
          paramStringBuilder.append((char)(n + 224));
          j = 0;
        }
        for (;;)
        {
          i = 0;
          break;
          paramStringBuilder.append((char)(n + 96));
        }
      }
    } while (paramBitSource.c() > 0);
    label285:
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, Collection<byte[]> paramCollection)
  {
    int i = 1 + paramBitSource.b();
    int j = paramBitSource.a(8);
    int k = i + 1;
    int m = a(j, i);
    int i3;
    if (m == 0) {
      i3 = paramBitSource.c() / 8;
    }
    while (i3 < 0)
    {
      throw FormatException.a();
      if (m < 250)
      {
        i3 = m;
      }
      else
      {
        int n = 250 * (m - 249);
        int i1 = paramBitSource.a(8);
        int i2 = k + 1;
        i3 = n + a(i1, k);
        k = i2;
      }
    }
    byte[] arrayOfByte = new byte[i3];
    int i4 = 0;
    while (i4 < i3)
    {
      if (paramBitSource.c() < 8) {
        throw FormatException.a();
      }
      int i5 = paramBitSource.a(8);
      int i6 = k + 1;
      arrayOfByte[i4] = ((byte)a(i5, k));
      i4++;
      k = i6;
    }
    paramCollection.add(arrayOfByte);
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "ISO8859_1"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException("Platform does not support required encoding: " + localUnsupportedEncodingException);
    }
  }
  
  private static void b(BitSource paramBitSource, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = new int[3];
    int i = 0;
    int j = 0;
    label163:
    do
    {
      if (paramBitSource.c() == 8) {}
      int k;
      do
      {
        return;
        k = paramBitSource.a(8);
      } while (k == 254);
      a(k, paramBitSource.a(8), arrayOfInt);
      int m = 0;
      if (m < 3)
      {
        int n = arrayOfInt[m];
        switch (i)
        {
        default: 
          throw FormatException.a();
        case 0: 
          if (n < 3) {
            i = n + 1;
          }
          for (;;)
          {
            m++;
            break;
            if (n >= c.length) {
              break label163;
            }
            char c3 = c[n];
            if (j != 0)
            {
              paramStringBuilder.append((char)(c3 + ''));
              j = 0;
            }
            else
            {
              paramStringBuilder.append(c3);
            }
          }
          throw FormatException.a();
        case 1: 
          if (j != 0)
          {
            paramStringBuilder.append((char)(n + 128));
            j = 0;
          }
          for (;;)
          {
            i = 0;
            break;
            paramStringBuilder.append((char)n);
          }
        case 2: 
          char c2;
          if (n < b.length)
          {
            c2 = b[n];
            if (j != 0)
            {
              paramStringBuilder.append((char)(c2 + ''));
              j = 0;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramStringBuilder.append(c2);
            continue;
            if (n == 27)
            {
              paramStringBuilder.append('\035');
            }
            else
            {
              if (n != 30) {
                break label285;
              }
              j = 1;
            }
          }
          throw FormatException.a();
        }
        if (n < d.length)
        {
          char c1 = d[n];
          if (j != 0)
          {
            paramStringBuilder.append((char)(c1 + ''));
            j = 0;
          }
          for (;;)
          {
            i = 0;
            break;
            paramStringBuilder.append(c1);
          }
        }
        throw FormatException.a();
      }
    } while (paramBitSource.c() > 0);
    label285:
  }
  
  private static void c(BitSource paramBitSource, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = new int[3];
    label162:
    do
    {
      if (paramBitSource.c() == 8) {}
      int i;
      do
      {
        return;
        i = paramBitSource.a(8);
      } while (i == 254);
      a(i, paramBitSource.a(8), arrayOfInt);
      int j = 0;
      if (j < 3)
      {
        int k = arrayOfInt[j];
        if (k == 0) {
          paramStringBuilder.append('\r');
        }
        for (;;)
        {
          j++;
          break;
          if (k == 1)
          {
            paramStringBuilder.append('*');
          }
          else if (k == 2)
          {
            paramStringBuilder.append('>');
          }
          else if (k == 3)
          {
            paramStringBuilder.append(' ');
          }
          else if (k < 14)
          {
            paramStringBuilder.append((char)(k + 44));
          }
          else
          {
            if (k >= 40) {
              break label162;
            }
            paramStringBuilder.append((char)(k + 51));
          }
        }
        throw FormatException.a();
      }
    } while (paramBitSource.c() > 0);
  }
  
  private static void d(BitSource paramBitSource, StringBuilder paramStringBuilder)
  {
    label79:
    do
    {
      if (paramBitSource.c() <= 16) {
        return;
      }
      for (int i = 0;; i++)
      {
        if (i >= 4) {
          break label79;
        }
        int j = paramBitSource.a(6);
        if (j == 31)
        {
          int k = 8 - paramBitSource.a();
          if (k == 8) {
            break;
          }
          paramBitSource.a(k);
          return;
        }
        if ((j & 0x20) == 0) {
          j |= 64;
        }
        paramStringBuilder.append((char)j);
      }
    } while (paramBitSource.c() > 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.decoder.DecodedBitStreamParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */