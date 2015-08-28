package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;

public class SymbolInfo
{
  static final SymbolInfo[] a = arrayOfSymbolInfo;
  private static SymbolInfo[] d = a;
  public final int b;
  public final int c;
  private final boolean e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  
  static
  {
    SymbolInfo[] arrayOfSymbolInfo = new SymbolInfo[30];
    arrayOfSymbolInfo[0] = new SymbolInfo(false, 3, 5, 8, 8, 1);
    arrayOfSymbolInfo[1] = new SymbolInfo(false, 5, 7, 10, 10, 1);
    arrayOfSymbolInfo[2] = new SymbolInfo(true, 5, 7, 16, 6, 1);
    arrayOfSymbolInfo[3] = new SymbolInfo(false, 8, 10, 12, 12, 1);
    arrayOfSymbolInfo[4] = new SymbolInfo(true, 10, 11, 14, 6, 2);
    arrayOfSymbolInfo[5] = new SymbolInfo(false, 12, 12, 14, 14, 1);
    arrayOfSymbolInfo[6] = new SymbolInfo(true, 16, 14, 24, 10, 1);
    arrayOfSymbolInfo[7] = new SymbolInfo(false, 18, 14, 16, 16, 1);
    arrayOfSymbolInfo[8] = new SymbolInfo(false, 22, 18, 18, 18, 1);
    arrayOfSymbolInfo[9] = new SymbolInfo(true, 22, 18, 16, 10, 2);
    arrayOfSymbolInfo[10] = new SymbolInfo(false, 30, 20, 20, 20, 1);
    arrayOfSymbolInfo[11] = new SymbolInfo(true, 32, 24, 16, 14, 2);
    arrayOfSymbolInfo[12] = new SymbolInfo(false, 36, 24, 22, 22, 1);
    arrayOfSymbolInfo[13] = new SymbolInfo(false, 44, 28, 24, 24, 1);
    arrayOfSymbolInfo[14] = new SymbolInfo(true, 49, 28, 22, 14, 2);
    arrayOfSymbolInfo[15] = new SymbolInfo(false, 62, 36, 14, 14, 4);
    arrayOfSymbolInfo[16] = new SymbolInfo(false, 86, 42, 16, 16, 4);
    arrayOfSymbolInfo[17] = new SymbolInfo(false, 114, 48, 18, 18, 4);
    arrayOfSymbolInfo[18] = new SymbolInfo(false, 144, 56, 20, 20, 4);
    arrayOfSymbolInfo[19] = new SymbolInfo(false, 174, 68, 22, 22, 4);
    arrayOfSymbolInfo[20] = new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42);
    arrayOfSymbolInfo[21] = new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56);
    arrayOfSymbolInfo[22] = new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36);
    arrayOfSymbolInfo[23] = new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48);
    arrayOfSymbolInfo[24] = new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56);
    arrayOfSymbolInfo[25] = new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68);
    arrayOfSymbolInfo[26] = new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56);
    arrayOfSymbolInfo[27] = new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68);
    arrayOfSymbolInfo[28] = new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62);
    arrayOfSymbolInfo[29] = new DataMatrixSymbolInfo144();
  }
  
  public SymbolInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt1, paramInt2);
  }
  
  SymbolInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.e = paramBoolean;
    this.f = paramInt1;
    this.g = paramInt2;
    this.b = paramInt3;
    this.c = paramInt4;
    this.h = paramInt5;
    this.i = paramInt6;
    this.j = paramInt7;
  }
  
  public static SymbolInfo a(int paramInt, SymbolShapeHint paramSymbolShapeHint, Dimension paramDimension1, Dimension paramDimension2, boolean paramBoolean)
  {
    SymbolInfo[] arrayOfSymbolInfo = d;
    int k = arrayOfSymbolInfo.length;
    int m = 0;
    if (m < k)
    {
      SymbolInfo localSymbolInfo = arrayOfSymbolInfo[m];
      if ((paramSymbolShapeHint == SymbolShapeHint.b) && (localSymbolInfo.e)) {}
      while (((paramSymbolShapeHint == SymbolShapeHint.c) && (!localSymbolInfo.e)) || ((paramDimension1 != null) && ((localSymbolInfo.f() < paramDimension1.a()) || (localSymbolInfo.g() < paramDimension1.b()))) || ((paramDimension2 != null) && ((localSymbolInfo.f() > paramDimension2.a()) || (localSymbolInfo.g() > paramDimension2.b()))) || (paramInt > localSymbolInfo.f))
      {
        m++;
        break;
      }
      return localSymbolInfo;
    }
    if (paramBoolean) {
      throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + paramInt);
    }
    return null;
  }
  
  public int a()
  {
    return this.f / this.i;
  }
  
  public int a(int paramInt)
  {
    return this.i;
  }
  
  final int b()
  {
    int k = 2;
    switch (this.h)
    {
    default: 
      throw new IllegalStateException("Cannot handle this number of data regions");
    case 1: 
      k = 1;
    case 2: 
    case 4: 
      return k;
    case 16: 
      return 4;
    }
    return 6;
  }
  
  public final int b(int paramInt)
  {
    return this.j;
  }
  
  final int c()
  {
    int k = 1;
    switch (this.h)
    {
    default: 
      throw new IllegalStateException("Cannot handle this number of data regions");
    case 4: 
      k = 2;
    case 1: 
    case 2: 
      return k;
    case 16: 
      return 4;
    }
    return 6;
  }
  
  public final int d()
  {
    return b() * this.b;
  }
  
  public final int e()
  {
    return c() * this.c;
  }
  
  public final int f()
  {
    return d() + 2 * b();
  }
  
  public final int g()
  {
    return e() + 2 * c();
  }
  
  public final int h()
  {
    return this.f;
  }
  
  public final int i()
  {
    return this.g;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.e) {}
    for (String str = "Rectangular Symbol:";; str = "Square Symbol:")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(" data region ").append(this.b).append('x').append(this.c);
      localStringBuilder.append(", symbol size ").append(f()).append('x').append(g());
      localStringBuilder.append(", symbol data size ").append(d()).append('x').append(e());
      localStringBuilder.append(", codewords ").append(this.f).append('+').append(this.g);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.SymbolInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */