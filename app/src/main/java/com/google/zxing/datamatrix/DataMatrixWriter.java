package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

public final class DataMatrixWriter
  implements Writer
{
  private static BitMatrix a(DefaultPlacement paramDefaultPlacement, SymbolInfo paramSymbolInfo)
  {
    int i = paramSymbolInfo.d();
    int j = paramSymbolInfo.e();
    ByteMatrix localByteMatrix = new ByteMatrix(paramSymbolInfo.f(), paramSymbolInfo.g());
    int k = 0;
    int m = 0;
    if (k < j)
    {
      if (k % paramSymbolInfo.c != 0) {
        break label311;
      }
      int i8 = 0;
      int i9 = 0;
      if (i8 < paramSymbolInfo.f())
      {
        if (i8 % 2 == 0) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          localByteMatrix.a(i9, m, bool2);
          i9++;
          i8++;
          break;
        }
      }
    }
    label304:
    label311:
    for (int n = m + 1;; n = m)
    {
      int i1 = 0;
      int i2 = 0;
      label112:
      int i7;
      boolean bool1;
      if (i1 < i)
      {
        if (i1 % paramSymbolInfo.b == 0)
        {
          localByteMatrix.a(i2, n, true);
          i2++;
        }
        localByteMatrix.a(i2, n, paramDefaultPlacement.a(i1, k));
        i7 = i2 + 1;
        if (i1 % paramSymbolInfo.b != -1 + paramSymbolInfo.b) {
          break label304;
        }
        if (k % 2 == 0)
        {
          bool1 = true;
          label190:
          localByteMatrix.a(i7, n, bool1);
        }
      }
      for (i2 = i7 + 1;; i2 = i7)
      {
        i1++;
        break label112;
        bool1 = false;
        break label190;
        int i3 = n + 1;
        if (k % paramSymbolInfo.c == -1 + paramSymbolInfo.c)
        {
          int i5 = 0;
          int i6 = 0;
          while (i5 < paramSymbolInfo.f())
          {
            localByteMatrix.a(i6, i3, true);
            i6++;
            i5++;
          }
        }
        for (int i4 = i3 + 1;; i4 = i3)
        {
          k++;
          m = i4;
          break;
          return a(localByteMatrix);
        }
      }
    }
  }
  
  private static BitMatrix a(ByteMatrix paramByteMatrix)
  {
    int i = paramByteMatrix.b();
    int j = paramByteMatrix.a();
    BitMatrix localBitMatrix = new BitMatrix(i, j);
    localBitMatrix.a();
    for (int k = 0; k < i; k++) {
      for (int m = 0; m < j; m++) {
        if (paramByteMatrix.a(k, m) == 1) {
          localBitMatrix.b(k, m);
        }
      }
    }
    return localBitMatrix;
  }
  
  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramString.isEmpty()) {
      throw new IllegalArgumentException("Found empty contents");
    }
    if (paramBarcodeFormat != BarcodeFormat.f) {
      throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + paramBarcodeFormat);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
    }
    Object localObject = SymbolShapeHint.a;
    Dimension localDimension1;
    Dimension localDimension4;
    if (paramMap != null)
    {
      SymbolShapeHint localSymbolShapeHint = (SymbolShapeHint)paramMap.get(EncodeHintType.c);
      if (localSymbolShapeHint != null) {
        localObject = localSymbolShapeHint;
      }
      Dimension localDimension3 = (Dimension)paramMap.get(EncodeHintType.d);
      if (localDimension3 != null)
      {
        localDimension1 = localDimension3;
        localDimension4 = (Dimension)paramMap.get(EncodeHintType.e);
        localDimension2 = null;
        if (localDimension4 == null) {}
      }
    }
    for (Dimension localDimension2 = localDimension4;; localDimension2 = null)
    {
      String str = HighLevelEncoder.a(paramString, (SymbolShapeHint)localObject, localDimension1, localDimension2);
      SymbolInfo localSymbolInfo = SymbolInfo.a(str.length(), (SymbolShapeHint)localObject, localDimension1, localDimension2, true);
      DefaultPlacement localDefaultPlacement = new DefaultPlacement(ErrorCorrection.a(str, localSymbolInfo), localSymbolInfo.d(), localSymbolInfo.e());
      localDefaultPlacement.a();
      return a(localDefaultPlacement, localSymbolInfo);
      localDimension1 = null;
      break;
      localDimension1 = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.DataMatrixWriter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */