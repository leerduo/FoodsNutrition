package com.google.zxing.pdf417.detector;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.List;

public final class PDF417DetectorResult
{
  private final BitMatrix a;
  private final List<ResultPoint[]> b;
  
  public PDF417DetectorResult(BitMatrix paramBitMatrix, List<ResultPoint[]> paramList)
  {
    this.a = paramBitMatrix;
    this.b = paramList;
  }
  
  public BitMatrix a()
  {
    return this.a;
  }
  
  public List<ResultPoint[]> b()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.detector.PDF417DetectorResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */