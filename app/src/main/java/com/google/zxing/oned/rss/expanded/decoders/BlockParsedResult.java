package com.google.zxing.oned.rss.expanded.decoders;

final class BlockParsedResult
{
  private final DecodedInformation a;
  private final boolean b;
  
  BlockParsedResult(DecodedInformation paramDecodedInformation, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.a = paramDecodedInformation;
  }
  
  BlockParsedResult(boolean paramBoolean)
  {
    this(null, paramBoolean);
  }
  
  DecodedInformation a()
  {
    return this.a;
  }
  
  boolean b()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.BlockParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */