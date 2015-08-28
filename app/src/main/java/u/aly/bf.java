package u.aly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bf
  implements Serializable, Cloneable, bz<bf, bf.e>
{
  public static final Map<bf.e, cl> j;
  private static final dd k = new dd("UALogEntry");
  private static final ct l = new ct("client_stats", (byte)12, (short)1);
  private static final ct m = new ct("app_info", (byte)12, (short)2);
  private static final ct n = new ct("device_info", (byte)12, (short)3);
  private static final ct o = new ct("misc_info", (byte)12, (short)4);
  private static final ct p = new ct("activate_msg", (byte)12, (short)5);
  private static final ct q = new ct("instant_msgs", (byte)15, (short)6);
  private static final ct r = new ct("sessions", (byte)15, (short)7);
  private static final ct s = new ct("imprint", (byte)12, (short)8);
  private static final ct t = new ct("id_tracking", (byte)12, (short)9);
  private static final Map<Class<? extends dg>, dh> u = new HashMap();
  public aj a;
  public ai b;
  public ak c;
  public ax d;
  public ah e;
  public List<av> f;
  public List<bd> g;
  public at h;
  public as i;
  private bf.e[] v;
  
  static
  {
    u.put(di.class, new bf.b(null));
    u.put(dj.class, new bf.d(null));
    EnumMap localEnumMap = new EnumMap(bf.e.class);
    localEnumMap.put(bf.e.a, new cl("client_stats", (byte)1, new cq((byte)12, aj.class)));
    localEnumMap.put(bf.e.b, new cl("app_info", (byte)1, new cq((byte)12, ai.class)));
    localEnumMap.put(bf.e.c, new cl("device_info", (byte)1, new cq((byte)12, ak.class)));
    localEnumMap.put(bf.e.d, new cl("misc_info", (byte)1, new cq((byte)12, ax.class)));
    localEnumMap.put(bf.e.e, new cl("activate_msg", (byte)2, new cq((byte)12, ah.class)));
    localEnumMap.put(bf.e.f, new cl("instant_msgs", (byte)2, new cn((byte)15, new cq((byte)12, av.class))));
    localEnumMap.put(bf.e.g, new cl("sessions", (byte)2, new cn((byte)15, new cq((byte)12, bd.class))));
    localEnumMap.put(bf.e.h, new cl("imprint", (byte)2, new cq((byte)12, at.class)));
    localEnumMap.put(bf.e.i, new cl("id_tracking", (byte)2, new cq((byte)12, as.class)));
    j = Collections.unmodifiableMap(localEnumMap);
    cl.a(bf.class, j);
  }
  
  public bf()
  {
    bf.e[] arrayOfe = new bf.e[5];
    arrayOfe[0] = bf.e.e;
    arrayOfe[1] = bf.e.f;
    arrayOfe[2] = bf.e.g;
    arrayOfe[3] = bf.e.h;
    arrayOfe[4] = bf.e.i;
    this.v = arrayOfe;
  }
  
  public bf a(ah paramah)
  {
    this.e = paramah;
    return this;
  }
  
  public bf a(ai paramai)
  {
    this.b = paramai;
    return this;
  }
  
  public bf a(aj paramaj)
  {
    this.a = paramaj;
    return this;
  }
  
  public bf a(ak paramak)
  {
    this.c = paramak;
    return this;
  }
  
  public bf a(as paramas)
  {
    this.i = paramas;
    return this;
  }
  
  public bf a(at paramat)
  {
    this.h = paramat;
    return this;
  }
  
  public bf a(ax paramax)
  {
    this.d = paramax;
    return this;
  }
  
  public void a(av paramav)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramav);
  }
  
  public void a(bd parambd)
  {
    if (this.g == null) {
      this.g = new ArrayList();
    }
    this.g.add(parambd);
  }
  
  public void a(cy paramcy)
  {
    ((dh)u.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return this.e != null;
  }
  
  public int b()
  {
    if (this.f == null) {
      return 0;
    }
    return this.f.size();
  }
  
  public void b(cy paramcy)
  {
    ((dh)u.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public List<av> c()
  {
    return this.f;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.d = null;
    }
  }
  
  public boolean d()
  {
    return this.f != null;
  }
  
  public List<bd> e()
  {
    return this.g;
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.e = null;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.f = null;
    }
  }
  
  public boolean f()
  {
    return this.g != null;
  }
  
  public void g(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.g = null;
    }
  }
  
  public boolean g()
  {
    return this.h != null;
  }
  
  public void h(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.h = null;
    }
  }
  
  public boolean h()
  {
    return this.i != null;
  }
  
  public void i()
  {
    if (this.a == null) {
      throw new cz("Required field 'client_stats' was not present! Struct: " + toString());
    }
    if (this.b == null) {
      throw new cz("Required field 'app_info' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new cz("Required field 'device_info' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new cz("Required field 'misc_info' was not present! Struct: " + toString());
    }
    if (this.a != null) {
      this.a.d();
    }
    if (this.b != null) {
      this.b.g();
    }
    if (this.c != null) {
      this.c.r();
    }
    if (this.d != null) {
      this.d.l();
    }
    if (this.e != null) {
      this.e.b();
    }
    if (this.h != null) {
      this.h.e();
    }
    if (this.i != null) {
      this.i.e();
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.i = null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UALogEntry(");
    localStringBuilder.append("client_stats:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("app_info:");
      if (this.b != null) {
        break label342;
      }
      localStringBuilder.append("null");
      label65:
      localStringBuilder.append(", ");
      localStringBuilder.append("device_info:");
      if (this.c != null) {
        break label354;
      }
      localStringBuilder.append("null");
      label96:
      localStringBuilder.append(", ");
      localStringBuilder.append("misc_info:");
      if (this.d != null) {
        break label366;
      }
      localStringBuilder.append("null");
      label127:
      if (a())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("activate_msg:");
        if (this.e != null) {
          break label378;
        }
        localStringBuilder.append("null");
      }
      label165:
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("instant_msgs:");
        if (this.f != null) {
          break label390;
        }
        localStringBuilder.append("null");
      }
      label203:
      if (f())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("sessions:");
        if (this.g != null) {
          break label402;
        }
        localStringBuilder.append("null");
      }
      label241:
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("imprint:");
        if (this.h != null) {
          break label414;
        }
        localStringBuilder.append("null");
      }
      label279:
      if (h())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("id_tracking:");
        if (this.i != null) {
          break label426;
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
      label342:
      localStringBuilder.append(this.b);
      break label65;
      label354:
      localStringBuilder.append(this.c);
      break label96;
      label366:
      localStringBuilder.append(this.d);
      break label127;
      label378:
      localStringBuilder.append(this.e);
      break label165;
      label390:
      localStringBuilder.append(this.f);
      break label203;
      label402:
      localStringBuilder.append(this.g);
      break label241;
      label414:
      localStringBuilder.append(this.h);
      break label279;
      label426:
      localStringBuilder.append(this.i);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bf
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */