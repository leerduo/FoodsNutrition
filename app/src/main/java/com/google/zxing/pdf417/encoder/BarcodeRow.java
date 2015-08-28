package com.google.zxing.pdf417.encoder;

final class BarcodeRow
{
  private final byte[] a;
  private int b;
  
  BarcodeRow(int paramInt)
  {
    this.a = new byte[paramInt];
    this.b = 0;
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[paramInt] = ((byte)i);
      return;
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      int j = this.b;
      this.b = (j + 1);
      a(j, paramBoolean);
    }
  }
  
  byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt * this.a.length];
    for (int i = 0; i < arrayOfByte.length; i++) {
      arrayOfByte[i] = this.a[(i / paramInt)];
    }
    return arrayOfByte;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.encoder.BarcodeRow
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */