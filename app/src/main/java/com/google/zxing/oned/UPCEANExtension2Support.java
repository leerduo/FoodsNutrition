package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension2Support
{
  private final int[] a = new int[4];
  private final StringBuilder b = new StringBuilder();
  
  private static Map<ResultMetadataType, Object> a(String paramString)
  {
    if (paramString.length() != 2) {
      return null;
    }
    EnumMap localEnumMap = new EnumMap(ResultMetadataType.class);
    localEnumMap.put(ResultMetadataType.e, Integer.valueOf(paramString));
    return localEnumMap;
  }
  
  int a(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.a;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.a();
    int j = paramArrayOfInt[1];
    int k = 0;
    int m = 0;
    while ((k < 2) && (j < i))
    {
      int n = UPCEANReader.a(paramBitArray, arrayOfInt, j, UPCEANReader.e);
      paramStringBuilder.append((char)(48 + n % 10));
      int i1 = arrayOfInt.length;
      int i2 = 0;
      while (i2 < i1)
      {
        int i3 = j + arrayOfInt[i2];
        i2++;
        j = i3;
      }
      if (n >= 10) {
        m |= 1 << 1 - k;
      }
      if (k != 1) {
        j = paramBitArray.d(paramBitArray.c(j));
      }
      k++;
    }
    if (paramStringBuilder.length() != 2) {
      throw NotFoundException.a();
    }
    if (Integer.parseInt(paramStringBuilder.toString()) % 4 != m) {
      throw NotFoundException.a();
    }
    return j;
  }
  
  Result a(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = this.b;
    localStringBuilder.setLength(0);
    int i = a(paramBitArray, paramArrayOfInt, localStringBuilder);
    String str = localStringBuilder.toString();
    Map localMap = a(str);
    ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
    arrayOfResultPoint[0] = new ResultPoint((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt);
    arrayOfResultPoint[1] = new ResultPoint(i, paramInt);
    Result localResult = new Result(str, null, arrayOfResultPoint, BarcodeFormat.q);
    if (localMap != null) {
      localResult.a(localMap);
    }
    return localResult;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.UPCEANExtension2Support
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */