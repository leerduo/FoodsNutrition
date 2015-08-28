package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.a;

public final class b
  extends f
{
  private static final k d = new k("");
  private static final c f = new c("", (byte)0, (short)0);
  private static final byte[] g = new byte[16];
  byte[] a = new byte[5];
  byte[] b = new byte[10];
  byte[] c = new byte[1];
  private a h = new a(15);
  private short i = 0;
  private c j = null;
  private Boolean k = null;
  private byte[] l = new byte[1];
  
  static
  {
    g[0] = 0;
    g[2] = 1;
    g[3] = 3;
    g[6] = 4;
    g[8] = 5;
    g[10] = 6;
    g[4] = 7;
    g[11] = 8;
    g[15] = 9;
    g[14] = 10;
    g[13] = 11;
    g[12] = 12;
  }
  
  public b(org.apache.thrift.transport.c paramc)
  {
    super(paramc);
  }
  
  private long A()
  {
    long l1 = 0L;
    int m = this.e.c();
    int n = 0;
    if (m >= 10)
    {
      byte[] arrayOfByte = this.e.a();
      int i2 = this.e.b();
      int i3 = 0;
      for (;;)
      {
        int i4 = arrayOfByte[(i2 + n)];
        l1 |= (i4 & 0x7F) << i3;
        if ((i4 & 0x80) != 128)
        {
          this.e.a(n + 1);
          return l1;
        }
        i3 += 7;
        n++;
      }
    }
    int i1;
    do
    {
      n += 7;
      i1 = r();
      l1 |= (i1 & 0x7F) << n;
    } while ((i1 & 0x80) == 128);
    return l1;
  }
  
  private long a(byte[] paramArrayOfByte)
  {
    return (0xFF & paramArrayOfByte[7]) << 56 | (0xFF & paramArrayOfByte[6]) << 48 | (0xFF & paramArrayOfByte[5]) << 40 | (0xFF & paramArrayOfByte[4]) << 32 | (0xFF & paramArrayOfByte[3]) << 24 | (0xFF & paramArrayOfByte[2]) << 16 | (0xFF & paramArrayOfByte[1]) << 8 | 0xFF & paramArrayOfByte[0];
  }
  
  private void a(c paramc, byte paramByte)
  {
    if (paramByte == -1) {
      paramByte = e(paramc.b);
    }
    if ((paramc.c > this.i) && (paramc.c - this.i <= 15)) {
      d(paramByte | paramc.c - this.i << 4);
    }
    for (;;)
    {
      this.i = paramc.c;
      return;
      b(paramByte);
      a(paramc.c);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    this.e.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void b(byte paramByte)
  {
    this.l[0] = paramByte;
    this.e.b(this.l);
  }
  
  private void b(int paramInt)
  {
    int n;
    for (int m = 0;; m = n)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        byte[] arrayOfByte2 = this.a;
        int i1 = m + 1;
        arrayOfByte2[m] = ((byte)paramInt);
        this.e.b(this.a, 0, i1);
        return;
      }
      byte[] arrayOfByte1 = this.a;
      n = m + 1;
      arrayOfByte1[m] = ((byte)(0x80 | paramInt & 0x7F));
      paramInt >>>= 7;
    }
  }
  
  private void b(long paramLong)
  {
    int n;
    for (int m = 0;; m = n)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        byte[] arrayOfByte2 = this.b;
        int i1 = m + 1;
        arrayOfByte2[m] = ((byte)(int)paramLong);
        this.e.b(this.b, 0, i1);
        return;
      }
      byte[] arrayOfByte1 = this.b;
      n = m + 1;
      arrayOfByte1[m] = ((byte)(int)(0x80 | 0x7F & paramLong));
      paramLong >>>= 7;
    }
  }
  
  private int c(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  private long c(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  private boolean c(byte paramByte)
  {
    int m = paramByte & 0xF;
    return (m == 1) || (m == 2);
  }
  
  private byte d(byte paramByte)
  {
    switch ((byte)(paramByte & 0xF))
    {
    default: 
      throw new g("don't know what type: " + (byte)(paramByte & 0xF));
    case 0: 
      return 0;
    case 1: 
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 6;
    case 5: 
      return 8;
    case 6: 
      return 10;
    case 7: 
      return 4;
    case 8: 
      return 11;
    case 9: 
      return 15;
    case 10: 
      return 14;
    case 11: 
      return 13;
    }
    return 12;
  }
  
  private long d(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private void d(int paramInt)
  {
    b((byte)paramInt);
  }
  
  private byte e(byte paramByte)
  {
    return g[paramByte];
  }
  
  private byte[] e(int paramInt)
  {
    if (paramInt == 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramInt];
    this.e.d(arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  private int f(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  private int z()
  {
    int m = 0;
    int n;
    if (this.e.c() >= 5)
    {
      byte[] arrayOfByte = this.e.a();
      int i3 = this.e.b();
      int i4 = 0;
      int i5 = 0;
      for (;;)
      {
        int i6 = arrayOfByte[(i3 + m)];
        i5 |= (i6 & 0x7F) << i4;
        if ((i6 & 0x80) != 128)
        {
          this.e.a(m + 1);
          return i5;
        }
        i4 += 7;
        m++;
      }
      n += 7;
    }
    for (;;)
    {
      int i2 = r();
      i1 |= (i2 & 0x7F) << n;
      if ((i2 & 0x80) == 128) {
        break;
      }
      return i1;
      n = 0;
      int i1 = 0;
    }
  }
  
  public void a()
  {
    this.i = this.h.a();
  }
  
  public void a(byte paramByte)
  {
    b(paramByte);
  }
  
  protected void a(byte paramByte, int paramInt)
  {
    if (paramInt <= 14)
    {
      d(paramInt << 4 | e(paramByte));
      return;
    }
    d(0xF0 | e(paramByte));
    b(paramInt);
  }
  
  public void a(int paramInt)
  {
    b(c(paramInt));
  }
  
  public void a(long paramLong)
  {
    b(c(paramLong));
  }
  
  public void a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      a(arrayOfByte, 0, arrayOfByte.length);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new org.apache.thrift.e("UTF-8 not supported!");
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int m = paramByteBuffer.limit() - paramByteBuffer.position() - paramByteBuffer.arrayOffset();
    a(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), m);
  }
  
  public void a(c paramc)
  {
    if (paramc.b == 2)
    {
      this.j = paramc;
      return;
    }
    a(paramc, (byte)-1);
  }
  
  public void a(d paramd)
  {
    a(paramd.a, paramd.b);
  }
  
  public void a(e parame)
  {
    if (parame.c == 0)
    {
      d(0);
      return;
    }
    b(parame.c);
    d(e(parame.a) << 4 | e(parame.b));
  }
  
  public void a(j paramj)
  {
    a(paramj.a, paramj.b);
  }
  
  public void a(k paramk)
  {
    this.h.a(this.i);
    this.i = 0;
  }
  
  public void a(short paramShort)
  {
    b(c(paramShort));
  }
  
  public void a(boolean paramBoolean)
  {
    byte b1 = 1;
    if (this.j != null)
    {
      c localc = this.j;
      if (paramBoolean) {}
      for (;;)
      {
        a(localc, b1);
        this.j = null;
        return;
        b1 = 2;
      }
    }
    if (paramBoolean) {}
    for (;;)
    {
      b(b1);
      return;
      b1 = 2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    b((byte)0);
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public k g()
  {
    this.h.a(this.i);
    this.i = 0;
    return d;
  }
  
  public void h()
  {
    this.i = this.h.a();
  }
  
  public c i()
  {
    int m = r();
    if (m == 0) {
      return f;
    }
    int n = (short)((m & 0xF0) >> 4);
    short s;
    c localc;
    if (n == 0)
    {
      s = s();
      localc = new c("", d((byte)(m & 0xF)), s);
      if (c(m)) {
        if ((byte)(m & 0xF) != 1) {
          break label103;
        }
      }
    }
    label103:
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      this.k = localBoolean;
      this.i = localc.c;
      return localc;
      s = (short)(n + this.i);
      break;
    }
  }
  
  public void j() {}
  
  public e k()
  {
    int m = z();
    if (m == 0) {}
    for (int n = 0;; n = r()) {
      return new e(d((byte)(n >> 4)), d((byte)(n & 0xF)), m);
    }
  }
  
  public void l() {}
  
  public d m()
  {
    byte b1 = r();
    int m = 0xF & b1 >> 4;
    if (m == 15) {
      m = z();
    }
    return new d(d(b1), m);
  }
  
  public void n() {}
  
  public j o()
  {
    return new j(m());
  }
  
  public void p() {}
  
  public boolean q()
  {
    int m = 1;
    if (this.k != null)
    {
      m = this.k.booleanValue();
      this.k = null;
    }
    while (r() == m) {
      return m;
    }
    return false;
  }
  
  public byte r()
  {
    if (this.e.c() > 0)
    {
      byte b1 = this.e.a()[this.e.b()];
      this.e.a(1);
      return b1;
    }
    this.e.d(this.c, 0, 1);
    return this.c[0];
  }
  
  public short s()
  {
    return (short)f(z());
  }
  
  public int t()
  {
    return f(z());
  }
  
  public long u()
  {
    return d(A());
  }
  
  public double v()
  {
    byte[] arrayOfByte = new byte[8];
    this.e.d(arrayOfByte, 0, 8);
    return Double.longBitsToDouble(a(arrayOfByte));
  }
  
  public String w()
  {
    int m = z();
    if (m == 0) {
      return "";
    }
    try
    {
      if (this.e.c() >= m)
      {
        String str1 = new String(this.e.a(), this.e.b(), m, "UTF-8");
        this.e.a(m);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new org.apache.thrift.e("UTF-8 not supported!");
    }
    String str2 = new String(e(m), "UTF-8");
    return str2;
  }
  
  public ByteBuffer x()
  {
    int m = z();
    if (m == 0) {
      return ByteBuffer.wrap(new byte[0]);
    }
    byte[] arrayOfByte = new byte[m];
    this.e.d(arrayOfByte, 0, m);
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  public void y()
  {
    this.h.b();
    this.i = 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.protocol.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */