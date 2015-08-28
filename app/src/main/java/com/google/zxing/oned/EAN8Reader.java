package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitArray;

public final class EAN8Reader
  extends UPCEANReader
{
  private final int[] a = new int[4];
  
  protected int a(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.a;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.a();
    int j = paramArrayOfInt[1];
    int k = 0;
    while ((k < 4) && (j < i))
    {
      paramStringBuilder.append((char)(48 + a(paramBitArray, arrayOfInt, j, d)));
      int i4 = arrayOfInt.length;
      int i5 = j;
      for (int i6 = 0; i6 < i4; i6++) {
        i5 += arrayOfInt[i6];
      }
      k++;
      j = i5;
    }
    int m = a(paramBitArray, j, true, c)[1];
    int n = 0;
    while ((n < 4) && (m < i))
    {
      paramStringBuilder.append((char)(48 + a(paramBitArray, arrayOfInt, m, d)));
      int i1 = arrayOfInt.length;
      int i2 = m;
      for (int i3 = 0; i3 < i1; i3++) {
        i2 += arrayOfInt[i3];
      }
      n++;
      m = i2;
    }
    return m;
  }
  
  BarcodeFormat b()
  {
    return BarcodeFormat.g;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.EAN8Reader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */