package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01decoder
  extends AbstractExpandedDecoder
{
  AI01decoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < 13)
    {
      int m = '￐' + paramStringBuilder.charAt(i + paramInt);
      if ((i & 0x1) == 0) {
        m *= 3;
      }
      j += m;
      i++;
    }
    int k = 10 - j % 10;
    if (k == 10) {
      k = 0;
    }
    paramStringBuilder.append(k);
  }
  
  protected final void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    for (int i = 0; i < 4; i++)
    {
      int j = c().a(paramInt1 + i * 10, 10);
      if (j / 100 == 0) {
        paramStringBuilder.append('0');
      }
      if (j / 10 == 0) {
        paramStringBuilder.append('0');
      }
      paramStringBuilder.append(j);
    }
    a(paramStringBuilder, paramInt2);
  }
  
  protected final void b(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append("(01)");
    int i = paramStringBuilder.length();
    paramStringBuilder.append('9');
    a(paramStringBuilder, paramInt, i);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.AI01decoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */