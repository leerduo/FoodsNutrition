package com.google.zxing;

import java.util.Map;

public abstract interface Reader
{
  public abstract Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap);
  
  public abstract void a();
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.Reader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */