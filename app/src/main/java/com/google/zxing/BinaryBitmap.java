package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public final class BinaryBitmap
{
  private final Binarizer a;
  private BitMatrix b;
  
  public BinaryBitmap(Binarizer paramBinarizer)
  {
    if (paramBinarizer == null) {
      throw new IllegalArgumentException("Binarizer must be non-null.");
    }
    this.a = paramBinarizer;
  }
  
  public int a()
  {
    return this.a.c();
  }
  
  public BitArray a(int paramInt, BitArray paramBitArray)
  {
    return this.a.a(paramInt, paramBitArray);
  }
  
  public int b()
  {
    return this.a.d();
  }
  
  public BitMatrix c()
  {
    if (this.b == null) {
      this.b = this.a.b();
    }
    return this.b;
  }
  
  public boolean d()
  {
    return this.a.a().d();
  }
  
  public BinaryBitmap e()
  {
    LuminanceSource localLuminanceSource = this.a.a().e();
    return new BinaryBitmap(this.a.a(localLuminanceSource));
  }
  
  public String toString()
  {
    try
    {
      String str = c().toString();
      return str;
    }
    catch (NotFoundException localNotFoundException) {}
    return "";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.BinaryBitmap
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */