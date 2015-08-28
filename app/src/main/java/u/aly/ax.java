package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ax
  implements Serializable, Cloneable, bz<ax, ax.e>
{
  public static final Map<ax.e, cl> l;
  private static final dd m = new dd("MiscInfo");
  private static final ct n = new ct("time_zone", (byte)8, (short)1);
  private static final ct o = new ct("language", (byte)11, (short)2);
  private static final ct p = new ct("country", (byte)11, (short)3);
  private static final ct q = new ct("latitude", (byte)4, (short)4);
  private static final ct r = new ct("longitude", (byte)4, (short)5);
  private static final ct s = new ct("carrier", (byte)11, (short)6);
  private static final ct t = new ct("latency", (byte)8, (short)7);
  private static final ct u = new ct("display_name", (byte)11, (short)8);
  private static final ct v = new ct("access_type", (byte)8, (short)9);
  private static final ct w = new ct("access_subtype", (byte)11, (short)10);
  private static final ct x = new ct("user_info", (byte)12, (short)11);
  private static final Map<Class<? extends dg>, dh> y = new HashMap();
  private ax.e[] A;
  public int a;
  public String b;
  public String c;
  public double d;
  public double e;
  public String f;
  public int g;
  public String h;
  public ag i;
  public String j;
  public bg k;
  private byte z = 0;
  
  static
  {
    y.put(di.class, new ax.b(null));
    y.put(dj.class, new ax.d(null));
    EnumMap localEnumMap = new EnumMap(ax.e.class);
    localEnumMap.put(ax.e.a, new cl("time_zone", (byte)2, new cm((byte)8)));
    localEnumMap.put(ax.e.b, new cl("language", (byte)2, new cm((byte)11)));
    localEnumMap.put(ax.e.c, new cl("country", (byte)2, new cm((byte)11)));
    localEnumMap.put(ax.e.d, new cl("latitude", (byte)2, new cm((byte)4)));
    localEnumMap.put(ax.e.e, new cl("longitude", (byte)2, new cm((byte)4)));
    localEnumMap.put(ax.e.f, new cl("carrier", (byte)2, new cm((byte)11)));
    localEnumMap.put(ax.e.g, new cl("latency", (byte)2, new cm((byte)8)));
    localEnumMap.put(ax.e.h, new cl("display_name", (byte)2, new cm((byte)11)));
    localEnumMap.put(ax.e.i, new cl("access_type", (byte)2, new ck((byte)16, ag.class)));
    localEnumMap.put(ax.e.j, new cl("access_subtype", (byte)2, new cm((byte)11)));
    localEnumMap.put(ax.e.k, new cl("user_info", (byte)2, new cq((byte)12, bg.class)));
    l = Collections.unmodifiableMap(localEnumMap);
    cl.a(ax.class, l);
  }
  
  public ax()
  {
    ax.e[] arrayOfe = new ax.e[11];
    arrayOfe[0] = ax.e.a;
    arrayOfe[1] = ax.e.b;
    arrayOfe[2] = ax.e.c;
    arrayOfe[3] = ax.e.d;
    arrayOfe[4] = ax.e.e;
    arrayOfe[5] = ax.e.f;
    arrayOfe[6] = ax.e.g;
    arrayOfe[7] = ax.e.h;
    arrayOfe[8] = ax.e.i;
    arrayOfe[9] = ax.e.j;
    arrayOfe[10] = ax.e.k;
    this.A = arrayOfe;
  }
  
  public ax a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
  }
  
  public ax a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public ax a(ag paramag)
  {
    this.i = paramag;
    return this;
  }
  
  public ax a(bg parambg)
  {
    this.k = parambg;
    return this;
  }
  
  public void a(cy paramcy)
  {
    ((dh)y.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = bw.a(this.z, 0, paramBoolean);
  }
  
  public boolean a()
  {
    return bw.a(this.z, 0);
  }
  
  public ax b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void b(cy paramcy)
  {
    ((dh)y.get(paramcy.y())).b().a(paramcy, this);
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
  
  public ax c(String paramString)
  {
    this.f = paramString;
    return this;
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
  
  public ax d(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public void d(boolean paramBoolean)
  {
    this.z = bw.a(this.z, 1, paramBoolean);
  }
  
  public boolean d()
  {
    return bw.a(this.z, 1);
  }
  
  public void e(boolean paramBoolean)
  {
    this.z = bw.a(this.z, 2, paramBoolean);
  }
  
  public boolean e()
  {
    return bw.a(this.z, 2);
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
    this.z = bw.a(this.z, 3, paramBoolean);
  }
  
  public boolean g()
  {
    return bw.a(this.z, 3);
  }
  
  public void h(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.h = null;
    }
  }
  
  public boolean h()
  {
    return this.h != null;
  }
  
  public void i(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.i = null;
    }
  }
  
  public boolean i()
  {
    return this.i != null;
  }
  
  public void j(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.j = null;
    }
  }
  
  public boolean j()
  {
    return this.j != null;
  }
  
  public void k(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.k = null;
    }
  }
  
  public boolean k()
  {
    return this.k != null;
  }
  
  public void l()
  {
    if (this.k != null) {
      this.k.e();
    }
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("MiscInfo(");
    int i2 = 1;
    if (a())
    {
      localStringBuilder.append("time_zone:");
      localStringBuilder.append(this.a);
      i2 = 0;
    }
    if (b())
    {
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("language:");
      if (this.b == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      if (c())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("country:");
        if (this.c != null) {
          break label484;
        }
        localStringBuilder.append("null");
        label127:
        i2 = 0;
      }
      if (d())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("latitude:");
        localStringBuilder.append(this.d);
        i2 = 0;
      }
      if (e())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("longitude:");
        localStringBuilder.append(this.e);
        i2 = 0;
      }
      if (f())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("carrier:");
        if (this.f != null) {
          break label496;
        }
        localStringBuilder.append("null");
        label247:
        i2 = 0;
      }
      if (g())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("latency:");
        localStringBuilder.append(this.g);
        i2 = 0;
      }
      if (h())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("display_name:");
        if (this.h != null) {
          break label508;
        }
        localStringBuilder.append("null");
        label329:
        i2 = 0;
      }
      if (i())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("access_type:");
        if (this.i != null) {
          break label520;
        }
        localStringBuilder.append("null");
        label373:
        i2 = 0;
      }
      if (!j()) {
        break label558;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("access_subtype:");
      if (this.j != null) {
        break label532;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      label417:
      if (k())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("user_info:");
        if (this.k != null) {
          break label546;
        }
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.b);
        break;
        label484:
        localStringBuilder.append(this.c);
        break label127;
        label496:
        localStringBuilder.append(this.f);
        break label247;
        label508:
        localStringBuilder.append(this.h);
        break label329;
        label520:
        localStringBuilder.append(this.i);
        break label373;
        label532:
        localStringBuilder.append(this.j);
        i1 = 0;
        break label417;
        label546:
        localStringBuilder.append(this.k);
      }
      label558:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ax
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */