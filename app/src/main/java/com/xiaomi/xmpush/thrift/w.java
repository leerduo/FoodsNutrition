package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class w
  implements Serializable, Cloneable, org.apache.thrift.b<w, w.a>
{
  public static final Map<w.a, org.apache.thrift.meta_data.b> k;
  private static final k l = new k("XmPushActionUnSubscriptionResult");
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("request", (byte)12, (short)5);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("errorCode", (byte)10, (short)6);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("reason", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("topic", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("category", (byte)11, (short)10);
  public String a;
  public g b;
  public String c;
  public String d;
  public v e;
  public long f;
  public String g;
  public String h;
  public String i;
  public String j;
  private BitSet w = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(w.a.class);
    localEnumMap.put(w.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(w.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(w.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(w.a.d, new org.apache.thrift.meta_data.b("appId", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(w.a.e, new org.apache.thrift.meta_data.b("request", (byte)2, new org.apache.thrift.meta_data.g((byte)12, v.class)));
    localEnumMap.put(w.a.f, new org.apache.thrift.meta_data.b("errorCode", (byte)2, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(w.a.g, new org.apache.thrift.meta_data.b("reason", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(w.a.h, new org.apache.thrift.meta_data.b("topic", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(w.a.i, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(w.a.j, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(w.class, k);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      m();
      return;
    }
    switch (localc.c)
    {
    default: 
      i.a(paramf, localc.b);
    }
    for (;;)
    {
      paramf.j();
      break;
      if (localc.b == 11)
      {
        this.a = paramf.w();
      }
      else
      {
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 12)
        {
          this.b = new g();
          this.b.a(paramf);
        }
        else
        {
          i.a(paramf, localc.b);
          continue;
          if (localc.b == 11)
          {
            this.c = paramf.w();
          }
          else
          {
            i.a(paramf, localc.b);
            continue;
            if (localc.b == 11)
            {
              this.d = paramf.w();
            }
            else
            {
              i.a(paramf, localc.b);
              continue;
              if (localc.b == 12)
              {
                this.e = new v();
                this.e.a(paramf);
              }
              else
              {
                i.a(paramf, localc.b);
                continue;
                if (localc.b == 10)
                {
                  this.f = paramf.u();
                  a(true);
                }
                else
                {
                  i.a(paramf, localc.b);
                  continue;
                  if (localc.b == 11)
                  {
                    this.g = paramf.w();
                  }
                  else
                  {
                    i.a(paramf, localc.b);
                    continue;
                    if (localc.b == 11)
                    {
                      this.h = paramf.w();
                    }
                    else
                    {
                      i.a(paramf, localc.b);
                      continue;
                      if (localc.b == 11)
                      {
                        this.i = paramf.w();
                      }
                      else
                      {
                        i.a(paramf, localc.b);
                        continue;
                        if (localc.b == 11) {
                          this.j = paramf.w();
                        } else {
                          i.a(paramf, localc.b);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(w paramw)
  {
    if (paramw == null) {}
    boolean bool19;
    boolean bool20;
    do
    {
      boolean bool17;
      boolean bool18;
      do
      {
        boolean bool15;
        boolean bool16;
        do
        {
          boolean bool13;
          boolean bool14;
          do
          {
            boolean bool11;
            boolean bool12;
            do
            {
              boolean bool9;
              boolean bool10;
              do
              {
                boolean bool7;
                boolean bool8;
                do
                {
                  boolean bool5;
                  boolean bool6;
                  do
                  {
                    boolean bool3;
                    boolean bool4;
                    do
                    {
                      boolean bool1;
                      boolean bool2;
                      do
                      {
                        return false;
                        bool1 = a();
                        bool2 = paramw.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramw.a))));
                      bool3 = b();
                      bool4 = paramw.b();
                    } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramw.b))));
                    bool5 = c();
                    bool6 = paramw.c();
                  } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramw.c))));
                  bool7 = d();
                  bool8 = paramw.d();
                } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramw.d))));
                bool9 = e();
                bool10 = paramw.e();
              } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.a(paramw.e))));
              bool11 = f();
              bool12 = paramw.f();
            } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (this.f != paramw.f)));
            bool13 = g();
            bool14 = paramw.g();
          } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramw.g))));
          bool15 = i();
          bool16 = paramw.i();
        } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(paramw.h))));
        bool17 = j();
        bool18 = paramw.j();
      } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.i.equals(paramw.i))));
      bool19 = l();
      bool20 = paramw.l();
    } while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.j.equals(paramw.j))));
    return true;
  }
  
  public int b(w paramw)
  {
    int i1;
    if (!getClass().equals(paramw.getClass())) {
      i1 = getClass().getName().compareTo(paramw.getClass().getName());
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            return i1;
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramw.a()));
                                          } while (i1 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.a, paramw.a);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramw.b()));
                                      } while (i1 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.b, paramw.b);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramw.c()));
                                  } while (i1 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.c, paramw.c);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramw.d()));
                              } while (i1 != 0);
                              if (!d()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.d, paramw.d);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramw.e()));
                          } while (i1 != 0);
                          if (!e()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.e, paramw.e);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramw.f()));
                      } while (i1 != 0);
                      if (!f()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.f, paramw.f);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramw.g()));
                  } while (i1 != 0);
                  if (!g()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.g, paramw.g);
                } while (i1 != 0);
                i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramw.i()));
              } while (i1 != 0);
              if (!i()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.h, paramw.h);
            } while (i1 != 0);
            i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramw.j()));
          } while (i1 != 0);
          if (!j()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.i, paramw.i);
        } while (i1 != 0);
        i1 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramw.l()));
      } while (i1 != 0);
      if (!l()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.j, paramw.j);
    } while (i1 != 0);
    return 0;
  }
  
  public void b(f paramf)
  {
    m();
    paramf.a(l);
    if ((this.a != null) && (a()))
    {
      paramf.a(m);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(n);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(o);
      paramf.a(this.c);
      paramf.b();
    }
    if ((this.d != null) && (d()))
    {
      paramf.a(p);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(q);
      this.e.b(paramf);
      paramf.b();
    }
    if (f())
    {
      paramf.a(r);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (g()))
    {
      paramf.a(s);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (i()))
    {
      paramf.a(t);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (j()))
    {
      paramf.a(u);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (l()))
    {
      paramf.a(v);
      paramf.a(this.j);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof w)) {
      return false;
    }
    return a((w)paramObject);
  }
  
  public boolean f()
  {
    return this.w.get(0);
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.h != null;
  }
  
  public boolean j()
  {
    return this.i != null;
  }
  
  public String k()
  {
    return this.j;
  }
  
  public boolean l()
  {
    return this.j != null;
  }
  
  public void m()
  {
    if (this.c == null) {
      throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionUnSubscriptionResult(");
    int i2 = 1;
    if (a())
    {
      localStringBuilder.append("debug:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      if (!b()) {
        break label507;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label409;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      label89:
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.c == null)
      {
        localStringBuilder.append("null");
        label124:
        if (d())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appId:");
          if (this.d != null) {
            break label435;
          }
          localStringBuilder.append("null");
        }
        label162:
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.e != null) {
            break label447;
          }
          localStringBuilder.append("null");
        }
        label200:
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("errorCode:");
          localStringBuilder.append(this.f);
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.g != null) {
            break label459;
          }
          localStringBuilder.append("null");
        }
        label270:
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("topic:");
          if (this.h != null) {
            break label471;
          }
          localStringBuilder.append("null");
        }
        label308:
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null) {
            break label483;
          }
          localStringBuilder.append("null");
        }
        label346:
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.j != null) {
            break label495;
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
        label409:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label435:
        localStringBuilder.append(this.d);
        break label162;
        label447:
        localStringBuilder.append(this.e);
        break label200;
        label459:
        localStringBuilder.append(this.g);
        break label270;
        label471:
        localStringBuilder.append(this.h);
        break label308;
        label483:
        localStringBuilder.append(this.i);
        break label346;
        label495:
        localStringBuilder.append(this.j);
      }
      label507:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.w
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */