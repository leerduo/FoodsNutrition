package u.aly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class av
  implements Serializable, Cloneable, bz<av, av.e>
{
  public static final Map<av.e, cl> e;
  private static final dd f = new dd("InstantMsg");
  private static final ct g = new ct("id", (byte)11, (short)1);
  private static final ct h = new ct("errors", (byte)15, (short)2);
  private static final ct i = new ct("events", (byte)15, (short)3);
  private static final ct j = new ct("game_events", (byte)15, (short)4);
  private static final Map<Class<? extends dg>, dh> k = new HashMap();
  public String a;
  public List<am> b;
  public List<ao> c;
  public List<ao> d;
  private av.e[] l;
  
  static
  {
    k.put(di.class, new av.b(null));
    k.put(dj.class, new av.d(null));
    EnumMap localEnumMap = new EnumMap(av.e.class);
    localEnumMap.put(av.e.a, new cl("id", (byte)1, new cm((byte)11)));
    localEnumMap.put(av.e.b, new cl("errors", (byte)2, new cn((byte)15, new cq((byte)12, am.class))));
    localEnumMap.put(av.e.c, new cl("events", (byte)2, new cn((byte)15, new cq((byte)12, ao.class))));
    localEnumMap.put(av.e.d, new cl("game_events", (byte)2, new cn((byte)15, new cq((byte)12, ao.class))));
    e = Collections.unmodifiableMap(localEnumMap);
    cl.a(av.class, e);
  }
  
  public av()
  {
    av.e[] arrayOfe = new av.e[3];
    arrayOfe[0] = av.e.b;
    arrayOfe[1] = av.e.c;
    arrayOfe[2] = av.e.d;
    this.l = arrayOfe;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public av a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(am paramam)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramam);
  }
  
  public void a(ao paramao)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(paramao);
  }
  
  public void a(cy paramcy)
  {
    ((dh)k.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public void b(ao paramao)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(paramao);
  }
  
  public void b(cy paramcy)
  {
    ((dh)k.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.d = null;
    }
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public void e()
  {
    if (this.a == null) {
      throw new cz("Required field 'id' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("InstantMsg(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (b())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("errors:");
        if (this.b != null) {
          break label160;
        }
        localStringBuilder.append("null");
      }
      label66:
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("events:");
        if (this.c != null) {
          break label172;
        }
        localStringBuilder.append("null");
      }
      label101:
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("game_events:");
        if (this.d != null) {
          break label184;
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
      label160:
      localStringBuilder.append(this.b);
      break label66;
      label172:
      localStringBuilder.append(this.c);
      break label101;
      label184:
      localStringBuilder.append(this.d);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.av
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */