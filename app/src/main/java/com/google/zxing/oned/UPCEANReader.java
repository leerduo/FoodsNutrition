package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader
  extends OneDReader
{
  static final int[] b = { 1, 1, 1 };
  static final int[] c = { 1, 1, 1, 1, 1 };
  static final int[][] d = { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 }, { 1, 2, 3, 1 }, { 1, 1, 1, 4 }, { 1, 3, 1, 2 }, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };
  static final int[][] e = new int[20][];
  private final StringBuilder a = new StringBuilder(20);
  private final UPCEANExtensionSupport f = new UPCEANExtensionSupport();
  private final EANManufacturerOrgSupport g = new EANManufacturerOrgSupport();
  
  static
  {
    System.arraycopy(d, 0, e, 0, 10);
    for (int i = 10; i < 20; i++)
    {
      int[] arrayOfInt1 = d[(i - 10)];
      int[] arrayOfInt2 = new int[arrayOfInt1.length];
      for (int j = 0; j < arrayOfInt1.length; j++) {
        arrayOfInt2[j] = arrayOfInt1[(-1 + (arrayOfInt1.length - j))];
      }
      e[i] = arrayOfInt2;
    }
  }
  
  static int a(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt, int[][] paramArrayOfInt1)
  {
    a(paramBitArray, paramInt, paramArrayOfInt);
    int i = 122;
    int j = -1;
    int k = paramArrayOfInt1.length;
    int m = 0;
    int n;
    if (m < k)
    {
      n = a(paramArrayOfInt, paramArrayOfInt1[m], 179);
      if (n >= i) {
        break label73;
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
      label73:
      n = i;
    }
  }
  
  static boolean a(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    if (i == 0) {}
    int m;
    do
    {
      return false;
      int j = i - 2;
      int k = 0;
      while (j >= 0)
      {
        int i2 = '￐' + paramCharSequence.charAt(j);
        if ((i2 < 0) || (i2 > 9)) {
          throw FormatException.a();
        }
        k += i2;
        j -= 2;
      }
      m = k * 3;
      for (int n = i - 1; n >= 0; n -= 2)
      {
        int i1 = '￐' + paramCharSequence.charAt(n);
        if ((i1 < 0) || (i1 > 9)) {
          throw FormatException.a();
        }
        m += i1;
      }
    } while (m % 10 != 0);
    return true;
  }
  
  static int[] a(BitArray paramBitArray)
  {
    int[] arrayOfInt1 = new int[b.length];
    int i = 0;
    int[] arrayOfInt2 = null;
    boolean bool = false;
    while (!bool)
    {
      Arrays.fill(arrayOfInt1, 0, b.length, 0);
      arrayOfInt2 = a(paramBitArray, i, false, b, arrayOfInt1);
      int j = arrayOfInt2[0];
      i = arrayOfInt2[1];
      int k = j - (i - j);
      if (k >= 0) {
        bool = paramBitArray.a(k, j, false);
      }
    }
    return arrayOfInt2;
  }
  
  static int[] a(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return a(paramBitArray, paramInt, paramBoolean, paramArrayOfInt, new int[paramArrayOfInt.length]);
  }
  
  private static int[] a(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1.length;
    int j = paramBitArray.a();
    int k;
    int m;
    int n;
    boolean bool;
    if (paramBoolean)
    {
      k = paramBitArray.d(paramInt);
      m = k;
      n = 0;
      bool = paramBoolean;
      label31:
      if (m >= j) {
        break label190;
      }
      if (!(bool ^ paramBitArray.a(m))) {
        break label78;
      }
      paramArrayOfInt2[n] = (1 + paramArrayOfInt2[n]);
    }
    for (;;)
    {
      m++;
      break label31;
      k = paramBitArray.c(paramInt);
      break;
      label78:
      if (n == i - 1)
      {
        if (a(paramArrayOfInt2, paramArrayOfInt1, 179) < 122) {
          return new int[] { k, m };
        }
        k += paramArrayOfInt2[0] + paramArrayOfInt2[1];
        System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, i - 2);
        paramArrayOfInt2[(i - 2)] = 0;
        paramArrayOfInt2[(i - 1)] = 0;
        n--;
      }
      for (;;)
      {
        paramArrayOfInt2[n] = 1;
        if (bool) {
          break label184;
        }
        bool = true;
        break;
        n++;
      }
      label184:
      bool = false;
    }
    label190:
    throw NotFoundException.a();
  }
  
  protected abstract int a(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder);
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    return a(paramInt, paramBitArray, a(paramBitArray), paramMap);
  }
  
  public Result a(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt, Map<DecodeHintType, ?> paramMap)
  {
    if (paramMap == null) {}
    StringBuilder localStringBuilder;
    int[] arrayOfInt1;
    for (ResultPointCallback localResultPointCallback = null;; localResultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.j))
    {
      if (localResultPointCallback != null) {
        localResultPointCallback.a(new ResultPoint((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt));
      }
      localStringBuilder = this.a;
      localStringBuilder.setLength(0);
      int i = a(paramBitArray, paramArrayOfInt, localStringBuilder);
      if (localResultPointCallback != null) {
        localResultPointCallback.a(new ResultPoint(i, paramInt));
      }
      arrayOfInt1 = a(paramBitArray, i);
      if (localResultPointCallback != null) {
        localResultPointCallback.a(new ResultPoint((arrayOfInt1[0] + arrayOfInt1[1]) / 2.0F, paramInt));
      }
      int j = arrayOfInt1[1];
      int k = j + (j - arrayOfInt1[0]);
      if ((k < paramBitArray.a()) && (paramBitArray.a(j, k, false))) {
        break;
      }
      throw NotFoundException.a();
    }
    String str1 = localStringBuilder.toString();
    if (str1.length() < 8) {
      throw FormatException.a();
    }
    if (!a(str1)) {
      throw ChecksumException.a();
    }
    float f1 = (paramArrayOfInt[1] + paramArrayOfInt[0]) / 2.0F;
    float f2 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
    BarcodeFormat localBarcodeFormat = b();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
    arrayOfResultPoint[0] = new ResultPoint(f1, paramInt);
    arrayOfResultPoint[1] = new ResultPoint(f2, paramInt);
    Result localResult1 = new Result(str1, null, arrayOfResultPoint, localBarcodeFormat);
    try
    {
      Result localResult2 = this.f.a(paramInt, paramBitArray, arrayOfInt1[1]);
      localResult1.a(ResultMetadataType.h, localResult2.a());
      localResult1.a(localResult2.e());
      localResult1.a(localResult2.c());
      int i3 = localResult2.a().length();
      m = i3;
      if (paramMap == null)
      {
        arrayOfInt2 = null;
        if (arrayOfInt2 == null) {
          break label456;
        }
        int n = arrayOfInt2.length;
        i1 = 0;
        int i2 = 0;
        if (i1 < n)
        {
          if (m != arrayOfInt2[i1]) {
            break label450;
          }
          i2 = 1;
        }
        if (i2 != 0) {
          break label456;
        }
        throw NotFoundException.a();
      }
    }
    catch (ReaderException localReaderException)
    {
      for (;;)
      {
        int i1;
        int m = 0;
        continue;
        int[] arrayOfInt2 = (int[])paramMap.get(DecodeHintType.k);
        continue;
        label450:
        i1++;
      }
      label456:
      if ((localBarcodeFormat == BarcodeFormat.h) || (localBarcodeFormat == BarcodeFormat.o))
      {
        String str2 = this.g.a(str1);
        if (str2 != null) {
          localResult1.a(ResultMetadataType.g, str2);
        }
      }
    }
    return localResult1;
  }
  
  boolean a(String paramString)
  {
    return a(paramString);
  }
  
  int[] a(BitArray paramBitArray, int paramInt)
  {
    return a(paramBitArray, paramInt, false, b);
  }
  
  abstract BarcodeFormat b();
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.UPCEANReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */