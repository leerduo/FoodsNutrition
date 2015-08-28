package u.aly;

public enum ap
{
  private final int d;
  
  static
  {
    ap[] arrayOfap = new ap[3];
    arrayOfap[0] = a;
    arrayOfap[1] = b;
    arrayOfap[2] = c;
  }
  
  private ap(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static ap a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return a;
    case 1: 
      return b;
    }
    return c;
  }
  
  public int a()
  {
    return this.d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ap
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */