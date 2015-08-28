package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

final class ExpandedRow
{
  private final List<ExpandedPair> a;
  private final int b;
  private final boolean c;
  
  ExpandedRow(List<ExpandedPair> paramList, int paramInt, boolean paramBoolean)
  {
    this.a = new ArrayList(paramList);
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  List<ExpandedPair> a()
  {
    return this.a;
  }
  
  boolean a(List<ExpandedPair> paramList)
  {
    return this.a.equals(paramList);
  }
  
  int b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ExpandedRow)) {}
    ExpandedRow localExpandedRow;
    do
    {
      return false;
      localExpandedRow = (ExpandedRow)paramObject;
    } while ((!this.a.equals(localExpandedRow.a())) || (this.c != localExpandedRow.c));
    return true;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
  }
  
  public String toString()
  {
    return "{ " + this.a + " }";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.ExpandedRow
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */