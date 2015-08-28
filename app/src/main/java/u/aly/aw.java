package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class aw
  implements Serializable, Cloneable, bz<aw, aw.e>
{
  public static final Map<aw.e, cl> d;
  private static final dd e = new dd("Location");
  private static final ct f = new ct("lat", (byte)4, (short)1);
  private static final ct g = new ct("lng", (byte)4, (short)2);
  private static final ct h = new ct("ts", (byte)10, (short)3);
  private static final Map<Class<? extends dg>, dh> i = new HashMap();
  public double a;
  public double b;
  public long c;
  private byte j = 0;
  
  static
  {
    i.put(di.class, new aw.b(null));
    i.put(dj.class, new aw.d(null));
    EnumMap localEnumMap = new EnumMap(aw.e.class);
    localEnumMap.put(aw.e.a, new cl("lat", (byte)1, new cm((byte)4)));
    localEnumMap.put(aw.e.b, new cl("lng", (byte)1, new cm((byte)4)));
    localEnumMap.put(aw.e.c, new cl("ts", (byte)1, new cm((byte)10)));
    d = Collections.unmodifiableMap(localEnumMap);
    cl.a(aw.class, d);
  }
  
  public aw() {}
  
  public aw(double paramDouble1, double paramDouble2, long paramLong)
  {
    this();
    this.a = paramDouble1;
    a(true);
    this.b = paramDouble2;
    b(true);
    this.c = paramLong;
    c(true);
  }
  
  public void a(cy paramcy)
  {
    ((dh)i.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = bw.a(this.j, 0, paramBoolean);
  }
  
  public boolean a()
  {
    return bw.a(this.j, 0);
  }
  
  public void b(cy paramcy)
  {
    ((dh)i.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = bw.a(this.j, 1, paramBoolean);
  }
  
  public boolean b()
  {
    return bw.a(this.j, 1);
  }
  
  public void c(boolean paramBoolean)
  {
    this.j = bw.a(this.j, 2, paramBoolean);
  }
  
  public boolean c()
  {
    return bw.a(this.j, 2);
  }
  
  public void d() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Location(");
    localStringBuilder.append("lat:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("lng:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("ts:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.aw
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */