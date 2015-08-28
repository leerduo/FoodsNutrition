package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder
{
  private final BitMatrix a;
  private final List<FinderPattern> b;
  private boolean c;
  private final int[] d;
  private final ResultPointCallback e;
  
  public FinderPatternFinder(BitMatrix paramBitMatrix, ResultPointCallback paramResultPointCallback)
  {
    this.a = paramBitMatrix;
    this.b = new ArrayList();
    this.d = new int[5];
    this.e = paramResultPointCallback;
  }
  
  private static float a(int[] paramArrayOfInt, int paramInt)
  {
    return paramInt - paramArrayOfInt[4] - paramArrayOfInt[3] - paramArrayOfInt[2] / 2.0F;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = a();
    for (int i = 0; (paramInt1 >= i) && (paramInt2 >= i) && (this.a.a(paramInt2 - i, paramInt1 - i)); i++) {
      arrayOfInt[2] = (1 + arrayOfInt[2]);
    }
    if ((paramInt1 < i) || (paramInt2 < i)) {
      return false;
    }
    while ((paramInt1 >= i) && (paramInt2 >= i) && (!this.a.a(paramInt2 - i, paramInt1 - i)) && (arrayOfInt[1] <= paramInt3))
    {
      arrayOfInt[1] = (1 + arrayOfInt[1]);
      i++;
    }
    if ((paramInt1 < i) || (paramInt2 < i) || (arrayOfInt[1] > paramInt3)) {
      return false;
    }
    while ((paramInt1 >= i) && (paramInt2 >= i) && (this.a.a(paramInt2 - i, paramInt1 - i)) && (arrayOfInt[0] <= paramInt3))
    {
      arrayOfInt[0] = (1 + arrayOfInt[0]);
      i++;
    }
    if (arrayOfInt[0] > paramInt3) {
      return false;
    }
    int j = this.a.g();
    int k = this.a.f();
    for (int m = 1; (paramInt1 + m < j) && (paramInt2 + m < k) && (this.a.a(paramInt2 + m, paramInt1 + m)); m++) {
      arrayOfInt[2] = (1 + arrayOfInt[2]);
    }
    if ((paramInt1 + m >= j) || (paramInt2 + m >= k)) {
      return false;
    }
    while ((paramInt1 + m < j) && (paramInt2 + m < k) && (!this.a.a(paramInt2 + m, paramInt1 + m)) && (arrayOfInt[3] < paramInt3))
    {
      arrayOfInt[3] = (1 + arrayOfInt[3]);
      m++;
    }
    if ((paramInt1 + m >= j) || (paramInt2 + m >= k) || (arrayOfInt[3] >= paramInt3)) {
      return false;
    }
    while ((paramInt1 + m < j) && (paramInt2 + m < k) && (this.a.a(paramInt2 + m, paramInt1 + m)) && (arrayOfInt[4] < paramInt3))
    {
      arrayOfInt[4] = (1 + arrayOfInt[4]);
      m++;
    }
    if (arrayOfInt[4] >= paramInt3) {
      return false;
    }
    return (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) < paramInt4 * 2) && (a(arrayOfInt));
  }
  
  protected static boolean a(int[] paramArrayOfInt)
  {
    boolean bool = true;
    int i = 0;
    int j = 0;
    if (i < 5)
    {
      n = paramArrayOfInt[i];
      if (n != 0) {}
    }
    while (j < 7)
    {
      int n;
      return false;
      j += n;
      i++;
      break;
    }
    int k = (j << 8) / 7;
    int m = k / 2;
    if ((Math.abs(k - (paramArrayOfInt[0] << 8)) < m) && (Math.abs(k - (paramArrayOfInt[bool] << 8)) < m) && (Math.abs(k * 3 - (paramArrayOfInt[2] << 8)) < m * 3) && (Math.abs(k - (paramArrayOfInt[3] << 8)) < m) && (Math.abs(k - (paramArrayOfInt[4] << 8)) < m)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private int[] a()
  {
    this.d[0] = 0;
    this.d[1] = 0;
    this.d[2] = 0;
    this.d[3] = 0;
    this.d[4] = 0;
    return this.d;
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitMatrix localBitMatrix = this.a;
    int i = localBitMatrix.g();
    int[] arrayOfInt = a();
    for (int j = paramInt1; (j >= 0) && (localBitMatrix.a(paramInt2, j)); j--) {
      arrayOfInt[2] = (1 + arrayOfInt[2]);
    }
    if (j < 0) {}
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (0.0F / 0.0F);
              while ((j >= 0) && (!localBitMatrix.a(paramInt2, j)) && (arrayOfInt[1] <= paramInt3))
              {
                arrayOfInt[1] = (1 + arrayOfInt[1]);
                j--;
              }
            } while ((j < 0) || (arrayOfInt[1] > paramInt3));
            while ((j >= 0) && (localBitMatrix.a(paramInt2, j)) && (arrayOfInt[0] <= paramInt3))
            {
              arrayOfInt[0] = (1 + arrayOfInt[0]);
              j--;
            }
          } while (arrayOfInt[0] > paramInt3);
          for (k = paramInt1 + 1; (k < i) && (localBitMatrix.a(paramInt2, k)); k++) {
            arrayOfInt[2] = (1 + arrayOfInt[2]);
          }
        } while (k == i);
        while ((k < i) && (!localBitMatrix.a(paramInt2, k)) && (arrayOfInt[3] < paramInt3))
        {
          arrayOfInt[3] = (1 + arrayOfInt[3]);
          k++;
        }
      } while ((k == i) || (arrayOfInt[3] >= paramInt3));
      while ((k < i) && (localBitMatrix.a(paramInt2, k)) && (arrayOfInt[4] < paramInt3))
      {
        arrayOfInt[4] = (1 + arrayOfInt[4]);
        k++;
      }
    } while ((arrayOfInt[4] >= paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) >= paramInt4 * 2) || (!a(arrayOfInt)));
    return a(arrayOfInt, k);
  }
  
  private int b()
  {
    if (this.b.size() <= 1) {
      return 0;
    }
    Object localObject1 = null;
    Iterator localIterator = this.b.iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (FinderPattern)localIterator.next();
      if (((FinderPattern)localObject2).d() < 2) {
        break label99;
      }
      if (localObject1 != null) {}
    }
    for (;;)
    {
      localObject1 = localObject2;
      break;
      this.c = true;
      return (int)(Math.abs(localObject1.a() - ((FinderPattern)localObject2).a()) - Math.abs(localObject1.b() - ((FinderPattern)localObject2).b())) / 2;
      return 0;
      label99:
      localObject2 = localObject1;
    }
  }
  
  private float c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitMatrix localBitMatrix = this.a;
    int i = localBitMatrix.f();
    int[] arrayOfInt = a();
    for (int j = paramInt1; (j >= 0) && (localBitMatrix.a(j, paramInt2)); j--) {
      arrayOfInt[2] = (1 + arrayOfInt[2]);
    }
    if (j < 0) {}
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (0.0F / 0.0F);
              while ((j >= 0) && (!localBitMatrix.a(j, paramInt2)) && (arrayOfInt[1] <= paramInt3))
              {
                arrayOfInt[1] = (1 + arrayOfInt[1]);
                j--;
              }
            } while ((j < 0) || (arrayOfInt[1] > paramInt3));
            while ((j >= 0) && (localBitMatrix.a(j, paramInt2)) && (arrayOfInt[0] <= paramInt3))
            {
              arrayOfInt[0] = (1 + arrayOfInt[0]);
              j--;
            }
          } while (arrayOfInt[0] > paramInt3);
          for (k = paramInt1 + 1; (k < i) && (localBitMatrix.a(k, paramInt2)); k++) {
            arrayOfInt[2] = (1 + arrayOfInt[2]);
          }
        } while (k == i);
        while ((k < i) && (!localBitMatrix.a(k, paramInt2)) && (arrayOfInt[3] < paramInt3))
        {
          arrayOfInt[3] = (1 + arrayOfInt[3]);
          k++;
        }
      } while ((k == i) || (arrayOfInt[3] >= paramInt3));
      while ((k < i) && (localBitMatrix.a(k, paramInt2)) && (arrayOfInt[4] < paramInt3))
      {
        arrayOfInt[4] = (1 + arrayOfInt[4]);
        k++;
      }
    } while ((arrayOfInt[4] >= paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) >= paramInt4) || (!a(arrayOfInt)));
    return a(arrayOfInt, k);
  }
  
  private boolean c()
  {
    float f1 = 0.0F;
    int i = this.b.size();
    Iterator localIterator1 = this.b.iterator();
    float f2 = 0.0F;
    int j = 0;
    int m;
    float f4;
    if (localIterator1.hasNext())
    {
      FinderPattern localFinderPattern = (FinderPattern)localIterator1.next();
      if (localFinderPattern.d() < 2) {
        break label161;
      }
      m = j + 1;
      f4 = f2 + localFinderPattern.c();
    }
    for (int k = m;; k = j)
    {
      j = k;
      f2 = f4;
      break;
      if (j < 3) {}
      do
      {
        return false;
        float f3 = f2 / i;
        Iterator localIterator2 = this.b.iterator();
        while (localIterator2.hasNext()) {
          f1 += Math.abs(((FinderPattern)localIterator2.next()).c() - f3);
        }
      } while (f1 > 0.05F * f2);
      return true;
      label161:
      f4 = f2;
    }
  }
  
  private FinderPattern[] d()
  {
    float f1 = 0.0F;
    int i = this.b.size();
    if (i < 3) {
      throw NotFoundException.a();
    }
    if (i > 3)
    {
      Iterator localIterator2 = this.b.iterator();
      float f3 = 0.0F;
      float f4 = 0.0F;
      while (localIterator2.hasNext())
      {
        float f8 = ((FinderPattern)localIterator2.next()).c();
        f4 += f8;
        f3 += f8 * f8;
      }
      float f5 = f4 / i;
      float f6 = (float)Math.sqrt(f3 / i - f5 * f5);
      Collections.sort(this.b, new FinderPatternFinder.FurthestFromAverageComparator(f5, null));
      float f7 = Math.max(0.2F * f5, f6);
      for (int j = 0; (j < this.b.size()) && (this.b.size() > 3); j++) {
        if (Math.abs(((FinderPattern)this.b.get(j)).c() - f5) > f7)
        {
          this.b.remove(j);
          j--;
        }
      }
    }
    if (this.b.size() > 3)
    {
      Iterator localIterator1 = this.b.iterator();
      while (localIterator1.hasNext()) {
        f1 += ((FinderPattern)localIterator1.next()).c();
      }
      float f2 = f1 / this.b.size();
      Collections.sort(this.b, new FinderPatternFinder.CenterComparator(f2, null));
      this.b.subList(3, this.b.size()).clear();
    }
    FinderPattern[] arrayOfFinderPattern = new FinderPattern[3];
    arrayOfFinderPattern[0] = ((FinderPattern)this.b.get(0));
    arrayOfFinderPattern[1] = ((FinderPattern)this.b.get(1));
    arrayOfFinderPattern[2] = ((FinderPattern)this.b.get(2));
    return arrayOfFinderPattern;
  }
  
  final FinderPatternInfo a(Map<DecodeHintType, ?> paramMap)
  {
    int i;
    boolean bool1;
    label36:
    int k;
    boolean bool2;
    int[] arrayOfInt;
    int n;
    int i1;
    int i2;
    int i3;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.d)))
    {
      i = 1;
      if ((paramMap == null) || (!paramMap.containsKey(DecodeHintType.b))) {
        break label193;
      }
      bool1 = true;
      int j = this.a.g();
      k = this.a.f();
      int m = j * 3 / 228;
      if ((m < 3) || (i != 0)) {
        m = 3;
      }
      bool2 = false;
      arrayOfInt = new int[5];
      n = m - 1;
      i1 = m;
      if ((n >= j) || (bool2)) {
        break label499;
      }
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      arrayOfInt[2] = 0;
      arrayOfInt[3] = 0;
      arrayOfInt[4] = 0;
      i2 = 0;
      i3 = 0;
      label138:
      if (i3 >= k) {
        break label448;
      }
      if (!this.a.a(i3, n)) {
        break label198;
      }
      if ((i2 & 0x1) == 1) {
        i2++;
      }
      arrayOfInt[i2] = (1 + arrayOfInt[i2]);
    }
    label182:
    label193:
    label198:
    boolean bool3;
    for (;;)
    {
      i3++;
      break label138;
      i = 0;
      break;
      bool1 = false;
      break label36;
      if ((i2 & 0x1) != 0) {
        break label433;
      }
      if (i2 != 4) {
        break label415;
      }
      if (!a(arrayOfInt)) {
        break label375;
      }
      if (!a(arrayOfInt, n, i3, bool1)) {
        break label335;
      }
      i1 = 2;
      if (!this.c) {
        break label284;
      }
      bool3 = c();
      label249:
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      arrayOfInt[2] = 0;
      arrayOfInt[3] = 0;
      arrayOfInt[4] = 0;
      bool2 = bool3;
      i2 = 0;
    }
    label284:
    int i4 = b();
    int i6;
    int i5;
    if (i4 > arrayOfInt[2])
    {
      i6 = n + (i4 - arrayOfInt[2] - i1);
      i5 = k - 1;
    }
    for (;;)
    {
      n = i6;
      i3 = i5;
      bool3 = bool2;
      break label249;
      label335:
      arrayOfInt[0] = arrayOfInt[2];
      arrayOfInt[1] = arrayOfInt[3];
      arrayOfInt[2] = arrayOfInt[4];
      arrayOfInt[3] = 1;
      arrayOfInt[4] = 0;
      i2 = 3;
      break label182;
      label375:
      arrayOfInt[0] = arrayOfInt[2];
      arrayOfInt[1] = arrayOfInt[3];
      arrayOfInt[2] = arrayOfInt[4];
      arrayOfInt[3] = 1;
      arrayOfInt[4] = 0;
      i2 = 3;
      break label182;
      label415:
      i2++;
      arrayOfInt[i2] = (1 + arrayOfInt[i2]);
      break label182;
      label433:
      arrayOfInt[i2] = (1 + arrayOfInt[i2]);
      break label182;
      label448:
      if ((a(arrayOfInt)) && (a(arrayOfInt, n, k, bool1)))
      {
        i1 = arrayOfInt[0];
        if (this.c) {
          bool2 = c();
        }
      }
      n += i1;
      break;
      label499:
      FinderPattern[] arrayOfFinderPattern = d();
      ResultPoint.a(arrayOfFinderPattern);
      return new FinderPatternInfo(arrayOfFinderPattern);
      i5 = i3;
      i6 = n;
    }
  }
  
  protected final boolean a(int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2] + paramArrayOfInt[3] + paramArrayOfInt[4];
    float f1 = a(paramArrayOfInt, paramInt2);
    float f2 = b(paramInt1, (int)f1, paramArrayOfInt[2], i);
    boolean bool1 = Float.isNaN(f2);
    boolean bool2 = false;
    float f3;
    float f4;
    if (!bool1)
    {
      f3 = c((int)f1, (int)f2, paramArrayOfInt[2], i);
      boolean bool3 = Float.isNaN(f3);
      bool2 = false;
      if (!bool3) {
        if (paramBoolean)
        {
          boolean bool4 = a((int)f2, (int)f3, paramArrayOfInt[2], i);
          bool2 = false;
          if (!bool4) {}
        }
        else
        {
          f4 = i / 7.0F;
        }
      }
    }
    for (int j = 0;; j++)
    {
      int k = this.b.size();
      int m = 0;
      if (j < k)
      {
        FinderPattern localFinderPattern2 = (FinderPattern)this.b.get(j);
        if (localFinderPattern2.a(f4, f2, f3))
        {
          this.b.set(j, localFinderPattern2.b(f2, f3, f4));
          m = 1;
        }
      }
      else
      {
        if (m == 0)
        {
          FinderPattern localFinderPattern1 = new FinderPattern(f3, f2, f4);
          this.b.add(localFinderPattern1);
          if (this.e != null) {
            this.e.a(localFinderPattern1);
          }
        }
        bool2 = true;
        return bool2;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */