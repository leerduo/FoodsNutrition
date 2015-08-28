package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern
  extends ResultPoint
{
  private final float a;
  private final int b;
  
  FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramFloat1, paramFloat2, paramFloat3, 1);
  }
  
  private FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
    this.b = paramInt;
  }
  
  boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool1 = Math.abs(paramFloat2 - b()) < paramFloat1;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = Math.abs(paramFloat3 - a()) < paramFloat1;
      bool2 = false;
      if (!bool3)
      {
        float f = Math.abs(paramFloat1 - this.a);
        if (f > 1.0F)
        {
          boolean bool4 = f < this.a;
          bool2 = false;
          if (bool4) {}
        }
        else
        {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  FinderPattern b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = 1 + this.b;
    return new FinderPattern((paramFloat2 + this.b * a()) / i, (paramFloat1 + this.b * b()) / i, (paramFloat3 + this.b * this.a) / i, i);
  }
  
  public float c()
  {
    return this.a;
  }
  
  int d()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPattern
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */