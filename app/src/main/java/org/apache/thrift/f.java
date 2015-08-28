package org.apache.thrift;

import java.io.ByteArrayOutputStream;
import org.apache.thrift.protocol.a.a;
import org.apache.thrift.protocol.h;
import org.apache.thrift.transport.a;

public class f
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  private final a b = new a(this.a);
  private org.apache.thrift.protocol.f c;
  
  public f()
  {
    this(new a.a());
  }
  
  public f(h paramh)
  {
    this.c = paramh.a(this.b);
  }
  
  public byte[] a(b paramb)
  {
    this.a.reset();
    paramb.b(this.c);
    return this.a.toByteArray();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */