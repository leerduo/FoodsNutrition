package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class CodaBarReader
  extends OneDReader
{
  static final char[] a = "0123456789-$:/.+ABCD".toCharArray();
  static final int[] b = { 3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14 };
  private static final char[] c = { 65, 66, 67, 68 };
  private final StringBuilder d = new StringBuilder(20);
  private int[] e = new int[80];
  private int f = 0;
  
  private void a(BitArray paramBitArray)
  {
    this.f = 0;
    int i = paramBitArray.d(0);
    int j = paramBitArray.a();
    if (i >= j) {
      throw NotFoundException.a();
    }
    int k = 1;
    int m = i;
    int n = 0;
    while (m < j) {
      if ((k ^ paramBitArray.a(m)) != 0)
      {
        n++;
        m++;
      }
      else
      {
        b(n);
        if (k == 0) {}
        for (int i1 = 1;; i1 = 0)
        {
          k = i1;
          n = 1;
          break;
        }
      }
    }
    b(n);
  }
  
  static boolean a(char[] paramArrayOfChar, char paramChar)
  {
    boolean bool = false;
    int i;
    if (paramArrayOfChar != null) {
      i = paramArrayOfChar.length;
    }
    for (int j = 0;; j++)
    {
      bool = false;
      if (j < i)
      {
        if (paramArrayOfChar[j] == paramChar) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  private int b()
  {
    for (int i = 1; i < this.f; i += 2)
    {
      int j = c(i);
      if ((j != -1) && (a(c, a[j])))
      {
        int k = 0;
        for (int m = i; m < i + 7; m++) {
          k += this.e[m];
        }
        if ((i == 1) || (this.e[(i - 1)] >= k / 2)) {
          return i;
        }
      }
    }
    throw NotFoundException.a();
  }
  
  private void b(int paramInt)
  {
    this.e[this.f] = paramInt;
    this.f = (1 + this.f);
    if (this.f >= this.e.length)
    {
      int[] arrayOfInt = new int[2 * this.f];
      System.arraycopy(this.e, 0, arrayOfInt, 0, this.f);
      this.e = arrayOfInt;
    }
  }
  
  private int c(int paramInt)
  {
    int i = 2147483647;
    int j = paramInt + 7;
    int i8;
    if (j >= this.f)
    {
      i8 = -1;
      return i8;
    }
    int[] arrayOfInt = this.e;
    int k = paramInt;
    int m = i;
    int n = 0;
    label37:
    int i12;
    if (k < j)
    {
      i12 = arrayOfInt[k];
      if (i12 < m) {
        m = i12;
      }
      if (i12 <= n) {
        break label258;
      }
    }
    for (;;)
    {
      k += 2;
      n = i12;
      break label37;
      int i1 = (m + n) / 2;
      int i2 = paramInt + 1;
      int i3 = 0;
      label95:
      int i11;
      if (i2 < j)
      {
        i11 = arrayOfInt[i2];
        if (i11 < i) {
          i = i11;
        }
        if (i11 <= i3) {
          break label251;
        }
      }
      for (;;)
      {
        i2 += 2;
        i3 = i11;
        break label95;
        int i4 = (i + i3) / 2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 128;
        label153:
        int i9;
        if (i5 < 7) {
          if ((i5 & 0x1) == 0)
          {
            i9 = i1;
            label171:
            i7 >>= 1;
            if (arrayOfInt[(paramInt + i5)] <= i9) {
              break label244;
            }
          }
        }
        label242:
        label244:
        for (int i10 = i6 | i7;; i10 = i6)
        {
          i5++;
          i6 = i10;
          break label153;
          i9 = i4;
          break label171;
          for (i8 = 0;; i8++)
          {
            if (i8 >= b.length) {
              break label242;
            }
            if (b[i8] == i6) {
              break;
            }
          }
          return -1;
        }
        label251:
        i11 = i3;
      }
      label258:
      i12 = n;
    }
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    Arrays.fill(this.e, 0);
    a(paramBitArray);
    int i = b();
    this.d.setLength(0);
    int j = i;
    int k = c(j);
    if (k == -1) {
      throw NotFoundException.a();
    }
    this.d.append((char)k);
    j += 8;
    if ((this.d.length() > 1) && (a(c, a[k]))) {}
    int m;
    int i1;
    for (;;)
    {
      m = this.e[(j - 1)];
      int n = -8;
      i1 = 0;
      while (n < -1)
      {
        i1 += this.e[(j + n)];
        n++;
      }
      if (j < this.f) {
        break;
      }
    }
    if ((j < this.f) && (m < i1 / 2)) {
      throw NotFoundException.a();
    }
    a(i);
    for (int i2 = 0; i2 < this.d.length(); i2++) {
      this.d.setCharAt(i2, a[this.d.charAt(i2)]);
    }
    char c1 = this.d.charAt(0);
    if (!a(c, c1)) {
      throw NotFoundException.a();
    }
    char c2 = this.d.charAt(-1 + this.d.length());
    if (!a(c, c2)) {
      throw NotFoundException.a();
    }
    if (this.d.length() <= 3) {
      throw NotFoundException.a();
    }
    if ((paramMap == null) || (!paramMap.containsKey(DecodeHintType.i)))
    {
      this.d.deleteCharAt(-1 + this.d.length());
      this.d.deleteCharAt(0);
    }
    int i3 = 0;
    int i5;
    for (int i4 = 0; i3 < i; i4 = i5)
    {
      i5 = i4 + this.e[i3];
      i3++;
    }
    float f1 = i4;
    while (i < j - 1)
    {
      i4 += this.e[i];
      i++;
    }
    float f2 = i4;
    String str = this.d.toString();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
    arrayOfResultPoint[0] = new ResultPoint(f1, paramInt);
    arrayOfResultPoint[1] = new ResultPoint(f2, paramInt);
    return new Result(str, null, arrayOfResultPoint, BarcodeFormat.b);
  }
  
  void a(int paramInt)
  {
    int[] arrayOfInt1 = { 0, 0, 0, 0 };
    int[] arrayOfInt2 = { 0, 0, 0, 0 };
    int i = -1 + this.d.length();
    int j = 0;
    int k = paramInt;
    int[] arrayOfInt3;
    int[] arrayOfInt4;
    int i2;
    for (;;)
    {
      int m = b[this.d.charAt(j)];
      for (int n = 6; n >= 0; n--)
      {
        int i7 = (n & 0x1) + 2 * (m & 0x1);
        arrayOfInt1[i7] += this.e[(k + n)];
        arrayOfInt2[i7] = (1 + arrayOfInt2[i7]);
        m >>= 1;
      }
      if (j >= i)
      {
        arrayOfInt3 = new int[4];
        arrayOfInt4 = new int[4];
        for (int i1 = 0;; i1++)
        {
          i2 = 0;
          if (i1 >= 2) {
            break;
          }
          arrayOfInt4[i1] = 0;
          arrayOfInt4[(i1 + 2)] = ((arrayOfInt1[i1] << 8) / arrayOfInt2[i1] + (arrayOfInt1[(i1 + 2)] << 8) / arrayOfInt2[(i1 + 2)] >> 1);
          arrayOfInt3[i1] = arrayOfInt4[(i1 + 2)];
          arrayOfInt3[(i1 + 2)] = ((384 + 512 * arrayOfInt1[(i1 + 2)]) / arrayOfInt2[(i1 + 2)]);
        }
      }
      k += 8;
      j++;
    }
    do
    {
      paramInt += 8;
      i2++;
      int i3 = b[this.d.charAt(i2)];
      for (int i4 = 6; i4 >= 0; i4--)
      {
        int i5 = (i4 & 0x1) + 2 * (i3 & 0x1);
        int i6 = this.e[(paramInt + i4)] << 8;
        if ((i6 < arrayOfInt4[i5]) || (i6 > arrayOfInt3[i5])) {
          throw NotFoundException.a();
        }
        i3 >>= 1;
      }
    } while (i2 < i);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.CodaBarReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */