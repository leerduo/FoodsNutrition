package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class n
  implements Serializable, Cloneable, org.apache.thrift.b<n, n.a>
{
  public static final Map<n.a, org.apache.thrift.meta_data.b> k;
  private static final k l = new k("XmPushActionRegistrationResult");
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("request", (byte)12, (short)5);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("errorCode", (byte)10, (short)6);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("reason", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("regId", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("regSecret", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)10);
  public String a;
  public g b;
  public String c;
  public String d;
  public m e;
  public long f;
  public String g;
  public String h;
  public String i;
  public String j;
  private BitSet w = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(n.a.class);
    localEnumMap.put(n.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(n.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(n.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(n.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(n.a.e, new org.apache.thrift.meta_data.b("request", (byte)2, new org.apache.thrift.meta_data.g((byte)12, m.class)));
    localEnumMap.put(n.a.f, new org.apache.thrift.meta_data.b("errorCode", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(n.a.g, new org.apache.thrift.meta_data.b("reason", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(n.a.h, new org.apache.thrift.meta_data.b("regId", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(n.a.i, new org.apache.thrift.meta_data.b("regSecret", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(n.a.j, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(n.class, k);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!f()) {
        throw new org.apache.thrift.protocol.g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
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
                  this.e = new m();
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
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(n paramn)
  {
    if (paramn == null) {}
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
                      bool2 = paramn.a();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramn.a))));
                    bool3 = b();
                    bool4 = paramn.b();
                  } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramn.b))));
                  bool5 = c();
                  bool6 = paramn.c();
                } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramn.c))));
                bool7 = d();
                bool8 = paramn.d();
              } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramn.d))));
              bool9 = e();
              bool10 = paramn.e();
            } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.a(paramn.e)) || (this.f != paramn.f)));
            bool11 = g();
            bool12 = paramn.g();
          } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.g.equals(paramn.g))));
          bool13 = h();
          bool14 = paramn.h();
        } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.h.equals(paramn.h))));
        bool15 = i();
        bool16 = paramn.i();
      } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.i.equals(paramn.i))));
      bool17 = j();
      bool18 = paramn.j();
    } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.j.equals(paramn.j))));
    return true;
  }
  
  public int b(n paramn)
  {
    int i1;
    if (!getClass().equals(paramn.getClass())) {
      i1 = getClass().getName().compareTo(paramn.getClass().getName());
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
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramn.a()));
                                          } while (i1 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.a, paramn.a);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramn.b()));
                                      } while (i1 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.b, paramn.b);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramn.c()));
                                  } while (i1 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.c, paramn.c);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramn.d()));
                              } while (i1 != 0);
                              if (!d()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.d, paramn.d);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramn.e()));
                          } while (i1 != 0);
                          if (!e()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.e, paramn.e);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramn.f()));
                      } while (i1 != 0);
                      if (!f()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.f, paramn.f);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramn.g()));
                  } while (i1 != 0);
                  if (!g()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.g, paramn.g);
                } while (i1 != 0);
                i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramn.h()));
              } while (i1 != 0);
              if (!h()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.h, paramn.h);
            } while (i1 != 0);
            i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramn.i()));
          } while (i1 != 0);
          if (!i()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.i, paramn.i);
        } while (i1 != 0);
        i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramn.j()));
      } while (i1 != 0);
      if (!j()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.j, paramn.j);
    } while (i1 != 0);
    return 0;
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
      this.e.b(paramf);
      paramf.b();
    }
    paramf.a(r);
    paramf.a(this.f);
    paramf.b();
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
    while (!(paramObject instanceof n)) {
      return false;
    }
    return a((n)paramObject);
  }
  
  public boolean f()
  {
    return this.w.get(0);
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
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionRegistrationResult(");
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
        break label493;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label395;
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
          break label421;
        }
        localStringBuilder.append("null");
        label155:
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.e != null) {
            break label433;
          }
          localStringBuilder.append("null");
        }
        label193:
        localStringBuilder.append(", ");
        localStringBuilder.append("errorCode:");
        localStringBuilder.append(this.f);
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.g != null) {
            break label445;
          }
          localStringBuilder.append("null");
        }
        label256:
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("regId:");
          if (this.h != null) {
            break label457;
          }
          localStringBuilder.append("null");
        }
        label294:
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("regSecret:");
          if (this.i != null) {
            break label469;
          }
          localStringBuilder.append("null");
        }
        label332:
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.j != null) {
            break label481;
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
        label395:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label421:
        localStringBuilder.append(this.d);
        break label155;
        label433:
        localStringBuilder.append(this.e);
        break label193;
        label445:
        localStringBuilder.append(this.g);
        break label256;
        label457:
        localStringBuilder.append(this.h);
        break label294;
        label469:
        localStringBuilder.append(this.i);
        break label332;
        label481:
        localStringBuilder.append(this.j);
      }
      label493:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.n
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */