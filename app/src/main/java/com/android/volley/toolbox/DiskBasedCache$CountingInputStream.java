package com.android.volley.toolbox;

import java.io.FilterInputStream;
import java.io.InputStream;

class DiskBasedCache$CountingInputStream
  extends FilterInputStream
{
  private int a = 0;
  
  private DiskBasedCache$CountingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read()
  {
    int i = super.read();
    if (i != -1) {
      this.a = (1 + this.a);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1) {
      this.a = (i + this.a);
    }
    return i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.DiskBasedCache.CountingInputStream
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */