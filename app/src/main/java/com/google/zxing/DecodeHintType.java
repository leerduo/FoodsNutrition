package com.google.zxing;

import java.util.List;

public enum DecodeHintType
{
  private final Class<?> l;
  
  static
  {
    DecodeHintType[] arrayOfDecodeHintType = new DecodeHintType[11];
    arrayOfDecodeHintType[0] = a;
    arrayOfDecodeHintType[1] = b;
    arrayOfDecodeHintType[2] = c;
    arrayOfDecodeHintType[3] = d;
    arrayOfDecodeHintType[4] = e;
    arrayOfDecodeHintType[5] = f;
    arrayOfDecodeHintType[6] = g;
    arrayOfDecodeHintType[7] = h;
    arrayOfDecodeHintType[8] = i;
    arrayOfDecodeHintType[9] = j;
    arrayOfDecodeHintType[10] = k;
  }
  
  private DecodeHintType(Class<?> paramClass)
  {
    this.l = paramClass;
  }
  
  public Class<?> a()
  {
    return this.l;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.DecodeHintType
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */