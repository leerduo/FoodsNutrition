package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

public final class MultiFormatWriter
  implements Writer
{
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    Object localObject;
    switch (MultiFormatWriter.1.a[paramBarcodeFormat.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("No encoder available for format " + paramBarcodeFormat);
    case 1: 
      localObject = new EAN8Writer();
    }
    for (;;)
    {
      return ((Writer)localObject).a(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      localObject = new EAN13Writer();
      continue;
      localObject = new UPCAWriter();
      continue;
      localObject = new QRCodeWriter();
      continue;
      localObject = new Code39Writer();
      continue;
      localObject = new Code128Writer();
      continue;
      localObject = new ITFWriter();
      continue;
      localObject = new PDF417Writer();
      continue;
      localObject = new CodaBarWriter();
      continue;
      localObject = new DataMatrixWriter();
      continue;
      localObject = new AztecWriter();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.MultiFormatWriter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */