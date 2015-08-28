package com.google.zxing.datamatrix.detector;

import java.io.Serializable;
import java.util.Comparator;

final class Detector$ResultPointsAndTransitionsComparator
  implements Serializable, Comparator<Detector.ResultPointsAndTransitions>
{
  public int a(Detector.ResultPointsAndTransitions paramResultPointsAndTransitions1, Detector.ResultPointsAndTransitions paramResultPointsAndTransitions2)
  {
    return paramResultPointsAndTransitions1.c() - paramResultPointsAndTransitions2.c();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.detector.Detector.ResultPointsAndTransitionsComparator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */