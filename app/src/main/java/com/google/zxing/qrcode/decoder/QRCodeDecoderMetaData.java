package com.google.zxing.qrcode.decoder;

import com.google.zxing.ResultPoint;

public final class QRCodeDecoderMetaData
{
  private final boolean a;
  
  QRCodeDecoderMetaData(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a(ResultPoint[] paramArrayOfResultPoint)
  {
    if ((!this.a) || (paramArrayOfResultPoint == null) || (paramArrayOfResultPoint.length < 3)) {
      return;
    }
    ResultPoint localResultPoint = paramArrayOfResultPoint[0];
    paramArrayOfResultPoint[0] = paramArrayOfResultPoint[2];
    paramArrayOfResultPoint[2] = localResultPoint;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */