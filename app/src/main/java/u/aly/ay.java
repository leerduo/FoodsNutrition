package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ay
  implements Serializable, Cloneable, bz<ay, ay.e>
{
  public static final Map<ay.e, cl> c;
  private static final dd d = new dd("Page");
  private static final ct e = new ct("page_name", (byte)11, (short)1);
  private static final ct f = new ct("duration", (byte)10, (short)2);
  private static final Map<Class<? extends dg>, dh> g = new HashMap();
  public String a;
  public long b;
  private byte h = 0;
  
  static
  {
    g.put(di.class, new ay.b(null));
    g.put(dj.class, new ay.d(null));
    EnumMap localEnumMap = new EnumMap(ay.e.class);
    localEnumMap.put(ay.e.a, new cl("page_name", (byte)1, new cm((byte)11)));
    localEnumMap.put(ay.e.b, new cl("duration", (byte)1, new cm((byte)10)));
    c = Collections.unmodifiableMap(localEnumMap);
    cl.a(ay.class, c);
  }
  
  public ay a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }
  
  public ay a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(cy paramcy)
  {
    ((dh)g.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return bw.a(this.h, 0);
  }
  
  public void b()
  {
    if (this.a == null) {
      throw new cz("Required field 'page_name' was not present! Struct: " + toString());
    }
  }
  
  public void b(cy paramcy)
  {
    ((dh)g.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = bw.a(this.h, 0, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Page(");
    localStringBuilder.append("page_name:");
    if (this.a == null) {
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("duration:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ay
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */