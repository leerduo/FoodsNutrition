package com.google.zxing.qrcode.decoder;

final class DataMask$DataMask111
  extends DataMask
{
  private DataMask$DataMask111()
  {
    super(null);
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    return (0x1 & (0x1 & paramInt1 + paramInt2) + paramInt1 * paramInt2 % 3) == 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.DataMask.DataMask111
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */