package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI01320xDecoder
  extends AI013x0xDecoder
{
  AI01320xDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  protected int a(int paramInt)
  {
    if (paramInt < 10000) {
      return paramInt;
    }
    return paramInt - 10000;
  }
  
  protected void a(StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt < 10000)
    {
      paramStringBuilder.append("(3202)");
      return;
    }
    paramStringBuilder.append("(3203)");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI01320xDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */