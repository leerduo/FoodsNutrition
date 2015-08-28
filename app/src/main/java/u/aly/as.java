package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class as
  implements Serializable, Cloneable, bz<as, as.e>
{
  public static final Map<as.e, cl> d;
  private static final dd e = new dd("IdTracking");
  private static final ct f = new ct("snapshots", (byte)13, (short)1);
  private static final ct g = new ct("journals", (byte)15, (short)2);
  private static final ct h = new ct("checksum", (byte)11, (short)3);
  private static final Map<Class<? extends dg>, dh> i = new HashMap();
  public Map<String, ar> a;
  public List<aq> b;
  public String c;
  private as.e[] j;
  
  static
  {
    i.put(di.class, new as.b(null));
    i.put(dj.class, new as.d(null));
    EnumMap localEnumMap = new EnumMap(as.e.class);
    localEnumMap.put(as.e.a, new cl("snapshots", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, ar.class))));
    localEnumMap.put(as.e.b, new cl("journals", (byte)2, new cn((byte)15, new cq((byte)12, aq.class))));
    localEnumMap.put(as.e.c, new cl("checksum", (byte)2, new cm((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cl.a(as.class, d);
  }
  
  public as()
  {
    as.e[] arrayOfe = new as.e[2];
    arrayOfe[0] = as.e.b;
    arrayOfe[1] = as.e.c;
    this.j = arrayOfe;
  }
  
  public Map<String, ar> a()
  {
    return this.a;
  }
  
  public as a(List<aq> paramList)
  {
    this.b = paramList;
    return this;
  }
  
  public as a(Map<String, ar> paramMap)
  {
    this.a = paramMap;
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
  
  public List<aq> b()
  {
    return this.b;
  }
  
  public void b(cy paramcy)
  {
    ((dh)i.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean c()
  {
    return this.b != null;
  }
  
  public boolean d()
  {
    return this.c != null;
  }
  
  public void e()
  {
    if (this.a == null) {
      throw new cz("Required field 'snapshots' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdTracking(");
    localStringBuilder.append("snapshots:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("journals:");
        if (this.b != null) {
          break label125;
        }
        localStringBuilder.append("null");
      }
      label66:
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("checksum:");
        if (this.c != null) {
          break label137;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label125:
      localStringBuilder.append(this.b);
      break label66;
      label137:
      localStringBuilder.append(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.as
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */