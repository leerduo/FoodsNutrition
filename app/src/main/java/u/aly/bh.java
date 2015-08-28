package u.aly;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class bh
  implements Serializable, Cloneable, bz<bh, bh.e>
{
  public static final Map<bh.e, cl> j;
  private static final dd k = new dd("UMEnvelope");
  private static final ct l = new ct("version", (byte)11, (short)1);
  private static final ct m = new ct("address", (byte)11, (short)2);
  private static final ct n = new ct("signature", (byte)11, (short)3);
  private static final ct o = new ct("serial_num", (byte)8, (short)4);
  private static final ct p = new ct("ts_secs", (byte)8, (short)5);
  private static final ct q = new ct("length", (byte)8, (short)6);
  private static final ct r = new ct("entity", (byte)11, (short)7);
  private static final ct s = new ct("guid", (byte)11, (short)8);
  private static final ct t = new ct("checksum", (byte)11, (short)9);
  private static final Map<Class<? extends dg>, dh> u = new HashMap();
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public ByteBuffer g;
  public String h;
  public String i;
  private byte v = 0;
  
  static
  {
    u.put(di.class, new bh.b(null));
    u.put(dj.class, new bh.d(null));
    EnumMap localEnumMap = new EnumMap(bh.e.class);
    localEnumMap.put(bh.e.a, new cl("version", (byte)1, new cm((byte)11)));
    localEnumMap.put(bh.e.b, new cl("address", (byte)1, new cm((byte)11)));
    localEnumMap.put(bh.e.c, new cl("signature", (byte)1, new cm((byte)11)));
    localEnumMap.put(bh.e.d, new cl("serial_num", (byte)1, new cm((byte)8)));
    localEnumMap.put(bh.e.e, new cl("ts_secs", (byte)1, new cm((byte)8)));
    localEnumMap.put(bh.e.f, new cl("length", (byte)1, new cm((byte)8)));
    localEnumMap.put(bh.e.g, new cl("entity", (byte)1, new cm((byte)11, true)));
    localEnumMap.put(bh.e.h, new cl("guid", (byte)1, new cm((byte)11)));
    localEnumMap.put(bh.e.i, new cl("checksum", (byte)1, new cm((byte)11)));
    j = Collections.unmodifiableMap(localEnumMap);
    cl.a(bh.class, j);
  }
  
  public bh a(int paramInt)
  {
    this.d = paramInt;
    d(true);
    return this;
  }
  
  public bh a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public bh a(ByteBuffer paramByteBuffer)
  {
    this.g = paramByteBuffer;
    return this;
  }
  
  public bh a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (ByteBuffer localByteBuffer = (ByteBuffer)null;; localByteBuffer = ByteBuffer.wrap(paramArrayOfByte))
    {
      a(localByteBuffer);
      return this;
    }
  }
  
  public void a(cy paramcy)
  {
    ((dh)u.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return bw.a(this.v, 0);
  }
  
  public bh b(int paramInt)
  {
    this.e = paramInt;
    e(true);
    return this;
  }
  
  public bh b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b(cy paramcy)
  {
    ((dh)u.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public boolean b()
  {
    return bw.a(this.v, 1);
  }
  
  public bh c(int paramInt)
  {
    this.f = paramInt;
    f(true);
    return this;
  }
  
  public bh c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean c()
  {
    return bw.a(this.v, 2);
  }
  
  public bh d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void d()
  {
    if (this.a == null) {
      throw new cz("Required field 'version' was not present! Struct: " + toString());
    }
    if (this.b == null) {
      throw new cz("Required field 'address' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new cz("Required field 'signature' was not present! Struct: " + toString());
    }
    if (this.g == null) {
      throw new cz("Required field 'entity' was not present! Struct: " + toString());
    }
    if (this.h == null) {
      throw new cz("Required field 'guid' was not present! Struct: " + toString());
    }
    if (this.i == null) {
      throw new cz("Required field 'checksum' was not present! Struct: " + toString());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.v = bw.a(this.v, 0, paramBoolean);
  }
  
  public bh e(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public void e(boolean paramBoolean)
  {
    this.v = bw.a(this.v, 1, paramBoolean);
  }
  
  public void f(boolean paramBoolean)
  {
    this.v = bw.a(this.v, 2, paramBoolean);
  }
  
  public void g(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.g = null;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.h = null;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.i = null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UMEnvelope(");
    localStringBuilder.append("version:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("address:");
      if (this.b != null) {
        break label289;
      }
      localStringBuilder.append("null");
      label65:
      localStringBuilder.append(", ");
      localStringBuilder.append("signature:");
      if (this.c != null) {
        break label301;
      }
      localStringBuilder.append("null");
      label96:
      localStringBuilder.append(", ");
      localStringBuilder.append("serial_num:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", ");
      localStringBuilder.append("ts_secs:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", ");
      localStringBuilder.append("length:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
      localStringBuilder.append("entity:");
      if (this.g != null) {
        break label313;
      }
      localStringBuilder.append("null");
      label202:
      localStringBuilder.append(", ");
      localStringBuilder.append("guid:");
      if (this.h != null) {
        break label324;
      }
      localStringBuilder.append("null");
      label233:
      localStringBuilder.append(", ");
      localStringBuilder.append("checksum:");
      if (this.i != null) {
        break label336;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label289:
      localStringBuilder.append(this.b);
      break label65;
      label301:
      localStringBuilder.append(this.c);
      break label96;
      label313:
      ca.a(this.g, localStringBuilder);
      break label202;
      label324:
      localStringBuilder.append(this.h);
      break label233;
      label336:
      localStringBuilder.append(this.i);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bh
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */