package com.google.zxing.pdf417.decoder;

final class Codeword
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private int e = -1;
  
  Codeword(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  boolean a()
  {
    return a(this.e);
  }
  
  boolean a(int paramInt)
  {
    return (paramInt != -1) && (this.c == 3 * (paramInt % 3));
  }
  
  void b()
  {
    this.e = (3 * (this.d / 30) + this.c / 3);
  }
  
  void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  int c()
  {
    return this.b - this.a;
  }
  
  int d()
  {
    return this.a;
  }
  
  int e()
  {
    return this.b;
  }
  
  int f()
  {
    return this.c;
  }
  
  int g()
  {
    return this.d;
  }
  
  int h()
  {
    return this.e;
  }
  
  public String toString()
  {
    return this.e + "|" + this.d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.Codeword
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */