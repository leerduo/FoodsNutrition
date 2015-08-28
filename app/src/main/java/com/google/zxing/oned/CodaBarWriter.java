package com.google.zxing.oned;

import java.util.Arrays;

public final class CodaBarWriter
  extends OneDimensionalCodeWriter
{
  private static final char[] a = { 65, 66, 67, 68 };
  private static final char[] b = { 84, 78, 42, 69 };
  private static final char[] c = { 47, 58, 43, 46 };
  
  public boolean[] a(String paramString)
  {
    if (paramString.length() < 2) {
      throw new IllegalArgumentException("Codabar should start/end with start/stop symbols");
    }
    char c1 = Character.toUpperCase(paramString.charAt(0));
    char c2 = Character.toUpperCase(paramString.charAt(-1 + paramString.length()));
    int i;
    if ((CodaBarReader.a(a, c1)) && (CodaBarReader.a(a, c2)))
    {
      i = 1;
      if ((!CodaBarReader.a(b, c1)) || (!CodaBarReader.a(b, c2))) {
        break label149;
      }
    }
    label149:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        break label155;
      }
      throw new IllegalArgumentException("Codabar should start/end with " + Arrays.toString(a) + ", or start/end with " + Arrays.toString(b));
      i = 0;
      break;
    }
    label155:
    int k = 20;
    int m = 1;
    if (m < -1 + paramString.length())
    {
      if ((Character.isDigit(paramString.charAt(m))) || (paramString.charAt(m) == '-') || (paramString.charAt(m) == '$')) {
        k += 9;
      }
      for (;;)
      {
        m++;
        break;
        if (!CodaBarReader.a(c, paramString.charAt(m))) {
          break label237;
        }
        k += 10;
      }
      label237:
      throw new IllegalArgumentException("Cannot encode : '" + paramString.charAt(m) + '\'');
    }
    boolean[] arrayOfBoolean = new boolean[k + (-1 + paramString.length())];
    int n = 0;
    int i1 = 0;
    int i2;
    int i3;
    if (n < paramString.length())
    {
      i2 = Character.toUpperCase(paramString.charAt(n));
      if ((n == 0) || (n == -1 + paramString.length())) {}
      switch (i2)
      {
      default: 
        i3 = 0;
        label375:
        if (i3 < CodaBarReader.a.length) {
          if (i2 != CodaBarReader.a[i3]) {
            break;
          }
        }
        break;
      }
    }
    for (int i4 = CodaBarReader.b[i3];; i4 = 0)
    {
      int i5 = 0;
      int i6 = 0;
      int i7 = 1;
      for (;;)
      {
        label412:
        if (i5 >= 7) {
          break label526;
        }
        arrayOfBoolean[i1] = i7;
        int i8 = i1 + 1;
        if (((0x1 & i4 >> 6 - i5) == 0) || (i6 == 1))
        {
          if (i7 == 0) {}
          for (int i9 = 1;; i9 = 0)
          {
            i5++;
            i7 = i9;
            i1 = i8;
            i6 = 0;
            break label412;
            i2 = 65;
            break;
            i2 = 66;
            break;
            i2 = 67;
            break;
            i2 = 68;
            break;
            i3++;
            break label375;
          }
        }
        i6++;
        i1 = i8;
      }
      label526:
      if (n < -1 + paramString.length())
      {
        arrayOfBoolean[i1] = false;
        i1++;
      }
      n++;
      break;
      return arrayOfBoolean;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.CodaBarWriter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */