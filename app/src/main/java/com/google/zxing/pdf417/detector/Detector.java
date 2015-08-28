package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Detector
{
  private static final int[] a = { 0, 4, 1, 5 };
  private static final int[] b = { 6, 2, 7, 3 };
  private static final int[] c = { 8, 1, 1, 1, 1, 1, 1, 3 };
  private static final int[] d = { 7, 1, 1, 3, 1, 1, 1, 2, 1 };
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = paramArrayOfInt1.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < i)
    {
      m += paramArrayOfInt1[j];
      k += paramArrayOfInt2[j];
      j++;
    }
    if (m < k) {}
    int i3;
    label143:
    for (;;)
    {
      return 2147483647;
      int n = (m << 8) / k;
      int i1 = paramInt * n >> 8;
      int i2 = 0;
      i3 = 0;
      if (i2 >= i) {
        break;
      }
      int i4 = paramArrayOfInt1[i2] << 8;
      int i5 = n * paramArrayOfInt2[i2];
      if (i4 > i5) {}
      for (int i6 = i4 - i5;; i6 = i5 - i4)
      {
        if (i6 > i1) {
          break label143;
        }
        i3 += i6;
        i2++;
        break;
      }
    }
    return i3 / m;
  }
  
  public static PDF417DetectorResult a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, boolean paramBoolean)
  {
    BitMatrix localBitMatrix = paramBinaryBitmap.c();
    List localList = a(paramBoolean, localBitMatrix);
    if (localList.isEmpty())
    {
      localBitMatrix = localBitMatrix.h();
      localBitMatrix.b();
      localList = a(paramBoolean, localBitMatrix);
    }
    return new PDF417DetectorResult(localBitMatrix, localList);
  }
  
  private static List<ResultPoint[]> a(boolean paramBoolean, BitMatrix paramBitMatrix)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    int k = 0;
    ResultPoint[] arrayOfResultPoint1;
    if (k < paramBitMatrix.g())
    {
      arrayOfResultPoint1 = a(paramBitMatrix, k, j);
      if ((arrayOfResultPoint1[0] != null) || (arrayOfResultPoint1[3] != null)) {
        break label144;
      }
      if (i != 0) {
        break label55;
      }
    }
    label55:
    do
    {
      return localArrayList;
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultPoint[] arrayOfResultPoint2 = (ResultPoint[])localIterator.next();
        if (arrayOfResultPoint2[1] != null) {
          k = (int)Math.max(k, arrayOfResultPoint2[1].b());
        }
        if (arrayOfResultPoint2[3] != null) {
          k = Math.max(k, (int)arrayOfResultPoint2[3].b());
        }
      }
      k += 5;
      i = 0;
      j = 0;
      break;
      localArrayList.add(arrayOfResultPoint1);
    } while (!paramBoolean);
    label144:
    int m;
    if (arrayOfResultPoint1[2] != null) {
      m = (int)arrayOfResultPoint1[2].a();
    }
    for (int n = (int)arrayOfResultPoint1[2].b();; n = (int)arrayOfResultPoint1[4].b())
    {
      k = n;
      j = m;
      i = 1;
      break;
      m = (int)arrayOfResultPoint1[4].a();
    }
  }
  
  private static void a(ResultPoint[] paramArrayOfResultPoint1, ResultPoint[] paramArrayOfResultPoint2, int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      paramArrayOfResultPoint1[paramArrayOfInt[i]] = paramArrayOfResultPoint2[i];
    }
  }
  
  private static int[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Arrays.fill(paramArrayOfInt2, 0, paramArrayOfInt2.length, 0);
    int i = paramArrayOfInt1.length;
    int n;
    for (int j = 0; (paramBitMatrix.a(paramInt1, paramInt2)) && (paramInt1 > 0); j = n)
    {
      n = j + 1;
      if (j >= 3) {
        break;
      }
      paramInt1--;
    }
    int k = 0;
    int m = paramInt1;
    boolean bool = paramBoolean;
    if (paramInt1 < paramInt3)
    {
      if ((bool ^ paramBitMatrix.a(paramInt1, paramInt2))) {
        paramArrayOfInt2[k] = (1 + paramArrayOfInt2[k]);
      }
      for (;;)
      {
        paramInt1++;
        break;
        if (k == i - 1)
        {
          if (a(paramArrayOfInt2, paramArrayOfInt1, 204) < 107) {
            return new int[] { m, paramInt1 };
          }
          m += paramArrayOfInt2[0] + paramArrayOfInt2[1];
          System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, i - 2);
          paramArrayOfInt2[(i - 2)] = 0;
          paramArrayOfInt2[(i - 1)] = 0;
          k--;
        }
        for (;;)
        {
          paramArrayOfInt2[k] = 1;
          if (bool) {
            break label204;
          }
          bool = true;
          break;
          k++;
        }
        label204:
        bool = false;
      }
    }
    if ((k == i - 1) && (a(paramArrayOfInt2, paramArrayOfInt1, 204) < 107))
    {
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = m;
      arrayOfInt[1] = (paramInt1 - 1);
      return arrayOfInt;
    }
    return null;
  }
  
  private static ResultPoint[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2)
  {
    int i = paramBitMatrix.g();
    int j = paramBitMatrix.f();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[8];
    a(arrayOfResultPoint, a(paramBitMatrix, i, j, paramInt1, paramInt2, c), a);
    int k;
    if (arrayOfResultPoint[4] != null) {
      k = (int)arrayOfResultPoint[4].a();
    }
    for (int m = (int)arrayOfResultPoint[4].b();; m = paramInt1)
    {
      a(arrayOfResultPoint, a(paramBitMatrix, i, j, m, k, d), b);
      return arrayOfResultPoint;
      k = paramInt2;
    }
  }
  
  private static ResultPoint[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ResultPoint[] arrayOfResultPoint = new ResultPoint[4];
    int[] arrayOfInt1 = new int[paramArrayOfInt.length];
    int i = paramInt3;
    int k;
    int j;
    if (i < paramInt1)
    {
      int[] arrayOfInt2 = a(paramBitMatrix, paramInt4, i, paramInt2, false, paramArrayOfInt, arrayOfInt1);
      if (arrayOfInt2 != null)
      {
        Object localObject3 = arrayOfInt2;
        int i4 = i;
        while (i4 > 0)
        {
          int i5 = i4 - 1;
          int[] arrayOfInt3 = a(paramBitMatrix, paramInt4, i5, paramInt2, false, paramArrayOfInt, arrayOfInt1);
          if (arrayOfInt3 != null)
          {
            localObject3 = arrayOfInt3;
            i4 = i5;
          }
          else
          {
            i4 = i5 + 1;
          }
        }
        arrayOfResultPoint[0] = new ResultPoint(localObject3[0], i4);
        arrayOfResultPoint[1] = new ResultPoint(localObject3[1], i4);
        k = 1;
        j = i4;
      }
    }
    for (;;)
    {
      int m = j + 1;
      Object localObject1;
      int i1;
      int i2;
      label192:
      Object localObject2;
      int i3;
      if (k != 0)
      {
        localObject1 = new int[2];
        localObject1[0] = ((int)arrayOfResultPoint[0].a());
        localObject1[1] = ((int)arrayOfResultPoint[1].a());
        i1 = 0;
        i2 = m;
        if (i2 < paramInt1)
        {
          localObject2 = a(paramBitMatrix, localObject1[0], i2, paramInt2, false, paramArrayOfInt, arrayOfInt1);
          if ((localObject2 != null) && (Math.abs(localObject1[0] - localObject2[0]) < 5) && (Math.abs(localObject1[1] - localObject2[1]) < 5)) {
            i3 = 0;
          }
        }
      }
      for (;;)
      {
        i2++;
        localObject1 = localObject2;
        i1 = i3;
        break label192;
        i += 5;
        break;
        if (i1 > 25)
        {
          m = i2 - (i1 + 1);
          arrayOfResultPoint[2] = new ResultPoint(localObject1[0], m);
          arrayOfResultPoint[3] = new ResultPoint(localObject1[1], m);
          if (m - j >= 10) {
            break label376;
          }
          for (int n = 0; n < arrayOfResultPoint.length; n++) {
            arrayOfResultPoint[n] = null;
          }
        }
        i3 = i1 + 1;
        localObject2 = localObject1;
      }
      label376:
      return arrayOfResultPoint;
      j = i;
      k = 0;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.detector.Detector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */