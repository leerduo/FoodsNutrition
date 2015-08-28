package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

abstract class AI013x0xDecoder
  extends AI01weightDecoder
{
  AI013x0xDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  public String a()
  {
    if (b().a() != 60) {
      throw NotFoundException.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, 5);
    b(localStringBuilder, 45, 15);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI013x0xDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */