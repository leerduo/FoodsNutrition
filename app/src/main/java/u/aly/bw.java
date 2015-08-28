package u.aly;

public class bw
{
  public static final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    return (byte)a(paramByte, paramInt, paramBoolean);
  }
  
  public static final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 | 1 << paramInt2;
    }
    return b(paramInt1, paramInt2);
  }
  
  public static final boolean a(byte paramByte, int paramInt)
  {
    return a(paramByte, paramInt);
  }
  
  public static final boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & 1 << paramInt2) != 0;
  }
  
  public static final int b(int paramInt1, int paramInt2)
  {
    return paramInt1 & (0xFFFFFFFF ^ 1 << paramInt2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bw
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */