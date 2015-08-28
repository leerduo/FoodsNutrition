package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class AlignmentPattern
  extends ResultPoint
{
  private final float a;
  
  AlignmentPattern(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
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
  
  AlignmentPattern b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new AlignmentPattern((paramFloat2 + a()) / 2.0F, (paramFloat1 + b()) / 2.0F, (paramFloat3 + this.a) / 2.0F);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.AlignmentPattern
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */