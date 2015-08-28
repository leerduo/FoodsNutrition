package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI013103decoder
  extends AI013x0xDecoder
{
  AI013103decoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  protected void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append("(3103)");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI013103decoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */