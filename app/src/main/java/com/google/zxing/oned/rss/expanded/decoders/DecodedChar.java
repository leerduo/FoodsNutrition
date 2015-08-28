package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedChar
  extends DecodedObject
{
  private final char a;
  
  DecodedChar(int paramInt, char paramChar)
  {
    super(paramInt);
    this.a = paramChar;
  }
  
  char a()
  {
    return this.a;
  }
  
  boolean b()
  {
    return this.a == '$';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.DecodedChar
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */