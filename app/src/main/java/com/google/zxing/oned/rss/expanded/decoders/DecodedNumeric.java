package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

final class DecodedNumeric
  extends DecodedObject
{
  private final int a;
  private final int b;
  
  DecodedNumeric(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 > 10) || (paramInt3 < 0) || (paramInt3 > 10)) {
      throw FormatException.a();
    }
    this.a = paramInt2;
    this.b = paramInt3;
  }
  
  int a()
  {
    return this.a;
  }
  
  int b()
  {
    return this.b;
  }
  
  boolean c()
  {
    return this.a == 10;
  }
  
  boolean d()
  {
    return this.b == 10;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.DecodedNumeric
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */