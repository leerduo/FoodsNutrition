package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement
{
  private final CharSequence a;
  private final int b;
  private final int c;
  private final byte[] d;
  
  public DefaultPlacement(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.a = paramCharSequence;
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = new byte[paramInt1 * paramInt2];
    Arrays.fill(this.d, (byte)-1);
  }
  
  private void a(int paramInt)
  {
    a(-1 + this.b, 0, paramInt, 1);
    a(-1 + this.b, 1, paramInt, 2);
    a(-1 + this.b, 2, paramInt, 3);
    a(0, -2 + this.c, paramInt, 4);
    a(0, -1 + this.c, paramInt, 5);
    a(1, -1 + this.c, paramInt, 6);
    a(2, -1 + this.c, paramInt, 7);
    a(3, -1 + this.c, paramInt, 8);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1 - 2, paramInt2 - 2, paramInt3, 1);
    a(paramInt1 - 2, paramInt2 - 1, paramInt3, 2);
    a(paramInt1 - 1, paramInt2 - 2, paramInt3, 3);
    a(paramInt1 - 1, paramInt2 - 1, paramInt3, 4);
    a(paramInt1 - 1, paramInt2, paramInt3, 5);
    a(paramInt1, paramInt2 - 2, paramInt3, 6);
    a(paramInt1, paramInt2 - 1, paramInt3, 7);
    a(paramInt1, paramInt2, paramInt3, 8);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    int m;
    int k;
    if (paramInt1 < 0)
    {
      m = paramInt1 + this.b;
      k = paramInt2 + (4 - (4 + this.b) % 8);
    }
    for (;;)
    {
      if (k < 0)
      {
        k += this.c;
        m += 4 - (4 + this.c) % 8;
      }
      if ((this.a.charAt(paramInt3) & i << 8 - paramInt4) != 0) {}
      for (;;)
      {
        a(k, m, i);
        return;
        int j = 0;
      }
      k = paramInt2;
      m = paramInt1;
    }
  }
  
  private void b(int paramInt)
  {
    a(-3 + this.b, 0, paramInt, 1);
    a(-2 + this.b, 0, paramInt, 2);
    a(-1 + this.b, 0, paramInt, 3);
    a(0, -4 + this.c, paramInt, 4);
    a(0, -3 + this.c, paramInt, 5);
    a(0, -2 + this.c, paramInt, 6);
    a(0, -1 + this.c, paramInt, 7);
    a(1, -1 + this.c, paramInt, 8);
  }
  
  private void c(int paramInt)
  {
    a(-3 + this.b, 0, paramInt, 1);
    a(-2 + this.b, 0, paramInt, 2);
    a(-1 + this.b, 0, paramInt, 3);
    a(0, -2 + this.c, paramInt, 4);
    a(0, -1 + this.c, paramInt, 5);
    a(1, -1 + this.c, paramInt, 6);
    a(2, -1 + this.c, paramInt, 7);
    a(3, -1 + this.c, paramInt, 8);
  }
  
  private void d(int paramInt)
  {
    a(-1 + this.b, 0, paramInt, 1);
    a(-1 + this.b, -1 + this.c, paramInt, 2);
    a(0, -3 + this.c, paramInt, 3);
    a(0, -2 + this.c, paramInt, 4);
    a(0, -1 + this.c, paramInt, 5);
    a(1, -3 + this.c, paramInt, 6);
    a(1, -2 + this.c, paramInt, 7);
    a(1, -1 + this.c, paramInt, 8);
  }
  
  public final void a()
  {
    int i = 0;
    int j = 4;
    int k = 0;
    if ((j == this.b) && (i == 0))
    {
      int i9 = k + 1;
      a(k);
      k = i9;
    }
    if ((j == -2 + this.b) && (i == 0) && (this.c % 4 != 0))
    {
      int i8 = k + 1;
      b(k);
      k = i8;
    }
    if ((j == -2 + this.b) && (i == 0) && (this.c % 8 == 4))
    {
      int i7 = k + 1;
      c(k);
      k = i7;
    }
    if ((j == 4 + this.b) && (i == 2) && (this.c % 8 == 0))
    {
      int i6 = k + 1;
      d(k);
      k = i6;
    }
    do
    {
      if ((j < this.b) && (i >= 0) && (!b(i, j)))
      {
        int i5 = k + 1;
        a(j, i, k);
        k = i5;
      }
      j -= 2;
      i += 2;
    } while ((j >= 0) && (i < this.c));
    int m = j + 1;
    int n = i + 3;
    int i1 = m;
    int i2 = n;
    int i3 = k;
    label220:
    if ((i1 >= 0) && (i2 < this.c) && (!b(i2, i1)))
    {
      k = i3 + 1;
      a(i1, i2, i3);
    }
    for (;;)
    {
      i1 += 2;
      int i4 = i2 - 2;
      if ((i1 >= this.b) || (i4 < 0))
      {
        j = i1 + 3;
        i = i4 + 1;
        if ((j < this.b) || (i < this.c)) {
          break;
        }
        if (!b(-1 + this.c, -1 + this.b))
        {
          a(-1 + this.c, -1 + this.b, true);
          a(-2 + this.c, -2 + this.b, true);
        }
        return;
      }
      i2 = i4;
      i3 = k;
      break label220;
      k = i3;
    }
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.d;
    int i = paramInt1 + paramInt2 * this.c;
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      arrayOfByte[i] = j;
      return;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    return this.d[(paramInt1 + paramInt2 * this.c)] == 1;
  }
  
  final boolean b(int paramInt1, int paramInt2)
  {
    return this.d[(paramInt1 + paramInt2 * this.c)] >= 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.DefaultPlacement
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */