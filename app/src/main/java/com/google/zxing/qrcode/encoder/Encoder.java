package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Encoder
{
  private static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  static int a(int paramInt)
  {
    if (paramInt < a.length) {
      return a[paramInt];
    }
    return -1;
  }
  
  private static int a(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, ByteMatrix paramByteMatrix)
  {
    int i = 2147483647;
    int j = -1;
    int k = 0;
    int m;
    if (k < 8)
    {
      MatrixUtil.a(paramBitArray, paramErrorCorrectionLevel, paramVersion, k, paramByteMatrix);
      m = a(paramByteMatrix);
      if (m >= i) {
        break label56;
      }
      j = k;
    }
    for (;;)
    {
      k++;
      i = m;
      break;
      return j;
      label56:
      m = i;
    }
  }
  
  private static int a(ByteMatrix paramByteMatrix)
  {
    return MaskUtil.a(paramByteMatrix) + MaskUtil.b(paramByteMatrix) + MaskUtil.c(paramByteMatrix) + MaskUtil.d(paramByteMatrix);
  }
  
  static BitArray a(BitArray paramBitArray, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBitArray.b() != paramInt2) {
      throw new WriterException("Number of bits and data bytes does not match");
    }
    ArrayList localArrayList = new ArrayList(paramInt3);
    int i = 0;
    int j = 0;
    int k = 0;
    int i5;
    for (int m = 0; i < paramInt3; m = i5)
    {
      int[] arrayOfInt1 = new int[1];
      int[] arrayOfInt2 = new int[1];
      a(paramInt1, paramInt2, paramInt3, i, arrayOfInt1, arrayOfInt2);
      int i2 = arrayOfInt1[0];
      byte[] arrayOfByte3 = new byte[i2];
      paramBitArray.a(m * 8, arrayOfByte3, 0, i2);
      byte[] arrayOfByte4 = a(arrayOfByte3, arrayOfInt2[0]);
      localArrayList.add(new BlockPair(arrayOfByte3, arrayOfByte4));
      int i3 = Math.max(k, i2);
      int i4 = Math.max(j, arrayOfByte4.length);
      i5 = m + arrayOfInt1[0];
      i++;
      j = i4;
      k = i3;
    }
    if (paramInt2 != m) {
      throw new WriterException("Data bytes does not match offset");
    }
    BitArray localBitArray = new BitArray();
    for (int n = 0; n < k; n++)
    {
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        byte[] arrayOfByte2 = ((BlockPair)localIterator2.next()).a();
        if (n < arrayOfByte2.length) {
          localBitArray.b(arrayOfByte2[n], 8);
        }
      }
    }
    for (int i1 = 0; i1 < j; i1++)
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        byte[] arrayOfByte1 = ((BlockPair)localIterator1.next()).b();
        if (i1 < arrayOfByte1.length) {
          localBitArray.b(arrayOfByte1[i1], 8);
        }
      }
    }
    if (paramInt1 != localBitArray.b()) {
      throw new WriterException("Interleaving error: " + paramInt1 + " and " + localBitArray.b() + " differ.");
    }
    return localBitArray;
  }
  
  private static Mode a(String paramString1, String paramString2)
  {
    int i = 0;
    if ("Shift_JIS".equals(paramString2))
    {
      if (a(paramString1)) {
        return Mode.g;
      }
      return Mode.e;
    }
    int j = 0;
    int k = 0;
    if (i < paramString1.length())
    {
      int m = paramString1.charAt(i);
      if ((m >= 48) && (m <= 57)) {
        k = 1;
      }
      for (;;)
      {
        i++;
        break;
        if (a(m) == -1) {
          break label83;
        }
        j = 1;
      }
      label83:
      return Mode.e;
    }
    if (j != 0) {
      return Mode.c;
    }
    if (k != 0) {
      return Mode.b;
    }
    return Mode.e;
  }
  
  private static Version a(int paramInt, ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    for (int i = 1; i <= 40; i++)
    {
      Version localVersion = Version.b(i);
      if (localVersion.c() - localVersion.a(paramErrorCorrectionLevel).c() >= (paramInt + 7) / 8) {
        return localVersion;
      }
    }
    throw new WriterException("Data too big");
  }
  
  public static QRCode a(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<EncodeHintType, ?> paramMap)
  {
    String str;
    Mode localMode;
    BitArray localBitArray2;
    Version localVersion2;
    BitArray localBitArray3;
    if (paramMap == null)
    {
      str = null;
      if (str == null) {
        str = "ISO-8859-1";
      }
      localMode = a(paramString, str);
      BitArray localBitArray1 = new BitArray();
      if ((localMode == Mode.e) && (!"ISO-8859-1".equals(str)))
      {
        CharacterSetECI localCharacterSetECI = CharacterSetECI.a(str);
        if (localCharacterSetECI != null) {
          a(localCharacterSetECI, localBitArray1);
        }
      }
      a(localMode, localBitArray1);
      localBitArray2 = new BitArray();
      a(paramString, localMode, localBitArray2, str);
      Version localVersion1 = a(localBitArray1.a() + localMode.a(Version.b(1)) + localBitArray2.a(), paramErrorCorrectionLevel);
      localVersion2 = a(localBitArray1.a() + localMode.a(localVersion1) + localBitArray2.a(), paramErrorCorrectionLevel);
      localBitArray3 = new BitArray();
      localBitArray3.a(localBitArray1);
      if (localMode != Mode.e) {
        break label343;
      }
    }
    label343:
    for (int i = localBitArray2.b();; i = paramString.length())
    {
      a(i, localVersion2, localMode, localBitArray3);
      localBitArray3.a(localBitArray2);
      Version.ECBlocks localECBlocks = localVersion2.a(paramErrorCorrectionLevel);
      int j = localVersion2.c() - localECBlocks.c();
      a(j, localBitArray3);
      BitArray localBitArray4 = a(localBitArray3, localVersion2.c(), j, localECBlocks.b());
      QRCode localQRCode = new QRCode();
      localQRCode.a(paramErrorCorrectionLevel);
      localQRCode.a(localMode);
      localQRCode.a(localVersion2);
      int k = localVersion2.d();
      ByteMatrix localByteMatrix = new ByteMatrix(k, k);
      int m = a(localBitArray4, paramErrorCorrectionLevel, localVersion2, localByteMatrix);
      localQRCode.a(m);
      MatrixUtil.a(localBitArray4, paramErrorCorrectionLevel, localVersion2, m, localByteMatrix);
      localQRCode.a(localByteMatrix);
      return localQRCode;
      str = (String)paramMap.get(EncodeHintType.b);
      break;
    }
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramInt4 >= paramInt3) {
      throw new WriterException("Block ID too large");
    }
    int i = paramInt1 % paramInt3;
    int j = paramInt3 - i;
    int k = paramInt1 / paramInt3;
    int m = k + 1;
    int n = paramInt2 / paramInt3;
    int i1 = n + 1;
    int i2 = k - n;
    int i3 = m - i1;
    if (i2 != i3) {
      throw new WriterException("EC bytes mismatch");
    }
    if (paramInt3 != j + i) {
      throw new WriterException("RS blocks mismatch");
    }
    if (paramInt1 != j * (n + i2) + i * (i1 + i3)) {
      throw new WriterException("Total bytes mismatch");
    }
    if (paramInt4 < j)
    {
      paramArrayOfInt1[0] = n;
      paramArrayOfInt2[0] = i2;
      return;
    }
    paramArrayOfInt1[0] = i1;
    paramArrayOfInt2[0] = i3;
  }
  
  static void a(int paramInt, BitArray paramBitArray)
  {
    int i = paramInt << 3;
    if (paramBitArray.a() > i) {
      throw new WriterException("data bits cannot fit in the QR Code" + paramBitArray.a() + " > " + i);
    }
    for (int j = 0; (j < 4) && (paramBitArray.a() < i); j++) {
      paramBitArray.a(false);
    }
    int k = 0x7 & paramBitArray.a();
    if (k > 0) {
      while (k < 8)
      {
        paramBitArray.a(false);
        k++;
      }
    }
    int m = paramInt - paramBitArray.b();
    int n = 0;
    if (n < m)
    {
      if ((n & 0x1) == 0) {}
      for (int i1 = 236;; i1 = 17)
      {
        paramBitArray.b(i1, 8);
        n++;
        break;
      }
    }
    if (paramBitArray.a() != i) {
      throw new WriterException("Bits size does not equal capacity");
    }
  }
  
  static void a(int paramInt, Version paramVersion, Mode paramMode, BitArray paramBitArray)
  {
    int i = paramMode.a(paramVersion);
    if (paramInt >= 1 << i) {
      throw new WriterException(paramInt + " is bigger than " + (-1 + (1 << i)));
    }
    paramBitArray.b(paramInt, i);
  }
  
  private static void a(CharacterSetECI paramCharacterSetECI, BitArray paramBitArray)
  {
    paramBitArray.b(Mode.f.a(), 4);
    paramBitArray.b(paramCharacterSetECI.a(), 8);
  }
  
  static void a(Mode paramMode, BitArray paramBitArray)
  {
    paramBitArray.b(paramMode.a(), 4);
  }
  
  static void a(CharSequence paramCharSequence, BitArray paramBitArray)
  {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i)
    {
      int k = '￐' + paramCharSequence.charAt(j);
      if (j + 2 < i)
      {
        int m = '￐' + paramCharSequence.charAt(j + 1);
        paramBitArray.b('￐' + paramCharSequence.charAt(j + 2) + (k * 100 + m * 10), 10);
        j += 3;
      }
      else if (j + 1 < i)
      {
        paramBitArray.b('￐' + paramCharSequence.charAt(j + 1) + k * 10, 7);
        j += 2;
      }
      else
      {
        paramBitArray.b(k, 4);
        j++;
      }
    }
  }
  
  static void a(String paramString, BitArray paramBitArray)
  {
    for (;;)
    {
      int j;
      int m;
      int n;
      try
      {
        byte[] arrayOfByte = paramString.getBytes("Shift_JIS");
        int i = arrayOfByte.length;
        j = 0;
        if (j >= i) {
          break label155;
        }
        int k = 0xFF & arrayOfByte[j];
        m = 0xFF & arrayOfByte[(j + 1)] | k << 8;
        if ((m >= 33088) && (m <= 40956))
        {
          n = m - 33088;
          if (n != -1) {
            break label127;
          }
          throw new WriterException("Invalid byte sequence");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new WriterException(localUnsupportedEncodingException);
      }
      if ((m >= 57408) && (m <= 60351))
      {
        n = m - 49472;
        continue;
        label127:
        paramBitArray.b(192 * (n >> 8) + (n & 0xFF), 13);
        j += 2;
      }
      else
      {
        label155:
        n = -1;
      }
    }
  }
  
  static void a(String paramString1, BitArray paramBitArray, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = paramString1.getBytes(paramString2);
      int i = arrayOfByte.length;
      for (int j = 0; j < i; j++) {
        paramBitArray.b(arrayOfByte[j], 8);
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new WriterException(localUnsupportedEncodingException);
    }
  }
  
  static void a(String paramString1, Mode paramMode, BitArray paramBitArray, String paramString2)
  {
    switch (Encoder.1.a[paramMode.ordinal()])
    {
    default: 
      throw new WriterException("Invalid mode: " + paramMode);
    case 1: 
      a(paramString1, paramBitArray);
      return;
    case 2: 
      b(paramString1, paramBitArray);
      return;
    case 3: 
      a(paramString1, paramBitArray, paramString2);
      return;
    }
    a(paramString1, paramBitArray);
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("Shift_JIS");
      int i = arrayOfByte.length;
      if (i % 2 != 0) {
        return false;
      }
      for (int j = 0;; j += 2)
      {
        if (j >= i) {
          break label75;
        }
        int k = 0xFF & arrayOfByte[j];
        if (((k < 129) || (k > 159)) && ((k < 224) || (k > 235))) {
          break;
        }
      }
      label75:
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return false;
  }
  
  static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    int[] arrayOfInt = new int[j + paramInt];
    for (int k = 0; k < j; k++) {
      arrayOfInt[k] = (0xFF & paramArrayOfByte[k]);
    }
    new ReedSolomonEncoder(GenericGF.e).a(arrayOfInt, paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)arrayOfInt[(j + i)]);
      i++;
    }
    return arrayOfByte;
  }
  
  static void b(CharSequence paramCharSequence, BitArray paramBitArray)
  {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i)
    {
      int k = a(paramCharSequence.charAt(j));
      if (k == -1) {
        throw new WriterException();
      }
      if (j + 1 < i)
      {
        int m = a(paramCharSequence.charAt(j + 1));
        if (m == -1) {
          throw new WriterException();
        }
        paramBitArray.b(m + k * 45, 11);
        j += 2;
      }
      else
      {
        paramBitArray.b(k, 6);
        j++;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.Encoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */