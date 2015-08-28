package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector
{
  private final BitMatrix a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  
  public WhiteRectangleDetector(BitMatrix paramBitMatrix)
  {
    this(paramBitMatrix, 10, paramBitMatrix.f() / 2, paramBitMatrix.g() / 2);
  }
  
  public WhiteRectangleDetector(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramBitMatrix;
    this.b = paramBitMatrix.g();
    this.c = paramBitMatrix.f();
    int i = paramInt1 / 2;
    this.d = (paramInt2 - i);
    this.e = (paramInt2 + i);
    this.g = (paramInt3 - i);
    this.f = (i + paramInt3);
    if ((this.g < 0) || (this.d < 0) || (this.f >= this.b) || (this.e >= this.c)) {
      throw NotFoundException.a();
    }
  }
  
  private ResultPoint a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = MathUtils.a(MathUtils.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    float f1 = (paramFloat3 - paramFloat1) / i;
    float f2 = (paramFloat4 - paramFloat2) / i;
    for (int j = 0; j < i; j++)
    {
      int k = MathUtils.a(paramFloat1 + f1 * j);
      int m = MathUtils.a(paramFloat2 + f2 * j);
      if (this.a.a(k, m)) {
        return new ResultPoint(k, m);
      }
    }
    return null;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean) {
      while (paramInt1 <= paramInt2)
      {
        if (this.a.a(paramInt1, paramInt3)) {
          return true;
        }
        paramInt1++;
      }
    }
    do
    {
      paramInt1++;
      if (paramInt1 > paramInt2) {
        break;
      }
    } while (!this.a.a(paramInt3, paramInt1));
    return true;
    return false;
  }
  
  private ResultPoint[] a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
  {
    float f1 = paramResultPoint1.a();
    float f2 = paramResultPoint1.b();
    float f3 = paramResultPoint2.a();
    float f4 = paramResultPoint2.b();
    float f5 = paramResultPoint3.a();
    float f6 = paramResultPoint3.b();
    float f7 = paramResultPoint4.a();
    float f8 = paramResultPoint4.b();
    if (f1 < this.c / 2.0F)
    {
      ResultPoint[] arrayOfResultPoint2 = new ResultPoint[4];
      arrayOfResultPoint2[0] = new ResultPoint(f7 - 1.0F, f8 + 1.0F);
      arrayOfResultPoint2[1] = new ResultPoint(f3 + 1.0F, f4 + 1.0F);
      arrayOfResultPoint2[2] = new ResultPoint(f5 - 1.0F, f6 - 1.0F);
      arrayOfResultPoint2[3] = new ResultPoint(f1 + 1.0F, f2 - 1.0F);
      return arrayOfResultPoint2;
    }
    ResultPoint[] arrayOfResultPoint1 = new ResultPoint[4];
    arrayOfResultPoint1[0] = new ResultPoint(f7 + 1.0F, f8 + 1.0F);
    arrayOfResultPoint1[1] = new ResultPoint(f3 + 1.0F, f4 - 1.0F);
    arrayOfResultPoint1[2] = new ResultPoint(f5 - 1.0F, f6 + 1.0F);
    arrayOfResultPoint1[3] = new ResultPoint(f1 - 1.0F, f2 - 1.0F);
    return arrayOfResultPoint1;
  }
  
  public ResultPoint[] a()
  {
    int i = 1;
    int j = this.d;
    int k = this.e;
    int m = this.g;
    int n = this.f;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    boolean bool1 = i;
    int i14;
    boolean bool4;
    boolean bool2;
    int i6;
    int i7;
    int i8;
    int i9;
    if (bool1)
    {
      boolean bool3 = i;
      i14 = i4;
      bool4 = false;
      while (((bool3) || (i14 == 0)) && (k < this.c))
      {
        bool3 = a(m, n, k, false);
        if (bool3)
        {
          k++;
          i14 = i;
          bool4 = i;
        }
        else if (i14 == 0)
        {
          k++;
        }
      }
      if (k >= this.c)
      {
        bool2 = i;
        i6 = k;
        i7 = n;
        i8 = j;
        i9 = m;
      }
    }
    for (;;)
    {
      label140:
      int i10;
      int i11;
      ResultPoint localResultPoint1;
      if ((!bool2) && (i5 != 0))
      {
        i10 = i6 - i8;
        i11 = i;
        localResultPoint1 = null;
        label163:
        if (i11 >= i10) {
          break label734;
        }
        localResultPoint1 = a(i8, i7 - i11, i8 + i11, i7);
        if (localResultPoint1 == null) {}
      }
      label734:
      for (ResultPoint localResultPoint2 = localResultPoint1;; localResultPoint2 = localResultPoint1)
      {
        if (localResultPoint2 == null)
        {
          throw NotFoundException.a();
          int i15 = i3;
          boolean bool5 = bool4;
          int i16 = i;
          while (((i16 != 0) || (i15 == 0)) && (n < this.b))
          {
            boolean bool6 = a(j, k, n, i);
            if (bool6)
            {
              n++;
              i15 = i;
              bool5 = i;
            }
            else if (i15 == 0)
            {
              n++;
            }
          }
          if (n >= this.b)
          {
            bool2 = i;
            i6 = k;
            i7 = n;
            i8 = j;
            i9 = m;
            break label140;
          }
          int i17 = i2;
          boolean bool7 = bool5;
          int i18 = i;
          while (((i18 != 0) || (i17 == 0)) && (j >= 0))
          {
            boolean bool8 = a(m, n, j, false);
            if (bool8)
            {
              j--;
              i17 = i;
              bool7 = i;
            }
            else if (i17 == 0)
            {
              j--;
            }
          }
          if (j < 0)
          {
            bool2 = i;
            i6 = k;
            i7 = n;
            i8 = j;
            i9 = m;
            break label140;
          }
          boolean bool9 = bool7;
          int i19 = i1;
          int i20 = i;
          while (((i20 != 0) || (i19 == 0)) && (m >= 0))
          {
            boolean bool10 = a(j, k, m, i);
            if (bool10)
            {
              m--;
              i19 = i;
              bool9 = i;
            }
            else if (i19 == 0)
            {
              m--;
            }
          }
          if (m < 0)
          {
            bool2 = i;
            i6 = k;
            i7 = n;
            i8 = j;
            i9 = m;
            break label140;
          }
          if (bool9) {
            i5 = i;
          }
          i1 = i19;
          i2 = i17;
          i4 = i14;
          int i21 = i15;
          bool1 = bool9;
          i3 = i21;
          break;
          i11++;
          break label163;
        }
        int i12 = i;
        ResultPoint localResultPoint3 = null;
        if (i12 < i10)
        {
          localResultPoint3 = a(i8, i9 + i12, i8 + i12, i9);
          if (localResultPoint3 == null) {}
        }
        for (ResultPoint localResultPoint4 = localResultPoint3;; localResultPoint4 = localResultPoint3)
        {
          if (localResultPoint4 == null)
          {
            throw NotFoundException.a();
            i12++;
            break;
          }
          int i13 = i;
          ResultPoint localResultPoint5 = null;
          if (i13 < i10)
          {
            localResultPoint5 = a(i6, i9 + i13, i6 - i13, i9);
            if (localResultPoint5 == null) {}
          }
          for (ResultPoint localResultPoint6 = localResultPoint5;; localResultPoint6 = localResultPoint5)
          {
            if (localResultPoint6 == null)
            {
              throw NotFoundException.a();
              i13++;
              break;
            }
            ResultPoint localResultPoint7 = null;
            for (;;)
            {
              if (i < i10)
              {
                localResultPoint7 = a(i6, i7 - i, i6 - i, i7);
                if (localResultPoint7 == null) {}
              }
              else
              {
                if (localResultPoint7 != null) {
                  break;
                }
                throw NotFoundException.a();
              }
              i++;
            }
            return a(localResultPoint7, localResultPoint2, localResultPoint6, localResultPoint4);
            throw NotFoundException.a();
          }
        }
      }
      i6 = k;
      i7 = n;
      i8 = j;
      i9 = m;
      bool2 = false;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.detector.WhiteRectangleDetector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */