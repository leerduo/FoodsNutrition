package com.google.zxing.datamatrix.decoder;

final class DataBlock
{
  private final int a;
  private final byte[] b;
  
  private DataBlock(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
  }
  
  static DataBlock[] a(byte[] paramArrayOfByte, Version paramVersion)
  {
    Version.ECBlocks localECBlocks = paramVersion.g();
    Version.ECB[] arrayOfECB = localECBlocks.b();
    int i = arrayOfECB.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfECB[j].a();
      j++;
    }
    DataBlock[] arrayOfDataBlock = new DataBlock[k];
    int m = arrayOfECB.length;
    int n = 0;
    int i19;
    for (int i1 = 0; n < m; i1 = i19)
    {
      Version.ECB localECB = arrayOfECB[n];
      i19 = i1;
      int i20 = 0;
      while (i20 < localECB.a())
      {
        int i21 = localECB.b();
        int i22 = i21 + localECBlocks.a();
        int i23 = i19 + 1;
        arrayOfDataBlock[i19] = new DataBlock(i21, new byte[i22]);
        i20++;
        i19 = i23;
      }
      n++;
    }
    int i2 = arrayOfDataBlock[0].b.length - localECBlocks.a();
    int i3 = i2 - 1;
    int i4 = 0;
    int i5 = 0;
    while (i4 < i3)
    {
      int i17 = 0;
      while (i17 < i1)
      {
        byte[] arrayOfByte3 = arrayOfDataBlock[i17].b;
        int i18 = i5 + 1;
        arrayOfByte3[i4] = paramArrayOfByte[i5];
        i17++;
        i5 = i18;
      }
      i4++;
    }
    int i6;
    if (paramVersion.a() == 24)
    {
      i6 = 1;
      if (i6 == 0) {
        break label315;
      }
    }
    label315:
    for (int i7 = 8;; i7 = i1)
    {
      int i8 = 0;
      while (i8 < i7)
      {
        byte[] arrayOfByte2 = arrayOfDataBlock[i8].b;
        int i15 = i2 - 1;
        int i16 = i5 + 1;
        arrayOfByte2[i15] = paramArrayOfByte[i5];
        i8++;
        i5 = i16;
      }
      i6 = 0;
      break;
    }
    int i9 = arrayOfDataBlock[0].b.length;
    int i12;
    for (int i10 = i5; i2 < i9; i10 = i12)
    {
      int i11 = 0;
      i12 = i10;
      if (i11 < i1)
      {
        if ((i6 != 0) && (i11 > 7)) {}
        for (int i13 = i2 - 1;; i13 = i2)
        {
          byte[] arrayOfByte1 = arrayOfDataBlock[i11].b;
          int i14 = i12 + 1;
          arrayOfByte1[i13] = paramArrayOfByte[i12];
          i11++;
          i12 = i14;
          break;
        }
      }
      i2++;
    }
    if (i10 != paramArrayOfByte.length) {
      throw new IllegalArgumentException();
    }
    return arrayOfDataBlock;
  }
  
  int a()
  {
    return this.a;
  }
  
  byte[] b()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.decoder.DataBlock
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */