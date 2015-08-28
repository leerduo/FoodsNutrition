package com.google.zxing.maxicode;

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
import com.google.zxing.maxicode.decoder.Decoder;
import java.util.Map;

public final class MaxiCodeReader
  implements Reader
{
  private static final ResultPoint[] a = new ResultPoint[0];
  private final Decoder b = new Decoder();
  
  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    int[] arrayOfInt = paramBitMatrix.c();
    if (arrayOfInt == null) {
      throw NotFoundException.a();
    }
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[2];
    int m = arrayOfInt[3];
    BitMatrix localBitMatrix = new BitMatrix(30, 33);
    for (int n = 0; n < 33; n++)
    {
      int i1 = j + (n * m + m / 2) / 33;
      for (int i2 = 0; i2 < 30; i2++) {
        if (paramBitMatrix.a(i + (i2 * k + k / 2 + k * (n & 0x1) / 2) / 30, i1)) {
          localBitMatrix.b(i2, n);
        }
      }
    }
    return localBitMatrix;
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.b)))
    {
      BitMatrix localBitMatrix = a(paramBinaryBitmap.c());
      DecoderResult localDecoderResult = this.b.a(localBitMatrix, paramMap);
      ResultPoint[] arrayOfResultPoint = a;
      Result localResult = new Result(localDecoderResult.b(), localDecoderResult.a(), arrayOfResultPoint, BarcodeFormat.j);
      String str = localDecoderResult.d();
      if (str != null) {
        localResult.a(ResultMetadataType.d, str);
      }
      return localResult;
    }
    throw NotFoundException.a();
  }
  
  public void a() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.maxicode.MaxiCodeReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */