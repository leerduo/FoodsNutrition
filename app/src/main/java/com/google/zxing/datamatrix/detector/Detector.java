package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Detector
{
  private final BitMatrix a;
  private final WhiteRectangleDetector b;
  
  public Detector(BitMatrix paramBitMatrix)
  {
    this.a = paramBitMatrix;
    this.b = new WhiteRectangleDetector(paramBitMatrix);
  }
  
  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    return MathUtils.a(ResultPoint.a(paramResultPoint1, paramResultPoint2));
  }
  
  private ResultPoint a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt)
  {
    float f1 = a(paramResultPoint1, paramResultPoint2) / paramInt;
    int i = a(paramResultPoint3, paramResultPoint4);
    float f2 = (paramResultPoint4.a() - paramResultPoint3.a()) / i;
    float f3 = (paramResultPoint4.b() - paramResultPoint3.b()) / i;
    Object localObject = new ResultPoint(paramResultPoint4.a() + f2 * f1, paramResultPoint4.b() + f1 * f3);
    float f4 = a(paramResultPoint1, paramResultPoint3) / paramInt;
    int j = a(paramResultPoint2, paramResultPoint4);
    float f5 = (paramResultPoint4.a() - paramResultPoint2.a()) / j;
    float f6 = (paramResultPoint4.b() - paramResultPoint2.b()) / j;
    ResultPoint localResultPoint = new ResultPoint(paramResultPoint4.a() + f5 * f4, paramResultPoint4.b() + f4 * f6);
    if (!a((ResultPoint)localObject)) {
      if (a(localResultPoint)) {
        localObject = localResultPoint;
      }
    }
    while ((!a(localResultPoint)) || (Math.abs(b(paramResultPoint3, (ResultPoint)localObject).c() - b(paramResultPoint2, (ResultPoint)localObject).c()) <= Math.abs(b(paramResultPoint3, localResultPoint).c() - b(paramResultPoint2, localResultPoint).c())))
    {
      return localObject;
      return null;
    }
    return localResultPoint;
  }
  
  private ResultPoint a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2)
  {
    float f1 = a(paramResultPoint1, paramResultPoint2) / paramInt1;
    int i = a(paramResultPoint3, paramResultPoint4);
    float f2 = (paramResultPoint4.a() - paramResultPoint3.a()) / i;
    float f3 = (paramResultPoint4.b() - paramResultPoint3.b()) / i;
    ResultPoint localResultPoint1 = new ResultPoint(paramResultPoint4.a() + f2 * f1, paramResultPoint4.b() + f1 * f3);
    float f4 = a(paramResultPoint1, paramResultPoint3) / paramInt2;
    int j = a(paramResultPoint2, paramResultPoint4);
    float f5 = (paramResultPoint4.a() - paramResultPoint2.a()) / j;
    float f6 = (paramResultPoint4.b() - paramResultPoint2.b()) / j;
    ResultPoint localResultPoint2 = new ResultPoint(paramResultPoint4.a() + f5 * f4, paramResultPoint4.b() + f4 * f6);
    if (!a(localResultPoint1)) {
      if (!a(localResultPoint2)) {}
    }
    do
    {
      return localResultPoint2;
      return null;
      if (!a(localResultPoint2)) {
        return localResultPoint1;
      }
    } while (Math.abs(paramInt1 - b(paramResultPoint3, localResultPoint1).c()) + Math.abs(paramInt2 - b(paramResultPoint2, localResultPoint1).c()) > Math.abs(paramInt1 - b(paramResultPoint3, localResultPoint2).c()) + Math.abs(paramInt2 - b(paramResultPoint2, localResultPoint2).c()));
    return localResultPoint1;
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2)
  {
    return GridSampler.a().a(paramBitMatrix, paramInt1, paramInt2, 0.5F, 0.5F, paramInt1 - 0.5F, 0.5F, paramInt1 - 0.5F, paramInt2 - 0.5F, 0.5F, paramInt2 - 0.5F, paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint4.a(), paramResultPoint4.b(), paramResultPoint3.a(), paramResultPoint3.b(), paramResultPoint2.a(), paramResultPoint2.b());
  }
  
  private static void a(Map<ResultPoint, Integer> paramMap, ResultPoint paramResultPoint)
  {
    Integer localInteger = (Integer)paramMap.get(paramResultPoint);
    if (localInteger == null) {}
    for (int i = 1;; i = 1 + localInteger.intValue())
    {
      paramMap.put(paramResultPoint, Integer.valueOf(i));
      return;
    }
  }
  
  private boolean a(ResultPoint paramResultPoint)
  {
    return (paramResultPoint.a() >= 0.0F) && (paramResultPoint.a() < this.a.f()) && (paramResultPoint.b() > 0.0F) && (paramResultPoint.b() < this.a.g());
  }
  
  private Detector.ResultPointsAndTransitions b(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    int i = (int)paramResultPoint1.a();
    int j = (int)paramResultPoint1.b();
    int k = (int)paramResultPoint2.a();
    int m = (int)paramResultPoint2.b();
    int n;
    if (Math.abs(m - j) > Math.abs(k - i))
    {
      n = 1;
      if (n == 0) {
        break label314;
      }
    }
    for (;;)
    {
      int i3 = Math.abs(m - j);
      int i4 = Math.abs(k - i);
      int i5 = -i3 >> 1;
      int i6;
      label88:
      int i7;
      label98:
      int i8;
      int i9;
      label115:
      int i10;
      label124:
      int i11;
      int i12;
      label142:
      int i14;
      label164:
      int i15;
      label173:
      int i16;
      if (i < k)
      {
        i6 = 1;
        if (j >= m) {
          break label246;
        }
        i7 = 1;
        i8 = 0;
        BitMatrix localBitMatrix1 = this.a;
        if (n == 0) {
          break label252;
        }
        i9 = i;
        if (n == 0) {
          break label259;
        }
        i10 = j;
        boolean bool1 = localBitMatrix1.a(i9, i10);
        i11 = i;
        i12 = i5;
        if (j == m) {
          break label307;
        }
        BitMatrix localBitMatrix2 = this.a;
        if (n == 0) {
          break label265;
        }
        i14 = i11;
        if (n == 0) {
          break label272;
        }
        i15 = j;
        boolean bool2 = localBitMatrix2.a(i14, i15);
        if (bool2 != bool1)
        {
          i8++;
          bool1 = bool2;
        }
        i16 = i12 + i4;
        if (i16 <= 0) {
          break label293;
        }
        if (i11 != k) {
          break label279;
        }
      }
      label259:
      label265:
      label272:
      label279:
      label293:
      label307:
      for (int i13 = i8;; i13 = i8)
      {
        return new Detector.ResultPointsAndTransitions(paramResultPoint1, paramResultPoint2, i13, null);
        n = 0;
        break;
        i6 = -1;
        break label88;
        label246:
        i7 = -1;
        break label98;
        label252:
        i9 = j;
        break label115;
        i10 = i;
        break label124;
        i14 = j;
        break label164;
        i15 = i11;
        break label173;
        i11 += i6;
        i16 -= i3;
        j += i7;
        i12 = i16;
        break label142;
      }
      label314:
      int i1 = m;
      m = k;
      k = i1;
      int i2 = j;
      j = i;
      i = i2;
    }
  }
  
  public DetectorResult a()
  {
    ResultPoint[] arrayOfResultPoint1 = this.b.a();
    ResultPoint localResultPoint1 = arrayOfResultPoint1[0];
    ResultPoint localResultPoint2 = arrayOfResultPoint1[1];
    ResultPoint localResultPoint3 = arrayOfResultPoint1[2];
    ResultPoint localResultPoint4 = arrayOfResultPoint1[3];
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(b(localResultPoint1, localResultPoint2));
    localArrayList.add(b(localResultPoint1, localResultPoint3));
    localArrayList.add(b(localResultPoint2, localResultPoint4));
    localArrayList.add(b(localResultPoint3, localResultPoint4));
    Collections.sort(localArrayList, new Detector.ResultPointsAndTransitionsComparator(null));
    Detector.ResultPointsAndTransitions localResultPointsAndTransitions1 = (Detector.ResultPointsAndTransitions)localArrayList.get(0);
    Detector.ResultPointsAndTransitions localResultPointsAndTransitions2 = (Detector.ResultPointsAndTransitions)localArrayList.get(1);
    HashMap localHashMap = new HashMap();
    a(localHashMap, localResultPointsAndTransitions1.a());
    a(localHashMap, localResultPointsAndTransitions1.b());
    a(localHashMap, localResultPointsAndTransitions2.a());
    a(localHashMap, localResultPointsAndTransitions2.b());
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Iterator localIterator = localHashMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject4 = (ResultPoint)localEntry.getKey();
      Object localObject5;
      Object localObject6;
      if (((Integer)localEntry.getValue()).intValue() == 2)
      {
        localObject5 = localObject4;
        localObject4 = localObject3;
        localObject6 = localObject1;
      }
      for (;;)
      {
        localObject2 = localObject5;
        localObject1 = localObject6;
        localObject3 = localObject4;
        break;
        if (localObject1 == null)
        {
          localObject5 = localObject2;
          Object localObject7 = localObject3;
          localObject6 = localObject4;
          localObject4 = localObject7;
        }
        else
        {
          localObject5 = localObject2;
          localObject6 = localObject1;
        }
      }
    }
    if ((localObject1 == null) || (localObject2 == null) || (localObject3 == null)) {
      throw NotFoundException.a();
    }
    ResultPoint[] arrayOfResultPoint2 = { localObject1, localObject2, localObject3 };
    ResultPoint.a(arrayOfResultPoint2);
    ResultPoint localResultPoint5 = arrayOfResultPoint2[0];
    ResultPoint localResultPoint6 = arrayOfResultPoint2[1];
    ResultPoint localResultPoint7 = arrayOfResultPoint2[2];
    ResultPoint localResultPoint8;
    int k;
    int m;
    ResultPoint localResultPoint9;
    int n;
    int i1;
    if (!localHashMap.containsKey(localResultPoint1))
    {
      localResultPoint8 = localResultPoint1;
      int i = b(localResultPoint7, localResultPoint8).c();
      int j = b(localResultPoint5, localResultPoint8).c();
      if ((i & 0x1) == 1) {
        i++;
      }
      k = i + 2;
      if ((j & 0x1) == 1) {
        j++;
      }
      m = j + 2;
      if ((k * 4 < m * 7) && (m * 4 < k * 7)) {
        break label654;
      }
      localResultPoint9 = a(localResultPoint6, localResultPoint5, localResultPoint7, localResultPoint8, k, m);
      if (localResultPoint9 == null) {
        localResultPoint9 = localResultPoint8;
      }
      n = b(localResultPoint7, localResultPoint9).c();
      i1 = b(localResultPoint5, localResultPoint9).c();
      if ((n & 0x1) == 1) {
        n++;
      }
      if ((i1 & 0x1) == 1) {
        i1++;
      }
    }
    label654:
    int i2;
    for (BitMatrix localBitMatrix = a(this.a, localResultPoint7, localResultPoint6, localResultPoint5, localResultPoint9, n, i1);; localBitMatrix = a(this.a, localResultPoint7, localResultPoint6, localResultPoint5, localResultPoint9, i2, i2))
    {
      return new DetectorResult(localBitMatrix, new ResultPoint[] { localResultPoint7, localResultPoint6, localResultPoint5, localResultPoint9 });
      if (!localHashMap.containsKey(localResultPoint2))
      {
        localResultPoint8 = localResultPoint2;
        break;
      }
      if (!localHashMap.containsKey(localResultPoint3))
      {
        localResultPoint8 = localResultPoint3;
        break;
      }
      localResultPoint8 = localResultPoint4;
      break;
      localResultPoint9 = a(localResultPoint6, localResultPoint5, localResultPoint7, localResultPoint8, Math.min(m, k));
      if (localResultPoint9 == null) {
        localResultPoint9 = localResultPoint8;
      }
      i2 = 1 + Math.max(b(localResultPoint7, localResultPoint9).c(), b(localResultPoint5, localResultPoint9).c());
      if ((i2 & 0x1) == 1) {
        i2++;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.detector.Detector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */