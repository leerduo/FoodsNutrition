package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder
{
  private static final int[] a = { 4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
  
  private static int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 88;; i = 112) {
      return paramInt * (i + paramInt * 16);
    }
  }
  
  public static AztecCode a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    BitArray localBitArray1 = new HighLevelEncoder(paramArrayOfByte).a();
    int i = 11 + paramInt1 * localBitArray1.a() / 100;
    int j = i + localBitArray1.a();
    label102:
    label109:
    int k;
    int i4;
    int i3;
    boolean bool2;
    BitArray localBitArray2;
    BitArray localBitArray3;
    int i5;
    BitArray localBitArray4;
    if (paramInt2 != 0)
    {
      boolean bool3;
      int i24;
      if (paramInt2 < 0)
      {
        bool3 = true;
        i24 = Math.abs(paramInt2);
        if (!bool3) {
          break label102;
        }
      }
      for (int i25 = 4;; i25 = 32)
      {
        if (i24 <= i25) {
          break label109;
        }
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt2);
        throw new IllegalArgumentException(String.format("Illegal value %s for layers", arrayOfObject));
        bool3 = false;
        break;
      }
      int i26 = a(i24, bool3);
      int i27 = a[i24];
      int i28 = i26 - i26 % i27;
      BitArray localBitArray5 = a(localBitArray1, i27);
      if (i + localBitArray5.a() > i28) {
        throw new IllegalArgumentException("Data to large for user specified layer");
      }
      if ((bool3) && (localBitArray5.a() > i27 * 64)) {
        throw new IllegalArgumentException("Data to large for user specified layer");
      }
      k = i27;
      i4 = i26;
      i3 = i24;
      bool2 = bool3;
      localBitArray2 = localBitArray5;
      localBitArray3 = a(localBitArray2, i4, k);
      i5 = localBitArray2.a() / k;
      localBitArray4 = a(bool2, i3, i5);
      if (!bool2) {
        break label460;
      }
    }
    int[] arrayOfInt;
    label331:
    label460:
    for (int i6 = 11 + i3 * 4;; i6 = 14 + i3 * 4)
    {
      arrayOfInt = new int[i6];
      if (!bool2) {
        break label748;
      }
      for (int i23 = 0; i23 < arrayOfInt.length; i23++) {
        arrayOfInt[i23] = i23;
      }
      k = 0;
      localBitArray2 = null;
      int m = 0;
      if (m > 32) {
        throw new IllegalArgumentException("Data too large for an Aztec code");
      }
      boolean bool1;
      int n;
      label342:
      int i1;
      if (m <= 3)
      {
        bool1 = true;
        if (!bool1) {
          break label370;
        }
        n = m + 1;
        i1 = a(n, bool1);
        if (j <= i1) {
          break label377;
        }
      }
      label370:
      label377:
      int i2;
      do
      {
        m++;
        break;
        bool1 = false;
        break label331;
        n = m;
        break label342;
        if (k != a[n])
        {
          k = a[n];
          localBitArray2 = a(localBitArray1, k);
        }
        i2 = i1 - i1 % k;
      } while (((bool1) && (localBitArray2.a() > k * 64)) || (i + localBitArray2.a() > i2));
      i3 = n;
      i4 = i1;
      bool2 = bool1;
      break;
    }
    int i7 = i6;
    BitMatrix localBitMatrix = new BitMatrix(i7);
    int i12 = 0;
    label517:
    label748:
    int i20;
    for (int i13 = 0;; i13 = i20)
    {
      if (i13 >= i3) {
        break label884;
      }
      int i17;
      if (bool2) {
        i17 = 9 + 4 * (i3 - i13);
      }
      for (int i18 = 0;; i18++)
      {
        if (i18 >= i17) {
          break label857;
        }
        int i21 = i18 * 2;
        int i22 = 0;
        for (;;)
        {
          if (i22 < 2)
          {
            if (localBitArray3.a(i22 + (i12 + i21))) {
              localBitMatrix.b(arrayOfInt[(i22 + i13 * 2)], arrayOfInt[(i18 + i13 * 2)]);
            }
            if (localBitArray3.a(i22 + (i21 + (i12 + i17 * 2)))) {
              localBitMatrix.b(arrayOfInt[(i18 + i13 * 2)], arrayOfInt[(i6 - 1 - i13 * 2 - i22)]);
            }
            if (localBitArray3.a(i22 + (i21 + (i12 + i17 * 4)))) {
              localBitMatrix.b(arrayOfInt[(i6 - 1 - i13 * 2 - i22)], arrayOfInt[(i6 - 1 - i13 * 2 - i18)]);
            }
            if (localBitArray3.a(i22 + (i21 + (i12 + i17 * 6)))) {
              localBitMatrix.b(arrayOfInt[(i6 - 1 - i13 * 2 - i18)], arrayOfInt[(i22 + i13 * 2)]);
            }
            i22++;
            continue;
            i7 = i6 + 1 + 2 * ((-1 + i6 / 2) / 15);
            int i8 = i6 / 2;
            int i9 = i7 / 2;
            for (int i10 = 0; i10 < i8; i10++)
            {
              int i11 = i10 + i10 / 15;
              arrayOfInt[(-1 + (i8 - i10))] = (-1 + (i9 - i11));
              arrayOfInt[(i8 + i10)] = (1 + (i11 + i9));
            }
            break;
            i17 = 12 + 4 * (i3 - i13);
            break label517;
          }
        }
      }
      label857:
      int i19 = i12 + i17 * 8;
      i20 = i13 + 1;
      i12 = i19;
    }
    label884:
    a(localBitMatrix, bool2, i7, localBitArray4);
    if (bool2) {
      a(localBitMatrix, i7 / 2, 5);
    }
    for (;;)
    {
      AztecCode localAztecCode = new AztecCode();
      localAztecCode.a(bool2);
      localAztecCode.a(i7);
      localAztecCode.b(i3);
      localAztecCode.c(i5);
      localAztecCode.a(localBitMatrix);
      return localAztecCode;
      a(localBitMatrix, i7 / 2, 7);
      int i14 = 0;
      for (int i15 = 0; i14 < -1 + i6 / 2; i15 += 16)
      {
        for (int i16 = 0x1 & i7 / 2; i16 < i7; i16 += 2)
        {
          localBitMatrix.b(i7 / 2 - i15, i16);
          localBitMatrix.b(i15 + i7 / 2, i16);
          localBitMatrix.b(i16, i7 / 2 - i15);
          localBitMatrix.b(i16, i15 + i7 / 2);
        }
        i14 += 15;
      }
    }
  }
  
  static BitArray a(BitArray paramBitArray, int paramInt)
  {
    BitArray localBitArray = new BitArray();
    int i = paramBitArray.a();
    int j = -2 + (1 << paramInt);
    int k = 0;
    if (k < i)
    {
      int m = 0;
      int n = 0;
      while (m < paramInt)
      {
        if ((k + m >= i) || (paramBitArray.a(k + m))) {
          n |= 1 << paramInt - 1 - m;
        }
        m++;
      }
      int i1;
      if ((n & j) == j)
      {
        localBitArray.b(n & j, paramInt);
        i1 = k - 1;
      }
      for (;;)
      {
        k = i1 + paramInt;
        break;
        if ((n & j) == 0)
        {
          localBitArray.b(n | 0x1, paramInt);
          i1 = k - 1;
        }
        else
        {
          localBitArray.b(n, paramInt);
          i1 = k;
        }
      }
    }
    return localBitArray;
  }
  
  private static BitArray a(BitArray paramBitArray, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramBitArray.a() / paramInt2;
    ReedSolomonEncoder localReedSolomonEncoder = new ReedSolomonEncoder(a(paramInt2));
    int k = paramInt1 / paramInt2;
    int[] arrayOfInt = b(paramBitArray, paramInt2, k);
    localReedSolomonEncoder.a(arrayOfInt, k - j);
    int m = paramInt1 % paramInt2;
    BitArray localBitArray = new BitArray();
    localBitArray.b(0, m);
    int n = arrayOfInt.length;
    while (i < n)
    {
      localBitArray.b(arrayOfInt[i], paramInt2);
      i++;
    }
    return localBitArray;
  }
  
  static BitArray a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    BitArray localBitArray = new BitArray();
    if (paramBoolean)
    {
      localBitArray.b(paramInt1 - 1, 2);
      localBitArray.b(paramInt2 - 1, 6);
      return a(localBitArray, 28, 4);
    }
    localBitArray.b(paramInt1 - 1, 5);
    localBitArray.b(paramInt2 - 1, 11);
    return a(localBitArray, 40, 4);
  }
  
  private static GenericGF a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 9: 
    case 11: 
    default: 
      return null;
    case 4: 
      return GenericGF.d;
    case 6: 
      return GenericGF.c;
    case 8: 
      return GenericGF.g;
    case 10: 
      return GenericGF.b;
    }
    return GenericGF.a;
  }
  
  private static void a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2)
  {
    for (int i = 0; i < paramInt2; i += 2) {
      for (int j = paramInt1 - i; j <= paramInt1 + i; j++)
      {
        paramBitMatrix.b(j, paramInt1 - i);
        paramBitMatrix.b(j, paramInt1 + i);
        paramBitMatrix.b(paramInt1 - i, j);
        paramBitMatrix.b(paramInt1 + i, j);
      }
    }
    paramBitMatrix.b(paramInt1 - paramInt2, paramInt1 - paramInt2);
    paramBitMatrix.b(1 + (paramInt1 - paramInt2), paramInt1 - paramInt2);
    paramBitMatrix.b(paramInt1 - paramInt2, 1 + (paramInt1 - paramInt2));
    paramBitMatrix.b(paramInt1 + paramInt2, paramInt1 - paramInt2);
    paramBitMatrix.b(paramInt1 + paramInt2, 1 + (paramInt1 - paramInt2));
    paramBitMatrix.b(paramInt1 + paramInt2, -1 + (paramInt1 + paramInt2));
  }
  
  private static void a(BitMatrix paramBitMatrix, boolean paramBoolean, int paramInt, BitArray paramBitArray)
  {
    int i = paramInt / 2;
    int j = 0;
    if (paramBoolean) {
      while (j < 7)
      {
        int m = j + (i - 3);
        if (paramBitArray.a(j)) {
          paramBitMatrix.b(m, i - 5);
        }
        if (paramBitArray.a(j + 7)) {
          paramBitMatrix.b(i + 5, m);
        }
        if (paramBitArray.a(20 - j)) {
          paramBitMatrix.b(m, i + 5);
        }
        if (paramBitArray.a(27 - j)) {
          paramBitMatrix.b(i - 5, m);
        }
        j++;
      }
    }
    while (j < 10)
    {
      int k = j + (i - 5) + j / 5;
      if (paramBitArray.a(j)) {
        paramBitMatrix.b(k, i - 7);
      }
      if (paramBitArray.a(j + 10)) {
        paramBitMatrix.b(i + 7, k);
      }
      if (paramBitArray.a(29 - j)) {
        paramBitMatrix.b(k, i + 7);
      }
      if (paramBitArray.a(39 - j)) {
        paramBitMatrix.b(i - 7, k);
      }
      j++;
    }
  }
  
  private static int[] b(BitArray paramBitArray, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt2];
    int i = paramBitArray.a() / paramInt1;
    for (int j = 0; j < i; j++)
    {
      int k = 0;
      int m = 0;
      if (k < paramInt1)
      {
        if (paramBitArray.a(k + j * paramInt1)) {}
        for (int n = 1 << -1 + (paramInt1 - k);; n = 0)
        {
          m |= n;
          k++;
          break;
        }
      }
      arrayOfInt[j] = m;
    }
    return arrayOfInt;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.encoder.Encoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */