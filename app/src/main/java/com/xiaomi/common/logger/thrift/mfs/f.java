package com.xiaomi.common.logger.thrift.mfs;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.j;
import org.apache.thrift.protocol.k;

public class f
  implements Serializable, Cloneable, org.apache.thrift.b<f, f.a>
{
  public static final Map<f.a, org.apache.thrift.meta_data.b> a;
  private static final k b = new k("Passport");
  private static final org.apache.thrift.protocol.c c = new org.apache.thrift.protocol.c("category", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c d = new org.apache.thrift.protocol.c("uuid", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.c e = new org.apache.thrift.protocol.c("version", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c f = new org.apache.thrift.protocol.c("network", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.c g = new org.apache.thrift.protocol.c("rid", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.c h = new org.apache.thrift.protocol.c("location", (byte)12, (short)6);
  private static final org.apache.thrift.protocol.c i = new org.apache.thrift.protocol.c("host_info", (byte)14, (short)7);
  private String j = "";
  private String k;
  private String l;
  private String m;
  private String n;
  private e o;
  private Set<g> p;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(f.a.class);
    localEnumMap.put(f.a.a, new org.apache.thrift.meta_data.b("category", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(f.a.b, new org.apache.thrift.meta_data.b("uuid", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(f.a.c, new org.apache.thrift.meta_data.b("version", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(f.a.d, new org.apache.thrift.meta_data.b("network", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(f.a.e, new org.apache.thrift.meta_data.b("rid", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(f.a.f, new org.apache.thrift.meta_data.b("location", (byte)2, new org.apache.thrift.meta_data.g((byte)12, e.class)));
    localEnumMap.put(f.a.g, new org.apache.thrift.meta_data.b("host_info", (byte)2, new org.apache.thrift.meta_data.f((byte)14, new org.apache.thrift.meta_data.g((byte)12, g.class))));
    a = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(f.class, a);
  }
  
  public void a(org.apache.thrift.protocol.f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      h();
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
        this.j = paramf.w();
      }
      else
      {
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 11)
        {
          this.k = paramf.w();
        }
        else
        {
          i.a(paramf, localc.b);
          continue;
          if (localc.b == 11)
          {
            this.l = paramf.w();
          }
          else
          {
            i.a(paramf, localc.b);
            continue;
            if (localc.b == 11)
            {
              this.m = paramf.w();
            }
            else
            {
              i.a(paramf, localc.b);
              continue;
              if (localc.b == 11)
              {
                this.n = paramf.w();
              }
              else
              {
                i.a(paramf, localc.b);
                continue;
                if (localc.b == 12)
                {
                  this.o = new e();
                  this.o.a(paramf);
                }
                else
                {
                  i.a(paramf, localc.b);
                  continue;
                  if (localc.b == 14)
                  {
                    j localj = paramf.o();
                    this.p = new HashSet(2 * localj.b);
                    for (int i1 = 0; i1 < localj.b; i1++)
                    {
                      g localg = new g();
                      localg.a(paramf);
                      this.p.add(localg);
                    }
                    paramf.p();
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
  
  public boolean a()
  {
    return this.j != null;
  }
  
  public boolean a(f paramf)
  {
    if (paramf == null) {}
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
                  bool2 = paramf.a();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramf.j))));
                bool3 = b();
                bool4 = paramf.b();
              } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.k.equals(paramf.k))));
              bool5 = c();
              bool6 = paramf.c();
            } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.l.equals(paramf.l))));
            bool7 = d();
            bool8 = paramf.d();
          } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.m.equals(paramf.m))));
          bool9 = e();
          bool10 = paramf.e();
        } while (((bool9) || (bool10)) && ((!bool9) || (!bool10) || (!this.n.equals(paramf.n))));
        bool11 = f();
        bool12 = paramf.f();
      } while (((bool11) || (bool12)) && ((!bool11) || (!bool12) || (!this.o.a(paramf.o))));
      bool13 = g();
      bool14 = paramf.g();
    } while (((bool13) || (bool14)) && ((!bool13) || (!bool14) || (!this.p.equals(paramf.p))));
    return true;
  }
  
  public int b(f paramf)
  {
    int i1;
    if (!getClass().equals(paramf.getClass())) {
      i1 = getClass().getName().compareTo(paramf.getClass().getName());
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
                                i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramf.a()));
                              } while (i1 != 0);
                              if (!a()) {
                                break;
                              }
                              i1 = org.apache.thrift.c.a(this.j, paramf.j);
                            } while (i1 != 0);
                            i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramf.b()));
                          } while (i1 != 0);
                          if (!b()) {
                            break;
                          }
                          i1 = org.apache.thrift.c.a(this.k, paramf.k);
                        } while (i1 != 0);
                        i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramf.c()));
                      } while (i1 != 0);
                      if (!c()) {
                        break;
                      }
                      i1 = org.apache.thrift.c.a(this.l, paramf.l);
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramf.d()));
                  } while (i1 != 0);
                  if (!d()) {
                    break;
                  }
                  i1 = org.apache.thrift.c.a(this.m, paramf.m);
                } while (i1 != 0);
                i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramf.e()));
              } while (i1 != 0);
              if (!e()) {
                break;
              }
              i1 = org.apache.thrift.c.a(this.n, paramf.n);
            } while (i1 != 0);
            i1 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramf.f()));
          } while (i1 != 0);
          if (!f()) {
            break;
          }
          i1 = org.apache.thrift.c.a(this.o, paramf.o);
        } while (i1 != 0);
        i1 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramf.g()));
      } while (i1 != 0);
      if (!g()) {
        break;
      }
      i1 = org.apache.thrift.c.a(this.p, paramf.p);
    } while (i1 != 0);
    return 0;
  }
  
  public void b(org.apache.thrift.protocol.f paramf)
  {
    h();
    paramf.a(b);
    if (this.j != null)
    {
      paramf.a(c);
      paramf.a(this.j);
      paramf.b();
    }
    if (this.k != null)
    {
      paramf.a(d);
      paramf.a(this.k);
      paramf.b();
    }
    if (this.l != null)
    {
      paramf.a(e);
      paramf.a(this.l);
      paramf.b();
    }
    if (this.m != null)
    {
      paramf.a(f);
      paramf.a(this.m);
      paramf.b();
    }
    if (this.n != null)
    {
      paramf.a(g);
      paramf.a(this.n);
      paramf.b();
    }
    if ((this.o != null) && (f()))
    {
      paramf.a(h);
      this.o.b(paramf);
      paramf.b();
    }
    if ((this.p != null) && (g()))
    {
      paramf.a(i);
      paramf.a(new j((byte)12, this.p.size()));
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).b(paramf);
      }
      paramf.f();
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public boolean b()
  {
    return this.k != null;
  }
  
  public boolean c()
  {
    return this.l != null;
  }
  
  public boolean d()
  {
    return this.m != null;
  }
  
  public boolean e()
  {
    return this.n != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof f)) {
      return false;
    }
    return a((f)paramObject);
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
      throw new org.apache.thrift.protocol.g("Required field 'category' was not present! Struct: " + toString());
    }
    if (this.k == null) {
      throw new org.apache.thrift.protocol.g("Required field 'uuid' was not present! Struct: " + toString());
    }
    if (this.l == null) {
      throw new org.apache.thrift.protocol.g("Required field 'version' was not present! Struct: " + toString());
    }
    if (this.m == null) {
      throw new org.apache.thrift.protocol.g("Required field 'network' was not present! Struct: " + toString());
    }
    if (this.n == null) {
      throw new org.apache.thrift.protocol.g("Required field 'rid' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Passport(");
    localStringBuilder.append("category:");
    if (this.j == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("uuid:");
      if (this.k != null) {
        break label259;
      }
      localStringBuilder.append("null");
      label65:
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      if (this.l != null) {
        break label271;
      }
      localStringBuilder.append("null");
      label96:
      localStringBuilder.append(", ");
      localStringBuilder.append("network:");
      if (this.m != null) {
        break label283;
      }
      localStringBuilder.append("null");
      label127:
      localStringBuilder.append(", ");
      localStringBuilder.append("rid:");
      if (this.n != null) {
        break label295;
      }
      localStringBuilder.append("null");
      label158:
      if (f())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("location:");
        if (this.o != null) {
          break label307;
        }
        localStringBuilder.append("null");
      }
      label196:
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("host_info:");
        if (this.p != null) {
          break label319;
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
      label259:
      localStringBuilder.append(this.k);
      break label65;
      label271:
      localStringBuilder.append(this.l);
      break label96;
      label283:
      localStringBuilder.append(this.m);
      break label127;
      label295:
      localStringBuilder.append(this.n);
      break label158;
      label307:
      localStringBuilder.append(this.o);
      break label196;
      label319:
      localStringBuilder.append(this.p);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.common.logger.thrift.mfs.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */