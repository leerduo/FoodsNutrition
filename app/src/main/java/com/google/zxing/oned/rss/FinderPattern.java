package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern
{
  private final int a;
  private final int[] b;
  private final ResultPoint[] c;
  
  public FinderPattern(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramArrayOfInt;
    ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
    arrayOfResultPoint[0] = new ResultPoint(paramInt2, paramInt4);
    arrayOfResultPoint[1] = new ResultPoint(paramInt3, paramInt4);
    this.c = arrayOfResultPoint;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int[] b()
  {
    return this.b;
  }
  
  public ResultPoint[] c()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FinderPattern)) {}
    FinderPattern localFinderPattern;
    do
    {
      return false;
      localFinderPattern = (FinderPattern)paramObject;
    } while (this.a != localFinderPattern.a);
    return true;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.FinderPattern
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */