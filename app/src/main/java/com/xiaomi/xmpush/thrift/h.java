package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class h
  implements Serializable, Cloneable, org.apache.thrift.b<h, h.a>
{
  public static final Map<h.a, org.apache.thrift.meta_data.b> k;
  private static final k l = new k("XmPushActionAckMessage");
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("messageTs", (byte)10, (short)5);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("topic", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("aliasName", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("request", (byte)12, (short)8);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("category", (byte)11, (short)10);
  public String a;
  public g b;
  public String c;
  public String d;
  public long e;
  public String f;
  public String g;
  public q h;
  public String i;
  public String j;
  private BitSet w = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(h.a.class);
    localEnumMap.put(h.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(h.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(h.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(h.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(h.a.e, new org.apache.thrift.meta_data.b("messageTs", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(h.a.f, new org.apache.thrift.meta_data.b("topic", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(h.a.g, new org.apache.thrift.meta_data.b("aliasName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(h.a.h, new org.apache.thrift.meta_data.b("request", (byte)2, new org.apache.thrift.meta_data.g((byte)12, q.class)));
    localEnumMap.put(h.a.i, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(h.a.j, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(h.class, k);
  }
  
  public h a(long paramLong)
  {
    this.e = paramLong;
    a(true);
    return this;
  }
  
  public h a(String paramString)
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
      if (!e()) {
        throw new org.apache.thrift.protocol.g("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
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
                if (localc.b == 10)
                {
                  this.e = paramf.u();
                  a(true);
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
                      if (localc.b == 12)
                      {
                        this.h = new q();
                        this.h.a(paramf);
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
  
  public boolean a(h paramh)
  {
    if (paramh == null) {}
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
                      bool2 = paramh.a();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramh.a))));
                    bool3 = b();
                    bool4 = paramh.b();
                  } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramh.b))));
                  bool5 = c();
                  bool6 = paramh.c();
                } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramh.c))));
                bool7 = d();
                bool8 = paramh.d();
              } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramh.d)) || (this.e != paramh.e)));
              bool9 = f();
              bool10 = paramh.f();
            } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.f.equals(paramh.f))));
            bool11 = g();
            bool12 = paramh.g();
          } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.g.equals(paramh.g))));
          bool13 = h();
          bool14 = paramh.h();
        } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.h.a(paramh.h))));
        bool15 = i();
        bool16 = paramh.i();
      } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.i.equals(paramh.i))));
      bool17 = j();
      bool18 = paramh.j();
    } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.j.equals(paramh.j))));
    return true;
  }
  
  public int b(h paramh)
  {
    int i1;
    if (!getClass().equals(paramh.getClass())) {
      i1 = getClass().getName().compareTo(paramh.getClass().getName());
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
                                            i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramh.a()));
                                          } while (i1 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.a, paramh.a);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramh.b()));
                                      } while (i1 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.b, paramh.b);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramh.c()));
                                  } while (i1 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.c, paramh.c);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramh.d()));
                              } while (i1 != 0);
                              if (!d()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.d, paramh.d);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramh.e()));
                          } while (i1 != 0);
                          if (!e()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.e, paramh.e);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramh.f()));
                      } while (i1 != 0);
                      if (!f()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.f, paramh.f);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramh.g()));
                  } while (i1 != 0);
                  if (!g()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.g, paramh.g);
                } while (i1 != 0);
                i1 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramh.h()));
              } while (i1 != 0);
              if (!h()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.h, paramh.h);
            } while (i1 != 0);
            i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramh.i()));
          } while (i1 != 0);
          if (!i()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.i, paramh.i);
        } while (i1 != 0);
        i1 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramh.j()));
      } while (i1 != 0);
      if (!j()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.j, paramh.j);
    } while (i1 != 0);
    return 0;
  }
  
  public h b(String paramString)
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
    paramf.a(q);
    paramf.a(this.e);
    paramf.b();
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
      this.h.b(paramf);
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
  
  public h c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public h d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public boolean e()
  {
    return this.w.get(0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof h)) {
      return false;
    }
    return a((h)paramObject);
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
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionAckMessage(");
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
        localStringBuilder.append(", ");
        localStringBuilder.append("messageTs:");
        localStringBuilder.append(this.e);
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("topic:");
          if (this.f != null) {
            break label433;
          }
          localStringBuilder.append("null");
        }
        label218:
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.g != null) {
            break label445;
          }
          localStringBuilder.append("null");
        }
        label256:
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.h != null) {
            break label457;
          }
          localStringBuilder.append("null");
        }
        label294:
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null) {
            break label469;
          }
          localStringBuilder.append("null");
        }
        label332:
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
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
        localStringBuilder.append(this.f);
        break label218;
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
 * Qualified Name:     com.xiaomi.xmpush.thrift.h
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */