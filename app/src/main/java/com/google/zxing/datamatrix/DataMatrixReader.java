package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;

public final class DataMatrixReader
  implements Reader
{
  private static final ResultPoint[] a = new ResultPoint[0];
  private final Decoder b = new Decoder();
  
  private static int a(int[] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.f();
    int j = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    while ((j < i) && (paramBitMatrix.a(j, k))) {
      j++;
    }
    if (j == i) {
      throw NotFoundException.a();
    }
    int m = j - paramArrayOfInt[0];
    if (m == 0) {
      throw NotFoundException.a();
    }
    return m;
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    int[] arrayOfInt1 = paramBitMatrix.d();
    int[] arrayOfInt2 = paramBitMatrix.e();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null)) {
      throw NotFoundException.a();
    }
    int i = a(arrayOfInt1, paramBitMatrix);
    int j = arrayOfInt1[1];
    int k = arrayOfInt2[1];
    int m = arrayOfInt1[0];
    int n = (1 + (arrayOfInt2[0] - m)) / i;
    int i1 = (1 + (k - j)) / i;
    if ((n <= 0) || (i1 <= 0)) {
      throw NotFoundException.a();
    }
    int i2 = i >> 1;
    int i3 = j + i2;
    int i4 = m + i2;
    BitMatrix localBitMatrix = new BitMatrix(n, i1);
    for (int i5 = 0; i5 < i1; i5++)
    {
      int i6 = i3 + i5 * i;
      for (int i7 = 0; i7 < n; i7++) {
        if (paramBitMatrix.a(i4 + i7 * i, i6)) {
          localBitMatrix.b(i7, i5);
        }
      }
    }
    return localBitMatrix;
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    DecoderResult localDecoderResult;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.b)))
    {
      BitMatrix localBitMatrix = a(paramBinaryBitmap.c());
      localDecoderResult = this.b.a(localBitMatrix);
    }
    DetectorResult localDetectorResult;
    for (ResultPoint[] arrayOfResultPoint = a;; arrayOfResultPoint = localDetectorResult.e())
    {
      Result localResult = new Result(localDecoderResult.b(), localDecoderResult.a(), arrayOfResultPoint, BarcodeFormat.f);
      List localList = localDecoderResult.c();
      if (localList != null) {
        localResult.a(ResultMetadataType.c, localList);
      }
      String str = localDecoderResult.d();
      if (str != null) {
        localResult.a(ResultMetadataType.d, str);
      }
      return localResult;
      localDetectorResult = new Detector(paramBinaryBitmap.c()).a();
      localDecoderResult = this.b.a(localDetectorResult.d());
    }
  }
  
  public void a() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.DataMatrixReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */