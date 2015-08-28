package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.util.Arrays;

final class DecodedBitStreamParser
{
  private static final char[] a = { 59, 60, 62, 64, 91, 92, 125, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39 };
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94 };
  private static final BigInteger[] c = new BigInteger[16];
  
  static
  {
    c[0] = BigInteger.ONE;
    BigInteger localBigInteger = BigInteger.valueOf(900L);
    c[1] = localBigInteger;
    for (int i = 2; i < c.length; i++) {
      c[i] = c[(i - 1)].multiply(localBigInteger);
    }
  }
  
  private static int a(int paramInt1, int[] paramArrayOfInt, int paramInt2, StringBuilder paramStringBuilder)
  {
    int i1;
    long l2;
    char[] arrayOfChar2;
    int[] arrayOfInt;
    int i2;
    int i4;
    int i5;
    if (paramInt1 == 901)
    {
      i1 = 0;
      l2 = 0L;
      arrayOfChar2 = new char[6];
      arrayOfInt = new int[6];
      i2 = 0;
      int i3 = paramInt2 + 1;
      i4 = paramArrayOfInt[paramInt2];
      i5 = i3;
    }
    for (;;)
    {
      int i8;
      int i9;
      if ((i5 < paramArrayOfInt[0]) && (i2 == 0))
      {
        i8 = i1 + 1;
        arrayOfInt[i1] = i4;
        l2 = l2 * 900L + i4;
        i9 = i5 + 1;
        i4 = paramArrayOfInt[i5];
        if ((i4 == 900) || (i4 == 901) || (i4 == 902) || (i4 == 924) || (i4 == 928) || (i4 == 923) || (i4 == 922))
        {
          int i10 = i9 - 1;
          i2 = 1;
          i5 = i10;
          i1 = i8;
        }
        else if ((i8 % 5 == 0) && (i8 > 0))
        {
          int i11 = 0;
          while (i11 < 6)
          {
            arrayOfChar2[(5 - i11)] = ((char)(int)(l2 % 256L));
            long l3 = l2 >> 8;
            i11++;
            l2 = l3;
          }
          paramStringBuilder.append(arrayOfChar2);
          i5 = i9;
          i1 = 0;
        }
      }
      else
      {
        if ((i5 == paramArrayOfInt[0]) && (i4 < 900))
        {
          int i7 = i1 + 1;
          arrayOfInt[i1] = i4;
          i1 = i7;
        }
        for (int i6 = 0; i6 < i1; i6++) {
          paramStringBuilder.append((char)arrayOfInt[i6]);
        }
        paramInt2 = i5;
        do
        {
          return paramInt2;
        } while (paramInt1 != 924);
        int i = 0;
        long l1 = 0L;
        int j = 0;
        label320:
        label504:
        label508:
        for (;;)
        {
          int k;
          int m;
          if ((paramInt2 < paramArrayOfInt[0]) && (j == 0))
          {
            k = paramInt2 + 1;
            m = paramArrayOfInt[paramInt2];
            if (m < 900)
            {
              i++;
              l1 = l1 * 900L + m;
              paramInt2 = k;
            }
          }
          for (;;)
          {
            if ((i % 5 != 0) || (i <= 0)) {
              break label508;
            }
            char[] arrayOfChar1 = new char[6];
            int n = 0;
            for (;;)
            {
              if (n < 6)
              {
                arrayOfChar1[(5 - n)] = ((char)(int)(0xFF & l1));
                l1 >>= 8;
                n++;
                continue;
                if ((m != 900) && (m != 901) && (m != 902) && (m != 924) && (m != 928) && (m != 923) && (m != 922)) {
                  break label504;
                }
                paramInt2 = k - 1;
                j = 1;
                break;
              }
            }
            paramStringBuilder.append(arrayOfChar1);
            i = 0;
            break label320;
            break;
            paramInt2 = k;
          }
        }
        i1 = i8;
        i5 = i9;
      }
    }
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt, PDF417ResultMetadata paramPDF417ResultMetadata)
  {
    if (paramInt + 2 > paramArrayOfInt[0]) {
      throw FormatException.a();
    }
    int[] arrayOfInt1 = new int[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfInt1[i] = paramArrayOfInt[paramInt];
      i++;
      paramInt++;
    }
    paramPDF417ResultMetadata.a(Integer.parseInt(a(arrayOfInt1, 2)));
    StringBuilder localStringBuilder = new StringBuilder();
    int j = a(paramArrayOfInt, paramInt, localStringBuilder);
    paramPDF417ResultMetadata.a(localStringBuilder.toString());
    if (paramArrayOfInt[j] == 923)
    {
      k = j + 1;
      arrayOfInt2 = new int[paramArrayOfInt[0] - k];
      m = 0;
      j = k;
      n = 0;
      while ((j < paramArrayOfInt[0]) && (n == 0))
      {
        i1 = j + 1;
        i2 = paramArrayOfInt[j];
        if (i2 < 900)
        {
          i3 = m + 1;
          arrayOfInt2[m] = i2;
          m = i3;
          j = i1;
        }
        else
        {
          switch (i2)
          {
          default: 
            throw FormatException.a();
          }
          paramPDF417ResultMetadata.a(true);
          j = i1 + 1;
          n = 1;
        }
      }
      paramPDF417ResultMetadata.a(Arrays.copyOf(arrayOfInt2, m));
    }
    while (paramArrayOfInt[j] != 922)
    {
      int k;
      int[] arrayOfInt2;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      return j;
    }
    paramPDF417ResultMetadata.a(true);
    return j + 1;
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt1 = new int[paramArrayOfInt[0] - paramInt << 1];
    int[] arrayOfInt2 = new int[paramArrayOfInt[0] - paramInt << 1];
    int i = 0;
    int j = 0;
    while ((paramInt < paramArrayOfInt[0]) && (i == 0))
    {
      int k = paramInt + 1;
      int m = paramArrayOfInt[paramInt];
      if (m < 900)
      {
        arrayOfInt1[j] = (m / 30);
        arrayOfInt1[(j + 1)] = (m % 30);
        j += 2;
        paramInt = k;
      }
      else
      {
        switch (m)
        {
        default: 
          paramInt = k;
          break;
        case 900: 
          int n = j + 1;
          arrayOfInt1[j] = 900;
          j = n;
          paramInt = k;
          break;
        case 901: 
        case 902: 
        case 922: 
        case 923: 
        case 924: 
        case 928: 
          paramInt = k - 1;
          i = 1;
          break;
        case 913: 
          arrayOfInt1[j] = 913;
          paramInt = k + 1;
          arrayOfInt2[j] = paramArrayOfInt[k];
          j++;
        }
      }
    }
    a(arrayOfInt1, arrayOfInt2, j, paramStringBuilder);
    return paramInt;
  }
  
  static DecoderResult a(int[] paramArrayOfInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(2 * paramArrayOfInt.length);
    int i = 2;
    int j = paramArrayOfInt[1];
    PDF417ResultMetadata localPDF417ResultMetadata = new PDF417ResultMetadata();
    if (i < paramArrayOfInt[0])
    {
      int k;
      switch (j)
      {
      default: 
        k = a(paramArrayOfInt, i - 1, localStringBuilder);
      }
      for (;;)
      {
        if (k < paramArrayOfInt.length)
        {
          i = k + 1;
          j = paramArrayOfInt[k];
          break;
          k = a(paramArrayOfInt, i, localStringBuilder);
          continue;
          k = a(j, paramArrayOfInt, i, localStringBuilder);
          continue;
          k = b(paramArrayOfInt, i, localStringBuilder);
          continue;
          k = a(paramArrayOfInt, i, localPDF417ResultMetadata);
          continue;
          throw FormatException.a();
        }
      }
      throw FormatException.a();
    }
    if (localStringBuilder.length() == 0) {
      throw FormatException.a();
    }
    DecoderResult localDecoderResult = new DecoderResult(null, localStringBuilder.toString(), null, paramString);
    localDecoderResult.a(localPDF417ResultMetadata);
    return localDecoderResult;
  }
  
  private static String a(int[] paramArrayOfInt, int paramInt)
  {
    BigInteger localBigInteger = BigInteger.ZERO;
    for (int i = 0; i < paramInt; i++) {
      localBigInteger = localBigInteger.add(c[(-1 + (paramInt - i))].multiply(BigInteger.valueOf(paramArrayOfInt[i])));
    }
    String str = localBigInteger.toString();
    if (str.charAt(0) != '1') {
      throw FormatException.a();
    }
    return str.substring(1);
  }
  
  private static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, StringBuilder paramStringBuilder)
  {
    Object localObject1 = DecodedBitStreamParser.Mode.a;
    Object localObject2 = DecodedBitStreamParser.Mode.a;
    int i = 0;
    int j;
    char c1;
    if (i < paramInt)
    {
      j = paramArrayOfInt1[i];
      int k = DecodedBitStreamParser.1.a[localObject1.ordinal()];
      c1 = '\000';
      switch (k)
      {
      }
    }
    for (;;)
    {
      if (c1 != 0) {
        paramStringBuilder.append(c1);
      }
      i++;
      break;
      if (j < 26)
      {
        c1 = (char)(j + 65);
      }
      else if (j == 26)
      {
        c1 = ' ';
      }
      else if (j == 27)
      {
        localObject1 = DecodedBitStreamParser.Mode.b;
        c1 = '\000';
      }
      else if (j == 28)
      {
        localObject1 = DecodedBitStreamParser.Mode.c;
        c1 = '\000';
      }
      else if (j == 29)
      {
        DecodedBitStreamParser.Mode localMode4 = DecodedBitStreamParser.Mode.f;
        Object localObject6 = localObject1;
        localObject1 = localMode4;
        localObject2 = localObject6;
        c1 = '\000';
      }
      else if (j == 913)
      {
        paramStringBuilder.append((char)paramArrayOfInt2[i]);
        c1 = '\000';
      }
      else
      {
        c1 = '\000';
        if (j == 900)
        {
          localObject1 = DecodedBitStreamParser.Mode.a;
          c1 = '\000';
          continue;
          if (j < 26)
          {
            c1 = (char)(j + 97);
          }
          else if (j == 26)
          {
            c1 = ' ';
          }
          else if (j == 27)
          {
            DecodedBitStreamParser.Mode localMode3 = DecodedBitStreamParser.Mode.e;
            Object localObject5 = localObject1;
            localObject1 = localMode3;
            localObject2 = localObject5;
            c1 = '\000';
          }
          else if (j == 28)
          {
            localObject1 = DecodedBitStreamParser.Mode.c;
            c1 = '\000';
          }
          else if (j == 29)
          {
            DecodedBitStreamParser.Mode localMode2 = DecodedBitStreamParser.Mode.f;
            Object localObject4 = localObject1;
            localObject1 = localMode2;
            localObject2 = localObject4;
            c1 = '\000';
          }
          else if (j == 913)
          {
            paramStringBuilder.append((char)paramArrayOfInt2[i]);
            c1 = '\000';
          }
          else
          {
            c1 = '\000';
            if (j == 900)
            {
              localObject1 = DecodedBitStreamParser.Mode.a;
              c1 = '\000';
              continue;
              if (j < 25)
              {
                c1 = b[j];
              }
              else if (j == 25)
              {
                localObject1 = DecodedBitStreamParser.Mode.d;
                c1 = '\000';
              }
              else if (j == 26)
              {
                c1 = ' ';
              }
              else if (j == 27)
              {
                localObject1 = DecodedBitStreamParser.Mode.b;
                c1 = '\000';
              }
              else if (j == 28)
              {
                localObject1 = DecodedBitStreamParser.Mode.a;
                c1 = '\000';
              }
              else if (j == 29)
              {
                DecodedBitStreamParser.Mode localMode1 = DecodedBitStreamParser.Mode.f;
                Object localObject3 = localObject1;
                localObject1 = localMode1;
                localObject2 = localObject3;
                c1 = '\000';
              }
              else if (j == 913)
              {
                paramStringBuilder.append((char)paramArrayOfInt2[i]);
                c1 = '\000';
              }
              else
              {
                c1 = '\000';
                if (j == 900)
                {
                  localObject1 = DecodedBitStreamParser.Mode.a;
                  c1 = '\000';
                  continue;
                  if (j < 29)
                  {
                    c1 = a[j];
                  }
                  else if (j == 29)
                  {
                    localObject1 = DecodedBitStreamParser.Mode.a;
                    c1 = '\000';
                  }
                  else if (j == 913)
                  {
                    paramStringBuilder.append((char)paramArrayOfInt2[i]);
                    c1 = '\000';
                  }
                  else
                  {
                    c1 = '\000';
                    if (j == 900)
                    {
                      localObject1 = DecodedBitStreamParser.Mode.a;
                      c1 = '\000';
                      continue;
                      if (j < 26)
                      {
                        c1 = (char)(j + 65);
                        localObject1 = localObject2;
                      }
                      else if (j == 26)
                      {
                        c1 = ' ';
                        localObject1 = localObject2;
                      }
                      else if (j == 900)
                      {
                        localObject1 = DecodedBitStreamParser.Mode.a;
                        c1 = '\000';
                        continue;
                        if (j < 29)
                        {
                          c1 = a[j];
                          localObject1 = localObject2;
                        }
                        else if (j == 29)
                        {
                          localObject1 = DecodedBitStreamParser.Mode.a;
                          c1 = '\000';
                        }
                        else if (j == 913)
                        {
                          paramStringBuilder.append((char)paramArrayOfInt2[i]);
                          localObject1 = localObject2;
                          c1 = '\000';
                        }
                        else if (j == 900)
                        {
                          localObject1 = DecodedBitStreamParser.Mode.a;
                          c1 = '\000';
                        }
                      }
                      else
                      {
                        localObject1 = localObject2;
                        c1 = '\000';
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = new int[15];
    int i = 0;
    int j = 0;
    label167:
    for (;;)
    {
      int k;
      int m;
      if ((paramInt < paramArrayOfInt[0]) && (i == 0))
      {
        k = paramInt + 1;
        m = paramArrayOfInt[paramInt];
        if (k == paramArrayOfInt[0]) {
          i = 1;
        }
        if (m < 900)
        {
          arrayOfInt[j] = m;
          j++;
          paramInt = k;
        }
      }
      for (;;)
      {
        if ((j % 15 != 0) && (m != 902) && (i == 0)) {
          break label167;
        }
        paramStringBuilder.append(a(arrayOfInt, j));
        j = 0;
        break;
        if ((m == 900) || (m == 901) || (m == 924) || (m == 928) || (m == 923) || (m == 922))
        {
          paramInt = k - 1;
          i = 1;
          continue;
          return paramInt;
        }
        else
        {
          paramInt = k;
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.DecodedBitStreamParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */