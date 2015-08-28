package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class f
  implements Serializable, Cloneable, org.apache.thrift.b<f, f.a>
{
  public static final Map<f.a, org.apache.thrift.meta_data.b> d;
  private static final k e = new k("StatsEvents");
  private static final org.apache.thrift.protocol.c f = new org.apache.thrift.protocol.c("uuid", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c g = new org.apache.thrift.protocol.c("operator", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.c h = new org.apache.thrift.protocol.c("events", (byte)15, (short)3);
  public String a;
  public String b;
  public List<e> c;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(f.a.class);
    localEnumMap.put(f.a.a, new org.apache.thrift.meta_data.b("uuid", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(f.a.b, new org.apache.thrift.meta_data.b("operator", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(f.a.c, new org.apache.thrift.meta_data.b("events", (byte)1, new org.apache.thrift.meta_data.d((byte)15, new org.apache.thrift.meta_data.g((byte)12, e.class))));
    d = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(f.class, d);
  }
  
  public f() {}
  
  public f(String paramString, List<e> paramList)
  {
    this();
    this.a = paramString;
    this.c = paramList;
  }
  
  public f a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void a(org.apache.thrift.protocol.f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      d();
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
        if (localc.b == 11)
        {
          this.b = paramf.w();
        }
        else
        {
          i.a(paramf, localc.b);
          continue;
          if (localc.b == 15)
          {
            org.apache.thrift.protocol.d locald = paramf.m();
            this.c = new ArrayList(locald.b);
            for (int i = 0; i < locald.b; i++)
            {
              e locale = new e();
              locale.a(paramf);
              this.c.add(locale);
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
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(f paramf)
  {
    if (paramf == null) {}
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
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramf.a))));
        bool3 = b();
        bool4 = paramf.b();
      } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.b.equals(paramf.b))));
      bool5 = c();
      bool6 = paramf.c();
    } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.c.equals(paramf.c))));
    return true;
  }
  
  public int b(f paramf)
  {
    int i;
    if (!getClass().equals(paramf.getClass())) {
      i = getClass().getName().compareTo(paramf.getClass().getName());
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
                return i;
                i = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramf.a()));
              } while (i != 0);
              if (!a()) {
                break;
              }
              i = org.apache.thrift.c.a(this.a, paramf.a);
            } while (i != 0);
            i = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramf.b()));
          } while (i != 0);
          if (!b()) {
            break;
          }
          i = org.apache.thrift.c.a(this.b, paramf.b);
        } while (i != 0);
        i = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramf.c()));
      } while (i != 0);
      if (!c()) {
        break;
      }
      i = org.apache.thrift.c.a(this.c, paramf.c);
    } while (i != 0);
    return 0;
  }
  
  public void b(org.apache.thrift.protocol.f paramf)
  {
    d();
    paramf.a(e);
    if (this.a != null)
    {
      paramf.a(f);
      paramf.a(this.a);
      paramf.b();
    }
    if ((this.b != null) && (b()))
    {
      paramf.a(g);
      paramf.a(this.b);
      paramf.b();
    }
    if (this.c != null)
    {
      paramf.a(h);
      paramf.a(new org.apache.thrift.protocol.d((byte)12, this.c.size()));
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).b(paramf);
      }
      paramf.e();
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
  
  public void d()
  {
    if (this.a == null) {
      throw new org.apache.thrift.protocol.g("Required field 'uuid' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new org.apache.thrift.protocol.g("Required field 'events' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof f)) {
      return false;
    }
    return a((f)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StatsEvents(");
    localStringBuilder.append("uuid:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (b())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("operator:");
        if (this.b != null) {
          break label128;
        }
        localStringBuilder.append("null");
      }
      label72:
      localStringBuilder.append(", ");
      localStringBuilder.append("events:");
      if (this.c != null) {
        break label140;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label128:
      localStringBuilder.append(this.b);
      break label72;
      label140:
      localStringBuilder.append(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.xmpush.thrift.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */