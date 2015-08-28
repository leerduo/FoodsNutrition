package com.google.zxing.datamatrix.decoder;

final class Version$ECBlocks
{
  private final int a;
  private final Version.ECB[] b;
  
  private Version$ECBlocks(int paramInt, Version.ECB paramECB)
  {
    this.a = paramInt;
    this.b = new Version.ECB[] { paramECB };
  }
  
  private Version$ECBlocks(int paramInt, Version.ECB paramECB1, Version.ECB paramECB2)
  {
    this.a = paramInt;
    this.b = new Version.ECB[] { paramECB1, paramECB2 };
  }
  
  int a()
  {
    return this.a;
  }
  
  Version.ECB[] b()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.decoder.Version.ECBlocks
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */