package cn.sharesdk.framework.network;

import java.io.InputStream;

public class c
  extends InputStream
{
  private InputStream a;
  private long b;
  private OnReadListener c;
  
  public c(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public void a(OnReadListener paramOnReadListener)
  {
    this.c = paramOnReadListener;
  }
  
  public int available()
  {
    return this.a.available();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public int read()
  {
    int i = this.a.read();
    if (i >= 0)
    {
      this.b = (1L + this.b);
      if (this.c != null) {
        this.c.onRead(this.b);
      }
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i > 0)
    {
      this.b += i;
      if (this.c != null) {
        this.c.onRead(this.b);
      }
    }
    return i;
  }
  
  public void reset()
  {
    try
    {
      this.a.reset();
      this.b = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    return this.a.skip(paramLong);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */