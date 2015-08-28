package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

class DetectionResultColumn
{
  private final BoundingBox a;
  private final Codeword[] b;
  
  DetectionResultColumn(BoundingBox paramBoundingBox)
  {
    this.a = new BoundingBox(paramBoundingBox);
    this.b = new Codeword[1 + (paramBoundingBox.d() - paramBoundingBox.c())];
  }
  
  final BoundingBox a()
  {
    return this.a;
  }
  
  final Codeword a(int paramInt)
  {
    Codeword localCodeword = c(paramInt);
    if (localCodeword != null) {
      return localCodeword;
    }
    for (int i = 1;; i++)
    {
      if (i >= 5) {
        break label82;
      }
      int j = b(paramInt) - i;
      if (j >= 0)
      {
        localCodeword = this.b[j];
        if (localCodeword != null) {
          break;
        }
      }
      int k = i + b(paramInt);
      if (k < this.b.length)
      {
        localCodeword = this.b[k];
        if (localCodeword != null) {
          break;
        }
      }
    }
    label82:
    return null;
  }
  
  final void a(int paramInt, Codeword paramCodeword)
  {
    this.b[b(paramInt)] = paramCodeword;
  }
  
  final int b(int paramInt)
  {
    return paramInt - this.a.c();
  }
  
  final Codeword[] b()
  {
    return this.b;
  }
  
  final Codeword c(int paramInt)
  {
    return this.b[b(paramInt)];
  }
  
  public String toString()
  {
    Formatter localFormatter = new Formatter();
    Codeword[] arrayOfCodeword = this.b;
    int i = arrayOfCodeword.length;
    int j = 0;
    int k = 0;
    if (j < i)
    {
      Codeword localCodeword = arrayOfCodeword[j];
      int m;
      if (localCodeword == null)
      {
        Object[] arrayOfObject2 = new Object[1];
        m = k + 1;
        arrayOfObject2[0] = Integer.valueOf(k);
        localFormatter.format("%3d:    |   %n", arrayOfObject2);
      }
      for (;;)
      {
        j++;
        k = m;
        break;
        Object[] arrayOfObject1 = new Object[3];
        m = k + 1;
        arrayOfObject1[0] = Integer.valueOf(k);
        arrayOfObject1[1] = Integer.valueOf(localCodeword.h());
        arrayOfObject1[2] = Integer.valueOf(localCodeword.g());
        localFormatter.format("%3d: %3d|%3d%n", arrayOfObject1);
      }
    }
    String str = localFormatter.toString();
    localFormatter.close();
    return str;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.DetectionResultColumn
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */