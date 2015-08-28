package com.google.zxing.aztec;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;

public final class AztecDetectorResult
  extends DetectorResult
{
  private final boolean a;
  private final int b;
  private final int c;
  
  public AztecDetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramBitMatrix, paramArrayOfResultPoint);
    this.a = paramBoolean;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.AztecDetectorResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */