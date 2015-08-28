package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection
{
  private final ModulusGF a = ModulusGF.a;
  
  private int[] a(ModulusPoly paramModulusPoly)
  {
    int i = paramModulusPoly.a();
    int[] arrayOfInt = new int[i];
    int j = 0;
    for (int k = 1; (k < this.a.c()) && (j < i); k++) {
      if (paramModulusPoly.b(k) == 0)
      {
        arrayOfInt[j] = this.a.c(k);
        j++;
      }
    }
    if (j != i) {
      throw ChecksumException.a();
    }
    return arrayOfInt;
  }
  
  private int[] a(ModulusPoly paramModulusPoly1, ModulusPoly paramModulusPoly2, int[] paramArrayOfInt)
  {
    int i = paramModulusPoly2.a();
    int[] arrayOfInt1 = new int[i];
    for (int j = 1; j <= i; j++) {
      arrayOfInt1[(i - j)] = this.a.d(j, paramModulusPoly2.a(j));
    }
    ModulusPoly localModulusPoly = new ModulusPoly(this.a, arrayOfInt1);
    int k = paramArrayOfInt.length;
    int[] arrayOfInt2 = new int[k];
    for (int m = 0; m < k; m++)
    {
      int n = this.a.c(paramArrayOfInt[m]);
      int i1 = this.a.c(0, paramModulusPoly1.b(n));
      int i2 = this.a.c(localModulusPoly.b(n));
      arrayOfInt2[m] = this.a.d(i1, i2);
    }
    return arrayOfInt2;
  }
  
  private ModulusPoly[] a(ModulusPoly paramModulusPoly1, ModulusPoly paramModulusPoly2, int paramInt)
  {
    if (paramModulusPoly1.a() < paramModulusPoly2.a()) {}
    for (;;)
    {
      Object localObject1 = this.a.a();
      Object localObject2 = this.a.b();
      while (paramModulusPoly1.a() >= paramInt / 2)
      {
        if (paramModulusPoly1.b()) {
          throw ChecksumException.a();
        }
        ModulusPoly localModulusPoly2 = this.a.a();
        int k = paramModulusPoly1.a(paramModulusPoly1.a());
        int m = this.a.c(k);
        ModulusPoly localModulusPoly3 = localModulusPoly2;
        int n;
        int i1;
        for (ModulusPoly localModulusPoly4 = paramModulusPoly2; (localModulusPoly4.a() >= paramModulusPoly1.a()) && (!localModulusPoly4.b()); localModulusPoly4 = localModulusPoly4.b(paramModulusPoly1.a(n, i1)))
        {
          n = localModulusPoly4.a() - paramModulusPoly1.a();
          i1 = this.a.d(localModulusPoly4.a(localModulusPoly4.a()), m);
          localModulusPoly3 = localModulusPoly3.a(this.a.a(n, i1));
        }
        ModulusPoly localModulusPoly5 = localModulusPoly3.c((ModulusPoly)localObject2).b((ModulusPoly)localObject1).c();
        paramModulusPoly2 = paramModulusPoly1;
        paramModulusPoly1 = localModulusPoly4;
        Object localObject3 = localObject2;
        localObject2 = localModulusPoly5;
        localObject1 = localObject3;
      }
      int i = ((ModulusPoly)localObject2).a(0);
      if (i == 0) {
        throw ChecksumException.a();
      }
      int j = this.a.c(i);
      return new ModulusPoly[] { ((ModulusPoly)localObject2).c(j), paramModulusPoly1.c(j) };
      ModulusPoly localModulusPoly1 = paramModulusPoly2;
      paramModulusPoly2 = paramModulusPoly1;
      paramModulusPoly1 = localModulusPoly1;
    }
  }
  
  public int a(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    ModulusPoly localModulusPoly1 = new ModulusPoly(this.a, paramArrayOfInt1);
    int[] arrayOfInt1 = new int[paramInt];
    int i = paramInt;
    int j = 0;
    while (i > 0)
    {
      int i4 = localModulusPoly1.b(this.a.a(i));
      arrayOfInt1[(paramInt - i)] = i4;
      if (i4 != 0) {
        j = 1;
      }
      i--;
    }
    if (j == 0) {
      return 0;
    }
    ModulusPoly localModulusPoly2 = this.a.b();
    int k = paramArrayOfInt2.length;
    ModulusPoly localModulusPoly3 = localModulusPoly2;
    for (int m = 0; m < k; m++)
    {
      int i2 = paramArrayOfInt2[m];
      int i3 = this.a.a(-1 + paramArrayOfInt1.length - i2);
      ModulusGF localModulusGF = this.a;
      int[] arrayOfInt4 = new int[2];
      arrayOfInt4[0] = this.a.c(0, i3);
      arrayOfInt4[1] = 1;
      localModulusPoly3 = localModulusPoly3.c(new ModulusPoly(localModulusGF, arrayOfInt4));
    }
    ModulusPoly localModulusPoly4 = new ModulusPoly(this.a, arrayOfInt1);
    ModulusPoly[] arrayOfModulusPoly = a(this.a.a(paramInt, 1), localModulusPoly4, paramInt);
    ModulusPoly localModulusPoly5 = arrayOfModulusPoly[0];
    ModulusPoly localModulusPoly6 = arrayOfModulusPoly[1];
    int[] arrayOfInt2 = a(localModulusPoly5);
    int[] arrayOfInt3 = a(localModulusPoly6, localModulusPoly5, arrayOfInt2);
    for (int n = 0; n < arrayOfInt2.length; n++)
    {
      int i1 = -1 + paramArrayOfInt1.length - this.a.b(arrayOfInt2[n]);
      if (i1 < 0) {
        throw ChecksumException.a();
      }
      paramArrayOfInt1[i1] = this.a.c(paramArrayOfInt1[i1], arrayOfInt3[n]);
    }
    return arrayOfInt2.length;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.ec.ErrorCorrection
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */