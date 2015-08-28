package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class q
  implements Serializable, Cloneable, org.apache.thrift.b<q, q.a>
{
  public static final Map<q.a, org.apache.thrift.meta_data.b> l;
  private static final k m = new k("XmPushActionSendMessage");
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("packageName", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("topic", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("aliasName", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("message", (byte)12, (short)8);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("needAck", (byte)2, (short)9);
  private static final org.apache.thrift.protocol.c w = new org.apache.thrift.protocol.c("params", (byte)13, (short)10);
  private static final org.apache.thrift.protocol.c x = new org.apache.thrift.protocol.c("category", (byte)11, (short)11);
  public String a;
  public g b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public c h;
  public boolean i = true;
  public Map<String, String> j;
  public String k;
  private BitSet y = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(q.a.class);
    localEnumMap.put(q.a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(q.a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new org.apache.thrift.meta_data.g((byte)12, g.class)));
    localEnumMap.put(q.a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(q.a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(q.a.e, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(q.a.f, new org.apache.thrift.meta_data.b("topic", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(q.a.g, new org.apache.thrift.meta_data.b("aliasName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(q.a.h, new org.apache.thrift.meta_data.b("message", (byte)2, new org.apache.thrift.meta_data.g((byte)12, c.class)));
    localEnumMap.put(q.a.i, new org.apache.thrift.meta_data.b("needAck", (byte)2, new org.apache.thrift.meta_data.c((byte)2)));
    localEnumMap.put(q.a.j, new org.apache.thrift.meta_data.b("params", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new org.apache.thrift.meta_data.c((byte)11), new org.apache.thrift.meta_data.c((byte)11))));
    localEnumMap.put(q.a.k, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    l = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(q.class, l);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      r();
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
                    if (localc.b == 12)
                    {
                      this.h = new c();
                      this.h.a(paramf);
                    }
                    else
                    {
                      i.a(paramf, localc.b);
                      continue;
                      if (localc.b == 2)
                      {
                        this.i = paramf.q();
                        a(true);
                      }
                      else
                      {
                        i.a(paramf, localc.b);
                        continue;
                        if (localc.b == 13)
                        {
                          org.apache.thrift.protocol.e locale = paramf.k();
                          this.j = new HashMap(2 * locale.c);
                          for (int i1 = 0; i1 < locale.c; i1++)
                          {
                            String str1 = paramf.w();
                            String str2 = paramf.w();
                            this.j.put(str1, str2);
                          }
                          paramf.l();
                        }
                        else
                        {
                          i.a(paramf, localc.b);
                          continue;
                          if (localc.b == 11) {
                            this.k = paramf.w();
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
  }
  
  public void a(boolean paramBoolean)
  {
    this.y.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(q paramq)
  {
    if (paramq == null) {}
    boolean bool21;
    boolean bool22;
    do
    {
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
                          bool2 = paramq.a();
                        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramq.a))));
                        bool3 = b();
                        bool4 = paramq.b();
                      } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.a(paramq.b))));
                      bool5 = d();
                      bool6 = paramq.d();
                    } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramq.c))));
                    bool7 = f();
                    bool8 = paramq.f();
                  } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.d.equals(paramq.d))));
                  bool9 = g();
                  bool10 = paramq.g();
                } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.e.equals(paramq.e))));
                bool11 = i();
                bool12 = paramq.i();
              } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.f.equals(paramq.f))));
              bool13 = k();
              bool14 = paramq.k();
            } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.g.equals(paramq.g))));
            bool15 = m();
            bool16 = paramq.m();
          } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (!this.h.a(paramq.h))));
          bool17 = n();
          bool18 = paramq.n();
        } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (this.i != paramq.i)));
        bool19 = o();
        bool20 = paramq.o();
      } while (((bool19) || (bool20)) && ((!bool19) || (!bool20) || (!this.j.equals(paramq.j))));
      bool21 = q();
      bool22 = paramq.q();
    } while (((bool21) || (bool22)) && ((!bool21) || (!bool22) || (!this.k.equals(paramq.k))));
    return true;
  }
  
  public int b(q paramq)
  {
    int i1;
    if (!getClass().equals(paramq.getClass())) {
      i1 = getClass().getName().compareTo(paramq.getClass().getName());
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
                                            do
                                            {
                                              do
                                              {
                                                return i1;
                                                i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramq.a()));
                                              } while (i1 != 0);
                                              if (!a()) {
                                                break;
                                              }
                                              i1 = org.apache.thrift.c.a(this.a, paramq.a);
                                            } while (i1 != 0);
                                            i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramq.b()));
                                          } while (i1 != 0);
                                          if (!b()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.b, paramq.b);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramq.d()));
                                      } while (i1 != 0);
                                      if (!d()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.c, paramq.c);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramq.f()));
                                  } while (i1 != 0);
                                  if (!f()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.d, paramq.d);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramq.g()));
                              } while (i1 != 0);
                              if (!g()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.e, paramq.e);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramq.i()));
                          } while (i1 != 0);
                          if (!i()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.f, paramq.f);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramq.k()));
                      } while (i1 != 0);
                      if (!k()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.g, paramq.g);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramq.m()));
                  } while (i1 != 0);
                  if (!m()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.h, paramq.h);
                } while (i1 != 0);
                i1 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramq.n()));
              } while (i1 != 0);
              if (!n()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.i, paramq.i);
            } while (i1 != 0);
            i1 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(paramq.o()));
          } while (i1 != 0);
          if (!o()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.j, paramq.j);
        } while (i1 != 0);
        i1 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(paramq.q()));
      } while (i1 != 0);
      if (!q()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.k, paramq.k);
    } while (i1 != 0);
    return 0;
  }
  
  public void b(f paramf)
  {
    r();
    paramf.a(m);
    if ((this.a != null) && (a()))
    {
      paramf.a(n);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(o);
      this.b.b(paramf);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(p);
      paramf.a(this.c);
      paramf.b();
    }
    if (this.d != null)
    {
      paramf.a(q);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (g()))
    {
      paramf.a(r);
      paramf.a(this.e);
      paramf.b();
    }
    if ((this.f != null) && (i()))
    {
      paramf.a(s);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (k()))
    {
      paramf.a(t);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (m()))
    {
      paramf.a(u);
      this.h.b(paramf);
      paramf.b();
    }
    if (n())
    {
      paramf.a(v);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (o()))
    {
      paramf.a(w);
      paramf.a(new org.apache.thrift.protocol.e((byte)11, (byte)11, this.j.size()));
      Iterator localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramf.a((String)localEntry.getKey());
        paramf.a((String)localEntry.getValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.k != null) && (q()))
    {
      paramf.a(x);
      paramf.a(this.k);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.c != null;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof q)) {
      return false;
    }
    return a((q)paramObject);
  }
  
  public boolean f()
  {
    return this.d != null;
  }
  
  public boolean g()
  {
    return this.e != null;
  }
  
  public String h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.f != null;
  }
  
  public String j()
  {
    return this.g;
  }
  
  public boolean k()
  {
    return this.g != null;
  }
  
  public c l()
  {
    return this.h;
  }
  
  public boolean m()
  {
    return this.h != null;
  }
  
  public boolean n()
  {
    return this.y.get(0);
  }
  
  public boolean o()
  {
    return this.j != null;
  }
  
  public String p()
  {
    return this.k;
  }
  
  public boolean q()
  {
    return this.k != null;
  }
  
  public void r()
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
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSendMessage(");
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
        break label550;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label440;
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
          break label466;
        }
        localStringBuilder.append("null");
        label155:
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.e != null) {
            break label478;
          }
          localStringBuilder.append("null");
        }
        label193:
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("topic:");
          if (this.f != null) {
            break label490;
          }
          localStringBuilder.append("null");
        }
        label231:
        if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.g != null) {
            break label502;
          }
          localStringBuilder.append("null");
        }
        label269:
        if (m())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("message:");
          if (this.h != null) {
            break label514;
          }
          localStringBuilder.append("null");
        }
        label307:
        if (n())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("needAck:");
          localStringBuilder.append(this.i);
        }
        if (o())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("params:");
          if (this.j != null) {
            break label526;
          }
          localStringBuilder.append("null");
        }
        label377:
        if (q())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.k != null) {
            break label538;
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
        label440:
        localStringBuilder.append(this.b);
        i1 = 0;
        break label89;
        localStringBuilder.append(this.c);
        break label124;
        label466:
        localStringBuilder.append(this.d);
        break label155;
        label478:
        localStringBuilder.append(this.e);
        break label193;
        label490:
        localStringBuilder.append(this.f);
        break label231;
        label502:
        localStringBuilder.append(this.g);
        break label269;
        label514:
        localStringBuilder.append(this.h);
        break label307;
        label526:
        localStringBuilder.append(this.j);
        break label377;
        label538:
        localStringBuilder.append(this.k);
      }
      label550:
      i1 = i2;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.q
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */