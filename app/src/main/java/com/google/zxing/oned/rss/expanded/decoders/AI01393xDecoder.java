package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01393xDecoder
  extends AI01decoder
{
  AI01393xDecoder(BitArray paramBitArray)
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
    localStringBuilder.append("(393");
    localStringBuilder.append(i);
    localStringBuilder.append(')');
    int j = c().a(50, 10);
    if (j / 100 == 0) {
      localStringBuilder.append('0');
    }
    if (j / 10 == 0) {
      localStringBuilder.append('0');
    }
    localStringBuilder.append(j);
    localStringBuilder.append(c().a(60, null).a());
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI01393xDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */