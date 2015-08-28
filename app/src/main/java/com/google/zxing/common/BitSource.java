package com.google.zxing.common;

public final class BitSource
{
  private final byte[] a;
  private int b;
  private int c;
  
  public BitSource(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 32) || (paramInt > c())) {
      throw new IllegalArgumentException(String.valueOf(paramInt));
    }
    int n;
    int i1;
    int j;
    int i;
    if (this.c > 0)
    {
      n = 8 - this.c;
      if (paramInt < n)
      {
        i1 = paramInt;
        int i2 = n - i1;
        int i3 = (255 >> 8 - i1 << i2 & this.a[this.b]) >> i2;
        int i4 = paramInt - i1;
        this.c = (i1 + this.c);
        if (this.c == 8)
        {
          this.c = 0;
          this.b = (1 + this.b);
        }
        j = i3;
        i = i4;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        for (;;)
        {
          if (i >= 8)
          {
            j = j << 8 | 0xFF & this.a[this.b];
            this.b = (1 + this.b);
            i -= 8;
            continue;
            i1 = n;
            break;
          }
        }
        if (i > 0)
        {
          int k = 8 - i;
          int m = 255 >> k << k;
          j = j << i | (m & this.a[this.b]) >> k;
          this.c = (i + this.c);
        }
      }
      return j;
      i = paramInt;
      j = 0;
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return 8 * (this.a.length - this.b) - this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.BitSource
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */