package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public final class DefaultGridSampler
  extends GridSampler
{
  public BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
  {
    return a(paramBitMatrix, paramInt1, paramInt2, PerspectiveTransform.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16));
  }
  
  public BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw NotFoundException.a();
    }
    BitMatrix localBitMatrix = new BitMatrix(paramInt1, paramInt2);
    float[] arrayOfFloat = new float[paramInt1 << 1];
    for (int i = 0; i < paramInt2; i++)
    {
      int j = arrayOfFloat.length;
      float f = 0.5F + i;
      for (int k = 0; k < j; k += 2)
      {
        arrayOfFloat[k] = (0.5F + (k >> 1));
        arrayOfFloat[(k + 1)] = f;
      }
      paramPerspectiveTransform.a(arrayOfFloat);
      a(paramBitMatrix, arrayOfFloat);
      int m = 0;
      while (m < j) {
        try
        {
          if (paramBitMatrix.a((int)arrayOfFloat[m], (int)arrayOfFloat[(m + 1)])) {
            localBitMatrix.b(m >> 1, i);
          }
          m += 2;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          throw NotFoundException.a();
        }
      }
    }
    return localBitMatrix;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.DefaultGridSampler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */