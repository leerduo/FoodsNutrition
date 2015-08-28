package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class au
  implements Serializable, Cloneable, bz<au, au.e>
{
  public static final Map<au.e, cl> d;
  private static final dd e = new dd("ImprintValue");
  private static final ct f = new ct("value", (byte)11, (short)1);
  private static final ct g = new ct("ts", (byte)10, (short)2);
  private static final ct h = new ct("guid", (byte)11, (short)3);
  private static final Map<Class<? extends dg>, dh> i = new HashMap();
  public String a;
  public long b;
  public String c;
  private byte j = 0;
  private au.e[] k;
  
  static
  {
    i.put(di.class, new au.b(null));
    i.put(dj.class, new au.d(null));
    EnumMap localEnumMap = new EnumMap(au.e.class);
    localEnumMap.put(au.e.a, new cl("value", (byte)2, new cm((byte)11)));
    localEnumMap.put(au.e.b, new cl("ts", (byte)1, new cm((byte)10)));
    localEnumMap.put(au.e.c, new cl("guid", (byte)1, new cm((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cl.a(au.class, d);
  }
  
  public au()
  {
    au.e[] arrayOfe = new au.e[1];
    arrayOfe[0] = au.e.a;
    this.k = arrayOfe;
  }
  
  public String a()
  {
    return this.a;
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
  
  public void b(cy paramcy)
  {
    ((dh)i.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = bw.a(this.j, 0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.a != null;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean d()
  {
    return bw.a(this.j, 0);
  }
  
  public String e()
  {
    return this.c;
  }
  
  public void f()
  {
    if (this.c == null) {
      throw new cz("Required field 'guid' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ImprintValue(");
    int m = 1;
    if (b())
    {
      localStringBuilder.append("value:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        m = 0;
      }
    }
    else
    {
      if (m == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("guid:");
      if (this.c != null) {
        break label121;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label121:
      localStringBuilder.append(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.au
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */