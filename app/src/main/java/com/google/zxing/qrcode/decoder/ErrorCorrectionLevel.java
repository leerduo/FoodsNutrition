package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel
{
  private static final ErrorCorrectionLevel[] e = arrayOfErrorCorrectionLevel2;
  private final int f;
  
  static
  {
    ErrorCorrectionLevel[] arrayOfErrorCorrectionLevel1 = new ErrorCorrectionLevel[4];
    arrayOfErrorCorrectionLevel1[0] = a;
    arrayOfErrorCorrectionLevel1[1] = b;
    arrayOfErrorCorrectionLevel1[2] = c;
    arrayOfErrorCorrectionLevel1[3] = d;
    g = arrayOfErrorCorrectionLevel1;
    ErrorCorrectionLevel[] arrayOfErrorCorrectionLevel2 = new ErrorCorrectionLevel[4];
    arrayOfErrorCorrectionLevel2[0] = b;
    arrayOfErrorCorrectionLevel2[1] = a;
    arrayOfErrorCorrectionLevel2[2] = d;
    arrayOfErrorCorrectionLevel2[3] = c;
  }
  
  private ErrorCorrectionLevel(int paramInt)
  {
    this.f = paramInt;
  }
  
  public static ErrorCorrectionLevel a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= e.length)) {
      throw new IllegalArgumentException();
    }
    return e[paramInt];
  }
  
  public int a()
  {
    return this.f;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */