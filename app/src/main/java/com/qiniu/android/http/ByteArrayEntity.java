package com.qiniu.android.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

public final class ByteArrayEntity
  extends AbstractHttpEntity
  implements Cloneable
{
  private final byte[] b;
  private final int len;
  private final int off;
  
  public ByteArrayEntity(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
    this.off = 0;
    this.len = this.b.length;
  }
  
  public ByteArrayEntity(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfByte.length);
    }
    this.b = paramArrayOfByte;
    this.off = paramInt1;
    this.len = paramInt2;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public InputStream getContent()
  {
    return new ByteArrayInputStream(this.b, this.off, this.len);
  }
  
  public long getContentLength()
  {
    return this.len;
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream.write(this.b, this.off, this.len);
    paramOutputStream.flush();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.http.ByteArrayEntity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */