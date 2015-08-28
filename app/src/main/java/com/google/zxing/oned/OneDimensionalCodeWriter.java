package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract class OneDimensionalCodeWriter
  implements Writer
{
  protected static int a(boolean[] paramArrayOfBoolean, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramArrayOfInt.length;
    int j = 0;
    int k = 0;
    int m = paramInt;
    if (j < i)
    {
      int n = paramArrayOfInt[j];
      int i1 = m;
      int i2 = 0;
      while (i2 < n)
      {
        int i3 = i1 + 1;
        paramArrayOfBoolean[i1] = paramBoolean;
        i2++;
        i1 = i3;
      }
      k += n;
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        j++;
        paramBoolean = bool;
        m = i1;
        break;
      }
    }
    return k;
  }
  
  private static BitMatrix a(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfBoolean.length;
    int j = i + paramInt3;
    int k = Math.max(paramInt1, j);
    int m = Math.max(1, paramInt2);
    int n = k / j;
    int i1 = (k - i * n) / 2;
    BitMatrix localBitMatrix = new BitMatrix(k, m);
    int i2 = 0;
    while (i2 < i)
    {
      if (paramArrayOfBoolean[i2] != 0) {
        localBitMatrix.a(i1, 0, n, m);
      }
      i2++;
      i1 += n;
    }
    return localBitMatrix;
  }
  
  public int a()
  {
    return 10;
  }
  
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramString.isEmpty()) {
      throw new IllegalArgumentException("Found empty contents");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("Negative size is not allowed. Input: " + paramInt1 + 'x' + paramInt2);
    }
    int i = a();
    Integer localInteger;
    if (paramMap != null)
    {
      localInteger = (Integer)paramMap.get(EncodeHintType.f);
      if (localInteger == null) {}
    }
    for (int j = localInteger.intValue();; j = i) {
      return a(a(paramString), paramInt1, paramInt2, j);
    }
  }
  
  public abstract boolean[] a(String paramString);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.OneDimensionalCodeWriter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */