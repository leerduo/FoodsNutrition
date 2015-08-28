package com.google.zxing.pdf417.decoder.ec;

public final class ModulusGF
{
  public static final ModulusGF a = new ModulusGF(929, 3);
  private final int[] b;
  private final int[] c;
  private final ModulusPoly d;
  private final ModulusPoly e;
  private final int f;
  
  private ModulusGF(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.b = new int[paramInt1];
    this.c = new int[paramInt1];
    int i = 0;
    int j = 1;
    while (i < paramInt1)
    {
      this.b[i] = j;
      j = j * paramInt2 % paramInt1;
      i++;
    }
    for (int k = 0; k < paramInt1 - 1; k++) {
      this.c[this.b[k]] = k;
    }
    this.d = new ModulusPoly(this, new int[] { 0 });
    this.e = new ModulusPoly(this, new int[] { 1 });
  }
  
  int a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  ModulusPoly a()
  {
    return this.d;
  }
  
  ModulusPoly a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.d;
    }
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new ModulusPoly(this, arrayOfInt);
  }
  
  int b(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException();
    }
    return this.c[paramInt];
  }
  
  int b(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) % this.f;
  }
  
  ModulusPoly b()
  {
    return this.e;
  }
  
  int c()
  {
    return this.f;
  }
  
  int c(int paramInt)
  {
    if (paramInt == 0) {
      throw new ArithmeticException();
    }
    return this.b[(-1 + (this.f - this.c[paramInt]))];
  }
  
  int c(int paramInt1, int paramInt2)
  {
    return (paramInt1 + this.f - paramInt2) % this.f;
  }
  
  int d(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.b[((this.c[paramInt1] + this.c[paramInt2]) % (-1 + this.f))];
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.ec.ModulusGF
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */