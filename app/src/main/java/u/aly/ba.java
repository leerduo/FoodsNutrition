package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ba
  implements Serializable, Cloneable, bz<ba, ba.e>
{
  public static final Map<ba.e, cl> c;
  private static final dd d = new dd("Resolution");
  private static final ct e = new ct("height", (byte)8, (short)1);
  private static final ct f = new ct("width", (byte)8, (short)2);
  private static final Map<Class<? extends dg>, dh> g = new HashMap();
  public int a;
  public int b;
  private byte h = 0;
  
  static
  {
    g.put(di.class, new ba.b(null));
    g.put(dj.class, new ba.d(null));
    EnumMap localEnumMap = new EnumMap(ba.e.class);
    localEnumMap.put(ba.e.a, new cl("height", (byte)1, new cm((byte)8)));
    localEnumMap.put(ba.e.b, new cl("width", (byte)1, new cm((byte)8)));
    c = Collections.unmodifiableMap(localEnumMap);
    cl.a(ba.class, c);
  }
  
  public ba() {}
  
  public ba(int paramInt1, int paramInt2)
  {
    this();
    this.a = paramInt1;
    a(true);
    this.b = paramInt2;
    b(true);
  }
  
  public void a(cy paramcy)
  {
    ((dh)g.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = bw.a(this.h, 0, paramBoolean);
  }
  
  public boolean a()
  {
    return bw.a(this.h, 0);
  }
  
  public void b(cy paramcy)
  {
    ((dh)g.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = bw.a(this.h, 1, paramBoolean);
  }
  
  public boolean b()
  {
    return bw.a(this.h, 1);
  }
  
  public void c() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Resolution(");
    localStringBuilder.append("height:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("width:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ba
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */