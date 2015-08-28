package com.google.zxing.qrcode.decoder;

final class DataMask$DataMask110
  extends DataMask
{
  private DataMask$DataMask110()
  {
    super(null);
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    return (0x1 & (i & 0x1) + i % 3) == 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.DataMask.DataMask110
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */