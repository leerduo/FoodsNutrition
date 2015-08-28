package com.google.zxing.pdf417.decoder.ec;

final class ModulusPoly
{
  private final ModulusGF a;
  private final int[] b;
  
  ModulusPoly(ModulusGF paramModulusGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.a = paramModulusGF;
    int j = paramArrayOfInt.length;
    if ((j > i) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i++;
      }
      if (i == j)
      {
        this.b = paramModulusGF.a().b;
        return;
      }
      this.b = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.b, 0, this.b.length);
      return;
    }
    this.b = paramArrayOfInt;
  }
  
  int a()
  {
    return -1 + this.b.length;
  }
  
  int a(int paramInt)
  {
    return this.b[(-1 + this.b.length - paramInt)];
  }
  
  ModulusPoly a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.a.a();
    }
    int i = this.b.length;
    int[] arrayOfInt = new int[i + paramInt1];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = this.a.d(this.b[j], paramInt2);
    }
    return new ModulusPoly(this.a, arrayOfInt);
  }
  
  ModulusPoly a(ModulusPoly paramModulusPoly)
  {
    if (!this.a.equals(paramModulusPoly.a)) {
      throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }
    if (b()) {
      return paramModulusPoly;
    }
    if (paramModulusPoly.b()) {
      return this;
    }
    Object localObject1 = this.b;
    Object localObject2 = paramModulusPoly.b;
    if (localObject1.length > localObject2.length) {}
    for (;;)
    {
      int[] arrayOfInt = new int[localObject1.length];
      int i = localObject1.length - localObject2.length;
      System.arraycopy(localObject1, 0, arrayOfInt, 0, i);
      for (int j = i; j < localObject1.length; j++) {
        arrayOfInt[j] = this.a.b(localObject2[(j - i)], localObject1[j]);
      }
      return new ModulusPoly(this.a, arrayOfInt);
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  int b(int paramInt)
  {
    int i = 0;
    int k;
    if (paramInt == 0) {
      k = a(0);
    }
    for (;;)
    {
      return k;
      int j = this.b.length;
      if (paramInt == 1)
      {
        int[] arrayOfInt = this.b;
        int i1 = arrayOfInt.length;
        int i3;
        for (k = 0; i < i1; k = i3)
        {
          int i2 = arrayOfInt[i];
          i3 = this.a.b(k, i2);
          i++;
        }
      }
      else
      {
        k = this.b[0];
        int m = 1;
        while (m < j)
        {
          int n = this.a.b(this.a.d(paramInt, k), this.b[m]);
          m++;
          k = n;
        }
      }
    }
  }
  
  ModulusPoly b(ModulusPoly paramModulusPoly)
  {
    if (!this.a.equals(paramModulusPoly.a)) {
      throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }
    if (paramModulusPoly.b()) {
      return this;
    }
    return a(paramModulusPoly.c());
  }
  
  boolean b()
  {
    int i = this.b[0];
    boolean bool = false;
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  ModulusPoly c()
  {
    int i = this.b.length;
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = this.a.c(0, this.b[j]);
    }
    return new ModulusPoly(this.a, arrayOfInt);
  }
  
  ModulusPoly c(int paramInt)
  {
    if (paramInt == 0) {
      this = this.a.a();
    }
    while (paramInt == 1) {
      return this;
    }
    int i = this.b.length;
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = this.a.d(this.b[j], paramInt);
    }
    return new ModulusPoly(this.a, arrayOfInt);
  }
  
  ModulusPoly c(ModulusPoly paramModulusPoly)
  {
    if (!this.a.equals(paramModulusPoly.a)) {
      throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }
    if ((b()) || (paramModulusPoly.b())) {
      return this.a.a();
    }
    int[] arrayOfInt1 = this.b;
    int i = arrayOfInt1.length;
    int[] arrayOfInt2 = paramModulusPoly.b;
    int j = arrayOfInt2.length;
    int[] arrayOfInt3 = new int[-1 + (i + j)];
    for (int k = 0; k < i; k++)
    {
      int m = arrayOfInt1[k];
      for (int n = 0; n < j; n++) {
        arrayOfInt3[(k + n)] = this.a.b(arrayOfInt3[(k + n)], this.a.d(m, arrayOfInt2[n]));
      }
    }
    return new ModulusPoly(this.a, arrayOfInt3);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(8 * a());
    int i = a();
    if (i >= 0)
    {
      int j = a(i);
      if (j != 0)
      {
        if (j >= 0) {
          break label85;
        }
        localStringBuilder.append(" - ");
        j = -j;
        label48:
        if ((i == 0) || (j != 1)) {
          localStringBuilder.append(j);
        }
        if (i != 0)
        {
          if (i != 1) {
            break label102;
          }
          localStringBuilder.append('x');
        }
      }
      for (;;)
      {
        i--;
        break;
        label85:
        if (localStringBuilder.length() <= 0) {
          break label48;
        }
        localStringBuilder.append(" + ");
        break label48;
        label102:
        localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.ec.ModulusPoly
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */