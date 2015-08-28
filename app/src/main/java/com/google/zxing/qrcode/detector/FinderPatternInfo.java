package com.google.zxing.qrcode.detector;

public final class FinderPatternInfo
{
  private final FinderPattern a = paramArrayOfFinderPattern[0];
  private final FinderPattern b = paramArrayOfFinderPattern[1];
  private final FinderPattern c = paramArrayOfFinderPattern[2];
  
  public FinderPatternInfo(FinderPattern[] paramArrayOfFinderPattern) {}
  
  public FinderPattern a()
  {
    return this.a;
  }
  
  public FinderPattern b()
  {
    return this.b;
  }
  
  public FinderPattern c()
  {
    return this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */