package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ar
  implements Serializable, Cloneable, bz<ar, ar.e>
{
  public static final Map<ar.e, cl> d;
  private static final dd e = new dd("IdSnapshot");
  private static final ct f = new ct("identity", (byte)11, (short)1);
  private static final ct g = new ct("ts", (byte)10, (short)2);
  private static final ct h = new ct("version", (byte)8, (short)3);
  private static final Map<Class<? extends dg>, dh> i = new HashMap();
  public String a;
  public long b;
  public int c;
  private byte j = 0;
  
  static
  {
    i.put(di.class, new ar.b(null));
    i.put(dj.class, new ar.d(null));
    EnumMap localEnumMap = new EnumMap(ar.e.class);
    localEnumMap.put(ar.e.a, new cl("identity", (byte)1, new cm((byte)11)));
    localEnumMap.put(ar.e.b, new cl("ts", (byte)1, new cm((byte)10)));
    localEnumMap.put(ar.e.c, new cl("version", (byte)1, new cm((byte)8)));
    d = Collections.unmodifiableMap(localEnumMap);
    cl.a(ar.class, d);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public ar a(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }
  
  public ar a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }
  
  public ar a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(cy paramcy)
  {
    ((dh)i.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public long b()
  {
    return this.b;
  }
  
  public void b(cy paramcy)
  {
    ((dh)i.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = bw.a(this.j, 0, paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.j = bw.a(this.j, 1, paramBoolean);
  }
  
  public boolean c()
  {
    return bw.a(this.j, 0);
  }
  
  public int d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return bw.a(this.j, 1);
  }
  
  public void f()
  {
    if (this.a == null) {
      throw new cz("Required field 'identity' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdSnapshot(");
    localStringBuilder.append("identity:");
    if (this.a == null) {
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ar
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */