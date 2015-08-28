package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.DataCharacter;
import java.util.List;

final class BitArrayBuilder
{
  static BitArray a(List<ExpandedPair> paramList)
  {
    int i = -1 + (paramList.size() << 1);
    if (((ExpandedPair)paramList.get(-1 + paramList.size())).b() == null) {}
    for (int j = i - 1;; j = i)
    {
      BitArray localBitArray = new BitArray(j * 12);
      int k = ((ExpandedPair)paramList.get(0)).b().a();
      int m = 11;
      int i8;
      for (int n = 0; m >= 0; n = i8)
      {
        if ((k & 1 << m) != 0) {
          localBitArray.b(n);
        }
        i8 = n + 1;
        m--;
      }
      int i1 = 1;
      int i2 = n;
      while (i1 < paramList.size())
      {
        ExpandedPair localExpandedPair = (ExpandedPair)paramList.get(i1);
        int i3 = localExpandedPair.a().a();
        int i4 = 11;
        while (i4 >= 0)
        {
          if ((i3 & 1 << i4) != 0) {
            localBitArray.b(i2);
          }
          int i7 = i2 + 1;
          i4--;
          i2 = i7;
        }
        if (localExpandedPair.b() != null)
        {
          int i5 = localExpandedPair.b().a();
          for (int i6 = 11; i6 >= 0; i6--)
          {
            if ((i5 & 1 << i6) != 0) {
              localBitArray.b(i2);
            }
            i2++;
          }
        }
        i1++;
      }
      return localBitArray;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.BitArrayBuilder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */