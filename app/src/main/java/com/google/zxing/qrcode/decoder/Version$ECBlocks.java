package com.google.zxing.qrcode.decoder;

public final class Version$ECBlocks
{
  private final int a;
  private final Version.ECB[] b;
  
  Version$ECBlocks(int paramInt, Version.ECB... paramVarArgs)
  {
    this.a = paramInt;
    this.b = paramVarArgs;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    int i = 0;
    Version.ECB[] arrayOfECB = this.b;
    int j = arrayOfECB.length;
    int k = 0;
    while (i < j)
    {
      k += arrayOfECB[i].a();
      i++;
    }
    return k;
  }
  
  public int c()
  {
    return this.a * b();
  }
  
  public Version.ECB[] d()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Version.ECBlocks
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */