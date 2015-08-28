package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

public final class BarcodeMatrix
{
  private final BarcodeRow[] a;
  private int b;
  private final int c;
  private final int d;
  
  BarcodeMatrix(int paramInt1, int paramInt2)
  {
    this.a = new BarcodeRow[paramInt1];
    int i = 0;
    int j = this.a.length;
    while (i < j)
    {
      this.a[i] = new BarcodeRow(1 + 17 * (paramInt2 + 4));
      i++;
    }
    this.d = (paramInt2 * 17);
    this.c = paramInt1;
    this.b = -1;
  }
  
  void a()
  {
    this.b = (1 + this.b);
  }
  
  public byte[][] a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = { paramInt2 * this.c, paramInt1 * this.d };
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, arrayOfInt);
    int i = paramInt2 * this.c;
    for (int j = 0; j < i; j++) {
      arrayOfByte[(-1 + (i - j))] = this.a[(j / paramInt2)].a(paramInt1);
    }
    return arrayOfByte;
  }
  
  BarcodeRow b()
  {
    return this.a[this.b];
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.encoder.BarcodeMatrix
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */