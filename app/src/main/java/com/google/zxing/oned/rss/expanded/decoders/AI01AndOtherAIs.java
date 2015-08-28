package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI01AndOtherAIs
  extends AI01decoder
{
  AI01AndOtherAIs(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(01)");
    int i = localStringBuilder.length();
    localStringBuilder.append(c().a(4, 4));
    a(localStringBuilder, 8, i);
    return c().a(localStringBuilder, 48);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI01AndOtherAIs
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */