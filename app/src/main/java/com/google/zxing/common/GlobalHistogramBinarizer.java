package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public class GlobalHistogramBinarizer
  extends Binarizer
{
  private static final byte[] a = new byte[0];
  private byte[] b = a;
  private final int[] c = new int[32];
  
  public GlobalHistogramBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (k < j)
    {
      if (paramArrayOfInt[k] > m)
      {
        m = paramArrayOfInt[k];
        n = k;
      }
      if (paramArrayOfInt[k] > i1) {
        i1 = paramArrayOfInt[k];
      }
      k++;
    }
    int i2 = 0;
    int i3 = 0;
    int i12;
    if (i < j)
    {
      int i11 = i - n;
      i12 = i11 * (i11 * paramArrayOfInt[i]);
      if (i12 <= i2) {
        break label236;
      }
    }
    for (int i13 = i;; i13 = i3)
    {
      i++;
      i3 = i13;
      i2 = i12;
      break;
      int i4;
      if (n > i3)
      {
        i4 = i3;
        i3 = n;
      }
      for (;;)
      {
        if (i3 - i4 <= j >> 4) {
          throw NotFoundException.a();
        }
        int i5 = i3 - 1;
        int i6 = -1;
        int i7 = i3 - 1;
        int i9;
        if (i7 > i4)
        {
          int i8 = i7 - i4;
          i9 = i8 * i8 * (i3 - i7) * (i1 - paramArrayOfInt[i7]);
          if (i9 <= i6) {
            break label218;
          }
        }
        for (int i10 = i7;; i10 = i5)
        {
          i7--;
          i5 = i10;
          i6 = i9;
          break;
          return i5 << 3;
          label218:
          i9 = i6;
        }
        i4 = n;
      }
      label236:
      i12 = i2;
    }
  }
  
  private void a(int paramInt)
  {
    if (this.b.length < paramInt) {
      this.b = new byte[paramInt];
    }
    for (int i = 0; i < 32; i++) {
      this.c[i] = 0;
    }
  }
  
  public Binarizer a(LuminanceSource paramLuminanceSource)
  {
    return new GlobalHistogramBinarizer(paramLuminanceSource);
  }
  
  public BitArray a(int paramInt, BitArray paramBitArray)
  {
    int i = 1;
    LuminanceSource localLuminanceSource = a();
    int j = localLuminanceSource.b();
    if ((paramBitArray == null) || (paramBitArray.a() < j)) {
      paramBitArray = new BitArray(j);
    }
    byte[] arrayOfByte;
    int[] arrayOfInt;
    for (;;)
    {
      a(j);
      arrayOfByte = localLuminanceSource.a(paramInt, this.b);
      arrayOfInt = this.c;
      for (int k = 0; k < j; k++)
      {
        int i4 = (0xFF & arrayOfByte[k]) >> 3;
        arrayOfInt[i4] = (1 + arrayOfInt[i4]);
      }
      paramBitArray.c();
    }
    int m = a(arrayOfInt);
    int n = 0xFF & arrayOfByte[0];
    int i1 = 0xFF & arrayOfByte[i];
    int i2 = n;
    while (i < j - 1)
    {
      int i3 = 0xFF & arrayOfByte[(i + 1)];
      if ((i1 << 2) - i2 - i3 >> 1 < m) {
        paramBitArray.b(i);
      }
      i++;
      i2 = i1;
      i1 = i3;
    }
    return paramBitArray;
  }
  
  public BitMatrix b()
  {
    LuminanceSource localLuminanceSource = a();
    int i = localLuminanceSource.b();
    int j = localLuminanceSource.c();
    BitMatrix localBitMatrix = new BitMatrix(i, j);
    a(i);
    int[] arrayOfInt = this.c;
    for (int k = 1; k < 5; k++)
    {
      byte[] arrayOfByte2 = localLuminanceSource.a(j * k / 5, this.b);
      int i3 = (i << 2) / 5;
      for (int i4 = i / 5; i4 < i3; i4++)
      {
        int i5 = (0xFF & arrayOfByte2[i4]) >> 3;
        arrayOfInt[i5] = (1 + arrayOfInt[i5]);
      }
    }
    int m = a(arrayOfInt);
    byte[] arrayOfByte1 = localLuminanceSource.a();
    for (int n = 0; n < j; n++)
    {
      int i1 = n * i;
      for (int i2 = 0; i2 < i; i2++) {
        if ((0xFF & arrayOfByte1[(i1 + i2)]) < m) {
          localBitMatrix.b(i2, n);
        }
      }
    }
    return localBitMatrix;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.GlobalHistogramBinarizer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */