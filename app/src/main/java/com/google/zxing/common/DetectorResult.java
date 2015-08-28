package com.google.zxing.common;

import com.google.zxing.ResultPoint;

public class DetectorResult
{
  private final BitMatrix a;
  private final ResultPoint[] b;
  
  public DetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint)
  {
    this.a = paramBitMatrix;
    this.b = paramArrayOfResultPoint;
  }
  
  public final BitMatrix d()
  {
    return this.a;
  }
  
  public final ResultPoint[] e()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.DetectorResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */