package org.apache.thrift.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a
  extends c
{
  protected InputStream a = null;
  protected OutputStream b = null;
  
  protected a() {}
  
  public a(OutputStream paramOutputStream)
  {
    this.b = paramOutputStream;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      throw new d(1, "Cannot read from null inputStream");
    }
    int i;
    try
    {
      i = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i < 0) {
        throw new d(4);
      }
    }
    catch (IOException localIOException)
    {
      throw new d(0, localIOException);
    }
    return i;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      throw new d(1, "Cannot write to null outputStream");
    }
    try
    {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      throw new d(0, localIOException);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.transport.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */