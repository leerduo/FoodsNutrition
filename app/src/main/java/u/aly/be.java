package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class be
  implements Serializable, Cloneable, bz<be, be.e>
{
  public static final Map<be.e, cl> c;
  private static final dd d = new dd("Traffic");
  private static final ct e = new ct("upload_traffic", (byte)8, (short)1);
  private static final ct f = new ct("download_traffic", (byte)8, (short)2);
  private static final Map<Class<? extends dg>, dh> g = new HashMap();
  public int a;
  public int b;
  private byte h = 0;
  
  static
  {
    g.put(di.class, new be.b(null));
    g.put(dj.class, new be.d(null));
    EnumMap localEnumMap = new EnumMap(be.e.class);
    localEnumMap.put(be.e.a, new cl("upload_traffic", (byte)1, new cm((byte)8)));
    localEnumMap.put(be.e.b, new cl("download_traffic", (byte)1, new cm((byte)8)));
    c = Collections.unmodifiableMap(localEnumMap);
    cl.a(be.class, c);
  }
  
  public be a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
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
  
  public be b(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
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
    StringBuilder localStringBuilder = new StringBuilder("Traffic(");
    localStringBuilder.append("upload_traffic:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("download_traffic:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.be
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */