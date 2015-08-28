package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Code128Reader
  extends OneDReader
{
  static final int[][] a = { { 2, 1, 2, 2, 2, 2 }, { 2, 2, 2, 1, 2, 2 }, { 2, 2, 2, 2, 2, 1 }, { 1, 2, 1, 2, 2, 3 }, { 1, 2, 1, 3, 2, 2 }, { 1, 3, 1, 2, 2, 2 }, { 1, 2, 2, 2, 1, 3 }, { 1, 2, 2, 3, 1, 2 }, { 1, 3, 2, 2, 1, 2 }, { 2, 2, 1, 2, 1, 3 }, { 2, 2, 1, 3, 1, 2 }, { 2, 3, 1, 2, 1, 2 }, { 1, 1, 2, 2, 3, 2 }, { 1, 2, 2, 1, 3, 2 }, { 1, 2, 2, 2, 3, 1 }, { 1, 1, 3, 2, 2, 2 }, { 1, 2, 3, 1, 2, 2 }, { 1, 2, 3, 2, 2, 1 }, { 2, 2, 3, 2, 1, 1 }, { 2, 2, 1, 1, 3, 2 }, { 2, 2, 1, 2, 3, 1 }, { 2, 1, 3, 2, 1, 2 }, { 2, 2, 3, 1, 1, 2 }, { 3, 1, 2, 1, 3, 1 }, { 3, 1, 1, 2, 2, 2 }, { 3, 2, 1, 1, 2, 2 }, { 3, 2, 1, 2, 2, 1 }, { 3, 1, 2, 2, 1, 2 }, { 3, 2, 2, 1, 1, 2 }, { 3, 2, 2, 2, 1, 1 }, { 2, 1, 2, 1, 2, 3 }, { 2, 1, 2, 3, 2, 1 }, { 2, 3, 2, 1, 2, 1 }, { 1, 1, 1, 3, 2, 3 }, { 1, 3, 1, 1, 2, 3 }, { 1, 3, 1, 3, 2, 1 }, { 1, 1, 2, 3, 1, 3 }, { 1, 3, 2, 1, 1, 3 }, { 1, 3, 2, 3, 1, 1 }, { 2, 1, 1, 3, 1, 3 }, { 2, 3, 1, 1, 1, 3 }, { 2, 3, 1, 3, 1, 1 }, { 1, 1, 2, 1, 3, 3 }, { 1, 1, 2, 3, 3, 1 }, { 1, 3, 2, 1, 3, 1 }, { 1, 1, 3, 1, 2, 3 }, { 1, 1, 3, 3, 2, 1 }, { 1, 3, 3, 1, 2, 1 }, { 3, 1, 3, 1, 2, 1 }, { 2, 1, 1, 3, 3, 1 }, { 2, 3, 1, 1, 3, 1 }, { 2, 1, 3, 1, 1, 3 }, { 2, 1, 3, 3, 1, 1 }, { 2, 1, 3, 1, 3, 1 }, { 3, 1, 1, 1, 2, 3 }, { 3, 1, 1, 3, 2, 1 }, { 3, 3, 1, 1, 2, 1 }, { 3, 1, 2, 1, 1, 3 }, { 3, 1, 2, 3, 1, 1 }, { 3, 3, 2, 1, 1, 1 }, { 3, 1, 4, 1, 1, 1 }, { 2, 2, 1, 4, 1, 1 }, { 4, 3, 1, 1, 1, 1 }, { 1, 1, 1, 2, 2, 4 }, { 1, 1, 1, 4, 2, 2 }, { 1, 2, 1, 1, 2, 4 }, { 1, 2, 1, 4, 2, 1 }, { 1, 4, 1, 1, 2, 2 }, { 1, 4, 1, 2, 2, 1 }, { 1, 1, 2, 2, 1, 4 }, { 1, 1, 2, 4, 1, 2 }, { 1, 2, 2, 1, 1, 4 }, { 1, 2, 2, 4, 1, 1 }, { 1, 4, 2, 1, 1, 2 }, { 1, 4, 2, 2, 1, 1 }, { 2, 4, 1, 2, 1, 1 }, { 2, 2, 1, 1, 1, 4 }, { 4, 1, 3, 1, 1, 1 }, { 2, 4, 1, 1, 1, 2 }, { 1, 3, 4, 1, 1, 1 }, { 1, 1, 1, 2, 4, 2 }, { 1, 2, 1, 1, 4, 2 }, { 1, 2, 1, 2, 4, 1 }, { 1, 1, 4, 2, 1, 2 }, { 1, 2, 4, 1, 1, 2 }, { 1, 2, 4, 2, 1, 1 }, { 4, 1, 1, 2, 1, 2 }, { 4, 2, 1, 1, 1, 2 }, { 4, 2, 1, 2, 1, 1 }, { 2, 1, 2, 1, 4, 1 }, { 2, 1, 4, 1, 2, 1 }, { 4, 1, 2, 1, 2, 1 }, { 1, 1, 1, 1, 4, 3 }, { 1, 1, 1, 3, 4, 1 }, { 1, 3, 1, 1, 4, 1 }, { 1, 1, 4, 1, 1, 3 }, { 1, 1, 4, 3, 1, 1 }, { 4, 1, 1, 1, 1, 3 }, { 4, 1, 1, 3, 1, 1 }, { 1, 1, 3, 1, 4, 1 }, { 1, 1, 4, 1, 3, 1 }, { 3, 1, 1, 1, 4, 1 }, { 4, 1, 1, 1, 3, 1 }, { 2, 1, 1, 4, 1, 2 }, { 2, 1, 1, 2, 1, 4 }, { 2, 1, 1, 2, 3, 2 }, { 2, 3, 3, 1, 1, 1, 2 } };
  
  private static int a(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt)
  {
    a(paramBitArray, paramInt, paramArrayOfInt);
    int i = 64;
    int j = -1;
    for (int k = 0; k < a.length; k++)
    {
      int m = a(paramArrayOfInt, a[k], 179);
      if (m < i)
      {
        j = k;
        i = m;
      }
    }
    if (j >= 0) {
      return j;
    }
    throw NotFoundException.a();
  }
  
  private static int[] a(BitArray paramBitArray)
  {
    int i = paramBitArray.a();
    int j = paramBitArray.c(0);
    int[] arrayOfInt = new int[6];
    int k = arrayOfInt.length;
    int m = j;
    int n = 0;
    int i1 = j;
    int i2 = 0;
    int i5;
    int i3;
    int i6;
    int i7;
    int i8;
    label102:
    int i9;
    for (;;)
    {
      if (m < i) {
        if ((n ^ paramBitArray.a(m)) != 0)
        {
          arrayOfInt[i2] = (1 + arrayOfInt[i2]);
          i5 = n;
          i3 = i2;
          m++;
          n = i5;
          i2 = i3;
        }
        else if (i2 == k - 1)
        {
          i6 = 64;
          i7 = -1;
          i8 = 103;
          if (i8 <= 105)
          {
            i9 = a(arrayOfInt, a[i8], 179);
            if (i9 >= i6) {
              break label279;
            }
            i7 = i8;
          }
        }
      }
    }
    for (;;)
    {
      i8++;
      i6 = i9;
      break label102;
      if ((i7 >= 0) && (paramBitArray.a(Math.max(0, i1 - (m - i1) / 2), i1, false))) {
        return new int[] { i1, m, i7 };
      }
      int i4 = i1 + (arrayOfInt[0] + arrayOfInt[1]);
      System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, k - 2);
      arrayOfInt[(k - 2)] = 0;
      arrayOfInt[(k - 1)] = 0;
      i3 = i2 - 1;
      label236:
      arrayOfInt[i3] = 1;
      if (n == 0) {}
      for (i5 = 1;; i5 = 0)
      {
        i1 = i4;
        break;
        i3 = i2 + 1;
        i4 = i1;
        break label236;
      }
      throw NotFoundException.a();
      label279:
      i9 = i6;
    }
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.h))) {}
    int[] arrayOfInt1;
    int j;
    ArrayList localArrayList;
    for (int i = 1;; i = 0)
    {
      arrayOfInt1 = a(paramBitArray);
      j = arrayOfInt1[2];
      localArrayList = new ArrayList(20);
      localArrayList.add(Byte.valueOf((byte)j));
      switch (j)
      {
      default: 
        throw FormatException.a();
      }
    }
    int k = 101;
    StringBuilder localStringBuilder;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i17;
    int i20;
    for (;;)
    {
      localStringBuilder = new StringBuilder(20);
      int m = arrayOfInt1[0];
      n = arrayOfInt1[1];
      int[] arrayOfInt2 = new int[6];
      i1 = 1;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      i5 = m;
      i6 = k;
      i7 = 0;
      i8 = j;
      i9 = 0;
      i10 = 0;
      i11 = 0;
      if (i11 != 0) {
        break label1456;
      }
      i17 = a(paramBitArray, arrayOfInt2, n);
      localArrayList.add(Byte.valueOf((byte)i17));
      if (i17 != 106) {
        i1 = 1;
      }
      if (i17 != 106)
      {
        i7++;
        i8 += i7 * i17;
      }
      int i18 = arrayOfInt2.length;
      int i19 = 0;
      i20 = n;
      while (i19 < i18)
      {
        i20 += arrayOfInt2[i19];
        i19++;
      }
      k = 100;
      continue;
      k = 99;
    }
    int i27;
    int i23;
    int i24;
    int i25;
    int i26;
    switch (i17)
    {
    default: 
      switch (i6)
      {
      default: 
        int i35 = i3;
        i22 = i6;
        i27 = 0;
        i23 = i2;
        i24 = i35;
        int i36 = i11;
        i25 = i1;
        i26 = i36;
        label359:
        if (i4 != 0) {
          if (i22 != 101) {
            break label1449;
          }
        }
        break;
      }
      break;
    }
    label1449:
    for (int i22 = 100;; i22 = 101)
    {
      i5 = n;
      i4 = i27;
      n = i20;
      i6 = i22;
      i3 = i24;
      i2 = i23;
      i9 = i10;
      i10 = i17;
      int i28 = i26;
      i1 = i25;
      i11 = i28;
      break;
      throw FormatException.a();
      if (i17 < 64)
      {
        if (i3 == i2) {
          localStringBuilder.append((char)(i17 + 32));
        }
        for (;;)
        {
          i22 = i6;
          i23 = i2;
          int i49 = i11;
          i25 = i1;
          i26 = i49;
          i24 = 0;
          i27 = 0;
          break;
          localStringBuilder.append((char)(128 + (i17 + 32)));
        }
      }
      if (i17 < 96)
      {
        if (i3 == i2) {
          localStringBuilder.append((char)(i17 - 64));
        }
        for (;;)
        {
          i22 = i6;
          i23 = i2;
          int i48 = i11;
          i25 = i1;
          i26 = i48;
          i24 = 0;
          i27 = 0;
          break;
          localStringBuilder.append((char)(i17 + 64));
        }
      }
      if (i17 != 106) {
        i1 = 0;
      }
      int i45 = 0;
      switch (i17)
      {
      }
      for (;;)
      {
        int i46 = i3;
        i22 = i6;
        i27 = i45;
        i23 = i2;
        i24 = i46;
        int i47 = i11;
        i25 = i1;
        i26 = i47;
        break;
        i45 = 0;
        if (i != 0) {
          if (localStringBuilder.length() == 0)
          {
            localStringBuilder.append("]C1");
            i45 = 0;
          }
          else
          {
            localStringBuilder.append('\035');
            i45 = 0;
            continue;
            if ((i2 == 0) && (i3 != 0))
            {
              i2 = 1;
              i3 = 0;
              i45 = 0;
            }
            else if ((i2 != 0) && (i3 != 0))
            {
              i3 = 0;
              i2 = 0;
              i45 = 0;
            }
            else
            {
              i3 = 1;
              i45 = 0;
              continue;
              i45 = 1;
              i6 = 100;
              continue;
              i6 = 100;
              i45 = 0;
              continue;
              i6 = 99;
              i45 = 0;
              continue;
              i11 = 1;
              i45 = 0;
            }
          }
        }
      }
      if (i17 < 96)
      {
        if (i3 == i2) {
          localStringBuilder.append((char)(i17 + 32));
        }
        for (;;)
        {
          i22 = i6;
          i23 = i2;
          int i44 = i11;
          i25 = i1;
          i26 = i44;
          i24 = 0;
          i27 = 0;
          break;
          localStringBuilder.append((char)(128 + (i17 + 32)));
        }
      }
      if (i17 != 106) {
        i1 = 0;
      }
      int i41 = 0;
      switch (i17)
      {
      }
      for (;;)
      {
        int i42 = i3;
        i22 = i6;
        i27 = i41;
        i23 = i2;
        i24 = i42;
        int i43 = i11;
        i25 = i1;
        i26 = i43;
        break;
        i41 = 0;
        if (i != 0) {
          if (localStringBuilder.length() == 0)
          {
            localStringBuilder.append("]C1");
            i41 = 0;
          }
          else
          {
            localStringBuilder.append('\035');
            i41 = 0;
            continue;
            if ((i2 == 0) && (i3 != 0))
            {
              i2 = 1;
              i3 = 0;
              i41 = 0;
            }
            else if ((i2 != 0) && (i3 != 0))
            {
              i3 = 0;
              i2 = 0;
              i41 = 0;
            }
            else
            {
              i3 = 1;
              i41 = 0;
              continue;
              i41 = 1;
              i6 = 101;
              continue;
              i6 = 101;
              i41 = 0;
              continue;
              i6 = 99;
              i41 = 0;
              continue;
              i11 = 1;
              i41 = 0;
            }
          }
        }
      }
      if (i17 < 100)
      {
        if (i17 < 10) {
          localStringBuilder.append('0');
        }
        localStringBuilder.append(i17);
        int i39 = i3;
        i22 = i6;
        i23 = i2;
        i24 = i39;
        int i40 = i11;
        i25 = i1;
        i26 = i40;
        i27 = 0;
        break label359;
      }
      if (i17 != 106) {
        i1 = 0;
      }
      switch (i17)
      {
      case 103: 
      case 104: 
      case 105: 
      default: 
        break;
      case 100: 
        int i37 = i3;
        i22 = 100;
        i23 = i2;
        i24 = i37;
        int i38 = i11;
        i25 = i1;
        i26 = i38;
        i27 = 0;
        break;
      case 102: 
        if (i == 0) {
          break;
        }
        if (localStringBuilder.length() == 0)
        {
          localStringBuilder.append("]C1");
          int i33 = i3;
          i22 = i6;
          i23 = i2;
          i24 = i33;
          int i34 = i11;
          i25 = i1;
          i26 = i34;
          i27 = 0;
          break label359;
        }
        localStringBuilder.append('\035');
        int i31 = i3;
        i22 = i6;
        i23 = i2;
        i24 = i31;
        int i32 = i11;
        i25 = i1;
        i26 = i32;
        i27 = 0;
        break;
      case 101: 
        int i29 = i3;
        i22 = 101;
        i23 = i2;
        i24 = i29;
        int i30 = i11;
        i25 = i1;
        i26 = i30;
        i27 = 0;
        break;
      case 106: 
        int i21 = i3;
        i22 = i6;
        i23 = i2;
        i24 = i21;
        i25 = i1;
        i26 = 1;
        i27 = 0;
        break label359;
      }
    }
    label1456:
    int i12 = n - i5;
    int i13 = paramBitArray.d(n);
    if (!paramBitArray.a(i13, Math.min(paramBitArray.a(), i13 + (i13 - i5) / 2), false)) {
      throw NotFoundException.a();
    }
    if ((i8 - i7 * i9) % 103 != i9) {
      throw ChecksumException.a();
    }
    int i14 = localStringBuilder.length();
    if (i14 == 0) {
      throw NotFoundException.a();
    }
    if ((i14 > 0) && (i1 != 0))
    {
      if (i6 != 99) {
        break label1643;
      }
      localStringBuilder.delete(i14 - 2, i14);
    }
    float f1;
    float f2;
    byte[] arrayOfByte;
    for (;;)
    {
      f1 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
      f2 = i5 + i12 / 2.0F;
      int i15 = localArrayList.size();
      arrayOfByte = new byte[i15];
      for (int i16 = 0; i16 < i15; i16++) {
        arrayOfByte[i16] = ((Byte)localArrayList.get(i16)).byteValue();
      }
      label1643:
      localStringBuilder.delete(i14 - 1, i14);
    }
    String str = localStringBuilder.toString();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
    arrayOfResultPoint[0] = new ResultPoint(f1, paramInt);
    arrayOfResultPoint[1] = new ResultPoint(f2, paramInt);
    return new Result(str, arrayOfByte, arrayOfResultPoint, BarcodeFormat.e);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.Code128Reader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */