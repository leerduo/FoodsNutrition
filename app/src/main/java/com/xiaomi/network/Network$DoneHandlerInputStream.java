package com.xiaomi.network;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class Network$DoneHandlerInputStream
  extends FilterInputStream
{
  private boolean a;
  
  public Network$DoneHandlerInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.a)
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i != -1) {
        return i;
      }
    }
    this.a = true;
    return -1;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.Network.DoneHandlerInputStream
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */