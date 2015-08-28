package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class aj
  implements Serializable, Cloneable, bz<aj, aj.e>
{
  public static final Map<aj.e, cl> d;
  private static final dd e = new dd("ClientStats");
  private static final ct f = new ct("successful_requests", (byte)8, (short)1);
  private static final ct g = new ct("failed_requests", (byte)8, (short)2);
  private static final ct h = new ct("last_request_spent_ms", (byte)8, (short)3);
  private static final Map<Class<? extends dg>, dh> i = new HashMap();
  public int a;
  public int b;
  public int c;
  private byte j = 0;
  private aj.e[] k;
  
  static
  {
    i.put(di.class, new aj.b(null));
    i.put(dj.class, new aj.d(null));
    EnumMap localEnumMap = new EnumMap(aj.e.class);
    localEnumMap.put(aj.e.a, new cl("successful_requests", (byte)1, new cm((byte)8)));
    localEnumMap.put(aj.e.b, new cl("failed_requests", (byte)1, new cm((byte)8)));
    localEnumMap.put(aj.e.c, new cl("last_request_spent_ms", (byte)2, new cm((byte)8)));
    d = Collections.unmodifiableMap(localEnumMap);
    cl.a(aj.class, d);
  }
  
  public aj()
  {
    aj.e[] arrayOfe = new aj.e[1];
    arrayOfe[0] = aj.e.c;
    this.k = arrayOfe;
    this.a = 0;
    this.b = 0;
  }
  
  public aj a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
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
  
  public aj b(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
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
  
  public aj c(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
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
    StringBuilder localStringBuilder = new StringBuilder("ClientStats(");
    localStringBuilder.append("successful_requests:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("failed_requests:");
    localStringBuilder.append(this.b);
    if (c())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("last_request_spent_ms:");
      localStringBuilder.append(this.c);
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.aj
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */