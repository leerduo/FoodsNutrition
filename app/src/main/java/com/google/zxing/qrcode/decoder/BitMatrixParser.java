package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser
{
  private final BitMatrix a;
  private Version b;
  private FormatInformation c;
  private boolean d;
  
  BitMatrixParser(BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.g();
    if ((i < 21) || ((i & 0x3) != 1)) {
      throw FormatException.a();
    }
    this.a = paramBitMatrix;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d) {}
    for (boolean bool = this.a.a(paramInt2, paramInt1); bool; bool = this.a.a(paramInt1, paramInt2)) {
      return 0x1 | paramInt3 << 1;
    }
    return paramInt3 << 1;
  }
  
  FormatInformation a()
  {
    int i = 0;
    if (this.c != null) {
      return this.c;
    }
    int j = 0;
    int k = 0;
    while (j < 6)
    {
      k = a(j, 8, k);
      j++;
    }
    int m = a(8, 7, a(8, 8, a(7, 8, k)));
    for (int n = 5; n >= 0; n--) {
      m = a(8, n, m);
    }
    int i1 = this.a.g();
    int i2 = i1 - 7;
    for (int i3 = i1 - 1; i3 >= i2; i3--) {
      i = a(8, i3, i);
    }
    for (int i4 = i1 - 8; i4 < i1; i4++) {
      i = a(i4, 8, i);
    }
    this.c = FormatInformation.b(m, i);
    if (this.c != null) {
      return this.c;
    }
    throw FormatException.a();
  }
  
  void a(boolean paramBoolean)
  {
    this.b = null;
    this.c = null;
    this.d = paramBoolean;
  }
  
  Version b()
  {
    if (this.b != null) {
      return this.b;
    }
    int i = this.a.g();
    int j = i - 17 >> 2;
    if (j <= 6) {
      return Version.b(j);
    }
    int k = i - 11;
    int m = 5;
    int n = 0;
    while (m >= 0)
    {
      for (int i4 = i - 9; i4 >= k; i4--) {
        n = a(i4, m, n);
      }
      m--;
    }
    Version localVersion1 = Version.c(n);
    if ((localVersion1 != null) && (localVersion1.d() == i))
    {
      this.b = localVersion1;
      return localVersion1;
    }
    int i1 = 0;
    for (int i2 = 5; i2 >= 0; i2--) {
      for (int i3 = i - 9; i3 >= k; i3--) {
        i1 = a(i2, i3, i1);
      }
    }
    Version localVersion2 = Version.c(i1);
    if ((localVersion2 != null) && (localVersion2.d() == i))
    {
      this.b = localVersion2;
      return localVersion2;
    }
    throw FormatException.a();
  }
  
  byte[] c()
  {
    FormatInformation localFormatInformation = a();
    Version localVersion = b();
    DataMask localDataMask = DataMask.a(localFormatInformation.b());
    int i = this.a.g();
    localDataMask.a(this.a, i);
    BitMatrix localBitMatrix = localVersion.e();
    byte[] arrayOfByte = new byte[localVersion.c()];
    int j = i - 1;
    int k = 0;
    int m = 0;
    int n = 0;
    int i3;
    for (int i1 = 1; j > 0; i1 = i3)
    {
      if (j == 6) {
        j--;
      }
      for (int i2 = 0; i2 < i; i2++)
      {
        if (i1 != 0) {}
        for (int i4 = i - 1 - i2;; i4 = i2) {
          for (int i5 = 0; i5 < 2; i5++) {
            if (!localBitMatrix.a(j - i5, i4))
            {
              k++;
              m <<= 1;
              if (this.a.a(j - i5, i4)) {
                m |= 1;
              }
              if (k == 8)
              {
                int i6 = n + 1;
                arrayOfByte[n] = ((byte)m);
                m = 0;
                n = i6;
                k = 0;
              }
            }
          }
        }
      }
      i3 = i1 ^ 0x1;
      j -= 2;
    }
    if (n != localVersion.c()) {
      throw FormatException.a();
    }
    return arrayOfByte;
  }
  
  void d()
  {
    if (this.c == null) {
      return;
    }
    DataMask localDataMask = DataMask.a(this.c.b());
    int i = this.a.g();
    localDataMask.a(this.a, i);
  }
  
  void e()
  {
    for (int i = 0; i < this.a.f(); i++) {
      for (int j = i + 1; j < this.a.g(); j++) {
        if (this.a.a(i, j) != this.a.a(j, i))
        {
          this.a.c(j, i);
          this.a.c(i, j);
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.BitMatrixParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */