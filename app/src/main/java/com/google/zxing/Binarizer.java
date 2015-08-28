package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public abstract class Binarizer
{
  private final LuminanceSource a;
  
  protected Binarizer(LuminanceSource paramLuminanceSource)
  {
    this.a = paramLuminanceSource;
  }
  
  public abstract Binarizer a(LuminanceSource paramLuminanceSource);
  
  public final LuminanceSource a()
  {
    return this.a;
  }
  
  public abstract BitArray a(int paramInt, BitArray paramBitArray);
  
  public abstract BitMatrix b();
  
  public final int c()
  {
    return this.a.b();
  }
  
  public final int d()
  {
    return this.a.c();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.Binarizer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */