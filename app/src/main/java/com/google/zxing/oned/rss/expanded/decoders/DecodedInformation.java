package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedInformation
  extends DecodedObject
{
  private final String a;
  private final int b;
  private final boolean c;
  
  DecodedInformation(int paramInt, String paramString)
  {
    super(paramInt);
    this.a = paramString;
    this.c = false;
    this.b = 0;
  }
  
  DecodedInformation(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1);
    this.c = true;
    this.b = paramInt2;
    this.a = paramString;
  }
  
  String a()
  {
    return this.a;
  }
  
  boolean b()
  {
    return this.c;
  }
  
  int c()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.DecodedInformation
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */