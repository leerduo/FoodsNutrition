package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class m
  implements Serializable, Cloneable, org.apache.thrift.b<m, m.a>
{
  public static final Map<m.a, org.apache.thrift.meta_data.b> k;
  private static final k l = new k("XmPushActionRegistration");
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("appVersion", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("token", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("deviceId", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("aliasName", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("sdkVersion", (byte)11, (short)10);
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
    EnumMap localEnumMap = new EnumMap(m.a.class);
    localEnumMap.put(m.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(m.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(m.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(m.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(m.a.e, new org.apache.thrift.meta_data.b("appVersion", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(m.a.f, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(m.a.g, new org.apache.thrift.meta_data.b("token", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(m.a.h, new org.apache.thrift.meta_data.b("deviceId", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(m.a.i, new org.apache.thrift.meta_data.b("aliasName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(m.a.j, new org.apache.thrift.meta_data.b("sdkVersion", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(m.class, k);
  }
  
  public m a(String paramString)
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
  
  public boolean a(m paramm)
  {
    if (paramm == null) {}
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
                        bool2 = paramm.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramm.a))));
                      bool3 = b();
                      bool4 = paramm.b();
                    } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramm.b))));
                    bool5 = c();
                    bool6 = paramm.c();
                  } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramm.c))));
                  bool7 = e();
                  bool8 = paramm.e();
                } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramm.d))));
                bool9 = f();
                bool10 = paramm.f();
              } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramm.e))));
              bool11 = g();
              bool12 = paramm.g();
            } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramm.f))));
            bool13 = i();
            bool14 = paramm.i();
          } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramm.g))));
          bool15 = j();
          bool16 = paramm.j();
        } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.equals(paramm.h))));
        bool17 = k();
        bool18 = paramm.k();
      } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.i.equals(paramm.i))));
      bool19 = l();
      bool20 = paramm.l();
    } while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.j.equals(paramm.j))));
    return true;
  }
  
  public int b(m paramm)
  {
    int i1;
    if (!getClass().equals(paramm.getClass())) {
      i1 = getClass().getName().compareTo(paramm.getClass().getName());
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
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramm.a()));
                                          } while (i1 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.a, paramm.a);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramm.b()));
                                      } while (i1 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.b, paramm.b);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramm.c()));
                                  } while (i1 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.c, paramm.c);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramm.e()));
                              } while (i1 != 0);
                              if (!e()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.d, paramm.d);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramm.f()));
                          } while (i1 != 0);
                          if (!f()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.e, paramm.e);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramm.g()));
                      } while (i1 != 0);
                      if (!g()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.f, paramm.f);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramm.i()));
                  } while (i1 != 0);
                  if (!i()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.g, paramm.g);
                } while (i1 != 0);
                i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramm.j()));
              } while (i1 != 0);
              if (!j()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.h, paramm.h);
            } while (i1 != 0);
            i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramm.k()));
          } while (i1 != 0);
          if (!k()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.i, paramm.i);
        } while (i1 != 0);
        i1 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramm.l()));
      } while (i1 != 0);
      if (!l()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.j, paramm.j);
    } while (i1 != 0);
    return 0;
  }
  
  public m b(String paramString)
  {
    this.d = paramString;
    return this;
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
    if (this.d != null)
    {
      paramf.a(p);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (f()))
    {
      paramf.a(q);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (g()))
    {
      paramf.a(r);
      paramf.a(this.f);
      paramf.b();
    }
    if (this.g != null)
    {
      paramf.a(s);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (j()))
    {
      paramf.a(t);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (k()))
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
  
  public m c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public m d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public m e(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public boolean e()
  {
    return this.d != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof m)) {
      return false;
    }
    return a((m)paramObject);
  }
  
  public m f(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public boolean f()
  {
    return this.e != null;
  }
  
  public boolean g()
  {
    return this.f != null;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.g != null;
  }
  
  public boolean j()
  {
    return this.h != null;
  }
  
  public boolean k()
  {
    return this.i != null;
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
    if (this.d == null) {
      throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
    }
    if (this.g == null) {
      throw new org.apache.thrift.protocol.g("Required field 'token' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionRegistration(");
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
        break label511;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label401;
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
          break label427;
        }
        localStringBuilder.append("null");
        label155:
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appVersion:");
          if (this.e != null) {
            break label439;
          }
          localStringBuilder.append("null");
        }
        label193:
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.f != null) {
            break label451;
          }
          localStringBuilder.append("null");
        }
        label231:
        localStringBuilder.append(", ");
        localStringBuilder.append("token:");
        if (this.g != null) {
          break label463;
        }
        localStringBuilder.append("null");
        label262:
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("deviceId:");
          if (this.h != null) {
            break label475;
          }
          localStringBuilder.append("null");
        }
        label300:
        if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.i != null) {
            break label487;
          }
          localStringBuilder.append("null");
        }
        label338:
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("sdkVersion:");
          if (this.j != null) {
            break label499;
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
        label401:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label427:
        localStringBuilder.append(this.d);
        break label155;
        label439:
        localStringBuilder.append(this.e);
        break label193;
        label451:
        localStringBuilder.append(this.f);
        break label231;
        label463:
        localStringBuilder.append(this.g);
        break label262;
        label475:
        localStringBuilder.append(this.h);
        break label300;
        label487:
        localStringBuilder.append(this.i);
        break label338;
        label499:
        localStringBuilder.append(this.j);
      }
      label511:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.m
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */