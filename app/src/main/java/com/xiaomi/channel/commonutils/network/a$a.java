package com.xiaomi.channel.commonutils.network;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class a$a
  extends FilterInputStream
{
  private boolean a;
  
  public a$a(InputStream paramInputStream)
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
 * Qualified Name:     com.xiaomi.channel.commonutils.network.a.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */