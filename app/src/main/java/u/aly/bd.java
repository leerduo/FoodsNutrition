package u.aly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bd
  implements Serializable, Cloneable, bz<bd, bd.e>
{
  public static final Map<bd.e, cl> h;
  private static final dd i = new dd("Session");
  private static final ct j = new ct("id", (byte)11, (short)1);
  private static final ct k = new ct("start_time", (byte)10, (short)2);
  private static final ct l = new ct("end_time", (byte)10, (short)3);
  private static final ct m = new ct("duration", (byte)10, (short)4);
  private static final ct n = new ct("pages", (byte)15, (short)5);
  private static final ct o = new ct("locations", (byte)15, (short)6);
  private static final ct p = new ct("traffic", (byte)12, (short)7);
  private static final Map<Class<? extends dg>, dh> q = new HashMap();
  public String a;
  public long b;
  public long c;
  public long d;
  public List<ay> e;
  public List<aw> f;
  public be g;
  private byte r = 0;
  private bd.e[] s;
  
  static
  {
    q.put(di.class, new bd.b(null));
    q.put(dj.class, new bd.d(null));
    EnumMap localEnumMap = new EnumMap(bd.e.class);
    localEnumMap.put(bd.e.a, new cl("id", (byte)1, new cm((byte)11)));
    localEnumMap.put(bd.e.b, new cl("start_time", (byte)1, new cm((byte)10)));
    localEnumMap.put(bd.e.c, new cl("end_time", (byte)1, new cm((byte)10)));
    localEnumMap.put(bd.e.d, new cl("duration", (byte)1, new cm((byte)10)));
    localEnumMap.put(bd.e.e, new cl("pages", (byte)2, new cn((byte)15, new cq((byte)12, ay.class))));
    localEnumMap.put(bd.e.f, new cl("locations", (byte)2, new cn((byte)15, new cq((byte)12, aw.class))));
    localEnumMap.put(bd.e.g, new cl("traffic", (byte)2, new cq((byte)12, be.class)));
    h = Collections.unmodifiableMap(localEnumMap);
    cl.a(bd.class, h);
  }
  
  public bd()
  {
    bd.e[] arrayOfe = new bd.e[3];
    arrayOfe[0] = bd.e.e;
    arrayOfe[1] = bd.e.f;
    arrayOfe[2] = bd.e.g;
    this.s = arrayOfe;
  }
  
  public bd a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }
  
  public bd a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public bd a(List<ay> paramList)
  {
    this.e = paramList;
    return this;
  }
  
  public bd a(be parambe)
  {
    this.g = parambe;
    return this;
  }
  
  public void a(aw paramaw)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramaw);
  }
  
  public void a(cy paramcy)
  {
    ((dh)q.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return bw.a(this.r, 0);
  }
  
  public bd b(long paramLong)
  {
    this.c = paramLong;
    c(true);
    return this;
  }
  
  public bd b(List<aw> paramList)
  {
    this.f = paramList;
    return this;
  }
  
  public void b(cy paramcy)
  {
    ((dh)q.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.r = bw.a(this.r, 0, paramBoolean);
  }
  
  public boolean b()
  {
    return bw.a(this.r, 1);
  }
  
  public bd c(long paramLong)
  {
    this.d = paramLong;
    d(true);
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.r = bw.a(this.r, 1, paramBoolean);
  }
  
  public boolean c()
  {
    return bw.a(this.r, 2);
  }
  
  public int d()
  {
    if (this.e == null) {
      return 0;
    }
    return this.e.size();
  }
  
  public void d(boolean paramBoolean)
  {
    this.r = bw.a(this.r, 2, paramBoolean);
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.e = null;
    }
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public void f(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.f = null;
    }
  }
  
  public boolean f()
  {
    return this.f != null;
  }
  
  public void g(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.g = null;
    }
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public void h()
  {
    if (this.a == null) {
      throw new cz("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.g != null) {
      this.g.c();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Session(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("start_time:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("end_time:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", ");
      localStringBuilder.append("duration:");
      localStringBuilder.append(this.d);
      if (e())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("pages:");
        if (this.e != null) {
          break label248;
        }
        localStringBuilder.append("null");
      }
      label147:
      if (f())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("locations:");
        if (this.f != null) {
          break label260;
        }
        localStringBuilder.append("null");
      }
      label185:
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("traffic:");
        if (this.g != null) {
          break label272;
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
      label248:
      localStringBuilder.append(this.e);
      break label147;
      label260:
      localStringBuilder.append(this.f);
      break label185;
      label272:
      localStringBuilder.append(this.g);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bd
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */