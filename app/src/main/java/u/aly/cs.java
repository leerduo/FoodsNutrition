package u.aly;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class cs
  extends cy
{
  private static final dd d = new dd("");
  private static final ct f = new ct("", (byte)0, (short)0);
  private static final byte[] g = new byte[16];
  byte[] a = new byte[5];
  byte[] b = new byte[10];
  byte[] c = new byte[1];
  private bx h = new bx(15);
  private short i = 0;
  private ct j = null;
  private Boolean k = null;
  private final long l;
  private byte[] m = new byte[1];
  
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
  
  public cs(dm paramdm, long paramLong)
  {
    super(paramdm);
    this.l = paramLong;
  }
  
  private long A()
  {
    long l1 = 0L;
    int n = this.e.d();
    int i1 = 0;
    if (n >= 10)
    {
      byte[] arrayOfByte = this.e.b();
      int i3 = this.e.c();
      int i4 = 0;
      for (;;)
      {
        int i5 = arrayOfByte[(i3 + i1)];
        l1 |= (i5 & 0x7F) << i4;
        if ((i5 & 0x80) != 128)
        {
          this.e.a(i1 + 1);
          return l1;
        }
        i4 += 7;
        i1++;
      }
    }
    int i2;
    do
    {
      i1 += 7;
      i2 = q();
      l1 |= (i2 & 0x7F) << i1;
    } while ((i2 & 0x80) == 128);
    return l1;
  }
  
  private long a(byte[] paramArrayOfByte)
  {
    return (0xFF & paramArrayOfByte[7]) << 56 | (0xFF & paramArrayOfByte[6]) << 48 | (0xFF & paramArrayOfByte[5]) << 40 | (0xFF & paramArrayOfByte[4]) << 32 | (0xFF & paramArrayOfByte[3]) << 24 | (0xFF & paramArrayOfByte[2]) << 16 | (0xFF & paramArrayOfByte[1]) << 8 | 0xFF & paramArrayOfByte[0];
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(0xFF & paramLong >> 8));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(0xFF & paramLong >> 16));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(0xFF & paramLong >> 24));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(0xFF & paramLong >> 32));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(0xFF & paramLong >> 40));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(0xFF & paramLong >> 48));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(0xFF & paramLong >> 56));
  }
  
  private void a(ct paramct, byte paramByte)
  {
    if (paramByte == -1) {
      paramByte = e(paramct.b);
    }
    if ((paramct.c > this.i) && (paramct.c - this.i <= 15)) {
      d(paramByte | paramct.c - this.i << 4);
    }
    for (;;)
    {
      this.i = paramct.c;
      return;
      b(paramByte);
      a(paramct.c);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    this.e.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void b(byte paramByte)
  {
    this.m[0] = paramByte;
    this.e.b(this.m);
  }
  
  private void b(int paramInt)
  {
    int i1;
    for (int n = 0;; n = i1)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        byte[] arrayOfByte2 = this.a;
        int i2 = n + 1;
        arrayOfByte2[n] = ((byte)paramInt);
        this.e.b(this.a, 0, i2);
        return;
      }
      byte[] arrayOfByte1 = this.a;
      i1 = n + 1;
      arrayOfByte1[n] = ((byte)(0x80 | paramInt & 0x7F));
      paramInt >>>= 7;
    }
  }
  
  private void b(long paramLong)
  {
    int i1;
    for (int n = 0;; n = i1)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        byte[] arrayOfByte2 = this.b;
        int i2 = n + 1;
        arrayOfByte2[n] = ((byte)(int)paramLong);
        this.e.b(this.b, 0, i2);
        return;
      }
      byte[] arrayOfByte1 = this.b;
      i1 = n + 1;
      arrayOfByte1[n] = ((byte)(int)(0x80 | 0x7F & paramLong));
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
    int n = paramByte & 0xF;
    return (n == 1) || (n == 2);
  }
  
  private byte d(byte paramByte)
  {
    switch ((byte)(paramByte & 0xF))
    {
    default: 
      throw new cz("don't know what type: " + (byte)(paramByte & 0xF));
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
  
  private void f(int paramInt)
  {
    if (paramInt < 0) {
      throw new cz("Negative length: " + paramInt);
    }
    if ((this.l != -1L) && (paramInt > this.l)) {
      throw new cz("Length exceeded max allowed: " + paramInt);
    }
  }
  
  private int g(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  private int z()
  {
    int n = 0;
    int i1;
    if (this.e.d() >= 5)
    {
      byte[] arrayOfByte = this.e.b();
      int i4 = this.e.c();
      int i5 = 0;
      int i6 = 0;
      for (;;)
      {
        int i7 = arrayOfByte[(i4 + n)];
        i6 |= (i7 & 0x7F) << i5;
        if ((i7 & 0x80) != 128)
        {
          this.e.a(n + 1);
          return i6;
        }
        i5 += 7;
        n++;
      }
      i1 += 7;
    }
    for (;;)
    {
      int i3 = q();
      i2 |= (i3 & 0x7F) << i1;
      if ((i3 & 0x80) == 128) {
        break;
      }
      return i2;
      i1 = 0;
      int i2 = 0;
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
  
  public void a(double paramDouble)
  {
    byte[] arrayOfByte = { 0, 0, 0, 0, 0, 0, 0, 0 };
    a(Double.doubleToLongBits(paramDouble), arrayOfByte, 0);
    this.e.b(arrayOfByte);
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
      throw new cf("UTF-8 not supported!");
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int n = paramByteBuffer.limit() - paramByteBuffer.position();
    a(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), n);
  }
  
  public void a(ct paramct)
  {
    if (paramct.b == 2)
    {
      this.j = paramct;
      return;
    }
    a(paramct, (byte)-1);
  }
  
  public void a(cu paramcu)
  {
    a(paramcu.a, paramcu.b);
  }
  
  public void a(cv paramcv)
  {
    if (paramcv.c == 0)
    {
      d(0);
      return;
    }
    b(paramcv.c);
    d(e(paramcv.a) << 4 | e(paramcv.b));
  }
  
  public void a(dd paramdd)
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
      ct localct = this.j;
      if (paramBoolean) {}
      for (;;)
      {
        a(localct, b1);
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
  
  public dd f()
  {
    this.h.a(this.i);
    this.i = 0;
    return d;
  }
  
  public void g()
  {
    this.i = this.h.a();
  }
  
  public ct h()
  {
    int n = q();
    if (n == 0) {
      return f;
    }
    int i1 = (short)((n & 0xF0) >> 4);
    short s;
    ct localct;
    if (i1 == 0)
    {
      s = r();
      localct = new ct("", d((byte)(n & 0xF)), s);
      if (c(n)) {
        if ((byte)(n & 0xF) != 1) {
          break label103;
        }
      }
    }
    label103:
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      this.k = localBoolean;
      this.i = localct.c;
      return localct;
      s = (short)(i1 + this.i);
      break;
    }
  }
  
  public void i() {}
  
  public cv j()
  {
    int n = z();
    if (n == 0) {}
    for (int i1 = 0;; i1 = q()) {
      return new cv(d((byte)(i1 >> 4)), d((byte)(i1 & 0xF)), n);
    }
  }
  
  public void k() {}
  
  public cu l()
  {
    byte b1 = q();
    int n = 0xF & b1 >> 4;
    if (n == 15) {
      n = z();
    }
    return new cu(d(b1), n);
  }
  
  public void m() {}
  
  public dc n()
  {
    return new dc(l());
  }
  
  public void o() {}
  
  public boolean p()
  {
    int n = 1;
    if (this.k != null)
    {
      n = this.k.booleanValue();
      this.k = null;
    }
    while (q() == n) {
      return n;
    }
    return false;
  }
  
  public byte q()
  {
    if (this.e.d() > 0)
    {
      byte b1 = this.e.b()[this.e.c()];
      this.e.a(1);
      return b1;
    }
    this.e.d(this.c, 0, 1);
    return this.c[0];
  }
  
  public short r()
  {
    return (short)g(z());
  }
  
  public int s()
  {
    return g(z());
  }
  
  public long t()
  {
    return d(A());
  }
  
  public double u()
  {
    byte[] arrayOfByte = new byte[8];
    this.e.d(arrayOfByte, 0, 8);
    return Double.longBitsToDouble(a(arrayOfByte));
  }
  
  public String v()
  {
    int n = z();
    f(n);
    if (n == 0) {
      return "";
    }
    try
    {
      if (this.e.d() >= n)
      {
        String str1 = new String(this.e.b(), this.e.c(), n, "UTF-8");
        this.e.a(n);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new cf("UTF-8 not supported!");
    }
    String str2 = new String(e(n), "UTF-8");
    return str2;
  }
  
  public ByteBuffer w()
  {
    int n = z();
    f(n);
    if (n == 0) {
      return ByteBuffer.wrap(new byte[0]);
    }
    byte[] arrayOfByte = new byte[n];
    this.e.d(arrayOfByte, 0, n);
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  public void x()
  {
    this.h.b();
    this.i = 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.cs
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */