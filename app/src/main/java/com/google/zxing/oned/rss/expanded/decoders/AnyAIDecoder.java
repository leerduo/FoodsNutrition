package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AnyAIDecoder
  extends AbstractExpandedDecoder
{
  AnyAIDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    return c().a(localStringBuilder, 5);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AnyAIDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */