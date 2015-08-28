package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class ITFReader
  extends OneDReader
{
  static final int[][] a = { { 1, 1, 3, 3, 1 }, { 3, 1, 1, 1, 3 }, { 1, 3, 1, 1, 3 }, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, { 3, 1, 3, 1, 1 }, { 1, 3, 3, 1, 1 }, { 1, 1, 1, 3, 3 }, { 3, 1, 1, 3, 1 }, { 1, 3, 1, 3, 1 } };
  private static final int[] b = { 6, 8, 10, 12, 14 };
  private static final int[] d = { 1, 1, 1, 1 };
  private static final int[] e = { 1, 1, 3 };
  private int c = -1;
  
  private static int a(int[] paramArrayOfInt)
  {
    int i = 107;
    int j = -1;
    int k = a.length;
    int m = 0;
    int n;
    if (m < k)
    {
      n = a(paramArrayOfInt, a[m], 199);
      if (n >= i) {
        break label62;
      }
      j = m;
    }
    for (;;)
    {
      m++;
      i = n;
      break;
      if (j >= 0) {
        return j;
      }
      throw NotFoundException.a();
      label62:
      n = i;
    }
  }
  
  private void a(BitArray paramBitArray, int paramInt)
  {
    int i = 10 * this.c;
    int j;
    int k;
    if (i < paramInt)
    {
      j = paramInt - 1;
      k = i;
    }
    for (int m = j;; m--)
    {
      if ((k <= 0) || (m < 0) || (paramBitArray.a(m)))
      {
        if (k == 0) {
          return;
        }
        throw NotFoundException.a();
        i = paramInt;
        break;
      }
      k--;
    }
  }
  
  private static void a(BitArray paramBitArray, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    int m;
    for (int i = paramInt1; i < paramInt2; i = m)
    {
      a(paramBitArray, i, arrayOfInt1);
      for (int j = 0; j < 5; j++)
      {
        int i1 = j << 1;
        arrayOfInt2[j] = arrayOfInt1[i1];
        arrayOfInt3[j] = arrayOfInt1[(i1 + 1)];
      }
      paramStringBuilder.append((char)(48 + a(arrayOfInt2)));
      paramStringBuilder.append((char)(48 + a(arrayOfInt3)));
      int k = arrayOfInt1.length;
      m = i;
      for (int n = 0; n < k; n++) {
        m += arrayOfInt1[n];
      }
    }
  }
  
  private static int c(BitArray paramBitArray)
  {
    int i = paramBitArray.a();
    int j = paramBitArray.c(0);
    if (j == i) {
      throw NotFoundException.a();
    }
    return j;
  }
  
  private static int[] c(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i];
    int j = paramBitArray.a();
    int k = paramInt;
    int m = 0;
    int n = 0;
    if (paramInt < j)
    {
      if ((n ^ paramBitArray.a(paramInt)) != 0) {
        arrayOfInt[m] = (1 + arrayOfInt[m]);
      }
      for (;;)
      {
        paramInt++;
        break;
        if (m == i - 1)
        {
          if (a(arrayOfInt, paramArrayOfInt, 199) < 107) {
            return new int[] { k, paramInt };
          }
          k += arrayOfInt[0] + arrayOfInt[1];
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i - 2);
          arrayOfInt[(i - 2)] = 0;
          arrayOfInt[(i - 1)] = 0;
          m--;
        }
        for (;;)
        {
          arrayOfInt[m] = 1;
          if (n != 0) {
            break label159;
          }
          n = 1;
          break;
          m++;
        }
        label159:
        n = 0;
      }
    }
    throw NotFoundException.a();
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt1 = a(paramBitArray);
    int[] arrayOfInt2 = b(paramBitArray);
    StringBuilder localStringBuilder = new StringBuilder(20);
    a(paramBitArray, arrayOfInt1[1], arrayOfInt2[0], localStringBuilder);
    String str = localStringBuilder.toString();
    if (paramMap != null) {}
    for (int[] arrayOfInt3 = (int[])paramMap.get(DecodeHintType.f);; arrayOfInt3 = null)
    {
      if (arrayOfInt3 == null) {
        arrayOfInt3 = b;
      }
      int i = str.length();
      int j = arrayOfInt3.length;
      int k = 0;
      int m = 0;
      int i1;
      if (k < j)
      {
        i1 = arrayOfInt3[k];
        if (i != i1) {}
      }
      for (int n = 1;; n = 0)
      {
        if ((n == 0) && (i > m)) {
          n = 1;
        }
        if (n == 0)
        {
          throw FormatException.a();
          if (i1 <= m) {
            break label218;
          }
        }
        for (;;)
        {
          k++;
          m = i1;
          break;
          ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
          arrayOfResultPoint[0] = new ResultPoint(arrayOfInt1[1], paramInt);
          arrayOfResultPoint[1] = new ResultPoint(arrayOfInt2[0], paramInt);
          return new Result(str, null, arrayOfResultPoint, BarcodeFormat.i);
          label218:
          i1 = m;
        }
      }
    }
  }
  
  int[] a(BitArray paramBitArray)
  {
    int[] arrayOfInt = c(paramBitArray, c(paramBitArray), d);
    this.c = (arrayOfInt[1] - arrayOfInt[0] >> 2);
    a(paramBitArray, arrayOfInt[0]);
    return arrayOfInt;
  }
  
  int[] b(BitArray paramBitArray)
  {
    paramBitArray.e();
    try
    {
      int[] arrayOfInt = c(paramBitArray, c(paramBitArray), e);
      a(paramBitArray, arrayOfInt[0]);
      int i = arrayOfInt[0];
      arrayOfInt[0] = (paramBitArray.a() - arrayOfInt[1]);
      arrayOfInt[1] = (paramBitArray.a() - i);
      return arrayOfInt;
    }
    finally
    {
      paramBitArray.e();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.ITFReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */