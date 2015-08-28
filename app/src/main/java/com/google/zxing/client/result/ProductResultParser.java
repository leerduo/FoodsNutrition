package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;

public final class ProductResultParser
  extends ResultParser
{
  public ProductParsedResult a(Result paramResult)
  {
    BarcodeFormat localBarcodeFormat = paramResult.d();
    if ((localBarcodeFormat != BarcodeFormat.o) && (localBarcodeFormat != BarcodeFormat.p) && (localBarcodeFormat != BarcodeFormat.g) && (localBarcodeFormat != BarcodeFormat.h)) {}
    String str1;
    do
    {
      return null;
      str1 = c(paramResult);
    } while (!a(str1, str1.length()));
    if ((localBarcodeFormat == BarcodeFormat.p) && (str1.length() == 8)) {}
    for (String str2 = UPCEReader.b(str1);; str2 = str1) {
      return new ProductParsedResult(str1, str2);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ProductResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */