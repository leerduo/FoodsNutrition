package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;

public class PoolingByteArrayOutputStream
  extends ByteArrayOutputStream
{
  private final ByteArrayPool a;
  
  public PoolingByteArrayOutputStream(ByteArrayPool paramByteArrayPool, int paramInt)
  {
    this.a = paramByteArrayPool;
    this.buf = this.a.a(Math.max(paramInt, 256));
  }
  
  private void a(int paramInt)
  {
    if (paramInt + this.count <= this.buf.length) {
      return;
    }
    byte[] arrayOfByte = this.a.a(2 * (paramInt + this.count));
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.a.a(this.buf);
    this.buf = arrayOfByte;
  }
  
  public void close()
  {
    this.a.a(this.buf);
    this.buf = null;
    super.close();
  }
  
  public void finalize()
  {
    this.a.a(this.buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      a(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.PoolingByteArrayOutputStream
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */