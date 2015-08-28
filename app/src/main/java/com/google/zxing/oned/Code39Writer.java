package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code39Writer
  extends OneDimensionalCodeWriter
{
  private static void a(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if (i < 9)
    {
      if ((paramInt & 1 << 8 - i) == 0) {}
      for (int j = 1;; j = 2)
      {
        paramArrayOfInt[i] = j;
        i++;
        break;
      }
    }
  }
  
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.c) {
      throw new IllegalArgumentException("Can only encode CODE_39, but got " + paramBarcodeFormat);
    }
    return super.a(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }
  
  public boolean[] a(String paramString)
  {
    int i = paramString.length();
    if (i > 80) {
      throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + i);
    }
    int[] arrayOfInt1 = new int[9];
    int j = i + 25;
    int k = 0;
    while (k < i)
    {
      int i4 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(k));
      if (i4 < 0) {
        throw new IllegalArgumentException("Bad contents: " + paramString);
      }
      a(Code39Reader.a[i4], arrayOfInt1);
      int i5 = arrayOfInt1.length;
      int i6 = j;
      for (int i7 = 0; i7 < i5; i7++) {
        i6 += arrayOfInt1[i7];
      }
      k++;
      j = i6;
    }
    boolean[] arrayOfBoolean = new boolean[j];
    a(Code39Reader.a[39], arrayOfInt1);
    int m = a(arrayOfBoolean, 0, arrayOfInt1, true);
    int[] arrayOfInt2 = { 1 };
    int n = m + a(arrayOfBoolean, m, arrayOfInt2, false);
    for (int i1 = 0; i1 < i; i1++)
    {
      int i2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(i1));
      a(Code39Reader.a[i2], arrayOfInt1);
      int i3 = n + a(arrayOfBoolean, n, arrayOfInt1, true);
      n = i3 + a(arrayOfBoolean, i3, arrayOfInt2, false);
    }
    a(Code39Reader.a[39], arrayOfInt1);
    a(arrayOfBoolean, n, arrayOfInt1, true);
    return arrayOfBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.Code39Writer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */