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
import org.apache.thrift.protocol.g;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class d
  implements Serializable, Cloneable, org.apache.thrift.b<d, d.a>
{
  public static final Map<d.a, org.apache.thrift.meta_data.b> k;
  private static final k l = new k("PushMetaInfo");
  private static final org.apache.thrift.protocol.c m = new org.apache.thrift.protocol.c("id", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c n = new org.apache.thrift.protocol.c("messageTs", (byte)10, (short)2);
  private static final org.apache.thrift.protocol.c o = new org.apache.thrift.protocol.c("topic", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c p = new org.apache.thrift.protocol.c("title", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c q = new org.apache.thrift.protocol.c("description", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c r = new org.apache.thrift.protocol.c("notifyType", (byte)8, (short)6);
  private static final org.apache.thrift.protocol.c s = new org.apache.thrift.protocol.c("url", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.c t = new org.apache.thrift.protocol.c("passThrough", (byte)8, (short)8);
  private static final org.apache.thrift.protocol.c u = new org.apache.thrift.protocol.c("notifyId", (byte)8, (short)9);
  private static final org.apache.thrift.protocol.c v = new org.apache.thrift.protocol.c("extra", (byte)13, (short)10);
  public String a;
  public long b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String g;
  public int h;
  public int i;
  public Map<String, String> j;
  private BitSet w = new BitSet(4);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(d.a.class);
    localEnumMap.put(d.a.a, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(d.a.b, new org.apache.thrift.meta_data.b("messageTs", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(d.a.c, new org.apache.thrift.meta_data.b("topic", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(d.a.d, new org.apache.thrift.meta_data.b("title", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(d.a.e, new org.apache.thrift.meta_data.b("description", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(d.a.f, new org.apache.thrift.meta_data.b("notifyType", (byte)2, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(d.a.g, new org.apache.thrift.meta_data.b("url", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(d.a.h, new org.apache.thrift.meta_data.b("passThrough", (byte)2, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(d.a.i, new org.apache.thrift.meta_data.b("notifyId", (byte)2, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(d.a.j, new org.apache.thrift.meta_data.b("extra", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new org.apache.thrift.meta_data.c((byte)11), new org.apache.thrift.meta_data.c((byte)11))));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(d.class, k);
  }
  
  public d() {}
  
  public d(d paramd)
  {
    this.w.clear();
    this.w.or(paramd.w);
    if (paramd.c()) {
      this.a = paramd.a;
    }
    this.b = paramd.b;
    if (paramd.g()) {
      this.c = paramd.c;
    }
    if (paramd.i()) {
      this.d = paramd.d;
    }
    if (paramd.k()) {
      this.e = paramd.e;
    }
    this.f = paramd.f;
    if (paramd.n()) {
      this.g = paramd.g;
    }
    this.h = paramd.h;
    this.i = paramd.i;
    if (paramd.t())
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramd.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      this.j = localHashMap;
    }
  }
  
  public d a()
  {
    return new d(this);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.j == null) {
      this.j = new HashMap();
    }
    this.j.put(paramString1, paramString2);
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!e()) {
        throw new g("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
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
          if (localc.b == 10)
          {
            this.b = paramf.u();
            a(true);
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
                  if (localc.b == 8)
                  {
                    this.f = paramf.t();
                    b(true);
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
                      if (localc.b == 8)
                      {
                        this.h = paramf.t();
                        c(true);
                      }
                      else
                      {
                        i.a(paramf, localc.b);
                        continue;
                        if (localc.b == 8)
                        {
                          this.i = paramf.t();
                          d(true);
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
    u();
  }
  
  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }
  
  public boolean a(d paramd)
  {
    if (paramd == null) {}
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
                      bool1 = c();
                      bool2 = paramd.c();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramd.a)) || (this.b != paramd.b)));
                    bool3 = g();
                    bool4 = paramd.g();
                  } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.c.equals(paramd.c))));
                  bool5 = i();
                  bool6 = paramd.i();
                } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.d.equals(paramd.d))));
                bool7 = k();
                bool8 = paramd.k();
              } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.e.equals(paramd.e))));
              bool9 = m();
              bool10 = paramd.m();
            } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (this.f != paramd.f)));
            bool11 = n();
            bool12 = paramd.n();
          } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.g.equals(paramd.g))));
          bool13 = p();
          bool14 = paramd.p();
        } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (this.h != paramd.h)));
        bool15 = r();
        bool16 = paramd.r();
      } while (((bool15) || (bool16)) && ((!bool15) || (!bool16) || (this.i != paramd.i)));
      bool17 = t();
      bool18 = paramd.t();
    } while (((bool17) || (bool18)) && ((!bool17) || (!bool18) || (!this.j.equals(paramd.j))));
    return true;
  }
  
  public int b(d paramd)
  {
    int i1;
    if (!getClass().equals(paramd.getClass())) {
      i1 = getClass().getName().compareTo(paramd.getClass().getName());
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
                                            i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramd.c()));
                                          } while (i1 != 0);
                                          if (!c()) {
                                            break;
                                          }
                                          i1 = org.apache.thrift.c.a(this.a, paramd.a);
                                        } while (i1 != 0);
                                        i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramd.e()));
                                      } while (i1 != 0);
                                      if (!e()) {
                                        break;
                                      }
                                      i1 = org.apache.thrift.c.a(this.b, paramd.b);
                                    } while (i1 != 0);
                                    i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramd.g()));
                                  } while (i1 != 0);
                                  if (!g()) {
                                    break;
                                  }
                                  i1 = org.apache.thrift.c.a(this.c, paramd.c);
                                } while (i1 != 0);
                                i1 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramd.i()));
                              } while (i1 != 0);
                              if (!i()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.d, paramd.d);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramd.k()));
                          } while (i1 != 0);
                          if (!k()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.e, paramd.e);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramd.m()));
                      } while (i1 != 0);
                      if (!m()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.f, paramd.f);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramd.n()));
                  } while (i1 != 0);
                  if (!n()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.g, paramd.g);
                } while (i1 != 0);
                i1 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(paramd.p()));
              } while (i1 != 0);
              if (!p()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.h, paramd.h);
            } while (i1 != 0);
            i1 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(paramd.r()));
          } while (i1 != 0);
          if (!r()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.i, paramd.i);
        } while (i1 != 0);
        i1 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(paramd.t()));
      } while (i1 != 0);
      if (!t()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.j, paramd.j);
    } while (i1 != 0);
    return 0;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(f paramf)
  {
    u();
    paramf.a(l);
    if (this.a != null)
    {
      paramf.a(m);
      paramf.a(this.a);
      paramf.b();
    }
    paramf.a(n);
    paramf.a(this.b);
    paramf.b();
    if ((this.c != null) && (g()))
    {
      paramf.a(o);
      paramf.a(this.c);
      paramf.b();
    }
    if ((this.d != null) && (i()))
    {
      paramf.a(p);
      paramf.a(this.d);
      paramf.b();
    }
    if ((this.e != null) && (k()))
    {
      paramf.a(q);
      paramf.a(this.e);
      paramf.b();
    }
    if (m())
    {
      paramf.a(r);
      paramf.a(this.f);
      paramf.b();
    }
    if ((this.g != null) && (n()))
    {
      paramf.a(s);
      paramf.a(this.g);
      paramf.b();
    }
    if (p())
    {
      paramf.a(t);
      paramf.a(this.h);
      paramf.b();
    }
    if (r())
    {
      paramf.a(u);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (t()))
    {
      paramf.a(v);
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
    paramf.c();
    paramf.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.w.set(1, paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.w.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.a != null;
  }
  
  public long d()
  {
    return this.b;
  }
  
  public void d(boolean paramBoolean)
  {
    this.w.set(3, paramBoolean);
  }
  
  public boolean e()
  {
    return this.w.get(0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof d)) {
      return false;
    }
    return a((d)paramObject);
  }
  
  public String f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    return this.c != null;
  }
  
  public String h()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.d != null;
  }
  
  public String j()
  {
    return this.e;
  }
  
  public boolean k()
  {
    return this.e != null;
  }
  
  public int l()
  {
    return this.f;
  }
  
  public boolean m()
  {
    return this.w.get(1);
  }
  
  public boolean n()
  {
    return this.g != null;
  }
  
  public int o()
  {
    return this.h;
  }
  
  public boolean p()
  {
    return this.w.get(2);
  }
  
  public int q()
  {
    return this.i;
  }
  
  public boolean r()
  {
    return this.w.get(3);
  }
  
  public Map<String, String> s()
  {
    return this.j;
  }
  
  public boolean t()
  {
    return this.j != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PushMetaInfo(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("messageTs:");
      localStringBuilder.append(this.b);
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("topic:");
        if (this.c != null) {
          break label370;
        }
        localStringBuilder.append("null");
      }
      label97:
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("title:");
        if (this.d != null) {
          break label382;
        }
        localStringBuilder.append("null");
      }
      label135:
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("description:");
        if (this.e != null) {
          break label394;
        }
        localStringBuilder.append("null");
      }
      label173:
      if (m())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("notifyType:");
        localStringBuilder.append(this.f);
      }
      if (n())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("url:");
        if (this.g != null) {
          break label406;
        }
        localStringBuilder.append("null");
      }
      label243:
      if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("passThrough:");
        localStringBuilder.append(this.h);
      }
      if (r())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("notifyId:");
        localStringBuilder.append(this.i);
      }
      if (t())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("extra:");
        if (this.j != null) {
          break label418;
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
      label370:
      localStringBuilder.append(this.c);
      break label97;
      label382:
      localStringBuilder.append(this.d);
      break label135;
      label394:
      localStringBuilder.append(this.e);
      break label173;
      label406:
      localStringBuilder.append(this.g);
      break label243;
      label418:
      localStringBuilder.append(this.j);
    }
  }
  
  public void u()
  {
    if (this.a == null) {
      throw new g("Required field 'id' was not present! Struct: " + toString());
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */