package com.xiaomi.network;

public class Base64Coder
{
  private static final String a = System.getProperty("line.separator");
  private static char[] b = new char[64];
  private static byte[] c;
  
  static
  {
    int i = 65;
    int i6;
    for (int j = 0; i <= 90; j = i6)
    {
      char[] arrayOfChar5 = b;
      i6 = j + 1;
      arrayOfChar5[j] = i;
      i = (char)(i + 1);
    }
    int k = 97;
    while (k <= 122)
    {
      char[] arrayOfChar4 = b;
      int i5 = j + 1;
      arrayOfChar4[j] = k;
      k = (char)(k + 1);
      j = i5;
    }
    int m = 48;
    while (m <= 57)
    {
      char[] arrayOfChar3 = b;
      int i4 = j + 1;
      arrayOfChar3[j] = m;
      m = (char)(m + 1);
      j = i4;
    }
    char[] arrayOfChar1 = b;
    int n = j + 1;
    arrayOfChar1[j] = '+';
    char[] arrayOfChar2 = b;
    (n + 1);
    arrayOfChar2[n] = '/';
    c = new byte[''];
    int i3;
    for (int i1 = 0;; i1++)
    {
      int i2 = c.length;
      i3 = 0;
      if (i1 >= i2) {
        break;
      }
      c[i1] = -1;
    }
    while (i3 < 64)
    {
      c[b[i3]] = ((byte)i3);
      i3++;
    }
  }
  
  public static char[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static char[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = (2 + paramInt2 * 4) / 3;
    char[] arrayOfChar = new char[4 * ((paramInt2 + 2) / 3)];
    int j = paramInt1 + paramInt2;
    int k = 0;
    if (paramInt1 < j)
    {
      int m = paramInt1 + 1;
      int n = 0xFF & paramArrayOfByte[paramInt1];
      int i1;
      label74:
      int i2;
      int i3;
      label97:
      int i7;
      int i10;
      label186:
      int i11;
      if (m < j)
      {
        int i13 = m + 1;
        i1 = 0xFF & paramArrayOfByte[m];
        m = i13;
        if (m >= j) {
          break label238;
        }
        i2 = m + 1;
        i3 = 0xFF & paramArrayOfByte[m];
        int i4 = n >>> 2;
        int i5 = (n & 0x3) << 4 | i1 >>> 4;
        int i6 = (i1 & 0xF) << 2 | i3 >>> 6;
        i7 = i3 & 0x3F;
        int i8 = k + 1;
        arrayOfChar[k] = b[i4];
        int i9 = i8 + 1;
        arrayOfChar[i8] = b[i5];
        if (i9 >= i) {
          break label248;
        }
        i10 = b[i6];
        arrayOfChar[i9] = i10;
        i11 = i9 + 1;
        if (i11 >= i) {
          break label255;
        }
      }
      label238:
      label248:
      label255:
      for (int i12 = b[i7];; i12 = 61)
      {
        arrayOfChar[i11] = i12;
        k = i11 + 1;
        paramInt1 = i2;
        break;
        i1 = 0;
        break label74;
        i2 = m;
        i3 = 0;
        break label97;
        i10 = 61;
        break label186;
      }
    }
    return arrayOfChar;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.Base64Coder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */