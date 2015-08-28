package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01392xDecoder
  extends AI01decoder
{
  AI01392xDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  public String a()
  {
    if (b().a() < 48) {
      throw NotFoundException.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, 8);
    int i = c().a(48, 2);
    localStringBuilder.append("(392");
    localStringBuilder.append(i);
    localStringBuilder.append(')');
    localStringBuilder.append(c().a(50, null).a());
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI01392xDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */