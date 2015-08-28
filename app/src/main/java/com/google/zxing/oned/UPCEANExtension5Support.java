package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension5Support
{
  private static final int[] a = { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
  private final int[] b = new int[4];
  private final StringBuilder c = new StringBuilder();
  
  private static int a(int paramInt)
  {
    for (int i = 0; i < 10; i++) {
      if (paramInt == a[i]) {
        return i;
      }
    }
    throw NotFoundException.a();
  }
  
  private static int a(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = 0;
    for (int k = i - 2; k >= 0; k -= 2) {
      j += '￐' + paramCharSequence.charAt(k);
    }
    int m = j * 3;
    for (int n = i - 1; n >= 0; n -= 2) {
      m += '￐' + paramCharSequence.charAt(n);
    }
    return m * 3 % 10;
  }
  
  private static Map<ResultMetadataType, Object> a(String paramString)
  {
    if (paramString.length() != 5) {}
    String str;
    do
    {
      return null;
      str = b(paramString);
    } while (str == null);
    EnumMap localEnumMap = new EnumMap(ResultMetadataType.class);
    localEnumMap.put(ResultMetadataType.f, str);
    return localEnumMap;
  }
  
  private static String b(String paramString)
  {
    String str1;
    String str2;
    int j;
    switch (paramString.charAt(0))
    {
    default: 
      str1 = "";
      int i = Integer.parseInt(paramString.substring(1));
      str2 = String.valueOf(i / 100);
      j = i % 100;
      if (j >= 10) {
        break;
      }
    }
    for (String str3 = "0" + j;; str3 = String.valueOf(j))
    {
      return str1 + str2 + '.' + str3;
      str1 = "£";
      break;
      str1 = "$";
      break;
      if ("90000".equals(paramString)) {
        return null;
      }
      if ("99991".equals(paramString)) {
        return "0.00";
      }
      if ("99990".equals(paramString)) {
        return "Used";
      }
      str1 = "";
      break;
    }
  }
  
  int a(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.b;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.a();
    int j = paramArrayOfInt[1];
    int k = 0;
    int m = 0;
    while ((k < 5) && (j < i))
    {
      int i1 = UPCEANReader.a(paramBitArray, arrayOfInt, j, UPCEANReader.e);
      paramStringBuilder.append((char)(48 + i1 % 10));
      int i2 = arrayOfInt.length;
      int i3 = 0;
      while (i3 < i2)
      {
        int i4 = j + arrayOfInt[i3];
        i3++;
        j = i4;
      }
      if (i1 >= 10) {
        m |= 1 << 4 - k;
      }
      if (k != 4) {
        j = paramBitArray.d(paramBitArray.c(j));
      }
      k++;
    }
    if (paramStringBuilder.length() != 5) {
      throw NotFoundException.a();
    }
    int n = a(m);
    if (a(paramStringBuilder.toString()) != n) {
      throw NotFoundException.a();
    }
    return j;
  }
  
  Result a(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = this.c;
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
 * Qualified Name:     com.google.zxing.oned.UPCEANExtension5Support
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */