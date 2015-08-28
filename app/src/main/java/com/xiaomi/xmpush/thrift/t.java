package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class t
  implements Serializable, Cloneable, org.apache.thrift.b<t, t.a>
{
  public static final Map<t.a, org.apache.thrift.meta_data.b> k;
  private static final k l = new k("XmPushActionUnRegistration");
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("regId", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("appVersion", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("token", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("deviceId", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("aliasName", (byte)11, (short)10);
  public String a;
  public g b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(t.a.class);
    localEnumMap.put(t.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(t.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(t.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(t.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(t.a.e, new org.apache.thrift.meta_data.b("regId", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(t.a.f, new org.apache.thrift.meta_data.b("appVersion", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(t.a.g, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(t.a.h, new org.apache.thrift.meta_data.b("token", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(t.a.i, new org.apache.thrift.meta_data.b("deviceId", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(t.a.j, new org.apache.thrift.meta_data.b("aliasName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(t.class, k);
  }
  
  public t a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      k();
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
              if (localc.b == 11)
              {
                this.e = paramf.w();
              }
              else
              {
                i.a(paramf, localc.b);
                continue;
                if (localc.b == 11)
                {
                  this.f = paramf.w();
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(t paramt)
  {
    if (paramt == null) {}
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
                        bool2 = paramt.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramt.a))));
                      bool3 = b();
                      bool4 = paramt.b();
                    } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramt.b))));
                    bool5 = c();
                    bool6 = paramt.c();
                  } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramt.c))));
                  bool7 = d();
                  bool8 = paramt.d();
                } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramt.d))));
                bool9 = e();
                bool10 = paramt.e();
              } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramt.e))));
              bool11 = f();
              bool12 = paramt.f();
            } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramt.f))));
            bool13 = g();
            bool14 = paramt.g();
          } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramt.g))));
          bool15 = h();
          bool16 = paramt.h();
        } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(paramt.h))));
        bool17 = i();
        bool18 = paramt.i();
      } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.i.equals(paramt.i))));
      bool19 = j();
      bool20 = paramt.j();
    } while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.j.equals(paramt.j))));
    return true;
  }
  
  public int b(t paramt)
  {
    int i1;
    if (!getClass().equals(paramt.getClass())) {
      i1 = getClass().getName().compareTo(paramt.getClass().getName());
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
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramt.a()));
                                          } while (i1 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.a, paramt.a);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramt.b()));
                                      } while (i1 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.b, paramt.b);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramt.c()));
                                  } while (i1 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.c, paramt.c);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramt.d()));
                              } while (i1 != 0);
                              if (!d()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.d, paramt.d);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramt.e()));
                          } while (i1 != 0);
                          if (!e()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.e, paramt.e);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramt.f()));
                      } while (i1 != 0);
                      if (!f()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.f, paramt.f);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramt.g()));
                  } while (i1 != 0);
                  if (!g()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.g, paramt.g);
                } while (i1 != 0);
                i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramt.h()));
              } while (i1 != 0);
              if (!h()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.h, paramt.h);
            } while (i1 != 0);
            i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramt.i()));
          } while (i1 != 0);
          if (!i()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.i, paramt.i);
        } while (i1 != 0);
        i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramt.j()));
      } while (i1 != 0);
      if (!j()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.j, paramt.j);
    } while (i1 != 0);
    return 0;
  }
  
  public t b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void b(f paramf)
  {
    k();
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
    if (this.d != null)
    {
      paramf.a(p);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (e()))
    {
      paramf.a(q);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (f()))
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
    if ((this.h != null) && (h()))
    {
      paramf.a(t);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (i()))
    {
      paramf.a(u);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (j()))
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
  
  public t c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public t d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public t e(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof t)) {
      return false;
    }
    return a((t)paramObject);
  }
  
  public boolean f()
  {
    return this.f != null;
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public boolean h()
  {
    return this.h != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.i != null;
  }
  
  public boolean j()
  {
    return this.j != null;
  }
  
  public void k()
  {
    if (this.c == null) {
      throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionUnRegistration(");
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
        break label518;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label408;
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
        localStringBuilder.append(", ");
        localStringBuilder.append("appId:");
        if (this.d != null) {
          break label434;
        }
        localStringBuilder.append("null");
        label155:
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("regId:");
          if (this.e != null) {
            break label446;
          }
          localStringBuilder.append("null");
        }
        label193:
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appVersion:");
          if (this.f != null) {
            break label458;
          }
          localStringBuilder.append("null");
        }
        label231:
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.g != null) {
            break label470;
          }
          localStringBuilder.append("null");
        }
        label269:
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("token:");
          if (this.h != null) {
            break label482;
          }
          localStringBuilder.append("null");
        }
        label307:
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("deviceId:");
          if (this.i != null) {
            break label494;
          }
          localStringBuilder.append("null");
        }
        label345:
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.j != null) {
            break label506;
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
        label408:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label434:
        localStringBuilder.append(this.d);
        break label155;
        label446:
        localStringBuilder.append(this.e);
        break label193;
        label458:
        localStringBuilder.append(this.f);
        break label231;
        label470:
        localStringBuilder.append(this.g);
        break label269;
        label482:
        localStringBuilder.append(this.h);
        break label307;
        label494:
        localStringBuilder.append(this.i);
        break label345;
        label506:
        localStringBuilder.append(this.j);
      }
      label518:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.t
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */