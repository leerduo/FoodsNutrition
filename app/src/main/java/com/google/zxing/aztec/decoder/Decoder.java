package com.google.zxing.aztec.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Arrays;

public final class Decoder
{
  private static final String[] a = { "CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS" };
  private static final String[] b = { "CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS" };
  private static final String[] c = { "CTRL_PS", " ", "\001", "\002", "\003", "\004", "\005", "\006", "\007", "\b", "\t", "\n", "\013", "\f", "\r", "\033", "\034", "\035", "\036", "\037", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS" };
  private static final String[] d = { "", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL" };
  private static final String[] e = { "CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US" };
  private AztecDetectorResult f;
  
  private static int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 88;; i = 112) {
      return paramInt * (i + paramInt * 16);
    }
  }
  
  private static int a(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    int i = 0;
    for (int j = paramInt1; j < paramInt1 + paramInt2; j++)
    {
      i <<= 1;
      if (paramArrayOfBoolean[j] != 0) {
        i++;
      }
    }
    return i;
  }
  
  private static Decoder.Table a(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return Decoder.Table.a;
    case 'L': 
      return Decoder.Table.b;
    case 'P': 
      return Decoder.Table.e;
    case 'M': 
      return Decoder.Table.c;
    case 'D': 
      return Decoder.Table.d;
    }
    return Decoder.Table.f;
  }
  
  private static String a(Decoder.Table paramTable, int paramInt)
  {
    switch (Decoder.1.a[paramTable.ordinal()])
    {
    default: 
      throw new IllegalStateException("Bad table");
    case 1: 
      return a[paramInt];
    case 2: 
      return b[paramInt];
    case 3: 
      return c[paramInt];
    case 4: 
      return d[paramInt];
    }
    return e[paramInt];
  }
  
  private static String a(boolean[] paramArrayOfBoolean)
  {
    int i = paramArrayOfBoolean.length;
    Decoder.Table localTable1 = Decoder.Table.a;
    Decoder.Table localTable2 = Decoder.Table.a;
    StringBuilder localStringBuilder = new StringBuilder(20);
    int j = 0;
    Object localObject1 = localTable2;
    Object localObject2 = localTable1;
    if (j < i)
    {
      if (localObject1 != Decoder.Table.f) {
        break label169;
      }
      if (i - j >= 5) {
        break label59;
      }
    }
    label53:
    label59:
    int i1;
    do
    {
      return localStringBuilder.toString();
      n = a(paramArrayOfBoolean, j, 5);
      i1 = j + 5;
      if (n != 0) {
        break;
      }
    } while (i - i1 < 11);
    int n = 31 + a(paramArrayOfBoolean, i1, 11);
    i1 += 11;
    int i2 = 0;
    label107:
    if (i2 < n) {
      if (i - i1 >= 8) {}
    }
    for (int i3 = i;; i3 = i1)
    {
      j = i3;
      localObject1 = localObject2;
      break;
      localStringBuilder.append((char)a(paramArrayOfBoolean, i1, 8));
      int i4 = i1 + 8;
      i2++;
      i1 = i4;
      break label107;
      label169:
      int k;
      label180:
      String str;
      Object localObject3;
      if (localObject1 == Decoder.Table.d)
      {
        k = 4;
        if (i - j < k) {
          break label264;
        }
        int m = a(paramArrayOfBoolean, j, k);
        j += k;
        str = a((Decoder.Table)localObject1, m);
        if (!str.startsWith("CTRL_")) {
          break label266;
        }
        localObject3 = a(str.charAt(5));
        if (str.charAt(6) == 'L') {
          localObject2 = localObject3;
        }
      }
      for (;;)
      {
        localObject1 = localObject3;
        break;
        k = 5;
        break label180;
        label264:
        break label53;
        label266:
        localStringBuilder.append(str);
        localObject3 = localObject2;
      }
    }
  }
  
  private boolean[] b(boolean[] paramArrayOfBoolean)
  {
    int i = 8;
    GenericGF localGenericGF;
    if (this.f.a() <= 2)
    {
      i = 6;
      localGenericGF = GenericGF.c;
    }
    int j;
    int n;
    int[] arrayOfInt;
    for (;;)
    {
      j = this.f.b();
      int k = paramArrayOfBoolean.length / i;
      int m = paramArrayOfBoolean.length % i;
      n = k - j;
      arrayOfInt = new int[k];
      int i1 = m;
      int i2 = 0;
      while (i2 < k)
      {
        arrayOfInt[i2] = a(paramArrayOfBoolean, i1, i);
        i2++;
        i1 += i;
      }
      if (this.f.a() <= i)
      {
        localGenericGF = GenericGF.g;
      }
      else if (this.f.a() <= 22)
      {
        i = 10;
        localGenericGF = GenericGF.b;
      }
      else
      {
        i = 12;
        localGenericGF = GenericGF.a;
      }
    }
    int i3;
    int i5;
    for (;;)
    {
      int i4;
      int i14;
      try
      {
        new ReedSolomonDecoder(localGenericGF).a(arrayOfInt, n);
        i3 = -1 + (1 << i);
        i4 = 0;
        i5 = 0;
        if (i4 >= j) {
          break;
        }
        i14 = arrayOfInt[i4];
        if ((i14 == 0) || (i14 == i3)) {
          throw FormatException.a();
        }
      }
      catch (ReedSolomonException localReedSolomonException)
      {
        throw FormatException.a();
      }
      if ((i14 == 1) || (i14 == i3 - 1)) {
        i5++;
      }
      i4++;
    }
    boolean[] arrayOfBoolean = new boolean[j * i - i5];
    int i6 = 0;
    int i7 = 0;
    int i8;
    boolean bool;
    if (i6 < j)
    {
      i8 = arrayOfInt[i6];
      if ((i8 == 1) || (i8 == i3 - 1))
      {
        int i9 = -1 + (i7 + i);
        if (i8 > 1)
        {
          bool = true;
          label294:
          Arrays.fill(arrayOfBoolean, i7, i9, bool);
        }
      }
    }
    for (int i10 = i7 + (i - 1);; i10 = i7)
    {
      i6++;
      i7 = i10;
      break;
      bool = false;
      break label294;
      int i11 = i - 1;
      if (i11 >= 0)
      {
        int i12 = i7 + 1;
        if ((i8 & 1 << i11) != 0) {}
        for (int i13 = 1;; i13 = 0)
        {
          arrayOfBoolean[i7] = i13;
          i11--;
          i7 = i12;
          break;
        }
        return arrayOfBoolean;
      }
    }
  }
  
  public DecoderResult a(AztecDetectorResult paramAztecDetectorResult)
  {
    this.f = paramAztecDetectorResult;
    return new DecoderResult(null, a(b(a(paramAztecDetectorResult.d()))), null, null);
  }
  
  boolean[] a(BitMatrix paramBitMatrix)
  {
    boolean bool = this.f.c();
    int i = this.f.a();
    if (bool) {}
    int[] arrayOfInt;
    boolean[] arrayOfBoolean;
    for (int j = 11 + i * 4;; j = 14 + i * 4)
    {
      arrayOfInt = new int[j];
      arrayOfBoolean = new boolean[a(i, bool)];
      if (!bool) {
        break;
      }
      for (int i13 = 0; i13 < arrayOfInt.length; i13++) {
        arrayOfInt[i13] = i13;
      }
    }
    int k = j + 1 + 2 * ((-1 + j / 2) / 15);
    int m = j / 2;
    int n = k / 2;
    for (int i1 = 0; i1 < m; i1++)
    {
      int i12 = i1 + i1 / 15;
      arrayOfInt[(-1 + (m - i1))] = (-1 + (n - i12));
      arrayOfInt[(m + i1)] = (1 + (i12 + n));
    }
    int i2 = 0;
    label403:
    int i9;
    for (int i3 = 0; i3 < i; i3 = i9)
    {
      int i4;
      int i5;
      int i6;
      if (bool)
      {
        i4 = 9 + 4 * (i - i3);
        i5 = i3 * 2;
        i6 = j - 1 - i5;
      }
      for (int i7 = 0;; i7++)
      {
        if (i7 >= i4) {
          break label403;
        }
        int i10 = i7 * 2;
        int i11 = 0;
        for (;;)
        {
          if (i11 < 2)
          {
            arrayOfBoolean[(i11 + (i2 + i10))] = paramBitMatrix.a(arrayOfInt[(i5 + i11)], arrayOfInt[(i5 + i7)]);
            arrayOfBoolean[(i11 + (i10 + (i2 + i4 * 2)))] = paramBitMatrix.a(arrayOfInt[(i5 + i7)], arrayOfInt[(i6 - i11)]);
            arrayOfBoolean[(i11 + (i10 + (i2 + i4 * 4)))] = paramBitMatrix.a(arrayOfInt[(i6 - i11)], arrayOfInt[(i6 - i7)]);
            arrayOfBoolean[(i11 + (i10 + (i2 + i4 * 6)))] = paramBitMatrix.a(arrayOfInt[(i6 - i7)], arrayOfInt[(i5 + i11)]);
            i11++;
            continue;
            i4 = 12 + 4 * (i - i3);
            break;
          }
        }
      }
      int i8 = i2 + i4 * 8;
      i9 = i3 + 1;
      i2 = i8;
    }
    return arrayOfBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.decoder.Decoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */