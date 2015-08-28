package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;

public final class AztecWriter
  implements Writer
{
  private static final Charset a = Charset.forName("ISO-8859-1");
  
  private static BitMatrix a(AztecCode paramAztecCode, int paramInt1, int paramInt2)
  {
    BitMatrix localBitMatrix1 = paramAztecCode.a();
    if (localBitMatrix1 == null) {
      throw new IllegalStateException();
    }
    int i = localBitMatrix1.f();
    int j = localBitMatrix1.g();
    int k = Math.max(paramInt1, i);
    int m = Math.max(paramInt2, j);
    int n = Math.min(k / i, m / j);
    int i1 = (k - i * n) / 2;
    int i2 = (m - j * n) / 2;
    BitMatrix localBitMatrix2 = new BitMatrix(k, m);
    int i3 = i2;
    int i7;
    for (int i4 = 0; i4 < j; i4 = i7)
    {
      int i5 = i1;
      int i6 = 0;
      while (i6 < i)
      {
        if (localBitMatrix1.a(i6, i4)) {
          localBitMatrix2.a(i5, i3, n, n);
        }
        i6++;
        i5 += n;
      }
      i7 = i4 + 1;
      i3 += n;
    }
    return localBitMatrix2;
  }
  
  private static BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Charset paramCharset, int paramInt3, int paramInt4)
  {
    if (paramBarcodeFormat != BarcodeFormat.a) {
      throw new IllegalArgumentException("Can only encode AZTEC, but got " + paramBarcodeFormat);
    }
    return a(Encoder.a(paramString.getBytes(paramCharset), paramInt3, paramInt4), paramInt1, paramInt2);
  }
  
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    String str;
    Number localNumber1;
    label16:
    Number localNumber2;
    label24:
    Charset localCharset;
    label34:
    int i;
    if (paramMap == null)
    {
      str = null;
      if (paramMap != null) {
        break label84;
      }
      localNumber1 = null;
      if (paramMap != null) {
        break label102;
      }
      localNumber2 = null;
      if (str != null) {
        break label120;
      }
      localCharset = a;
      if (localNumber1 != null) {
        break label130;
      }
      i = 33;
      label43:
      if (localNumber2 != null) {
        break label140;
      }
    }
    label130:
    label140:
    for (int j = 0;; j = localNumber2.intValue())
    {
      return a(paramString, paramBarcodeFormat, paramInt1, paramInt2, localCharset, i, j);
      str = (String)paramMap.get(EncodeHintType.b);
      break;
      label84:
      localNumber1 = (Number)paramMap.get(EncodeHintType.a);
      break label16;
      label102:
      localNumber2 = (Number)paramMap.get(EncodeHintType.j);
      break label24;
      label120:
      localCharset = Charset.forName(str);
      break label34;
      i = localNumber1.intValue();
      break label43;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.AztecWriter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */