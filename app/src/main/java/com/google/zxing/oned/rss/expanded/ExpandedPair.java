package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

final class ExpandedPair
{
  private final boolean a;
  private final DataCharacter b;
  private final DataCharacter c;
  private final FinderPattern d;
  
  ExpandedPair(DataCharacter paramDataCharacter1, DataCharacter paramDataCharacter2, FinderPattern paramFinderPattern, boolean paramBoolean)
  {
    this.b = paramDataCharacter1;
    this.c = paramDataCharacter2;
    this.d = paramFinderPattern;
    this.a = paramBoolean;
  }
  
  private static int a(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  DataCharacter a()
  {
    return this.b;
  }
  
  DataCharacter b()
  {
    return this.c;
  }
  
  FinderPattern c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.c == null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ExpandedPair)) {}
    ExpandedPair localExpandedPair;
    do
    {
      return false;
      localExpandedPair = (ExpandedPair)paramObject;
    } while ((!a(this.b, localExpandedPair.b)) || (!a(this.c, localExpandedPair.c)) || (!a(this.d, localExpandedPair.d)));
    return true;
  }
  
  public int hashCode()
  {
    return a(this.b) ^ a(this.c) ^ a(this.d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[ ").append(this.b).append(" , ").append(this.c).append(" : ");
    if (this.d == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.d.a())) {
      return localObject + " ]";
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.ExpandedPair
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */