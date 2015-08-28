package com.google.zxing.qrcode;

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
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

public class QRCodeReader
  implements Reader
{
  private static final ResultPoint[] a = new ResultPoint[0];
  private final Decoder b = new Decoder();
  
  private static float a(int[] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.g();
    int j = paramBitMatrix.f();
    int k = paramArrayOfInt[0];
    int m = paramArrayOfInt[1];
    int n = 1;
    int i1 = m;
    int i2 = k;
    int i3 = 0;
    int i5;
    if ((i2 < j) && (i1 < i))
    {
      if (n == paramBitMatrix.a(i2, i1)) {
        break label133;
      }
      i5 = i3 + 1;
      if (i5 != 5) {}
    }
    else
    {
      if ((i2 != j) && (i1 != i)) {
        break label122;
      }
      throw NotFoundException.a();
    }
    int i6;
    label95:
    int i4;
    if (n == 0)
    {
      i6 = 1;
      i4 = i6;
      i3 = i5;
    }
    for (;;)
    {
      i2++;
      i1++;
      n = i4;
      break;
      i6 = 0;
      break label95;
      label122:
      return (i2 - paramArrayOfInt[0]) / 7.0F;
      label133:
      i4 = n;
    }
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    int[] arrayOfInt1 = paramBitMatrix.d();
    int[] arrayOfInt2 = paramBitMatrix.e();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null)) {
      throw NotFoundException.a();
    }
    float f = a(arrayOfInt1, paramBitMatrix);
    int i = arrayOfInt1[1];
    int j = arrayOfInt2[1];
    int k = arrayOfInt1[0];
    int m = arrayOfInt2[0];
    if ((k >= m) || (i >= j)) {
      throw NotFoundException.a();
    }
    if (j - i != m - k) {
      m = k + (j - i);
    }
    int n = Math.round((1 + (m - k)) / f);
    int i1 = Math.round((1 + (j - i)) / f);
    if ((n <= 0) || (i1 <= 0)) {
      throw NotFoundException.a();
    }
    if (i1 != n) {
      throw NotFoundException.a();
    }
    int i2 = (int)(f / 2.0F);
    int i3 = i + i2;
    int i4 = k + i2;
    int i5 = i4 + (int)(f * (n - 1)) - (m - 1);
    if (i5 > 0) {
      if (i5 > i2) {
        throw NotFoundException.a();
      }
    }
    for (int i6 = i4 - i5;; i6 = i4)
    {
      int i7 = i3 + (int)(f * (i1 - 1)) - (j - 1);
      if (i7 > 0) {
        if (i7 > i2) {
          throw NotFoundException.a();
        }
      }
      for (int i8 = i3 - i7;; i8 = i3)
      {
        BitMatrix localBitMatrix = new BitMatrix(n, i1);
        for (int i9 = 0; i9 < i1; i9++)
        {
          int i10 = i8 + (int)(f * i9);
          for (int i11 = 0; i11 < n; i11++) {
            if (paramBitMatrix.a(i6 + (int)(f * i11), i10)) {
              localBitMatrix.b(i11, i9);
            }
          }
        }
        return localBitMatrix;
      }
    }
  }
  
  public final Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    ResultPoint[] arrayOfResultPoint2;
    Object localObject1;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.b)))
    {
      BitMatrix localBitMatrix = a(paramBinaryBitmap.c());
      DecoderResult localDecoderResult2 = this.b.a(localBitMatrix, paramMap);
      arrayOfResultPoint2 = a;
      localObject1 = localDecoderResult2;
    }
    ResultPoint[] arrayOfResultPoint1;
    for (Object localObject2 = arrayOfResultPoint2;; localObject2 = arrayOfResultPoint1)
    {
      if ((((DecoderResult)localObject1).e() instanceof QRCodeDecoderMetaData)) {
        ((QRCodeDecoderMetaData)((DecoderResult)localObject1).e()).a((ResultPoint[])localObject2);
      }
      Result localResult = new Result(((DecoderResult)localObject1).b(), ((DecoderResult)localObject1).a(), (ResultPoint[])localObject2, BarcodeFormat.l);
      List localList = ((DecoderResult)localObject1).c();
      if (localList != null) {
        localResult.a(ResultMetadataType.c, localList);
      }
      String str = ((DecoderResult)localObject1).d();
      if (str != null) {
        localResult.a(ResultMetadataType.d, str);
      }
      if (((DecoderResult)localObject1).f())
      {
        localResult.a(ResultMetadataType.j, Integer.valueOf(((DecoderResult)localObject1).h()));
        localResult.a(ResultMetadataType.k, Integer.valueOf(((DecoderResult)localObject1).g()));
      }
      return localResult;
      DetectorResult localDetectorResult = new Detector(paramBinaryBitmap.c()).a(paramMap);
      DecoderResult localDecoderResult1 = this.b.a(localDetectorResult.d(), paramMap);
      arrayOfResultPoint1 = localDetectorResult.e();
      localObject1 = localDecoderResult1;
    }
  }
  
  public void a() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.QRCodeReader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */