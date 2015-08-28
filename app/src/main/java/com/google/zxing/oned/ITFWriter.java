package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class ITFWriter
  extends OneDimensionalCodeWriter
{
  private static final int[] a = { 1, 1, 1, 1 };
  private static final int[] b = { 3, 1, 1 };
  
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.i) {
      throw new IllegalArgumentException("Can only encode ITF, but got " + paramBarcodeFormat);
    }
    return super.a(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }
  
  public boolean[] a(String paramString)
  {
    int i = paramString.length();
    if (i % 2 != 0) {
      throw new IllegalArgumentException("The lenght of the input should be even");
    }
    if (i > 80) {
      throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + i);
    }
    boolean[] arrayOfBoolean = new boolean[9 + i * 9];
    int j = a(arrayOfBoolean, 0, a, true);
    int k = 0;
    int m = j;
    while (k < i)
    {
      int n = Character.digit(paramString.charAt(k), 10);
      int i1 = Character.digit(paramString.charAt(k + 1), 10);
      int[] arrayOfInt = new int[18];
      for (int i2 = 0; i2 < 5; i2++)
      {
        arrayOfInt[(i2 << 1)] = ITFReader.a[n][i2];
        arrayOfInt[(1 + (i2 << 1))] = ITFReader.a[i1][i2];
      }
      m += a(arrayOfBoolean, m, arrayOfInt, true);
      k += 2;
    }
    a(arrayOfBoolean, m, b, true);
    return arrayOfBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.ITFWriter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */