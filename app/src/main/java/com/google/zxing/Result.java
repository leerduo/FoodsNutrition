package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class Result
{
  private final String a;
  private final byte[] b;
  private ResultPoint[] c;
  private final BarcodeFormat d;
  private Map<ResultMetadataType, Object> e;
  private final long f;
  
  public Result(String paramString, byte[] paramArrayOfByte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat)
  {
    this(paramString, paramArrayOfByte, paramArrayOfResultPoint, paramBarcodeFormat, System.currentTimeMillis());
  }
  
  public Result(String paramString, byte[] paramArrayOfByte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat, long paramLong)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.c = paramArrayOfResultPoint;
    this.d = paramBarcodeFormat;
    this.e = null;
    this.f = paramLong;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(ResultMetadataType paramResultMetadataType, Object paramObject)
  {
    if (this.e == null) {
      this.e = new EnumMap(ResultMetadataType.class);
    }
    this.e.put(paramResultMetadataType, paramObject);
  }
  
  public void a(Map<ResultMetadataType, Object> paramMap)
  {
    if (paramMap != null)
    {
      if (this.e == null) {
        this.e = paramMap;
      }
    }
    else {
      return;
    }
    this.e.putAll(paramMap);
  }
  
  public void a(ResultPoint[] paramArrayOfResultPoint)
  {
    ResultPoint[] arrayOfResultPoint1 = this.c;
    if (arrayOfResultPoint1 == null) {
      this.c = paramArrayOfResultPoint;
    }
    while ((paramArrayOfResultPoint == null) || (paramArrayOfResultPoint.length <= 0)) {
      return;
    }
    ResultPoint[] arrayOfResultPoint2 = new ResultPoint[arrayOfResultPoint1.length + paramArrayOfResultPoint.length];
    System.arraycopy(arrayOfResultPoint1, 0, arrayOfResultPoint2, 0, arrayOfResultPoint1.length);
    System.arraycopy(paramArrayOfResultPoint, 0, arrayOfResultPoint2, arrayOfResultPoint1.length, paramArrayOfResultPoint.length);
    this.c = arrayOfResultPoint2;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public ResultPoint[] c()
  {
    return this.c;
  }
  
  public BarcodeFormat d()
  {
    return this.d;
  }
  
  public Map<ResultMetadataType, Object> e()
  {
    return this.e;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.Result
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */