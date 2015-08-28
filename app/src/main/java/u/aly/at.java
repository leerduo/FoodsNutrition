package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class at
  implements Serializable, Cloneable, bz<at, at.e>
{
  public static final Map<at.e, cl> d;
  private static final dd e = new dd("Imprint");
  private static final ct f = new ct("property", (byte)13, (short)1);
  private static final ct g = new ct("version", (byte)8, (short)2);
  private static final ct h = new ct("checksum", (byte)11, (short)3);
  private static final Map<Class<? extends dg>, dh> i = new HashMap();
  public Map<String, au> a;
  public int b;
  public String c;
  private byte j = 0;
  
  static
  {
    i.put(di.class, new at.b(null));
    i.put(dj.class, new at.d(null));
    EnumMap localEnumMap = new EnumMap(at.e.class);
    localEnumMap.put(at.e.a, new cl("property", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, au.class))));
    localEnumMap.put(at.e.b, new cl("version", (byte)1, new cm((byte)8)));
    localEnumMap.put(at.e.c, new cl("checksum", (byte)1, new cm((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cl.a(at.class, d);
  }
  
  public Map<String, au> a()
  {
    return this.a;
  }
  
  public at a(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }
  
  public at a(String paramString)
  {
    this.c = paramString;
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
  
  public int b()
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
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean c()
  {
    return bw.a(this.j, 0);
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void e()
  {
    if (this.a == null) {
      throw new cz("Required field 'property' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new cz("Required field 'checksum' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Imprint(");
    localStringBuilder.append("property:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("checksum:");
      if (this.c != null) {
        break label106;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label106:
      localStringBuilder.append(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.at
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */