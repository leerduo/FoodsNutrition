package com.google.zxing.oned.rss;

final class Pair
  extends DataCharacter
{
  private final FinderPattern a;
  private int b;
  
  Pair(int paramInt1, int paramInt2, FinderPattern paramFinderPattern)
  {
    super(paramInt1, paramInt2);
    this.a = paramFinderPattern;
  }
  
  FinderPattern c()
  {
    return this.a;
  }
  
  int d()
  {
    return this.b;
  }
  
  void e()
  {
    this.b = (1 + this.b);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.Pair
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */