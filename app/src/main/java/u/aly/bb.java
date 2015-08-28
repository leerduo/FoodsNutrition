package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class bb
  implements Serializable, Cloneable, bz<bb, bb.e>
{
  public static final Map<bb.e, cl> d;
  private static final dd e = new dd("Response");
  private static final ct f = new ct("resp_code", (byte)8, (short)1);
  private static final ct g = new ct("msg", (byte)11, (short)2);
  private static final ct h = new ct("imprint", (byte)12, (short)3);
  private static final Map<Class<? extends dg>, dh> i = new HashMap();
  public int a;
  public String b;
  public at c;
  private byte j = 0;
  private bb.e[] k;
  
  static
  {
    i.put(di.class, new bb.b(null));
    i.put(dj.class, new bb.d(null));
    EnumMap localEnumMap = new EnumMap(bb.e.class);
    localEnumMap.put(bb.e.a, new cl("resp_code", (byte)1, new cm((byte)8)));
    localEnumMap.put(bb.e.b, new cl("msg", (byte)2, new cm((byte)11)));
    localEnumMap.put(bb.e.c, new cl("imprint", (byte)2, new cq((byte)12, at.class)));
    d = Collections.unmodifiableMap(localEnumMap);
    cl.a(bb.class, d);
  }
  
  public bb()
  {
    bb.e[] arrayOfe = new bb.e[2];
    arrayOfe[0] = bb.e.b;
    arrayOfe[1] = bb.e.c;
    this.k = arrayOfe;
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
  
  public String b()
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
  
  public at d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.c != null;
  }
  
  public void f()
  {
    if (this.c != null) {
      this.c.e();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Response(");
    localStringBuilder.append("resp_code:");
    localStringBuilder.append(this.a);
    if (c())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("msg:");
      if (this.b == null) {
        localStringBuilder.append("null");
      }
    }
    else if (e())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("imprint:");
      if (this.c != null) {
        break label120;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label120:
      localStringBuilder.append(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bb
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */