package org.apache.thrift;

import org.apache.thrift.protocol.a.a;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;

public class d
{
  private final f a;
  private final org.apache.thrift.transport.b b = new org.apache.thrift.transport.b();
  
  public d()
  {
    this(new a.a());
  }
  
  public d(h paramh)
  {
    this.a = paramh.a(this.b);
  }
  
  public void a(b paramb, byte[] paramArrayOfByte)
  {
    try
    {
      this.b.a(paramArrayOfByte);
      paramb.a(this.a);
      return;
    }
    finally
    {
      this.a.y();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */