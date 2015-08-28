package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.util.Arrays;

public final class HighLevelEncoder
{
  private static char a(char paramChar, int paramInt)
  {
    int i = paramChar + (1 + paramInt * 149 % 253);
    if (i <= 254) {
      return (char)i;
    }
    return (char)(i - 254);
  }
  
  public static int a(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    int j = 0;
    if (paramInt < i)
    {
      char c = paramCharSequence.charAt(paramInt);
      while ((a(c)) && (paramInt < i))
      {
        j++;
        paramInt++;
        if (paramInt < i) {
          c = paramCharSequence.charAt(paramInt);
        }
      }
    }
    return j;
  }
  
  static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt1 >= paramCharSequence.length())
    {
      i1 = paramInt2;
      return i1;
    }
    float[] arrayOfFloat;
    label50:
    int i;
    if (paramInt2 == 0)
    {
      arrayOfFloat = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.25F };
      i = 0;
    }
    label247:
    int[] arrayOfInt1;
    label264:
    label281:
    label298:
    label315:
    label587:
    label619:
    do
    {
      do
      {
        byte[] arrayOfByte1;
        int j;
        for (;;)
        {
          if (paramInt1 + i == paramCharSequence.length())
          {
            byte[] arrayOfByte2 = new byte[6];
            int[] arrayOfInt2 = new int[6];
            int i2 = a(arrayOfFloat, arrayOfInt2, 2147483647, arrayOfByte2);
            int i3 = a(arrayOfByte2);
            int i4 = arrayOfInt2[0];
            i1 = 0;
            if (i4 == i2) {
              break;
            }
            if ((i3 == 1) && (arrayOfByte2[5] > 0))
            {
              return 5;
              arrayOfFloat = new float[] { 1.0F, 2.0F, 2.0F, 2.0F, 2.0F, 2.25F };
              arrayOfFloat[paramInt2] = 0.0F;
              break label50;
            }
            if ((i3 == 1) && (arrayOfByte2[4] > 0)) {
              return 4;
            }
            if ((i3 == 1) && (arrayOfByte2[2] > 0)) {
              return 2;
            }
            if ((i3 == 1) && (arrayOfByte2[3] > 0)) {
              return 3;
            }
            return 1;
          }
          char c1 = paramCharSequence.charAt(paramInt1 + i);
          i++;
          if (a(c1))
          {
            arrayOfFloat[0] = ((float)(0.5D + arrayOfFloat[0]));
            if (!d(c1)) {
              break label523;
            }
            arrayOfFloat[1] = (0.6666667F + arrayOfFloat[1]);
            if (!e(c1)) {
              break label555;
            }
            arrayOfFloat[2] = (0.6666667F + arrayOfFloat[2]);
            if (!f(c1)) {
              break label587;
            }
            arrayOfFloat[3] = (0.6666667F + arrayOfFloat[3]);
            if (!h(c1)) {
              break label619;
            }
            arrayOfFloat[4] = (0.75F + arrayOfFloat[4]);
            if (!i(c1)) {
              break label651;
            }
            arrayOfFloat[5] = (4.0F + arrayOfFloat[5]);
          }
          for (;;)
          {
            if (i < 4) {
              break label660;
            }
            arrayOfInt1 = new int[6];
            arrayOfByte1 = new byte[6];
            a(arrayOfFloat, arrayOfInt1, 2147483647, arrayOfByte1);
            j = a(arrayOfByte1);
            if ((arrayOfInt1[0] < arrayOfInt1[5]) && (arrayOfInt1[0] < arrayOfInt1[1]) && (arrayOfInt1[0] < arrayOfInt1[2]) && (arrayOfInt1[0] < arrayOfInt1[3]))
            {
              int m = arrayOfInt1[0];
              int n = arrayOfInt1[4];
              i1 = 0;
              if (m < n) {
                break;
              }
            }
            if ((arrayOfInt1[5] >= arrayOfInt1[0]) && (arrayOfByte1[1] + arrayOfByte1[2] + arrayOfByte1[3] + arrayOfByte1[4] != 0)) {
              break label662;
            }
            return 5;
            if (b(c1))
            {
              arrayOfFloat[0] = ((int)Math.ceil(arrayOfFloat[0]));
              arrayOfFloat[0] = (2.0F + arrayOfFloat[0]);
              break label247;
            }
            arrayOfFloat[0] = ((int)Math.ceil(arrayOfFloat[0]));
            arrayOfFloat[0] = (1.0F + arrayOfFloat[0]);
            break label247;
            if (b(c1))
            {
              arrayOfFloat[1] = (2.666667F + arrayOfFloat[1]);
              break label264;
            }
            arrayOfFloat[1] = (1.333333F + arrayOfFloat[1]);
            break label264;
            if (b(c1))
            {
              arrayOfFloat[2] = (2.666667F + arrayOfFloat[2]);
              break label281;
            }
            arrayOfFloat[2] = (1.333333F + arrayOfFloat[2]);
            break label281;
            if (b(c1))
            {
              arrayOfFloat[3] = (4.333334F + arrayOfFloat[3]);
              break label298;
            }
            arrayOfFloat[3] = (3.333333F + arrayOfFloat[3]);
            break label298;
            if (b(c1))
            {
              arrayOfFloat[4] = (4.25F + arrayOfFloat[4]);
              break label315;
            }
            arrayOfFloat[4] = (3.25F + arrayOfFloat[4]);
            break label315;
            arrayOfFloat[5] = (1.0F + arrayOfFloat[5]);
          }
        }
        if ((j == 1) && (arrayOfByte1[4] > 0)) {
          return 4;
        }
        if ((j == 1) && (arrayOfByte1[2] > 0)) {
          return 2;
        }
        if ((j == 1) && (arrayOfByte1[3] > 0)) {
          return 3;
        }
      } while ((1 + arrayOfInt1[1] >= arrayOfInt1[0]) || (1 + arrayOfInt1[1] >= arrayOfInt1[5]) || (1 + arrayOfInt1[1] >= arrayOfInt1[4]) || (1 + arrayOfInt1[1] >= arrayOfInt1[2]));
      if (arrayOfInt1[1] < arrayOfInt1[3]) {
        return 1;
      }
    } while (arrayOfInt1[1] != arrayOfInt1[3]);
    label523:
    label555:
    for (int k = 1 + (paramInt1 + i);; k++) {
      if (k < paramCharSequence.length())
      {
        char c2 = paramCharSequence.charAt(k);
        if (g(c2)) {
          return 3;
        }
        if (f(c2)) {}
      }
      else
      {
        return 1;
      }
    }
  }
  
  private static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 6)
    {
      j += paramArrayOfByte[i];
      i++;
    }
    return j;
  }
  
  private static int a(float[] paramArrayOfFloat, int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    Arrays.fill(paramArrayOfByte, (byte)0);
    int i = 0;
    int j = paramInt;
    while (i < 6)
    {
      paramArrayOfInt[i] = ((int)Math.ceil(paramArrayOfFloat[i]));
      int k = paramArrayOfInt[i];
      if (j > k)
      {
        Arrays.fill(paramArrayOfByte, (byte)0);
        j = k;
      }
      if (j == k) {
        paramArrayOfByte[i] = ((byte)(1 + paramArrayOfByte[i]));
      }
      i++;
    }
    return j;
  }
  
  public static String a(String paramString, SymbolShapeHint paramSymbolShapeHint, Dimension paramDimension1, Dimension paramDimension2)
  {
    int i = 0;
    Encoder[] arrayOfEncoder = new Encoder[6];
    arrayOfEncoder[0] = new ASCIIEncoder();
    arrayOfEncoder[1] = new C40Encoder();
    arrayOfEncoder[2] = new TextEncoder();
    arrayOfEncoder[3] = new X12Encoder();
    arrayOfEncoder[4] = new EdifactEncoder();
    arrayOfEncoder[5] = new Base256Encoder();
    EncoderContext localEncoderContext = new EncoderContext(paramString);
    localEncoderContext.a(paramSymbolShapeHint);
    localEncoderContext.a(paramDimension1, paramDimension2);
    if ((paramString.startsWith("[)>\03605\035")) && (paramString.endsWith("\036\004")))
    {
      localEncoderContext.a('ì');
      localEncoderContext.a(2);
      localEncoderContext.a += "[)>\03605\035".length();
    }
    while (localEncoderContext.g())
    {
      arrayOfEncoder[i].a(localEncoderContext);
      if (localEncoderContext.e() >= 0)
      {
        i = localEncoderContext.e();
        localEncoderContext.f();
        continue;
        boolean bool1 = paramString.startsWith("[)>\03606\035");
        i = 0;
        if (bool1)
        {
          boolean bool2 = paramString.endsWith("\036\004");
          i = 0;
          if (bool2)
          {
            localEncoderContext.a('í');
            localEncoderContext.a(2);
            localEncoderContext.a += "[)>\03606\035".length();
            i = 0;
          }
        }
      }
    }
    int j = localEncoderContext.d();
    localEncoderContext.j();
    int k = localEncoderContext.i().h();
    if ((j < k) && (i != 0) && (i != 5)) {
      localEncoderContext.a('þ');
    }
    StringBuilder localStringBuilder = localEncoderContext.c();
    if (localStringBuilder.length() < k) {
      localStringBuilder.append('');
    }
    while (localStringBuilder.length() < k) {
      localStringBuilder.append(a('', 1 + localStringBuilder.length()));
    }
    return localEncoderContext.c().toString();
  }
  
  static boolean a(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  static boolean b(char paramChar)
  {
    return (paramChar >= '') && (paramChar <= 'ÿ');
  }
  
  static void c(char paramChar)
  {
    String str1 = Integer.toHexString(paramChar);
    String str2 = "0000".substring(0, 4 - str1.length()) + str1;
    throw new IllegalArgumentException("Illegal character: " + paramChar + " (0x" + str2 + ')');
  }
  
  private static boolean d(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean e(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  private static boolean f(char paramChar)
  {
    return (g(paramChar)) || (paramChar == ' ') || ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean g(char paramChar)
  {
    return (paramChar == '\r') || (paramChar == '*') || (paramChar == '>');
  }
  
  private static boolean h(char paramChar)
  {
    return (paramChar >= ' ') && (paramChar <= '^');
  }
  
  private static boolean i(char paramChar)
  {
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.HighLevelEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */