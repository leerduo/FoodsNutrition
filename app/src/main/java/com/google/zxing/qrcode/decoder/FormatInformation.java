package com.google.zxing.qrcode.decoder;

final class FormatInformation
{
  private static final int[][] a = { { 21522, 0 }, { 20773, 1 }, { 24188, 2 }, { 23371, 3 }, { 17913, 4 }, { 16590, 5 }, { 20375, 6 }, { 19104, 7 }, { 30660, 8 }, { 29427, 9 }, { 32170, 10 }, { 30877, 11 }, { 26159, 12 }, { 25368, 13 }, { 27713, 14 }, { 26998, 15 }, { 5769, 16 }, { 5054, 17 }, { 7399, 18 }, { 6608, 19 }, { 1890, 20 }, { 597, 21 }, { 3340, 22 }, { 2107, 23 }, { 13663, 24 }, { 12392, 25 }, { 16177, 26 }, { 14854, 27 }, { 9396, 28 }, { 8579, 29 }, { 11994, 30 }, { 11245, 31 } };
  private static final int[] b = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
  private final ErrorCorrectionLevel c;
  private final byte d;
  
  private FormatInformation(int paramInt)
  {
    this.c = ErrorCorrectionLevel.a(0x3 & paramInt >> 3);
    this.d = ((byte)(paramInt & 0x7));
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 ^ paramInt2;
    return b[(i & 0xF)] + b[(0xF & i >>> 4)] + b[(0xF & i >>> 8)] + b[(0xF & i >>> 12)] + b[(0xF & i >>> 16)] + b[(0xF & i >>> 20)] + b[(0xF & i >>> 24)] + b[(0xF & i >>> 28)];
  }
  
  static FormatInformation b(int paramInt1, int paramInt2)
  {
    FormatInformation localFormatInformation = c(paramInt1, paramInt2);
    if (localFormatInformation != null) {
      return localFormatInformation;
    }
    return c(paramInt1 ^ 0x5412, paramInt2 ^ 0x5412);
  }
  
  private static FormatInformation c(int paramInt1, int paramInt2)
  {
    int i = 2147483647;
    int[][] arrayOfInt = a;
    int j = arrayOfInt.length;
    int k = 0;
    int m = 0;
    int[] arrayOfInt1;
    int n;
    int i1;
    if (k < j)
    {
      arrayOfInt1 = arrayOfInt[k];
      n = arrayOfInt1[0];
      if ((n == paramInt1) || (n == paramInt2)) {
        return new FormatInformation(arrayOfInt1[1]);
      }
      i1 = a(paramInt1, n);
      if (i1 >= i) {
        break label147;
      }
    }
    for (int i2 = arrayOfInt1[1];; i2 = m)
    {
      int i3;
      if (paramInt1 != paramInt2)
      {
        i3 = a(paramInt2, n);
        if (i3 < i1) {
          i2 = arrayOfInt1[1];
        }
      }
      for (;;)
      {
        k++;
        int i4 = i2;
        i = i3;
        m = i4;
        break;
        if (i <= 3) {
          return new FormatInformation(m);
        }
        return null;
        i3 = i1;
      }
      label147:
      i1 = i;
    }
  }
  
  ErrorCorrectionLevel a()
  {
    return this.c;
  }
  
  byte b()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FormatInformation)) {}
    FormatInformation localFormatInformation;
    do
    {
      return false;
      localFormatInformation = (FormatInformation)paramObject;
    } while ((this.c != localFormatInformation.c) || (this.d != localFormatInformation.d));
    return true;
  }
  
  public int hashCode()
  {
    return this.c.ordinal() << 3 | this.d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.FormatInformation
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */