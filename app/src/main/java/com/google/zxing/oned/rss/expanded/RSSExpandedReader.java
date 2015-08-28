package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader
  extends AbstractRSSReader
{
  private static final int[] a = { 7, 5, 4, 3, 1 };
  private static final int[] b = { 4, 20, 52, 104, 204 };
  private static final int[] c = { 0, 348, 1388, 2948, 3988 };
  private static final int[][] d = { { 1, 8, 4, 1 }, { 3, 6, 4, 1 }, { 3, 4, 6, 1 }, { 3, 2, 8, 1 }, { 2, 6, 5, 1 }, { 2, 2, 9, 1 } };
  private static final int[][] e = { { 1, 3, 9, 27, 81, 32, 96, 77 }, { 20, 60, 180, 118, 143, 7, 21, 63 }, { 189, 145, 13, 39, 117, 140, 209, 205 }, { 193, 157, 49, 147, 19, 57, 171, 91 }, { 62, 186, 136, 197, 169, 85, 44, 132 }, { 185, 133, 188, 142, 4, 12, 36, 108 }, { 113, 128, 173, 97, 80, 29, 87, 50 }, { 150, 28, 84, 41, 123, 158, 52, 156 }, { 46, 138, 203, 187, 139, 206, 196, 166 }, { 76, 17, 51, 153, 37, 111, 122, 155 }, { 43, 129, 176, 106, 107, 110, 119, 146 }, { 16, 48, 144, 10, 30, 90, 59, 177 }, { 109, 116, 137, 200, 178, 112, 125, 164 }, { 70, 210, 208, 202, 184, 130, 179, 115 }, { 134, 191, 151, 31, 93, 68, 204, 190 }, { 148, 22, 66, 198, 172, 94, 71, 2 }, { 6, 18, 54, 162, 64, 192, 154, 40 }, { 120, 149, 25, 75, 14, 42, 126, 167 }, { 79, 26, 78, 23, 69, 207, 199, 175 }, { 103, 98, 83, 38, 114, 131, 182, 124 }, { 161, 61, 183, 127, 170, 88, 53, 159 }, { 55, 165, 73, 8, 24, 72, 5, 15 }, { 45, 135, 194, 160, 58, 174, 100, 89 } };
  private static final int[][] f = { { 0, 0 }, { 0, 1, 1 }, { 0, 2, 1, 3 }, { 0, 4, 1, 3, 2 }, { 0, 4, 1, 3, 3, 5 }, { 0, 4, 1, 3, 4, 5, 5 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 4, 4 }, { 0, 0, 1, 1, 2, 2, 3, 4, 5, 5 }, { 0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5 } };
  private final List<ExpandedPair> g = new ArrayList(11);
  private final List<ExpandedRow> h = new ArrayList();
  private final int[] i = new int[2];
  private boolean j = false;
  
  private static int a(BitArray paramBitArray, int paramInt)
  {
    if (paramBitArray.a(paramInt)) {
      return paramBitArray.c(paramBitArray.d(paramInt));
    }
    return paramBitArray.d(paramBitArray.c(paramInt));
  }
  
  static Result a(List<ExpandedPair> paramList)
  {
    String str = AbstractExpandedDecoder.a(BitArrayBuilder.a(paramList)).a();
    ResultPoint[] arrayOfResultPoint1 = ((ExpandedPair)paramList.get(0)).c().c();
    ResultPoint[] arrayOfResultPoint2 = ((ExpandedPair)paramList.get(-1 + paramList.size())).c().c();
    ResultPoint[] arrayOfResultPoint3 = new ResultPoint[4];
    arrayOfResultPoint3[0] = arrayOfResultPoint1[0];
    arrayOfResultPoint3[1] = arrayOfResultPoint1[1];
    arrayOfResultPoint3[2] = arrayOfResultPoint2[0];
    arrayOfResultPoint3[3] = arrayOfResultPoint2[1];
    return new Result(str, null, arrayOfResultPoint3, BarcodeFormat.n);
  }
  
  private FinderPattern a(BitArray paramBitArray, int paramInt, boolean paramBoolean)
  {
    int k;
    int n;
    int m;
    if (paramBoolean)
    {
      for (int i2 = -1 + this.i[0]; (i2 >= 0) && (!paramBitArray.a(i2)); i2--) {}
      k = i2 + 1;
      n = this.i[0] - k;
      m = this.i[1];
    }
    for (;;)
    {
      int[] arrayOfInt = b();
      System.arraycopy(arrayOfInt, 0, arrayOfInt, 1, -1 + arrayOfInt.length);
      arrayOfInt[0] = n;
      try
      {
        int i1 = a(arrayOfInt, d);
        return new FinderPattern(i1, new int[] { k, m }, k, m, paramInt);
      }
      catch (NotFoundException localNotFoundException) {}
      k = this.i[0];
      m = paramBitArray.d(1 + this.i[1]);
      n = m - this.i[1];
    }
    return null;
  }
  
  private List<ExpandedPair> a(List<ExpandedRow> paramList, int paramInt)
  {
    ExpandedRow localExpandedRow;
    if (paramInt < this.h.size())
    {
      localExpandedRow = (ExpandedRow)this.h.get(paramInt);
      this.g.clear();
      int k = paramList.size();
      for (int m = 0; m < k; m++) {
        this.g.addAll(((ExpandedRow)paramList.get(m)).a());
      }
      this.g.addAll(localExpandedRow.a());
      if (b(this.g)) {}
    }
    for (;;)
    {
      paramInt++;
      break;
      if (h()) {
        return this.g;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      localArrayList.add(localExpandedRow);
      int n = paramInt + 1;
      try
      {
        List localList = a(localArrayList, n);
        return localList;
      }
      catch (NotFoundException localNotFoundException) {}
      throw NotFoundException.a();
    }
  }
  
  private List<ExpandedPair> a(boolean paramBoolean)
  {
    Object localObject = null;
    if (this.h.size() > 25) {
      this.h.clear();
    }
    for (;;)
    {
      return localObject;
      this.g.clear();
      if (paramBoolean) {
        Collections.reverse(this.h);
      }
      try
      {
        List localList = a(new ArrayList(), 0);
        localObject = localList;
        if (!paramBoolean) {
          continue;
        }
        Collections.reverse(this.h);
        return localObject;
      }
      catch (NotFoundException localNotFoundException)
      {
        for (;;)
        {
          localObject = null;
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    int k = 1;
    int m = a(f());
    int n = a(g());
    int i1 = m + n - paramInt;
    int i2;
    int i3;
    label47:
    int i4;
    int i5;
    if ((m & 0x1) == k)
    {
      i2 = k;
      if ((n & 0x1) != 0) {
        break label98;
      }
      i3 = k;
      if (m <= 13) {
        break label104;
      }
      i4 = k;
      i5 = 0;
    }
    for (;;)
    {
      label59:
      int i7;
      int i6;
      if (n > 13)
      {
        i7 = 0;
        i6 = k;
      }
      for (;;)
      {
        label98:
        label104:
        int i9;
        int i8;
        if (i1 == k) {
          if (i2 != 0)
          {
            if (i3 != 0)
            {
              throw NotFoundException.a();
              i2 = 0;
              break;
              i3 = 0;
              break label47;
              if (m >= 4) {
                break label403;
              }
              i5 = k;
              i4 = 0;
              break label59;
              if (n >= 4) {
                break label394;
              }
              i7 = k;
              i6 = 0;
              continue;
            }
            i9 = i5;
            int i12 = k;
            k = i7;
            i8 = i12;
          }
        }
        for (;;)
        {
          if (i9 != 0)
          {
            if (i8 != 0)
            {
              throw NotFoundException.a();
              if (i3 == 0) {
                throw NotFoundException.a();
              }
              i6 = k;
              k = i7;
              i8 = i4;
              i9 = i5;
              continue;
              if (i1 == -1)
              {
                if (i2 != 0)
                {
                  if (i3 != 0) {
                    throw NotFoundException.a();
                  }
                  int i11 = i7;
                  i8 = i4;
                  i9 = k;
                  k = i11;
                }
                else
                {
                  if (i3 == 0) {
                    throw NotFoundException.a();
                  }
                  i8 = i4;
                  i9 = i5;
                }
              }
              else if (i1 == 0)
              {
                if (i2 != 0)
                {
                  if (i3 == 0) {
                    throw NotFoundException.a();
                  }
                  if (m < n)
                  {
                    i6 = k;
                    int i10 = i7;
                    i8 = i4;
                    i9 = k;
                    k = i10;
                  }
                  else
                  {
                    i8 = k;
                    i9 = i5;
                  }
                }
                else if (i3 != 0)
                {
                  throw NotFoundException.a();
                }
              }
              else {
                throw NotFoundException.a();
              }
            }
            else
            {
              a(f(), d());
            }
          }
          else
          {
            if (i8 != 0) {
              b(f(), d());
            }
            if (k != 0)
            {
              if (i6 != 0) {
                throw NotFoundException.a();
              }
              a(g(), d());
            }
            if (i6 != 0) {
              b(g(), e());
            }
            return;
            k = i7;
            i8 = i4;
            i9 = i5;
          }
        }
        label394:
        i6 = 0;
        i7 = 0;
      }
      label403:
      i4 = 0;
      i5 = 0;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int k = 0;
    int m = 0;
    int n = this.h.size();
    boolean bool1 = false;
    ExpandedRow localExpandedRow;
    if (m < n)
    {
      localExpandedRow = (ExpandedRow)this.h.get(m);
      if (localExpandedRow.b() > paramInt) {
        bool1 = localExpandedRow.a(this.g);
      }
    }
    else
    {
      if ((!bool1) && (k == 0)) {
        break label92;
      }
    }
    label92:
    while (a(this.g, this.h))
    {
      return;
      boolean bool2 = localExpandedRow.a(this.g);
      m++;
      k = bool2;
      break;
    }
    this.h.add(m, new ExpandedRow(this.g, paramInt, paramBoolean));
    a(this.g, this.h);
  }
  
  private static void a(List<ExpandedPair> paramList, List<ExpandedRow> paramList1)
  {
    Iterator localIterator1 = paramList1.iterator();
    label143:
    label149:
    for (;;)
    {
      label55:
      int m;
      if (localIterator1.hasNext())
      {
        ExpandedRow localExpandedRow = (ExpandedRow)localIterator1.next();
        if (localExpandedRow.a().size() != paramList.size())
        {
          Iterator localIterator2 = localExpandedRow.a().iterator();
          if (localIterator2.hasNext())
          {
            ExpandedPair localExpandedPair = (ExpandedPair)localIterator2.next();
            Iterator localIterator3 = paramList.iterator();
            while (localIterator3.hasNext()) {
              if (localExpandedPair.equals((ExpandedPair)localIterator3.next()))
              {
                m = 1;
                label116:
                if (m != 0) {
                  break label143;
                }
              }
            }
          }
        }
      }
      else
      {
        for (int k = 0;; k = 1)
        {
          if (k == 0) {
            break label149;
          }
          localIterator1.remove();
          break;
          return;
          m = 0;
          break label116;
          break label55;
        }
      }
    }
  }
  
  private static boolean a(FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramFinderPattern.a() != 0) || (!paramBoolean1) || (!paramBoolean2);
  }
  
  private static boolean a(Iterable<ExpandedPair> paramIterable, Iterable<ExpandedRow> paramIterable1)
  {
    Iterator localIterator1 = paramIterable1.iterator();
    label98:
    label119:
    label121:
    label125:
    for (;;)
    {
      int m;
      if (localIterator1.hasNext())
      {
        ExpandedRow localExpandedRow = (ExpandedRow)localIterator1.next();
        Iterator localIterator2 = paramIterable.iterator();
        if (!localIterator2.hasNext()) {
          break label121;
        }
        ExpandedPair localExpandedPair = (ExpandedPair)localIterator2.next();
        Iterator localIterator3 = localExpandedRow.a().iterator();
        while (localIterator3.hasNext()) {
          if (localExpandedPair.equals((ExpandedPair)localIterator3.next()))
          {
            m = 1;
            if (m != 0) {
              break label119;
            }
          }
        }
      }
      for (int k = 0;; k = 1)
      {
        if (k == 0) {
          break label125;
        }
        return true;
        return false;
        m = 0;
        break label98;
        break;
      }
    }
  }
  
  private void b(BitArray paramBitArray, List<ExpandedPair> paramList, int paramInt)
  {
    int[] arrayOfInt = b();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int k = paramBitArray.a();
    int m;
    label50:
    label65:
    int n;
    int i1;
    label71:
    label90:
    int i2;
    int i4;
    int i5;
    int i6;
    if (paramInt >= 0)
    {
      if (paramList.size() % 2 == 0) {
        break label194;
      }
      m = 1;
      if (this.j)
      {
        if (m != 0) {
          break label200;
        }
        m = 1;
      }
      n = 0;
      i1 = paramInt;
      if (i1 < k)
      {
        if (paramBitArray.a(i1)) {
          break label206;
        }
        n = 1;
        if (n != 0) {
          break label212;
        }
      }
      i2 = i1;
      int i3 = i1;
      i4 = 0;
      i5 = n;
      i6 = i3;
      label114:
      if (i2 >= k) {
        break label341;
      }
      if ((i5 ^ paramBitArray.a(i2)) == 0) {
        break label218;
      }
      arrayOfInt[i4] = (1 + arrayOfInt[i4]);
    }
    for (;;)
    {
      i2++;
      break label114;
      if (paramList.isEmpty())
      {
        paramInt = 0;
        break;
      }
      paramInt = ((ExpandedPair)paramList.get(-1 + paramList.size())).c().b()[1];
      break;
      label194:
      m = 0;
      break label50;
      label200:
      m = 0;
      break label65;
      label206:
      n = 0;
      break label90;
      label212:
      i1++;
      break label71;
      label218:
      if (i4 == 3)
      {
        if (m != 0) {
          c(arrayOfInt);
        }
        if (b(arrayOfInt))
        {
          this.i[0] = i6;
          this.i[1] = i2;
          return;
        }
        if (m != 0) {
          c(arrayOfInt);
        }
        i6 += arrayOfInt[0] + arrayOfInt[1];
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = arrayOfInt[3];
        arrayOfInt[2] = 0;
        arrayOfInt[3] = 0;
        i4--;
      }
      for (;;)
      {
        arrayOfInt[i4] = 1;
        if (i5 != 0) {
          break label335;
        }
        i5 = 1;
        break;
        i4++;
      }
      label335:
      i5 = 0;
    }
    label341:
    throw NotFoundException.a();
  }
  
  private static boolean b(List<ExpandedPair> paramList)
  {
    int[][] arrayOfInt = f;
    int k = arrayOfInt.length;
    int m = 0;
    boolean bool = false;
    int[] arrayOfInt1;
    if (m < k)
    {
      arrayOfInt1 = arrayOfInt[m];
      if (paramList.size() <= arrayOfInt1.length) {}
    }
    label103:
    for (;;)
    {
      m++;
      break;
      int n = 0;
      if (n < paramList.size()) {
        if (((ExpandedPair)paramList.get(n)).c().a() == arrayOfInt1[n]) {}
      }
      for (int i1 = 0;; i1 = 1)
      {
        if (i1 == 0) {
          break label103;
        }
        bool = true;
        return bool;
        n++;
        break;
      }
    }
  }
  
  private static void c(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    for (int m = 0; m < k / 2; m++)
    {
      int n = paramArrayOfInt[m];
      paramArrayOfInt[m] = paramArrayOfInt[(-1 + (k - m))];
      paramArrayOfInt[(-1 + (k - m))] = n;
    }
  }
  
  private boolean h()
  {
    int k = 1;
    ExpandedPair localExpandedPair1 = (ExpandedPair)this.g.get(0);
    DataCharacter localDataCharacter1 = localExpandedPair1.a();
    DataCharacter localDataCharacter2 = localExpandedPair1.b();
    if (localDataCharacter2 == null) {
      return false;
    }
    int m = localDataCharacter2.b();
    int n = 2;
    int i1 = m;
    for (int i2 = k; i2 < this.g.size(); i2++)
    {
      ExpandedPair localExpandedPair2 = (ExpandedPair)this.g.get(i2);
      i1 += localExpandedPair2.a().b();
      n++;
      DataCharacter localDataCharacter3 = localExpandedPair2.b();
      if (localDataCharacter3 != null)
      {
        i1 += localDataCharacter3.b();
        n++;
      }
    }
    if (i1 % 211 + 211 * (n - 4) == localDataCharacter1.a()) {}
    for (;;)
    {
      return k;
      k = 0;
    }
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    this.g.clear();
    this.j = false;
    try
    {
      Result localResult = a(a(paramInt, paramBitArray));
      return localResult;
    }
    catch (NotFoundException localNotFoundException)
    {
      this.g.clear();
      this.j = true;
    }
    return a(a(paramInt, paramBitArray));
  }
  
  DataCharacter a(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2)
  {
    int[] arrayOfInt1 = c();
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = 0;
    arrayOfInt1[4] = 0;
    arrayOfInt1[5] = 0;
    arrayOfInt1[6] = 0;
    arrayOfInt1[7] = 0;
    if (paramBoolean2) {
      b(paramBitArray, paramFinderPattern.b()[0], arrayOfInt1);
    }
    float f1;
    for (;;)
    {
      f1 = a(arrayOfInt1) / 17;
      float f2 = (paramFinderPattern.b()[1] - paramFinderPattern.b()[0]) / 15.0F;
      if (Math.abs(f1 - f2) / f2 <= 0.3F) {
        break;
      }
      throw NotFoundException.a();
      a(paramBitArray, paramFinderPattern.b()[1], arrayOfInt1);
      int k = 0;
      for (int m = -1 + arrayOfInt1.length; k < m; m--)
      {
        int n = arrayOfInt1[k];
        arrayOfInt1[k] = arrayOfInt1[m];
        arrayOfInt1[m] = n;
        k++;
      }
    }
    int[] arrayOfInt2 = f();
    int[] arrayOfInt3 = g();
    float[] arrayOfFloat1 = d();
    float[] arrayOfFloat2 = e();
    int i1 = 0;
    if (i1 < arrayOfInt1.length)
    {
      float f3 = 1.0F * arrayOfInt1[i1] / f1;
      int i22 = (int)(0.5F + f3);
      label260:
      int i23;
      if (i22 < 1)
      {
        if (f3 < 0.3F) {
          throw NotFoundException.a();
        }
        i22 = 1;
        i23 = i1 >> 1;
        if ((i1 & 0x1) != 0) {
          break label324;
        }
        arrayOfInt2[i23] = i22;
        arrayOfFloat1[i23] = (f3 - i22);
      }
      for (;;)
      {
        i1++;
        break;
        if (i22 <= 8) {
          break label260;
        }
        if (f3 > 8.7F) {
          throw NotFoundException.a();
        }
        i22 = 8;
        break label260;
        label324:
        arrayOfInt3[i23] = i22;
        arrayOfFloat2[i23] = (f3 - i22);
      }
    }
    a(17);
    int i2 = 4 * paramFinderPattern.a();
    int i3;
    int i4;
    if (paramBoolean1)
    {
      i3 = 0;
      i4 = i2 + i3;
      if (!paramBoolean2) {
        break label470;
      }
    }
    int i6;
    int i8;
    int i10;
    label470:
    for (int i5 = 0;; i5 = 1)
    {
      i6 = -1 + (i5 + i4);
      int i7 = -1 + arrayOfInt2.length;
      i8 = 0;
      int i9 = i7;
      i10 = 0;
      while (i9 >= 0)
      {
        if (a(paramFinderPattern, paramBoolean1, paramBoolean2)) {
          i10 += e[i6][(i9 * 2)] * arrayOfInt2[i9];
        }
        int i21 = i8 + arrayOfInt2[i9];
        i9--;
        i8 = i21;
      }
      i3 = 2;
      break;
    }
    int i11 = -1 + arrayOfInt3.length;
    int i12 = 0;
    for (int i13 = i11; i13 >= 0; i13--) {
      if (a(paramFinderPattern, paramBoolean1, paramBoolean2)) {
        i12 += e[i6][(1 + i13 * 2)] * arrayOfInt3[i13];
      }
    }
    int i14 = i10 + i12;
    if (((i8 & 0x1) != 0) || (i8 > 13) || (i8 < 4)) {
      throw NotFoundException.a();
    }
    int i15 = (13 - i8) / 2;
    int i16 = a[i15];
    int i17 = 9 - i16;
    int i18 = RSSUtils.a(arrayOfInt2, i16, true);
    int i19 = RSSUtils.a(arrayOfInt3, i17, false);
    int i20 = b[i15];
    return new DataCharacter(c[i15] + (i19 + i18 * i20), i14);
  }
  
  ExpandedPair a(BitArray paramBitArray, List<ExpandedPair> paramList, int paramInt)
  {
    boolean bool1;
    boolean bool3;
    if (paramList.size() % 2 == 0)
    {
      bool1 = true;
      if (!this.j) {
        break label184;
      }
      if (bool1) {
        break label133;
      }
      bool3 = true;
    }
    label29:
    label184:
    for (boolean bool2 = bool3;; bool2 = bool1)
    {
      int k = -1;
      int m = 1;
      FinderPattern localFinderPattern;
      DataCharacter localDataCharacter1;
      for (;;)
      {
        b(paramBitArray, paramList, k);
        localFinderPattern = a(paramBitArray, paramInt, bool2);
        if (localFinderPattern == null) {
          k = a(paramBitArray, this.i[0]);
        }
        for (;;)
        {
          if (m != 0) {
            break label143;
          }
          localDataCharacter1 = a(paramBitArray, localFinderPattern, bool2, true);
          if ((paramList.isEmpty()) || (!((ExpandedPair)paramList.get(-1 + paramList.size())).d())) {
            break label145;
          }
          throw NotFoundException.a();
          bool1 = false;
          break;
          bool3 = false;
          break label29;
          m = 0;
        }
      }
      try
      {
        DataCharacter localDataCharacter3 = a(paramBitArray, localFinderPattern, bool2, false);
        localDataCharacter2 = localDataCharacter3;
        return new ExpandedPair(localDataCharacter1, localDataCharacter2, localFinderPattern, true);
      }
      catch (NotFoundException localNotFoundException)
      {
        for (;;)
        {
          DataCharacter localDataCharacter2 = null;
        }
      }
    }
  }
  
  List<ExpandedPair> a(int paramInt, BitArray paramBitArray)
  {
    try
    {
      for (;;)
      {
        ExpandedPair localExpandedPair = a(paramBitArray, this.g, paramInt);
        this.g.add(localExpandedPair);
      }
      localList = this.g;
    }
    catch (NotFoundException localNotFoundException)
    {
      if (this.g.isEmpty()) {
        throw localNotFoundException;
      }
      if (!h()) {
        break label58;
      }
    }
    List localList;
    return localList;
    label58:
    if (!this.h.isEmpty()) {}
    for (int k = 1;; k = 0)
    {
      a(paramInt, false);
      if (k != 0)
      {
        localList = a(false);
        if (localList != null) {
          break;
        }
        localList = a(true);
        if (localList != null) {
          break;
        }
      }
      throw NotFoundException.a();
    }
  }
  
  public void a()
  {
    this.g.clear();
    this.h.clear();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.RSSExpandedReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */