package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

public final class Version
{
  private static final Version[] a = ;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final Version.ECBlocks g;
  private final int h;
  
  private Version(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Version.ECBlocks paramECBlocks)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramECBlocks;
    int j = paramECBlocks.a();
    Version.ECB[] arrayOfECB = paramECBlocks.b();
    int k = arrayOfECB.length;
    int m = 0;
    while (i < k)
    {
      Version.ECB localECB = arrayOfECB[i];
      m += localECB.a() * (j + localECB.b());
      i++;
    }
    this.h = m;
  }
  
  public static Version a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 & 0x1) != 0) || ((paramInt2 & 0x1) != 0)) {
      throw FormatException.a();
    }
    for (Version localVersion : a) {
      if ((localVersion.c == paramInt1) && (localVersion.d == paramInt2)) {
        return localVersion;
      }
    }
    throw FormatException.a();
  }
  
  private static Version[] h()
  {
    Version[] arrayOfVersion = new Version[30];
    arrayOfVersion[0] = new Version(1, 10, 10, 8, 8, new Version.ECBlocks(5, new Version.ECB(1, 3, null), null));
    arrayOfVersion[1] = new Version(2, 12, 12, 10, 10, new Version.ECBlocks(7, new Version.ECB(1, 5, null), null));
    arrayOfVersion[2] = new Version(3, 14, 14, 12, 12, new Version.ECBlocks(10, new Version.ECB(1, 8, null), null));
    arrayOfVersion[3] = new Version(4, 16, 16, 14, 14, new Version.ECBlocks(12, new Version.ECB(1, 12, null), null));
    arrayOfVersion[4] = new Version(5, 18, 18, 16, 16, new Version.ECBlocks(14, new Version.ECB(1, 18, null), null));
    arrayOfVersion[5] = new Version(6, 20, 20, 18, 18, new Version.ECBlocks(18, new Version.ECB(1, 22, null), null));
    arrayOfVersion[6] = new Version(7, 22, 22, 20, 20, new Version.ECBlocks(20, new Version.ECB(1, 30, null), null));
    arrayOfVersion[7] = new Version(8, 24, 24, 22, 22, new Version.ECBlocks(24, new Version.ECB(1, 36, null), null));
    arrayOfVersion[8] = new Version(9, 26, 26, 24, 24, new Version.ECBlocks(28, new Version.ECB(1, 44, null), null));
    arrayOfVersion[9] = new Version(10, 32, 32, 14, 14, new Version.ECBlocks(36, new Version.ECB(1, 62, null), null));
    arrayOfVersion[10] = new Version(11, 36, 36, 16, 16, new Version.ECBlocks(42, new Version.ECB(1, 86, null), null));
    arrayOfVersion[11] = new Version(12, 40, 40, 18, 18, new Version.ECBlocks(48, new Version.ECB(1, 114, null), null));
    arrayOfVersion[12] = new Version(13, 44, 44, 20, 20, new Version.ECBlocks(56, new Version.ECB(1, 144, null), null));
    arrayOfVersion[13] = new Version(14, 48, 48, 22, 22, new Version.ECBlocks(68, new Version.ECB(1, 174, null), null));
    arrayOfVersion[14] = new Version(15, 52, 52, 24, 24, new Version.ECBlocks(42, new Version.ECB(2, 102, null), null));
    arrayOfVersion[15] = new Version(16, 64, 64, 14, 14, new Version.ECBlocks(56, new Version.ECB(2, 140, null), null));
    arrayOfVersion[16] = new Version(17, 72, 72, 16, 16, new Version.ECBlocks(36, new Version.ECB(4, 92, null), null));
    arrayOfVersion[17] = new Version(18, 80, 80, 18, 18, new Version.ECBlocks(48, new Version.ECB(4, 114, null), null));
    arrayOfVersion[18] = new Version(19, 88, 88, 20, 20, new Version.ECBlocks(56, new Version.ECB(4, 144, null), null));
    arrayOfVersion[19] = new Version(20, 96, 96, 22, 22, new Version.ECBlocks(68, new Version.ECB(4, 174, null), null));
    arrayOfVersion[20] = new Version(21, 104, 104, 24, 24, new Version.ECBlocks(56, new Version.ECB(6, 136, null), null));
    arrayOfVersion[21] = new Version(22, 120, 120, 18, 18, new Version.ECBlocks(68, new Version.ECB(6, 175, null), null));
    arrayOfVersion[22] = new Version(23, 132, 132, 20, 20, new Version.ECBlocks(62, new Version.ECB(8, 163, null), null));
    arrayOfVersion[23] = new Version(24, 144, 144, 22, 22, new Version.ECBlocks(62, new Version.ECB(8, 156, null), new Version.ECB(2, 155, null), null));
    arrayOfVersion[24] = new Version(25, 8, 18, 6, 16, new Version.ECBlocks(7, new Version.ECB(1, 5, null), null));
    arrayOfVersion[25] = new Version(26, 8, 32, 6, 14, new Version.ECBlocks(11, new Version.ECB(1, 10, null), null));
    arrayOfVersion[26] = new Version(27, 12, 26, 10, 24, new Version.ECBlocks(14, new Version.ECB(1, 16, null), null));
    arrayOfVersion[27] = new Version(28, 12, 36, 10, 16, new Version.ECBlocks(18, new Version.ECB(1, 22, null), null));
    arrayOfVersion[28] = new Version(29, 16, 36, 14, 16, new Version.ECBlocks(24, new Version.ECB(1, 32, null), null));
    arrayOfVersion[29] = new Version(30, 16, 48, 14, 22, new Version.ECBlocks(28, new Version.ECB(1, 49, null), null));
    return arrayOfVersion;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.h;
  }
  
  Version.ECBlocks g()
  {
    return this.g;
  }
  
  public String toString()
  {
    return String.valueOf(this.b);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.decoder.Version
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */