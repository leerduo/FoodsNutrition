package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

final class DetectionResult
{
  private final BarcodeMetadata a;
  private final DetectionResultColumn[] b;
  private BoundingBox c;
  private final int d;
  
  DetectionResult(BarcodeMetadata paramBarcodeMetadata, BoundingBox paramBoundingBox)
  {
    this.a = paramBarcodeMetadata;
    this.d = paramBarcodeMetadata.a();
    this.c = paramBoundingBox;
    this.b = new DetectionResultColumn[2 + this.d];
  }
  
  private static int a(int paramInt1, int paramInt2, Codeword paramCodeword)
  {
    if (paramCodeword == null) {}
    while (paramCodeword.a()) {
      return paramInt2;
    }
    if (paramCodeword.a(paramInt1))
    {
      paramCodeword.b(paramInt1);
      return 0;
    }
    return paramInt2 + 1;
  }
  
  private void a(int paramInt1, int paramInt2, Codeword[] paramArrayOfCodeword)
  {
    Codeword localCodeword = paramArrayOfCodeword[paramInt2];
    Codeword[] arrayOfCodeword1 = this.b[(paramInt1 - 1)].b();
    if (this.b[(paramInt1 + 1)] != null) {}
    for (Codeword[] arrayOfCodeword2 = this.b[(paramInt1 + 1)].b();; arrayOfCodeword2 = arrayOfCodeword1)
    {
      Codeword[] arrayOfCodeword3 = new Codeword[14];
      arrayOfCodeword3[2] = arrayOfCodeword1[paramInt2];
      arrayOfCodeword3[3] = arrayOfCodeword2[paramInt2];
      if (paramInt2 > 0)
      {
        arrayOfCodeword3[0] = paramArrayOfCodeword[(paramInt2 - 1)];
        arrayOfCodeword3[4] = arrayOfCodeword1[(paramInt2 - 1)];
        arrayOfCodeword3[5] = arrayOfCodeword2[(paramInt2 - 1)];
      }
      if (paramInt2 > 1)
      {
        arrayOfCodeword3[8] = paramArrayOfCodeword[(paramInt2 - 2)];
        arrayOfCodeword3[10] = arrayOfCodeword1[(paramInt2 - 2)];
        arrayOfCodeword3[11] = arrayOfCodeword2[(paramInt2 - 2)];
      }
      if (paramInt2 < -1 + paramArrayOfCodeword.length)
      {
        arrayOfCodeword3[1] = paramArrayOfCodeword[(paramInt2 + 1)];
        arrayOfCodeword3[6] = arrayOfCodeword1[(paramInt2 + 1)];
        arrayOfCodeword3[7] = arrayOfCodeword2[(paramInt2 + 1)];
      }
      if (paramInt2 < -2 + paramArrayOfCodeword.length)
      {
        arrayOfCodeword3[9] = paramArrayOfCodeword[(paramInt2 + 2)];
        arrayOfCodeword3[12] = arrayOfCodeword1[(paramInt2 + 2)];
        arrayOfCodeword3[13] = arrayOfCodeword2[(paramInt2 + 2)];
      }
      int i = arrayOfCodeword3.length;
      for (int j = 0;; j++) {
        if ((j >= i) || (a(localCodeword, arrayOfCodeword3[j]))) {
          return;
        }
      }
    }
  }
  
  private void a(DetectionResultColumn paramDetectionResultColumn)
  {
    if (paramDetectionResultColumn != null) {
      ((DetectionResultRowIndicatorColumn)paramDetectionResultColumn).a(this.a);
    }
  }
  
  private static boolean a(Codeword paramCodeword1, Codeword paramCodeword2)
  {
    if (paramCodeword2 == null) {}
    while ((!paramCodeword2.a()) || (paramCodeword2.f() != paramCodeword1.f())) {
      return false;
    }
    paramCodeword1.b(paramCodeword2.h());
    return true;
  }
  
  private int f()
  {
    int i = g();
    if (i == 0) {
      return 0;
    }
    for (int j = 1; j < 1 + this.d; j++)
    {
      Codeword[] arrayOfCodeword = this.b[j].b();
      int k = 0;
      if (k < arrayOfCodeword.length)
      {
        if (arrayOfCodeword[k] == null) {}
        for (;;)
        {
          k++;
          break;
          if (!arrayOfCodeword[k].a()) {
            a(j, k, arrayOfCodeword);
          }
        }
      }
    }
    return i;
  }
  
  private int g()
  {
    h();
    return j() + i();
  }
  
  private void h()
  {
    int i = 0;
    if ((this.b[0] == null) || (this.b[(1 + this.d)] == null)) {}
    for (;;)
    {
      return;
      Codeword[] arrayOfCodeword1 = this.b[0].b();
      Codeword[] arrayOfCodeword2 = this.b[(1 + this.d)].b();
      while (i < arrayOfCodeword1.length)
      {
        if ((arrayOfCodeword1[i] != null) && (arrayOfCodeword2[i] != null) && (arrayOfCodeword1[i].h() == arrayOfCodeword2[i].h()))
        {
          int j = 1;
          if (j <= this.d)
          {
            Codeword localCodeword = this.b[j].b()[i];
            if (localCodeword == null) {}
            for (;;)
            {
              j++;
              break;
              localCodeword.b(arrayOfCodeword1[i].h());
              if (!localCodeword.a()) {
                this.b[j].b()[i] = null;
              }
            }
          }
        }
        i++;
      }
    }
  }
  
  private int i()
  {
    if (this.b[(1 + this.d)] == null) {
      return 0;
    }
    Codeword[] arrayOfCodeword = this.b[(1 + this.d)].b();
    int i = 0;
    int j = 0;
    if (i < arrayOfCodeword.length) {
      if (arrayOfCodeword[i] != null) {}
    }
    for (;;)
    {
      i++;
      break;
      int k = arrayOfCodeword[i].h();
      int m = 1 + this.d;
      int n = j;
      int i1 = 0;
      while ((m > 0) && (i1 < 2))
      {
        Codeword localCodeword = this.b[m].b()[i];
        if (localCodeword != null)
        {
          i1 = a(k, i1, localCodeword);
          if (!localCodeword.a()) {
            n++;
          }
        }
        m--;
        continue;
        return j;
      }
      j = n;
    }
  }
  
  private int j()
  {
    if (this.b[0] == null) {
      return 0;
    }
    Codeword[] arrayOfCodeword = this.b[0].b();
    int i = 0;
    int j = 0;
    if (i < arrayOfCodeword.length) {
      if (arrayOfCodeword[i] != null) {}
    }
    for (;;)
    {
      i++;
      break;
      int k = arrayOfCodeword[i].h();
      int m = j;
      int n = 1;
      int i1 = 0;
      while ((n < 1 + this.d) && (i1 < 2))
      {
        Codeword localCodeword = this.b[n].b()[i];
        if (localCodeword != null)
        {
          i1 = a(k, i1, localCodeword);
          if (!localCodeword.a()) {
            m++;
          }
        }
        n++;
        continue;
        return j;
      }
      j = m;
    }
  }
  
  DetectionResultColumn a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  void a(int paramInt, DetectionResultColumn paramDetectionResultColumn)
  {
    this.b[paramInt] = paramDetectionResultColumn;
  }
  
  public void a(BoundingBox paramBoundingBox)
  {
    this.c = paramBoundingBox;
  }
  
  DetectionResultColumn[] a()
  {
    a(this.b[0]);
    a(this.b[(1 + this.d)]);
    int j;
    for (int i = 928;; i = j)
    {
      j = f();
      if ((j <= 0) || (j >= i)) {
        return this.b;
      }
    }
  }
  
  int b()
  {
    return this.d;
  }
  
  int c()
  {
    return this.a.c();
  }
  
  int d()
  {
    return this.a.b();
  }
  
  BoundingBox e()
  {
    return this.c;
  }
  
  public String toString()
  {
    DetectionResultColumn localDetectionResultColumn = this.b[0];
    if (localDetectionResultColumn == null) {
      localDetectionResultColumn = this.b[(1 + this.d)];
    }
    Formatter localFormatter = new Formatter();
    for (int i = 0; i < localDetectionResultColumn.b().length; i++)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i);
      localFormatter.format("CW %3d:", arrayOfObject1);
      int j = 0;
      if (j < 2 + this.d)
      {
        if (this.b[j] == null) {
          localFormatter.format("    |   ", new Object[0]);
        }
        for (;;)
        {
          j++;
          break;
          Codeword localCodeword = this.b[j].b()[i];
          if (localCodeword == null)
          {
            localFormatter.format("    |   ", new Object[0]);
          }
          else
          {
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = Integer.valueOf(localCodeword.h());
            arrayOfObject2[1] = Integer.valueOf(localCodeword.g());
            localFormatter.format(" %3d|%3d", arrayOfObject2);
          }
        }
      }
      localFormatter.format("%n", new Object[0]);
    }
    String str = localFormatter.toString();
    localFormatter.close();
    return str;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.DetectionResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */