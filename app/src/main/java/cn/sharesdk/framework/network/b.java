package cn.sharesdk.framework.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class b
  extends e
{
  private a a;
  
  public b a(byte[] paramArrayOfByte)
  {
    if (this.a == null) {
      this.a = new a(paramArrayOfByte.length);
    }
    this.a.write(paramArrayOfByte);
    this.a.flush();
    return this;
  }
  
  protected InputStream a()
  {
    if (this.a == null) {
      return new ByteArrayInputStream(new byte[0]);
    }
    byte[] arrayOfByte = this.a.a();
    if ((arrayOfByte == null) || (this.a.size() <= 0)) {
      return new ByteArrayInputStream(new byte[0]);
    }
    return new ByteArrayInputStream(arrayOfByte, 0, this.a.size());
  }
  
  protected long b()
  {
    if (this.a == null) {
      return 0L;
    }
    return this.a.size();
  }
  
  public String toString()
  {
    if (this.a == null) {}
    byte[] arrayOfByte;
    do
    {
      return null;
      arrayOfByte = this.a.a();
    } while (arrayOfByte == null);
    return cn.sharesdk.framework.utils.a.a(arrayOfByte, 0, this.a.size());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */