package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

public class ResultPoint
{
  private final float a;
  private final float b;
  
  public ResultPoint(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public static float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    return MathUtils.a(paramResultPoint1.a, paramResultPoint1.b, paramResultPoint2.a, paramResultPoint2.b);
  }
  
  private static float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3)
  {
    float f1 = paramResultPoint2.a;
    float f2 = paramResultPoint2.b;
    return (paramResultPoint3.a - f1) * (paramResultPoint1.b - f2) - (paramResultPoint3.b - f2) * (paramResultPoint1.a - f1);
  }
  
  public static void a(ResultPoint[] paramArrayOfResultPoint)
  {
    float f1 = a(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1]);
    float f2 = a(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2]);
    float f3 = a(paramArrayOfResultPoint[0], paramArrayOfResultPoint[2]);
    ResultPoint localResultPoint;
    Object localObject1;
    Object localObject2;
    if ((f2 >= f1) && (f2 >= f3))
    {
      localResultPoint = paramArrayOfResultPoint[0];
      localObject1 = paramArrayOfResultPoint[1];
      localObject2 = paramArrayOfResultPoint[2];
      if (a((ResultPoint)localObject1, localResultPoint, (ResultPoint)localObject2) >= 0.0F) {
        break label135;
      }
    }
    for (;;)
    {
      paramArrayOfResultPoint[0] = localObject2;
      paramArrayOfResultPoint[1] = localResultPoint;
      paramArrayOfResultPoint[2] = localObject1;
      return;
      if ((f3 >= f2) && (f3 >= f1))
      {
        localResultPoint = paramArrayOfResultPoint[1];
        localObject1 = paramArrayOfResultPoint[0];
        localObject2 = paramArrayOfResultPoint[2];
        break;
      }
      localResultPoint = paramArrayOfResultPoint[2];
      localObject1 = paramArrayOfResultPoint[0];
      localObject2 = paramArrayOfResultPoint[1];
      break;
      label135:
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final float a()
  {
    return this.a;
  }
  
  public final float b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ResultPoint;
    boolean bool2 = false;
    if (bool1)
    {
      ResultPoint localResultPoint = (ResultPoint)paramObject;
      boolean bool3 = this.a < localResultPoint.a;
      bool2 = false;
      if (!bool3)
      {
        boolean bool4 = this.b < localResultPoint.b;
        bool2 = false;
        if (!bool4) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public final int hashCode()
  {
    return 31 * Float.floatToIntBits(this.a) + Float.floatToIntBits(this.b);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(25);
    localStringBuilder.append('(');
    localStringBuilder.append(this.a);
    localStringBuilder.append(',');
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.ResultPoint
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */