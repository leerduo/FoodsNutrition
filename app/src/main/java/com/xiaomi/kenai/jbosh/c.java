package com.xiaomi.kenai.jbosh;

abstract class c
  extends a<Integer>
{
  protected c(String paramString)
  {
    super(Integer.valueOf(a(paramString)));
  }
  
  private static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new aa("Could not parse an integer from the value provided: " + paramString, localNumberFormatException);
    }
  }
  
  protected final void a(int paramInt)
  {
    int i = ((Integer)a()).intValue();
    if (i < paramInt) {
      throw new aa("Illegal attribute value '" + i + "' provided.  " + "Must be >= " + paramInt);
    }
  }
  
  public int b()
  {
    return ((Integer)a()).intValue();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */