package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.pdf417.detector.Detector;
import com.google.zxing.pdf417.detector.PDF417DetectorResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class PDF417Reader
  implements Reader
{
  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    if ((paramResultPoint1 == null) || (paramResultPoint2 == null)) {
      return 0;
    }
    return (int)Math.abs(paramResultPoint1.a() - paramResultPoint2.a());
  }
  
  private static int a(ResultPoint[] paramArrayOfResultPoint)
  {
    return Math.max(Math.max(a(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]), 17 * a(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) / 18), Math.max(a(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5]), 17 * a(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3]) / 18));
  }
  
  private static Result[] a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    PDF417DetectorResult localPDF417DetectorResult = Detector.a(paramBinaryBitmap, paramMap, paramBoolean);
    Iterator localIterator = localPDF417DetectorResult.b().iterator();
    while (localIterator.hasNext())
    {
      ResultPoint[] arrayOfResultPoint = (ResultPoint[])localIterator.next();
      DecoderResult localDecoderResult = PDF417ScanningDecoder.a(localPDF417DetectorResult.a(), arrayOfResultPoint[4], arrayOfResultPoint[5], arrayOfResultPoint[6], arrayOfResultPoint[7], b(arrayOfResultPoint), a(arrayOfResultPoint));
      Result localResult = new Result(localDecoderResult.b(), localDecoderResult.a(), arrayOfResultPoint, BarcodeFormat.k);
      localResult.a(ResultMetadataType.d, localDecoderResult.d());
      PDF417ResultMetadata localPDF417ResultMetadata = (PDF417ResultMetadata)localDecoderResult.e();
      if (localPDF417ResultMetadata != null) {
        localResult.a(ResultMetadataType.i, localPDF417ResultMetadata);
      }
      localArrayList.add(localResult);
    }
    return (Result[])localArrayList.toArray(new Result[localArrayList.size()]);
  }
  
  private static int b(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    if ((paramResultPoint1 == null) || (paramResultPoint2 == null)) {
      return 2147483647;
    }
    return (int)Math.abs(paramResultPoint1.a() - paramResultPoint2.a());
  }
  
  private static int b(ResultPoint[] paramArrayOfResultPoint)
  {
    return Math.min(Math.min(b(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]), 17 * b(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) / 18), Math.min(b(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5]), 17 * b(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3]) / 18));
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    Result[] arrayOfResult = a(paramBinaryBitmap, paramMap, false);
    if ((arrayOfResult == null) || (arrayOfResult.length == 0) || (arrayOfResult[0] == null)) {
      throw NotFoundException.a();
    }
    return arrayOfResult[0];
  }
  
  public void a() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.PDF417Reader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */