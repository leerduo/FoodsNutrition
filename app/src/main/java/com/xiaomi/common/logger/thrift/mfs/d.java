package com.xiaomi.common.logger.thrift.mfs;

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
  public static final Map<d.a, org.apache.thrift.meta_data.b> a;
  private static final k b = new k("LandNodeInfo");
  private static final org.apache.thrift.protocol.c c = new org.apache.thrift.protocol.c("ip", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c d = new org.apache.thrift.protocol.c("failed_count", (byte)8, (short)2);
  private static final org.apache.thrift.protocol.c e = new org.apache.thrift.protocol.c("success_count", (byte)8, (short)3);
  private static final org.apache.thrift.protocol.c f = new org.apache.thrift.protocol.c("duration", (byte)10, (short)4);
  private static final org.apache.thrift.protocol.c g = new org.apache.thrift.protocol.c("size", (byte)8, (short)5);
  private static final org.apache.thrift.protocol.c h = new org.apache.thrift.protocol.c("exp_info", (byte)13, (short)6);
  private static final org.apache.thrift.protocol.c i = new org.apache.thrift.protocol.c("http_info", (byte)13, (short)7);
  private String j;
  private int k;
  private int l;
  private long m;
  private int n;
  private Map<String, Integer> o;
  private Map<Integer, Integer> p;
  private BitSet q = new BitSet(4);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(d.a.class);
    localEnumMap.put(d.a.a, new org.apache.thrift.meta_data.b("ip", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(d.a.b, new org.apache.thrift.meta_data.b("failed_count", (byte)1, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(d.a.c, new org.apache.thrift.meta_data.b("success_count", (byte)1, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(d.a.d, new org.apache.thrift.meta_data.b("duration", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(d.a.e, new org.apache.thrift.meta_data.b("size", (byte)1, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(d.a.f, new org.apache.thrift.meta_data.b("exp_info", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new org.apache.thrift.meta_data.c((byte)11), new org.apache.thrift.meta_data.c((byte)8))));
    localEnumMap.put(d.a.g, new org.apache.thrift.meta_data.b("http_info", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new org.apache.thrift.meta_data.c((byte)8), new org.apache.thrift.meta_data.c((byte)8))));
    a = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(d.class, a);
  }
  
  public d a(int paramInt)
  {
    this.k = paramInt;
    a(true);
    return this;
  }
  
  public d a(long paramLong)
  {
    this.m = paramLong;
    c(true);
    return this;
  }
  
  public d a(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public d a(Map<String, Integer> paramMap)
  {
    this.o = paramMap;
    return this;
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      if (!b()) {
        throw new g("Required field 'failed_count' was not found in serialized data! Struct: " + toString());
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
          this.j = paramf.w();
        }
        else
        {
          i.a(paramf, localc.b);
          continue;
          if (localc.b == 8)
          {
            this.k = paramf.t();
            a(true);
          }
          else
          {
            i.a(paramf, localc.b);
            continue;
            if (localc.b == 8)
            {
              this.l = paramf.t();
              b(true);
            }
            else
            {
              i.a(paramf, localc.b);
              continue;
              if (localc.b == 10)
              {
                this.m = paramf.u();
                c(true);
              }
              else
              {
                i.a(paramf, localc.b);
                continue;
                if (localc.b == 8)
                {
                  this.n = paramf.t();
                  d(true);
                }
                else
                {
                  i.a(paramf, localc.b);
                  continue;
                  if (localc.b == 13)
                  {
                    org.apache.thrift.protocol.e locale2 = paramf.k();
                    this.o = new HashMap(2 * locale2.c);
                    for (int i4 = 0; i4 < locale2.c; i4++)
                    {
                      String str = paramf.w();
                      int i5 = paramf.t();
                      this.o.put(str, Integer.valueOf(i5));
                    }
                    paramf.l();
                  }
                  else
                  {
                    i.a(paramf, localc.b);
                    continue;
                    if (localc.b == 13)
                    {
                      org.apache.thrift.protocol.e locale1 = paramf.k();
                      this.p = new HashMap(2 * locale1.c);
                      for (int i1 = 0; i1 < locale1.c; i1++)
                      {
                        int i2 = paramf.t();
                        int i3 = paramf.t();
                        this.p.put(Integer.valueOf(i2), Integer.valueOf(i3));
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
    if (!c()) {
      throw new g("Required field 'success_count' was not found in serialized data! Struct: " + toString());
    }
    if (!d()) {
      throw new g("Required field 'duration' was not found in serialized data! Struct: " + toString());
    }
    if (!e()) {
      throw new g("Required field 'size' was not found in serialized data! Struct: " + toString());
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    this.q.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.j != null;
  }
  
  public boolean a(d paramd)
  {
    if (paramd == null) {}
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
          bool2 = paramd.a();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramd.j)) || (this.k != paramd.k) || (this.l != paramd.l) || (this.m != paramd.m) || (this.n != paramd.n)));
        bool3 = f();
        bool4 = paramd.f();
      } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.o.equals(paramd.o))));
      bool5 = g();
      bool6 = paramd.g();
    } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.p.equals(paramd.p))));
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
                                return i1;
                                i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramd.a()));
                              } while (i1 != 0);
                              if (!a()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.j, paramd.j);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramd.b()));
                          } while (i1 != 0);
                          if (!b()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.k, paramd.k);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramd.c()));
                      } while (i1 != 0);
                      if (!c()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.l, paramd.l);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramd.d()));
                  } while (i1 != 0);
                  if (!d()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.m, paramd.m);
                } while (i1 != 0);
                i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramd.e()));
              } while (i1 != 0);
              if (!e()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.n, paramd.n);
            } while (i1 != 0);
            i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramd.f()));
          } while (i1 != 0);
          if (!f()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.o, paramd.o);
        } while (i1 != 0);
        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramd.g()));
      } while (i1 != 0);
      if (!g()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.p, paramd.p);
    } while (i1 != 0);
    return 0;
  }
  
  public d b(int paramInt)
  {
    this.l = paramInt;
    b(true);
    return this;
  }
  
  public void b(f paramf)
  {
    h();
    paramf.a(b);
    if (this.j != null)
    {
      paramf.a(c);
      paramf.a(this.j);
      paramf.b();
    }
    paramf.a(d);
    paramf.a(this.k);
    paramf.b();
    paramf.a(e);
    paramf.a(this.l);
    paramf.b();
    paramf.a(f);
    paramf.a(this.m);
    paramf.b();
    paramf.a(g);
    paramf.a(this.n);
    paramf.b();
    if ((this.o != null) && (f()))
    {
      paramf.a(h);
      paramf.a(new org.apache.thrift.protocol.e((byte)11, (byte)8, this.o.size()));
      Iterator localIterator2 = this.o.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        paramf.a((String)localEntry2.getKey());
        paramf.a(((Integer)localEntry2.getValue()).intValue());
      }
      paramf.d();
      paramf.b();
    }
    if ((this.p != null) && (g()))
    {
      paramf.a(i);
      paramf.a(new org.apache.thrift.protocol.e((byte)8, (byte)8, this.p.size()));
      Iterator localIterator1 = this.p.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        paramf.a(((Integer)localEntry1.getKey()).intValue());
        paramf.a(((Integer)localEntry1.getValue()).intValue());
      }
      paramf.d();
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.q.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.q.get(0);
  }
  
  public d c(int paramInt)
  {
    this.n = paramInt;
    d(true);
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.q.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.q.get(1);
  }
  
  public void d(boolean paramBoolean)
  {
    this.q.set(3, paramBoolean);
  }
  
  public boolean d()
  {
    return this.q.get(2);
  }
  
  public boolean e()
  {
    return this.q.get(3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof d)) {
      return false;
    }
    return a((d)paramObject);
  }
  
  public boolean f()
  {
    return this.o != null;
  }
  
  public boolean g()
  {
    return this.p != null;
  }
  
  public void h()
  {
    if (this.j == null) {
      throw new g("Required field 'ip' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LandNodeInfo(");
    localStringBuilder.append("ip:");
    if (this.j == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("failed_count:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", ");
      localStringBuilder.append("success_count:");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", ");
      localStringBuilder.append("duration:");
      localStringBuilder.append(this.m);
      localStringBuilder.append(", ");
      localStringBuilder.append("size:");
      localStringBuilder.append(this.n);
      if (f())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("exp_info:");
        if (this.o != null) {
          break label235;
        }
        localStringBuilder.append("null");
      }
      label172:
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("http_info:");
        if (this.p != null) {
          break label247;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.j);
      break;
      label235:
      localStringBuilder.append(this.o);
      break label172;
      label247:
      localStringBuilder.append(this.p);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.common.logger.thrift.mfs.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */