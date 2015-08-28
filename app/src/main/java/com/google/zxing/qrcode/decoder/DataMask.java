package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

abstract class DataMask
{
  private static final DataMask[] a = arrayOfDataMask;
  
  static
  {
    DataMask[] arrayOfDataMask = new DataMask[8];
    arrayOfDataMask[0] = new DataMask.DataMask000(null);
    arrayOfDataMask[1] = new DataMask.DataMask001(null);
    arrayOfDataMask[2] = new DataMask.DataMask010(null);
    arrayOfDataMask[3] = new DataMask.DataMask011(null);
    arrayOfDataMask[4] = new DataMask.DataMask100(null);
    arrayOfDataMask[5] = new DataMask.DataMask101(null);
    arrayOfDataMask[6] = new DataMask.DataMask110(null);
    arrayOfDataMask[7] = new DataMask.DataMask111(null);
  }
  
  static DataMask a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 7)) {
      throw new IllegalArgumentException();
    }
    return a[paramInt];
  }
  
  final void a(BitMatrix paramBitMatrix, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      for (int j = 0; j < paramInt; j++) {
        if (a(i, j)) {
          paramBitMatrix.c(j, i);
        }
      }
    }
  }
  
  abstract boolean a(int paramInt1, int paramInt2);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.DataMask
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */