package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN13Reader
  extends UPCEANReader
{
  static final int[] a = { 0, 11, 13, 14, 19, 25, 28, 21, 22, 26 };
  private final int[] f = new int[4];
  
  private static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < 10; i++) {
      if (paramInt == a[i])
      {
        paramStringBuilder.insert(0, (char)(i + 48));
        return;
      }
    }
    throw NotFoundException.a();
  }
  
  protected int a(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.f;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.a();
    int j = paramArrayOfInt[1];
    int k = 0;
    int m = 0;
    while ((k < 6) && (j < i))
    {
      int i5 = a(paramBitArray, arrayOfInt, j, e);
      paramStringBuilder.append((char)(48 + i5 % 10));
      int i6 = arrayOfInt.length;
      int i7 = j;
      for (int i8 = 0; i8 < i6; i8++) {
        i7 += arrayOfInt[i8];
      }
      if (i5 >= 10) {
        m |= 1 << 5 - k;
      }
      k++;
      j = i7;
    }
    a(paramStringBuilder, m);
    int n = a(paramBitArray, j, true, c)[1];
    int i1 = 0;
    while ((i1 < 6) && (n < i))
    {
      paramStringBuilder.append((char)(48 + a(paramBitArray, arrayOfInt, n, d)));
      int i2 = arrayOfInt.length;
      int i3 = n;
      for (int i4 = 0; i4 < i2; i4++) {
        i3 += arrayOfInt[i4];
      }
      i1++;
      n = i3;
    }
    return n;
  }
  
  BarcodeFormat b()
  {
    return BarcodeFormat.h;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.EAN13Reader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */