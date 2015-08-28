package com.google.zxing.datamatrix.detector;

import com.google.zxing.ResultPoint;

final class Detector$ResultPointsAndTransitions
{
  private final ResultPoint a;
  private final ResultPoint b;
  private final int c;
  
  private Detector$ResultPointsAndTransitions(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, int paramInt)
  {
    this.a = paramResultPoint1;
    this.b = paramResultPoint2;
    this.c = paramInt;
  }
  
  ResultPoint a()
  {
    return this.a;
  }
  
  ResultPoint b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return this.a + "/" + this.b + '/' + this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.detector.Detector.ResultPointsAndTransitions
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */