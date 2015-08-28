package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

final class BoundingBox
{
  private BitMatrix a;
  private ResultPoint b;
  private ResultPoint c;
  private ResultPoint d;
  private ResultPoint e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  BoundingBox(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
  {
    if (((paramResultPoint1 == null) && (paramResultPoint3 == null)) || ((paramResultPoint2 == null) && (paramResultPoint4 == null)) || ((paramResultPoint1 != null) && (paramResultPoint2 == null)) || ((paramResultPoint3 != null) && (paramResultPoint4 == null))) {
      throw NotFoundException.a();
    }
    a(paramBitMatrix, paramResultPoint1, paramResultPoint2, paramResultPoint3, paramResultPoint4);
  }
  
  BoundingBox(BoundingBox paramBoundingBox)
  {
    a(paramBoundingBox.a, paramBoundingBox.b, paramBoundingBox.c, paramBoundingBox.d, paramBoundingBox.e);
  }
  
  static BoundingBox a(BoundingBox paramBoundingBox1, BoundingBox paramBoundingBox2)
  {
    if (paramBoundingBox1 == null) {
      return paramBoundingBox2;
    }
    if (paramBoundingBox2 == null) {
      return paramBoundingBox1;
    }
    return new BoundingBox(paramBoundingBox1.a, paramBoundingBox1.b, paramBoundingBox1.c, paramBoundingBox2.d, paramBoundingBox2.e);
  }
  
  private void a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
  {
    this.a = paramBitMatrix;
    this.b = paramResultPoint1;
    this.c = paramResultPoint2;
    this.d = paramResultPoint3;
    this.e = paramResultPoint4;
    i();
  }
  
  private void i()
  {
    if (this.b == null)
    {
      this.b = new ResultPoint(0.0F, this.d.b());
      this.c = new ResultPoint(0.0F, this.e.b());
    }
    for (;;)
    {
      this.f = ((int)Math.min(this.b.a(), this.c.a()));
      this.g = ((int)Math.max(this.d.a(), this.e.a()));
      this.h = ((int)Math.min(this.b.b(), this.d.b()));
      this.i = ((int)Math.max(this.c.b(), this.e.b()));
      return;
      if (this.d == null)
      {
        this.d = new ResultPoint(-1 + this.a.f(), this.b.b());
        this.e = new ResultPoint(-1 + this.a.f(), this.c.b());
      }
    }
  }
  
  int a()
  {
    return this.f;
  }
  
  BoundingBox a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ResultPoint localResultPoint1 = this.b;
    ResultPoint localResultPoint2 = this.c;
    Object localObject1 = this.d;
    Object localObject2 = this.e;
    ResultPoint localResultPoint6;
    ResultPoint localResultPoint3;
    if (paramInt1 > 0) {
      if (paramBoolean)
      {
        localResultPoint6 = this.b;
        int k = (int)localResultPoint6.b() - paramInt1;
        if (k < 0) {
          k = 0;
        }
        localResultPoint3 = new ResultPoint(localResultPoint6.a(), k);
        if (!paramBoolean) {
          break label178;
        }
      }
    }
    for (;;)
    {
      label77:
      ResultPoint localResultPoint5;
      label91:
      ResultPoint localResultPoint4;
      if (paramInt2 > 0) {
        if (paramBoolean)
        {
          localResultPoint5 = this.c;
          int j = paramInt2 + (int)localResultPoint5.b();
          if (j >= this.a.g()) {
            j = -1 + this.a.g();
          }
          localResultPoint4 = new ResultPoint(localResultPoint5.a(), j);
          if (!paramBoolean) {
            break label198;
          }
        }
      }
      for (;;)
      {
        i();
        return new BoundingBox(this.a, localResultPoint3, localResultPoint4, (ResultPoint)localObject1, (ResultPoint)localObject2);
        localResultPoint6 = this.d;
        break;
        label178:
        localObject1 = localResultPoint3;
        localResultPoint3 = localResultPoint1;
        break label77;
        localResultPoint5 = this.e;
        break label91;
        label198:
        localObject2 = localResultPoint4;
        localResultPoint4 = localResultPoint2;
        continue;
        localResultPoint4 = localResultPoint2;
      }
      localResultPoint3 = localResultPoint1;
    }
  }
  
  int b()
  {
    return this.g;
  }
  
  int c()
  {
    return this.h;
  }
  
  int d()
  {
    return this.i;
  }
  
  ResultPoint e()
  {
    return this.b;
  }
  
  ResultPoint f()
  {
    return this.d;
  }
  
  ResultPoint g()
  {
    return this.c;
  }
  
  ResultPoint h()
  {
    return this.e;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.BoundingBox
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */