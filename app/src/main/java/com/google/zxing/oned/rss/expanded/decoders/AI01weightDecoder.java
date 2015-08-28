package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01weightDecoder
  extends AI01decoder
{
  AI01weightDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  protected abstract int a(int paramInt);
  
  protected abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  protected final void b(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int i = c().a(paramInt1, paramInt2);
    a(paramStringBuilder, i);
    int j = a(i);
    int k = 100000;
    for (int m = 0; m < 5; m++)
    {
      if (j / k == 0) {
        paramStringBuilder.append('0');
      }
      k /= 10;
    }
    paramStringBuilder.append(j);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */