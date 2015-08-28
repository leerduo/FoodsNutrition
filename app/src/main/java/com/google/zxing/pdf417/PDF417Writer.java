package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.BarcodeMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class PDF417Writer
  implements Writer
{
  private static BitMatrix a(PDF417 paramPDF417, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramPDF417.a(paramString, 2);
    byte[][] arrayOfByte1 = paramPDF417.a().a(2, 8);
    int i;
    int j;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      if (arrayOfByte1[0].length >= arrayOfByte1.length) {
        break label132;
      }
      j = 1;
      label40:
      if ((i ^ j) == 0) {
        break label160;
      }
      arrayOfByte1 = a(arrayOfByte1);
    }
    label132:
    label145:
    label153:
    label160:
    for (int k = 1;; k = 0)
    {
      int m = paramInt1 / arrayOfByte1[0].length;
      int n = paramInt2 / arrayOfByte1.length;
      label81:
      byte[][] arrayOfByte2;
      if (m < n)
      {
        if (m <= 1) {
          break label145;
        }
        arrayOfByte2 = paramPDF417.a().a(m * 2, 2 * (m * 4));
        if (k == 0) {
          break label153;
        }
      }
      for (byte[][] arrayOfByte3 = a(arrayOfByte2);; arrayOfByte3 = arrayOfByte2)
      {
        return a(arrayOfByte3, paramInt3);
        i = 0;
        break;
        j = 0;
        break label40;
        m = n;
        break label81;
        return a(arrayOfByte1, paramInt3);
      }
    }
  }
  
  private static BitMatrix a(byte[][] paramArrayOfByte, int paramInt)
  {
    BitMatrix localBitMatrix = new BitMatrix(paramArrayOfByte[0].length + paramInt * 2, paramArrayOfByte.length + paramInt * 2);
    localBitMatrix.a();
    int i = -1 + (localBitMatrix.g() - paramInt);
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      for (int k = 0; k < paramArrayOfByte[0].length; k++) {
        if (paramArrayOfByte[j][k] == 1) {
          localBitMatrix.b(k + paramInt, i);
        }
      }
      j++;
      i--;
    }
    return localBitMatrix;
  }
  
  private static byte[][] a(byte[][] paramArrayOfByte)
  {
    int[] arrayOfInt = { paramArrayOfByte[0].length, paramArrayOfByte.length };
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, arrayOfInt);
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = -1 + (paramArrayOfByte.length - i);
      for (int k = 0; k < paramArrayOfByte[0].length; k++) {
        arrayOfByte[k][j] = paramArrayOfByte[i][k];
      }
    }
    return arrayOfByte;
  }
  
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.k) {
      throw new IllegalArgumentException("Can only encode PDF_417, but got " + paramBarcodeFormat);
    }
    PDF417 localPDF417 = new PDF417();
    int i = 30;
    if (paramMap != null)
    {
      if (paramMap.containsKey(EncodeHintType.g)) {
        localPDF417.a(((Boolean)paramMap.get(EncodeHintType.g)).booleanValue());
      }
      if (paramMap.containsKey(EncodeHintType.h)) {
        localPDF417.a((Compaction)paramMap.get(EncodeHintType.h));
      }
      if (paramMap.containsKey(EncodeHintType.i))
      {
        Dimensions localDimensions = (Dimensions)paramMap.get(EncodeHintType.i);
        localPDF417.a(localDimensions.b(), localDimensions.a(), localDimensions.d(), localDimensions.c());
      }
      if (paramMap.containsKey(EncodeHintType.f)) {
        i = ((Number)paramMap.get(EncodeHintType.f)).intValue();
      }
      if (paramMap.containsKey(EncodeHintType.b)) {
        localPDF417.a(Charset.forName((String)paramMap.get(EncodeHintType.b)));
      }
    }
    return a(localPDF417, paramString, paramInt1, paramInt2, i);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.PDF417Writer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */