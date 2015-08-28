package com.xiaomi.common.logger.thrift.mfs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class a
  implements Serializable, Cloneable, org.apache.thrift.b<a, a.a>
{
  public static final Map<a.a, org.apache.thrift.meta_data.b> a;
  private static final k b = new k("HostInfo");
  private static final org.apache.thrift.protocol.c c = new org.apache.thrift.protocol.c("host", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c d = new org.apache.thrift.protocol.c("land_node_info", (byte)15, (short)2);
  private String e;
  private List<d> f;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.a.class);
    localEnumMap.put(a.a.a, new org.apache.thrift.meta_data.b("host", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.a.b, new org.apache.thrift.meta_data.b("land_node_info", (byte)1, new org.apache.thrift.meta_data.d((byte)15, new org.apache.thrift.meta_data.g((byte)12, d.class))));
    a = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(a.class, a);
  }
  
  public a a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public a a(List<d> paramList)
  {
    this.f = paramList;
    return this;
  }
  
  public void a(f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      c();
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
        this.e = paramf.w();
      }
      else
      {
        i.a(paramf, localc.b);
        continue;
        if (localc.b == 15)
        {
          org.apache.thrift.protocol.d locald = paramf.m();
          this.f = new ArrayList(locald.b);
          for (int i = 0; i < locald.b; i++)
          {
            d locald1 = new d();
            locald1.a(paramf);
            this.f.add(locald1);
          }
          paramf.n();
        }
        else
        {
          i.a(paramf, localc.b);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.e != null;
  }
  
  public boolean a(a parama)
  {
    if (parama == null) {}
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
        bool2 = parama.a();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(parama.e))));
      bool3 = b();
      bool4 = parama.b();
    } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.f.equals(parama.f))));
    return true;
  }
  
  public int b(a parama)
  {
    int i;
    if (!getClass().equals(parama.getClass())) {
      i = getClass().getName().compareTo(parama.getClass().getName());
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            i = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parama.a()));
          } while (i != 0);
          if (!a()) {
            break;
          }
          i = org.apache.thrift.c.a(this.e, parama.e);
        } while (i != 0);
        i = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parama.b()));
      } while (i != 0);
      if (!b()) {
        break;
      }
      i = org.apache.thrift.c.a(this.f, parama.f);
    } while (i != 0);
    return 0;
  }
  
  public void b(f paramf)
  {
    c();
    paramf.a(b);
    if (this.e != null)
    {
      paramf.a(c);
      paramf.a(this.e);
      paramf.b();
    }
    if (this.f != null)
    {
      paramf.a(d);
      paramf.a(new org.apache.thrift.protocol.d((byte)12, this.f.size()));
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(paramf);
      }
      paramf.e();
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public boolean b()
  {
    return this.f != null;
  }
  
  public void c()
  {
    if (this.e == null) {
      throw new org.apache.thrift.protocol.g("Required field 'host' was not present! Struct: " + toString());
    }
    if (this.f == null) {
      throw new org.apache.thrift.protocol.g("Required field 'land_node_info' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof a)) {
      return false;
    }
    return a((a)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("HostInfo(");
    localStringBuilder.append("host:");
    if (this.e == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("land_node_info:");
      if (this.f != null) {
        break label90;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.e);
      break;
      label90:
      localStringBuilder.append(this.f);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.common.logger.thrift.mfs.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */