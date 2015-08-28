package com.google.zxing;

public final class Dimension
{
  private final int a;
  private final int b;
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Dimension;
    boolean bool2 = false;
    if (bool1)
    {
      Dimension localDimension = (Dimension)paramObject;
      int i = this.a;
      int j = localDimension.a;
      bool2 = false;
      if (i == j)
      {
        int k = this.b;
        int m = localDimension.b;
        bool2 = false;
        if (k == m) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public int hashCode()
  {
    return 32713 * this.a + this.b;
  }
  
  public String toString()
  {
    return this.a + "x" + this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.Dimension
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */