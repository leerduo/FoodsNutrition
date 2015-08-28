package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class EAN8Writer
  extends UPCEANWriter
{
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.g) {
      throw new IllegalArgumentException("Can only encode EAN_8, but got " + paramBarcodeFormat);
    }
    return super.a(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }
  
  public boolean[] a(String paramString)
  {
    if (paramString.length() != 8) {
      throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + paramString.length());
    }
    boolean[] arrayOfBoolean = new boolean[67];
    int i = 0 + a(arrayOfBoolean, 0, UPCEANReader.b, true);
    for (int j = 0; j <= 3; j++)
    {
      int i1 = Integer.parseInt(paramString.substring(j, j + 1));
      i += a(arrayOfBoolean, i, UPCEANReader.d[i1], false);
    }
    int k = i + a(arrayOfBoolean, i, UPCEANReader.c, false);
    for (int m = 4; m <= 7; m++)
    {
      int n = Integer.parseInt(paramString.substring(m, m + 1));
      k += a(arrayOfBoolean, k, UPCEANReader.d[n], true);
    }
    a(arrayOfBoolean, k, UPCEANReader.b, true);
    return arrayOfBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.EAN8Writer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */