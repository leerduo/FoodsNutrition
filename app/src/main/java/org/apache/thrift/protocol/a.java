package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class a
  extends f
{
  private static final k f = new k();
  protected boolean a = false;
  protected boolean b = true;
  protected int c;
  protected boolean d = false;
  private byte[] g = new byte[1];
  private byte[] h = new byte[2];
  private byte[] i = new byte[4];
  private byte[] j = new byte[8];
  private byte[] k = new byte[1];
  private byte[] l = new byte[2];
  private byte[] m = new byte[4];
  private byte[] n = new byte[8];
  
  public a(org.apache.thrift.transport.c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramc);
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    d(paramInt2);
    return this.e.d(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void a() {}
  
  public void a(byte paramByte)
  {
    this.g[0] = paramByte;
    this.e.b(this.g, 0, 1);
  }
  
  public void a(int paramInt)
  {
    this.i[0] = ((byte)(0xFF & paramInt >> 24));
    this.i[1] = ((byte)(0xFF & paramInt >> 16));
    this.i[2] = ((byte)(0xFF & paramInt >> 8));
    this.i[3] = ((byte)(paramInt & 0xFF));
    this.e.b(this.i, 0, 4);
  }
  
  public void a(long paramLong)
  {
    this.j[0] = ((byte)(int)(0xFF & paramLong >> 56));
    this.j[1] = ((byte)(int)(0xFF & paramLong >> 48));
    this.j[2] = ((byte)(int)(0xFF & paramLong >> 40));
    this.j[3] = ((byte)(int)(0xFF & paramLong >> 32));
    this.j[4] = ((byte)(int)(0xFF & paramLong >> 24));
    this.j[5] = ((byte)(int)(0xFF & paramLong >> 16));
    this.j[6] = ((byte)(int)(0xFF & paramLong >> 8));
    this.j[7] = ((byte)(int)(0xFF & paramLong));
    this.e.b(this.j, 0, 8);
  }
  
  public void a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      a(arrayOfByte.length);
      this.e.b(arrayOfByte, 0, arrayOfByte.length);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new org.apache.thrift.e("JVM DOES NOT SUPPORT UTF-8");
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit() - paramByteBuffer.position() - paramByteBuffer.arrayOffset();
    a(i1);
    this.e.b(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), i1);
  }
  
  public void a(c paramc)
  {
    a(paramc.b);
    a(paramc.c);
  }
  
  public void a(d paramd)
  {
    a(paramd.a);
    a(paramd.b);
  }
  
  public void a(e parame)
  {
    a(parame.a);
    a(parame.b);
    a(parame.c);
  }
  
  public void a(j paramj)
  {
    a(paramj.a);
    a(paramj.b);
  }
  
  public void a(k paramk) {}
  
  public void a(short paramShort)
  {
    this.h[0] = ((byte)(0xFF & paramShort >> 8));
    this.h[1] = ((byte)(paramShort & 0xFF));
    this.e.b(this.h, 0, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b1 = 1;; b1 = 0)
    {
      a(b1);
      return;
    }
  }
  
  public String b(int paramInt)
  {
    try
    {
      d(paramInt);
      byte[] arrayOfByte = new byte[paramInt];
      this.e.d(arrayOfByte, 0, paramInt);
      String str = new String(arrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new org.apache.thrift.e("JVM DOES NOT SUPPORT UTF-8");
    }
  }
  
  public void b() {}
  
  public void c()
  {
    a((byte)0);
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
    this.d = true;
  }
  
  public void d() {}
  
  protected void d(int paramInt)
  {
    if (paramInt < 0) {
      throw new org.apache.thrift.e("Negative length: " + paramInt);
    }
    if (this.d)
    {
      this.c -= paramInt;
      if (this.c < 0) {
        throw new org.apache.thrift.e("Message length exceeded: " + paramInt);
      }
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public k g()
  {
    return f;
  }
  
  public void h() {}
  
  public c i()
  {
    byte b1 = r();
    if (b1 == 0) {}
    for (short s = 0;; s = s()) {
      return new c("", b1, s);
    }
  }
  
  public void j() {}
  
  public e k()
  {
    return new e(r(), r(), t());
  }
  
  public void l() {}
  
  public d m()
  {
    return new d(r(), t());
  }
  
  public void n() {}
  
  public j o()
  {
    return new j(r(), t());
  }
  
  public void p() {}
  
  public boolean q()
  {
    return r() == 1;
  }
  
  public byte r()
  {
    if (this.e.c() >= 1)
    {
      byte b1 = this.e.a()[this.e.b()];
      this.e.a(1);
      return b1;
    }
    a(this.k, 0, 1);
    return this.k[0];
  }
  
  public short s()
  {
    byte[] arrayOfByte = this.l;
    int i1;
    if (this.e.c() >= 2)
    {
      arrayOfByte = this.e.a();
      i1 = this.e.b();
      this.e.a(2);
    }
    for (;;)
    {
      return (short)((0xFF & arrayOfByte[i1]) << 8 | 0xFF & arrayOfByte[(i1 + 1)]);
      a(this.l, 0, 2);
      i1 = 0;
    }
  }
  
  public int t()
  {
    byte[] arrayOfByte = this.m;
    int i1;
    if (this.e.c() >= 4)
    {
      arrayOfByte = this.e.a();
      i1 = this.e.b();
      this.e.a(4);
    }
    for (;;)
    {
      return (0xFF & arrayOfByte[i1]) << 24 | (0xFF & arrayOfByte[(i1 + 1)]) << 16 | (0xFF & arrayOfByte[(i1 + 2)]) << 8 | 0xFF & arrayOfByte[(i1 + 3)];
      a(this.m, 0, 4);
      i1 = 0;
    }
  }
  
  public long u()
  {
    byte[] arrayOfByte = this.n;
    int i1;
    if (this.e.c() >= 8)
    {
      arrayOfByte = this.e.a();
      i1 = this.e.b();
      this.e.a(8);
    }
    for (;;)
    {
      return (0xFF & arrayOfByte[i1]) << 56 | (0xFF & arrayOfByte[(i1 + 1)]) << 48 | (0xFF & arrayOfByte[(i1 + 2)]) << 40 | (0xFF & arrayOfByte[(i1 + 3)]) << 32 | (0xFF & arrayOfByte[(i1 + 4)]) << 24 | (0xFF & arrayOfByte[(i1 + 5)]) << 16 | (0xFF & arrayOfByte[(i1 + 6)]) << 8 | 0xFF & arrayOfByte[(i1 + 7)];
      a(this.n, 0, 8);
      i1 = 0;
    }
  }
  
  public double v()
  {
    return Double.longBitsToDouble(u());
  }
  
  public String w()
  {
    int i1 = t();
    if (this.e.c() >= i1) {
      try
      {
        String str = new String(this.e.a(), this.e.b(), i1, "UTF-8");
        this.e.a(i1);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new org.apache.thrift.e("JVM DOES NOT SUPPORT UTF-8");
      }
    }
    return b(i1);
  }
  
  public ByteBuffer x()
  {
    int i1 = t();
    d(i1);
    if (this.e.c() >= i1)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(this.e.a(), this.e.b(), i1);
      this.e.a(i1);
      return localByteBuffer;
    }
    byte[] arrayOfByte = new byte[i1];
    this.e.d(arrayOfByte, 0, i1);
    return ByteBuffer.wrap(arrayOfByte);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.protocol.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */