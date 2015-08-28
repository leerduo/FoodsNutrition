package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix
  implements Cloneable
{
  private final int a;
  private final int b;
  private final int c;
  private final int[] d;
  
  public BitMatrix(int paramInt)
  {
    this(paramInt, paramInt);
  }
  
  public BitMatrix(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1)) {
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = (paramInt1 + 31 >> 5);
    this.d = new int[paramInt2 * this.c];
  }
  
  private BitMatrix(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramArrayOfInt;
  }
  
  public BitArray a(int paramInt, BitArray paramBitArray)
  {
    if ((paramBitArray == null) || (paramBitArray.a() < this.a)) {
      paramBitArray = new BitArray(this.a);
    }
    for (;;)
    {
      int i = paramInt * this.c;
      for (int j = 0; j < this.c; j++) {
        paramBitArray.a(j << 5, this.d[(i + j)]);
      }
      paramBitArray.c();
    }
    return paramBitArray;
  }
  
  public void a()
  {
    int i = this.d.length;
    for (int j = 0; j < i; j++) {
      this.d[j] = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0)) {
      throw new IllegalArgumentException("Left and top must be nonnegative");
    }
    if ((paramInt4 < 1) || (paramInt3 < 1)) {
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    int i = paramInt1 + paramInt3;
    int j = paramInt2 + paramInt4;
    if ((j > this.b) || (i > this.a)) {
      throw new IllegalArgumentException("The region must fit inside the matrix");
    }
    for (;;)
    {
      paramInt2++;
      if (paramInt2 >= j) {
        break;
      }
      int k = paramInt2 * this.c;
      for (int m = paramInt1; m < i; m++)
      {
        int[] arrayOfInt = this.d;
        int n = k + (m >> 5);
        arrayOfInt[n] |= 1 << (m & 0x1F);
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    return (0x1 & this.d[i] >>> (paramInt1 & 0x1F)) != 0;
  }
  
  public void b()
  {
    int i = f();
    int j = g();
    BitArray localBitArray1 = new BitArray(i);
    BitArray localBitArray2 = new BitArray(i);
    for (int k = 0; k < (j + 1) / 2; k++)
    {
      localBitArray1 = a(k, localBitArray1);
      localBitArray2 = a(j - 1 - k, localBitArray2);
      localBitArray1.e();
      localBitArray2.e();
      b(k, localBitArray2);
      b(j - 1 - k, localBitArray1);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    int[] arrayOfInt = this.d;
    arrayOfInt[i] |= 1 << (paramInt1 & 0x1F);
  }
  
  public void b(int paramInt, BitArray paramBitArray)
  {
    System.arraycopy(paramBitArray.d(), 0, this.d, paramInt * this.c, this.c);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    int[] arrayOfInt = this.d;
    arrayOfInt[i] ^= 1 << (paramInt1 & 0x1F);
  }
  
  public int[] c()
  {
    int i = this.a;
    int j = this.b;
    int k = i;
    int m = -1;
    int n = -1;
    int i1 = 0;
    int i4;
    label33:
    int i6;
    label135:
    int i7;
    int i8;
    int i9;
    if (i1 < this.b)
    {
      i4 = 0;
      if (i4 < this.c)
      {
        int i5 = this.d[(i4 + i1 * this.c)];
        if (i5 == 0) {
          break label292;
        }
        if (i1 < j) {
          j = i1;
        }
        if (i1 > n) {
          n = i1;
        }
        if (i4 * 32 >= k) {
          break label286;
        }
        for (int i12 = 0; i5 << 31 - i12 == 0; i12++) {}
        if (i12 + i4 * 32 >= k) {
          break label286;
        }
        i6 = i12 + i4 * 32;
        if (31 + i4 * 32 <= m) {
          break label272;
        }
        for (int i10 = 31; i5 >>> i10 == 0; i10--) {}
        if (i10 + i4 * 32 <= m) {
          break label272;
        }
        int i11 = i10 + i4 * 32;
        i7 = j;
        i8 = i11;
        i9 = n;
      }
    }
    for (;;)
    {
      i4++;
      n = i9;
      m = i8;
      j = i7;
      k = i6;
      break label33;
      i1++;
      break;
      int i2 = m - k;
      int i3 = n - j;
      if ((i2 < 0) || (i3 < 0)) {
        return null;
      }
      return new int[] { k, j, i2, i3 };
      label272:
      i7 = j;
      i8 = m;
      i9 = n;
      continue;
      label286:
      i6 = k;
      break label135;
      label292:
      i6 = k;
      i7 = j;
      i8 = m;
      i9 = n;
    }
  }
  
  public int[] d()
  {
    for (int i = 0; (i < this.d.length) && (this.d[i] == 0); i++) {}
    if (i == this.d.length) {
      return null;
    }
    int j = i / this.c;
    int k = i % this.c << 5;
    int m = this.d[i];
    for (int n = 0; m << 31 - n == 0; n++) {}
    return new int[] { k + n, j };
  }
  
  public int[] e()
  {
    for (int i = -1 + this.d.length; (i >= 0) && (this.d[i] == 0); i--) {}
    if (i < 0) {
      return null;
    }
    int j = i / this.c;
    int k = i % this.c << 5;
    int m = this.d[i];
    for (int n = 31; m >>> n == 0; n--) {}
    return new int[] { k + n, j };
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BitMatrix)) {}
    BitMatrix localBitMatrix;
    do
    {
      return false;
      localBitMatrix = (BitMatrix)paramObject;
    } while ((this.a != localBitMatrix.a) || (this.b != localBitMatrix.b) || (this.c != localBitMatrix.c) || (!Arrays.equals(this.d, localBitMatrix.d)));
    return true;
  }
  
  public int f()
  {
    return this.a;
  }
  
  public int g()
  {
    return this.b;
  }
  
  public BitMatrix h()
  {
    return new BitMatrix(this.a, this.b, this.c, (int[])this.d.clone());
  }
  
  public int hashCode()
  {
    return 31 * (31 * (31 * (31 * this.a + this.a) + this.b) + this.c) + Arrays.hashCode(this.d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * (1 + this.a));
    for (int i = 0; i < this.b; i++)
    {
      int j = 0;
      if (j < this.a)
      {
        if (a(j, i)) {}
        for (String str = "X ";; str = "  ")
        {
          localStringBuilder.append(str);
          j++;
          break;
        }
      }
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.BitMatrix
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */