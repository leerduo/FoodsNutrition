package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ah
  implements Serializable, Cloneable, bz<ah, ah.e>
{
  public static final Map<ah.e, cl> b;
  private static final dd c = new dd("ActivateMsg");
  private static final ct d = new ct("ts", (byte)10, (short)1);
  private static final Map<Class<? extends dg>, dh> e = new HashMap();
  public long a;
  private byte f = 0;
  
  static
  {
    e.put(di.class, new ah.b(null));
    e.put(dj.class, new ah.d(null));
    EnumMap localEnumMap = new EnumMap(ah.e.class);
    localEnumMap.put(ah.e.a, new cl("ts", (byte)1, new cm((byte)10)));
    b = Collections.unmodifiableMap(localEnumMap);
    cl.a(ah.class, b);
  }
  
  public ah() {}
  
  public ah(long paramLong)
  {
    this();
    this.a = paramLong;
    a(true);
  }
  
  public void a(cy paramcy)
  {
    ((dh)e.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = bw.a(this.f, 0, paramBoolean);
  }
  
  public boolean a()
  {
    return bw.a(this.f, 0);
  }
  
  public void b() {}
  
  public void b(cy paramcy)
  {
    ((dh)e.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ActivateMsg(");
    localStringBuilder.append("ts:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ah
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */