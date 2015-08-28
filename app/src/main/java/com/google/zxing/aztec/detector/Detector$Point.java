package com.google.zxing.aztec.detector;

import com.google.zxing.ResultPoint;

final class Detector$Point
{
  private final int a;
  private final int b;
  
  Detector$Point(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  ResultPoint a()
  {
    return new ResultPoint(b(), c());
  }
  
  int b()
  {
    return this.a;
  }
  
  int c()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "<" + this.a + ' ' + this.b + '>';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.detector.Detector.Point
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */