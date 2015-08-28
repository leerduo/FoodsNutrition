package com.google.zxing;

public final class NotFoundException
  extends ReaderException
{
  private static final NotFoundException a = new NotFoundException();
  
  public static NotFoundException a()
  {
    return a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.NotFoundException
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */