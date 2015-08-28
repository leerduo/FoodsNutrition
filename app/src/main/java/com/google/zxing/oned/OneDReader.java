package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class OneDReader
  implements Reader
{
  protected static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
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
  
  protected static void a(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    Arrays.fill(paramArrayOfInt, 0, i, 0);
    int j = paramBitArray.a();
    if (paramInt >= j) {
      throw NotFoundException.a();
    }
    if (!paramBitArray.a(paramInt)) {}
    int m;
    int n;
    int i4;
    for (int k = 1;; k = 0)
    {
      m = k;
      n = 0;
      for (;;)
      {
        if (paramInt >= j) {
          break label162;
        }
        if ((m ^ paramBitArray.a(paramInt)) == 0) {
          break;
        }
        paramArrayOfInt[n] = (1 + paramArrayOfInt[n]);
        i4 = m;
        paramInt++;
        m = i4;
      }
    }
    int i1 = n + 1;
    if (i1 == i) {}
    for (;;)
    {
      if ((i1 != i) && ((i1 != i - 1) || (paramInt != j)))
      {
        throw NotFoundException.a();
        paramArrayOfInt[i1] = 1;
        if (m == 0) {}
        for (int i2 = 1;; i2 = 0)
        {
          int i3 = i1;
          i4 = i2;
          n = i3;
          break;
        }
      }
      return;
      label162:
      i1 = n;
    }
  }
  
  private Result b(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    int i = paramBinaryBitmap.a();
    int j = paramBinaryBitmap.b();
    BitArray localBitArray1 = new BitArray(i);
    int k = j >> 1;
    int m;
    int n;
    label55:
    int i1;
    int i2;
    label75:
    int i3;
    Object localObject1;
    Object localObject2;
    int i4;
    int i5;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.d)))
    {
      m = 1;
      if (m == 0) {
        break label147;
      }
      n = 8;
      i1 = Math.max(1, j >> n);
      if (m == 0) {
        break label153;
      }
      i2 = j;
      i3 = 0;
      localObject1 = localBitArray1;
      localObject2 = paramMap;
      if (i3 < i2)
      {
        i4 = i3 + 1 >> 1;
        if ((i3 & 0x1) != 0) {
          break label160;
        }
        i5 = 1;
        label110:
        if (i5 == 0) {
          break label166;
        }
      }
    }
    int i6;
    for (;;)
    {
      i6 = k + i4 * i1;
      if ((i6 >= 0) && (i6 < j)) {
        break label174;
      }
      throw NotFoundException.a();
      m = 0;
      break;
      label147:
      n = 5;
      break label55;
      label153:
      i2 = 15;
      break label75;
      label160:
      i5 = 0;
      break label110;
      label166:
      i4 = -i4;
    }
    for (;;)
    {
      try
      {
        label174:
        BitArray localBitArray2 = paramBinaryBitmap.a(i6, (BitArray)localObject1);
        localObject1 = localBitArray2;
        int i7 = 0;
        if (i7 < 2)
        {
          if (i7 != 1) {
            break label384;
          }
          ((BitArray)localObject1).e();
          if ((localObject2 == null) || (!((Map)localObject2).containsKey(DecodeHintType.j))) {
            break label384;
          }
          localObject3 = new EnumMap(DecodeHintType.class);
          ((Map)localObject3).putAll((Map)localObject2);
          ((Map)localObject3).remove(DecodeHintType.j);
          try
          {
            Result localResult = a(i6, (BitArray)localObject1, (Map)localObject3);
            if (i7 == 1)
            {
              localResult.a(ResultMetadataType.b, Integer.valueOf(180));
              ResultPoint[] arrayOfResultPoint = localResult.c();
              if (arrayOfResultPoint != null)
              {
                arrayOfResultPoint[0] = new ResultPoint(i - arrayOfResultPoint[0].a() - 1.0F, arrayOfResultPoint[0].b());
                arrayOfResultPoint[1] = new ResultPoint(i - arrayOfResultPoint[1].a() - 1.0F, arrayOfResultPoint[1].b());
              }
            }
            return localResult;
          }
          catch (ReaderException localReaderException)
          {
            i7++;
            localObject2 = localObject3;
          }
          continue;
        }
      }
      catch (NotFoundException localNotFoundException)
      {
        i3++;
      }
      label384:
      Object localObject3 = localObject2;
    }
  }
  
  protected static void b(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    boolean bool = paramBitArray.a(paramInt);
    while ((paramInt > 0) && (i >= 0))
    {
      paramInt--;
      if (paramBitArray.a(paramInt) != bool)
      {
        i--;
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    if (i >= 0) {
      throw NotFoundException.a();
    }
    a(paramBitArray, paramInt + 1, paramArrayOfInt);
  }
  
  public abstract Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap);
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    try
    {
      Result localResult2 = b(paramBinaryBitmap, paramMap);
      return localResult2;
    }
    catch (NotFoundException localNotFoundException)
    {
      if (paramMap == null) {
        break label192;
      }
    }
    int i;
    BinaryBitmap localBinaryBitmap;
    Result localResult1;
    Map localMap;
    if (paramMap.containsKey(DecodeHintType.d))
    {
      i = 1;
      if ((i == 0) || (!paramBinaryBitmap.d())) {
        break label201;
      }
      localBinaryBitmap = paramBinaryBitmap.e();
      localResult1 = b(localBinaryBitmap, paramMap);
      localMap = localResult1.e();
      if ((localMap == null) || (!localMap.containsKey(ResultMetadataType.b))) {
        break label203;
      }
    }
    label192:
    label201:
    label203:
    for (int j = (270 + ((Integer)localMap.get(ResultMetadataType.b)).intValue()) % 360;; j = 270)
    {
      localResult1.a(ResultMetadataType.b, Integer.valueOf(j));
      ResultPoint[] arrayOfResultPoint = localResult1.c();
      if (arrayOfResultPoint != null)
      {
        int k = localBinaryBitmap.b();
        int m = 0;
        for (;;)
        {
          if (m < arrayOfResultPoint.length)
          {
            arrayOfResultPoint[m] = new ResultPoint(k - arrayOfResultPoint[m].b() - 1.0F, arrayOfResultPoint[m].a());
            m++;
            continue;
            i = 0;
            break;
          }
        }
      }
      return localResult1;
      throw localNotFoundException;
    }
  }
  
  public void a() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.OneDReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */