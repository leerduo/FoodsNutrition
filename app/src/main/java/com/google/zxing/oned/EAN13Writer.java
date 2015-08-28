package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class EAN13Writer
  extends UPCEANWriter
{
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.h) {
      throw new IllegalArgumentException("Can only encode EAN_13, but got " + paramBarcodeFormat);
    }
    return super.a(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }
  
  public boolean[] a(String paramString)
  {
    if (paramString.length() != 13) {
      throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + paramString.length());
    }
    try
    {
      if (!UPCEANReader.a(paramString)) {
        throw new IllegalArgumentException("Contents do not pass checksum");
      }
    }
    catch (FormatException localFormatException)
    {
      throw new IllegalArgumentException("Illegal contents");
    }
    int i = Integer.parseInt(paramString.substring(0, 1));
    int j = EAN13Reader.a[i];
    boolean[] arrayOfBoolean = new boolean[95];
    int k = 0 + a(arrayOfBoolean, 0, UPCEANReader.b, true);
    int m = 1;
    int n = k;
    while (m <= 6)
    {
      int i4 = Integer.parseInt(paramString.substring(m, m + 1));
      if ((0x1 & j >> 6 - m) == 1) {
        i4 += 10;
      }
      n += a(arrayOfBoolean, n, UPCEANReader.e[i4], false);
      m++;
    }
    int i1 = n + a(arrayOfBoolean, n, UPCEANReader.c, false);
    for (int i2 = 7; i2 <= 12; i2++)
    {
      int i3 = Integer.parseInt(paramString.substring(i2, i2 + 1));
      i1 += a(arrayOfBoolean, i1, UPCEANReader.d[i3], true);
    }
    a(arrayOfBoolean, i1, UPCEANReader.b, true);
    return arrayOfBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.EAN13Writer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */