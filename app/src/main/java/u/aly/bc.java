package u.aly;

public enum bc
{
  private final int e;
  
  static
  {
    bc[] arrayOfbc = new bc[4];
    arrayOfbc[0] = a;
    arrayOfbc[1] = b;
    arrayOfbc[2] = c;
    arrayOfbc[3] = d;
  }
  
  private bc(int paramInt)
  {
    this.e = paramInt;
  }
  
  public static bc a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return a;
    case 1: 
      return b;
    case 2: 
      return c;
    }
    return d;
  }
  
  public int a()
  {
    return this.e;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bc
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */