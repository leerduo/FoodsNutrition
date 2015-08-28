package com.google.zxing.common.reedsolomon;

public final class GenericGF
{
  public static final GenericGF a = new GenericGF(4201, 4096, 1);
  public static final GenericGF b = new GenericGF(1033, 1024, 1);
  public static final GenericGF c = new GenericGF(67, 64, 1);
  public static final GenericGF d = new GenericGF(19, 16, 1);
  public static final GenericGF e = new GenericGF(285, 256, 0);
  public static final GenericGF f = new GenericGF(301, 256, 1);
  public static final GenericGF g = f;
  public static final GenericGF h = c;
  private int[] i;
  private int[] j;
  private GenericGFPoly k;
  private GenericGFPoly l;
  private final int m;
  private final int n;
  private final int o;
  private boolean p = false;
  
  public GenericGF(int paramInt1, int paramInt2, int paramInt3)
  {
    this.n = paramInt1;
    this.m = paramInt2;
    this.o = paramInt3;
    if (paramInt2 <= 0) {
      e();
    }
  }
  
  static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  private void e()
  {
    this.i = new int[this.m];
    this.j = new int[this.m];
    int i1 = 0;
    int i2 = 1;
    while (i1 < this.m)
    {
      this.i[i1] = i2;
      i2 <<= 1;
      if (i2 >= this.m) {
        i2 = (i2 ^ this.n) & -1 + this.m;
      }
      i1++;
    }
    for (int i3 = 0; i3 < -1 + this.m; i3++) {
      this.j[this.i[i3]] = i3;
    }
    this.k = new GenericGFPoly(this, new int[] { 0 });
    this.l = new GenericGFPoly(this, new int[] { 1 });
    this.p = true;
  }
  
  private void f()
  {
    if (!this.p) {
      e();
    }
  }
  
  int a(int paramInt)
  {
    f();
    return this.i[paramInt];
  }
  
  GenericGFPoly a()
  {
    f();
    return this.k;
  }
  
  GenericGFPoly a(int paramInt1, int paramInt2)
  {
    f();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.k;
    }
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new GenericGFPoly(this, arrayOfInt);
  }
  
  int b(int paramInt)
  {
    f();
    if (paramInt == 0) {
      throw new IllegalArgumentException();
    }
    return this.j[paramInt];
  }
  
  GenericGFPoly b()
  {
    f();
    return this.l;
  }
  
  public int c()
  {
    return this.m;
  }
  
  int c(int paramInt)
  {
    f();
    if (paramInt == 0) {
      throw new ArithmeticException();
    }
    return this.i[(-1 + (this.m - this.j[paramInt]))];
  }
  
  int c(int paramInt1, int paramInt2)
  {
    f();
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.i[((this.j[paramInt1] + this.j[paramInt2]) % (-1 + this.m))];
  }
  
  public int d()
  {
    return this.o;
  }
  
  public String toString()
  {
    return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGF
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */