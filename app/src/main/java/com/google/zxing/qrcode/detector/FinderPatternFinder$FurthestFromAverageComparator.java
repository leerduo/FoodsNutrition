package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

final class FinderPatternFinder$FurthestFromAverageComparator
  implements Serializable, Comparator<FinderPattern>
{
  private final float a;
  
  private FinderPatternFinder$FurthestFromAverageComparator(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public int a(FinderPattern paramFinderPattern1, FinderPattern paramFinderPattern2)
  {
    float f1 = Math.abs(paramFinderPattern2.c() - this.a);
    float f2 = Math.abs(paramFinderPattern1.c() - this.a);
    if (f1 < f2) {
      return -1;
    }
    if (f1 == f2) {
      return 0;
    }
    return 1;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder.FurthestFromAverageComparator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */