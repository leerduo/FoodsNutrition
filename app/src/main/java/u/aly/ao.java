package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ao
  implements Serializable, Cloneable, bz<ao, ao.e>
{
  public static final Map<ao.e, cl> f;
  private static final dd g = new dd("Event");
  private static final ct h = new ct("name", (byte)11, (short)1);
  private static final ct i = new ct("properties", (byte)13, (short)2);
  private static final ct j = new ct("duration", (byte)10, (short)3);
  private static final ct k = new ct("acc", (byte)8, (short)4);
  private static final ct l = new ct("ts", (byte)10, (short)5);
  private static final Map<Class<? extends dg>, dh> m = new HashMap();
  public String a;
  public Map<String, az> b;
  public long c;
  public int d;
  public long e;
  private byte n = 0;
  private ao.e[] o;
  
  static
  {
    m.put(di.class, new ao.b(null));
    m.put(dj.class, new ao.d(null));
    EnumMap localEnumMap = new EnumMap(ao.e.class);
    localEnumMap.put(ao.e.a, new cl("name", (byte)1, new cm((byte)11)));
    localEnumMap.put(ao.e.b, new cl("properties", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, az.class))));
    localEnumMap.put(ao.e.c, new cl("duration", (byte)2, new cm((byte)10)));
    localEnumMap.put(ao.e.d, new cl("acc", (byte)2, new cm((byte)8)));
    localEnumMap.put(ao.e.e, new cl("ts", (byte)1, new cm((byte)10)));
    f = Collections.unmodifiableMap(localEnumMap);
    cl.a(ao.class, f);
  }
  
  public ao()
  {
    ao.e[] arrayOfe = new ao.e[2];
    arrayOfe[0] = ao.e.c;
    arrayOfe[1] = ao.e.d;
    this.o = arrayOfe;
  }
  
  public ao a(int paramInt)
  {
    this.d = paramInt;
    d(true);
    return this;
  }
  
  public ao a(long paramLong)
  {
    this.c = paramLong;
    c(true);
    return this;
  }
  
  public ao a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ao a(Map<String, az> paramMap)
  {
    this.b = paramMap;
    return this;
  }
  
  public void a(cy paramcy)
  {
    ((dh)m.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return bw.a(this.n, 0);
  }
  
  public ao b(long paramLong)
  {
    this.e = paramLong;
    e(true);
    return this;
  }
  
  public void b(cy paramcy)
  {
    ((dh)m.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public boolean b()
  {
    return bw.a(this.n, 1);
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = bw.a(this.n, 0, paramBoolean);
  }
  
  public boolean c()
  {
    return bw.a(this.n, 2);
  }
  
  public void d()
  {
    if (this.a == null) {
      throw new cz("Required field 'name' was not present! Struct: " + toString());
    }
    if (this.b == null) {
      throw new cz("Required field 'properties' was not present! Struct: " + toString());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.n = bw.a(this.n, 1, paramBoolean);
  }
  
  public void e(boolean paramBoolean)
  {
    this.n = bw.a(this.n, 2, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Event(");
    localStringBuilder.append("name:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("properties:");
      if (this.b != null) {
        break label167;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      if (a())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("duration:");
        localStringBuilder.append(this.c);
      }
      if (b())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("acc:");
        localStringBuilder.append(this.d);
      }
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label167:
      localStringBuilder.append(this.b);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ao
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */