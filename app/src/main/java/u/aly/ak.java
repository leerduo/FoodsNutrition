package u.aly;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ak
  implements Serializable, Cloneable, bz<ak, ak.e>
{
  private static final ct A;
  private static final ct B;
  private static final ct C;
  private static final ct D;
  private static final ct E;
  private static final ct F;
  private static final ct G;
  private static final ct H;
  private static final ct I;
  private static final ct J;
  private static final Map<Class<? extends dg>, dh> K;
  public static final Map<ak.e, cl> r;
  private static final dd s = new dd("DeviceInfo");
  private static final ct t = new ct("device_id", (byte)11, (short)1);
  private static final ct u = new ct("idmd5", (byte)11, (short)2);
  private static final ct v = new ct("mac_address", (byte)11, (short)3);
  private static final ct w = new ct("open_udid", (byte)11, (short)4);
  private static final ct x = new ct("model", (byte)11, (short)5);
  private static final ct y = new ct("cpu", (byte)11, (short)6);
  private static final ct z = new ct("os", (byte)11, (short)7);
  private byte L = 0;
  private ak.e[] M;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public ba i;
  public boolean j;
  public boolean k;
  public String l;
  public String m;
  public long n;
  public String o;
  public String p;
  public String q;
  
  static
  {
    A = new ct("os_version", (byte)11, (short)8);
    B = new ct("resolution", (byte)12, (short)9);
    C = new ct("is_jailbroken", (byte)2, (short)10);
    D = new ct("is_pirated", (byte)2, (short)11);
    E = new ct("device_board", (byte)11, (short)12);
    F = new ct("device_brand", (byte)11, (short)13);
    G = new ct("device_manutime", (byte)10, (short)14);
    H = new ct("device_manufacturer", (byte)11, (short)15);
    I = new ct("device_manuid", (byte)11, (short)16);
    J = new ct("device_name", (byte)11, (short)17);
    K = new HashMap();
    K.put(di.class, new ak.b(null));
    K.put(dj.class, new ak.d(null));
    EnumMap localEnumMap = new EnumMap(ak.e.class);
    localEnumMap.put(ak.e.a, new cl("device_id", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.b, new cl("idmd5", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.c, new cl("mac_address", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.d, new cl("open_udid", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.e, new cl("model", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.f, new cl("cpu", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.g, new cl("os", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.h, new cl("os_version", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.i, new cl("resolution", (byte)2, new cq((byte)12, ba.class)));
    localEnumMap.put(ak.e.j, new cl("is_jailbroken", (byte)2, new cm((byte)2)));
    localEnumMap.put(ak.e.k, new cl("is_pirated", (byte)2, new cm((byte)2)));
    localEnumMap.put(ak.e.l, new cl("device_board", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.m, new cl("device_brand", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.n, new cl("device_manutime", (byte)2, new cm((byte)10)));
    localEnumMap.put(ak.e.o, new cl("device_manufacturer", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.p, new cl("device_manuid", (byte)2, new cm((byte)11)));
    localEnumMap.put(ak.e.q, new cl("device_name", (byte)2, new cm((byte)11)));
    r = Collections.unmodifiableMap(localEnumMap);
    cl.a(ak.class, r);
  }
  
  public ak()
  {
    ak.e[] arrayOfe = new ak.e[17];
    arrayOfe[0] = ak.e.a;
    arrayOfe[1] = ak.e.b;
    arrayOfe[2] = ak.e.c;
    arrayOfe[3] = ak.e.d;
    arrayOfe[4] = ak.e.e;
    arrayOfe[5] = ak.e.f;
    arrayOfe[6] = ak.e.g;
    arrayOfe[7] = ak.e.h;
    arrayOfe[8] = ak.e.i;
    arrayOfe[9] = ak.e.j;
    arrayOfe[10] = ak.e.k;
    arrayOfe[11] = ak.e.l;
    arrayOfe[12] = ak.e.m;
    arrayOfe[13] = ak.e.n;
    arrayOfe[14] = ak.e.o;
    arrayOfe[15] = ak.e.p;
    arrayOfe[16] = ak.e.q;
    this.M = arrayOfe;
  }
  
  public ak a(long paramLong)
  {
    this.n = paramLong;
    n(true);
    return this;
  }
  
  public ak a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ak a(ba paramba)
  {
    this.i = paramba;
    return this;
  }
  
  public void a(cy paramcy)
  {
    ((dh)K.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public ak b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b(cy paramcy)
  {
    ((dh)K.get(paramcy.y())).b().a(paramcy, this);
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
  
  public ak c(String paramString)
  {
    this.c = paramString;
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
  
  public ak d(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.d = null;
    }
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public ak e(String paramString)
  {
    this.f = paramString;
    return this;
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
  
  public ak f(String paramString)
  {
    this.g = paramString;
    return this;
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
  
  public ak g(String paramString)
  {
    this.h = paramString;
    return this;
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
  
  public ak h(String paramString)
  {
    this.l = paramString;
    return this;
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
  
  public ak i(String paramString)
  {
    this.m = paramString;
    return this;
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
  
  public ak j(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public void j(boolean paramBoolean)
  {
    this.L = bw.a(this.L, 0, paramBoolean);
  }
  
  public boolean j()
  {
    return bw.a(this.L, 0);
  }
  
  public ak k(String paramString)
  {
    this.p = paramString;
    return this;
  }
  
  public void k(boolean paramBoolean)
  {
    this.L = bw.a(this.L, 1, paramBoolean);
  }
  
  public boolean k()
  {
    return bw.a(this.L, 1);
  }
  
  public ak l(String paramString)
  {
    this.q = paramString;
    return this;
  }
  
  public void l(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.l = null;
    }
  }
  
  public boolean l()
  {
    return this.l != null;
  }
  
  public void m(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.m = null;
    }
  }
  
  public boolean m()
  {
    return this.m != null;
  }
  
  public void n(boolean paramBoolean)
  {
    this.L = bw.a(this.L, 2, paramBoolean);
  }
  
  public boolean n()
  {
    return bw.a(this.L, 2);
  }
  
  public void o(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.o = null;
    }
  }
  
  public boolean o()
  {
    return this.o != null;
  }
  
  public void p(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.p = null;
    }
  }
  
  public boolean p()
  {
    return this.p != null;
  }
  
  public void q(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.q = null;
    }
  }
  
  public boolean q()
  {
    return this.q != null;
  }
  
  public void r()
  {
    if (this.i != null) {
      this.i.c();
    }
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("DeviceInfo(");
    int i2 = 1;
    if (a())
    {
      localStringBuilder.append("device_id:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      if (b())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("idmd5:");
        if (this.b != null) {
          break label754;
        }
        localStringBuilder.append("null");
        label89:
        i2 = 0;
      }
      if (c())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("mac_address:");
        if (this.c != null) {
          break label766;
        }
        localStringBuilder.append("null");
        label133:
        i2 = 0;
      }
      if (d())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("open_udid:");
        if (this.d != null) {
          break label778;
        }
        localStringBuilder.append("null");
        label177:
        i2 = 0;
      }
      if (e())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("model:");
        if (this.e != null) {
          break label790;
        }
        localStringBuilder.append("null");
        label221:
        i2 = 0;
      }
      if (f())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("cpu:");
        if (this.f != null) {
          break label802;
        }
        localStringBuilder.append("null");
        label265:
        i2 = 0;
      }
      if (g())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("os:");
        if (this.g != null) {
          break label814;
        }
        localStringBuilder.append("null");
        label309:
        i2 = 0;
      }
      if (h())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("os_version:");
        if (this.h != null) {
          break label826;
        }
        localStringBuilder.append("null");
        label353:
        i2 = 0;
      }
      if (i())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("resolution:");
        if (this.i != null) {
          break label838;
        }
        localStringBuilder.append("null");
        label397:
        i2 = 0;
      }
      if (j())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("is_jailbroken:");
        localStringBuilder.append(this.j);
        i2 = 0;
      }
      if (k())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("is_pirated:");
        localStringBuilder.append(this.k);
        i2 = 0;
      }
      if (l())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_board:");
        if (this.l != null) {
          break label850;
        }
        localStringBuilder.append("null");
        label517:
        i2 = 0;
      }
      if (m())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_brand:");
        if (this.m != null) {
          break label862;
        }
        localStringBuilder.append("null");
        label561:
        i2 = 0;
      }
      if (n())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_manutime:");
        localStringBuilder.append(this.n);
        i2 = 0;
      }
      if (o())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_manufacturer:");
        if (this.o != null) {
          break label874;
        }
        localStringBuilder.append("null");
        label643:
        i2 = 0;
      }
      if (!p()) {
        break label912;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("device_manuid:");
      if (this.p != null) {
        break label886;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      label687:
      if (q())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("device_name:");
        if (this.q != null) {
          break label900;
        }
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        label754:
        localStringBuilder.append(this.b);
        break label89;
        label766:
        localStringBuilder.append(this.c);
        break label133;
        label778:
        localStringBuilder.append(this.d);
        break label177;
        label790:
        localStringBuilder.append(this.e);
        break label221;
        label802:
        localStringBuilder.append(this.f);
        break label265;
        label814:
        localStringBuilder.append(this.g);
        break label309;
        label826:
        localStringBuilder.append(this.h);
        break label353;
        label838:
        localStringBuilder.append(this.i);
        break label397;
        label850:
        localStringBuilder.append(this.l);
        break label517;
        label862:
        localStringBuilder.append(this.m);
        break label561;
        label874:
        localStringBuilder.append(this.o);
        break label643;
        label886:
        localStringBuilder.append(this.p);
        i1 = 0;
        break label687;
        label900:
        localStringBuilder.append(this.q);
      }
      label912:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ak
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */