package com.xiaomi.common.logger.thrift.mfs;

import com.xiaomi.common.logger.thrift.a;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class c
  implements Serializable, Cloneable, org.apache.thrift.b<c, c.a>
{
  public static final Map<c.a, org.apache.thrift.meta_data.b> a;
  private static final k b = new k("HttpLog");
  private static final org.apache.thrift.protocol.c c = new org.apache.thrift.protocol.c("common", (byte)12, (short)1);
  private static final org.apache.thrift.protocol.c d = new org.apache.thrift.protocol.c("category", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.c e = new org.apache.thrift.protocol.c("httpApi", (byte)12, (short)3);
  private static final org.apache.thrift.protocol.c f = new org.apache.thrift.protocol.c("passport", (byte)12, (short)4);
  private a g;
  private String h = "";
  private b i;
  private f j;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(c.a.class);
    localEnumMap.put(c.a.a, new org.apache.thrift.meta_data.b("common", (byte)1, new org.apache.thrift.meta_data.g((byte)12, a.class)));
    localEnumMap.put(c.a.b, new org.apache.thrift.meta_data.b("category", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(c.a.c, new org.apache.thrift.meta_data.b("httpApi", (byte)2, new org.apache.thrift.meta_data.g((byte)12, b.class)));
    localEnumMap.put(c.a.d, new org.apache.thrift.meta_data.b("passport", (byte)2, new org.apache.thrift.meta_data.g((byte)12, f.class)));
    a = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(c.class, a);
  }
  
  public c a(a parama)
  {
    this.g = parama;
    return this;
  }
  
  public c a(b paramb)
  {
    this.i = paramb;
    return this;
  }
  
  public c a(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void a(org.apache.thrift.protocol.f paramf)
  {
    paramf.g();
    org.apache.thrift.protocol.c localc = paramf.i();
    if (localc.b == 0)
    {
      paramf.h();
      e();
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
      if (localc.b == 12)
      {
        this.g = new a();
        this.g.a(paramf);
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
          if (localc.b == 12)
          {
            this.i = new b();
            this.i.a(paramf);
          }
          else
          {
            i.a(paramf, localc.b);
            continue;
            if (localc.b == 12)
            {
              this.j = new f();
              this.j.a(paramf);
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
  
  public boolean a()
  {
    return this.g != null;
  }
  
  public boolean a(c paramc)
  {
    if (paramc == null) {}
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
            bool2 = paramc.a();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.a(paramc.g))));
          bool3 = b();
          bool4 = paramc.b();
        } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.h.equals(paramc.h))));
        bool5 = c();
        bool6 = paramc.c();
      } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.i.a(paramc.i))));
      bool7 = d();
      bool8 = paramc.d();
    } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.j.a(paramc.j))));
    return true;
  }
  
  public int b(c paramc)
  {
    int k;
    if (!getClass().equals(paramc.getClass())) {
      k = getClass().getName().compareTo(paramc.getClass().getName());
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
                    return k;
                    k = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramc.a()));
                  } while (k != 0);
                  if (!a()) {
                    break;
                  }
                  k = org.apache.thrift.c.a(this.g, paramc.g);
                } while (k != 0);
                k = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramc.b()));
              } while (k != 0);
              if (!b()) {
                break;
              }
              k = org.apache.thrift.c.a(this.h, paramc.h);
            } while (k != 0);
            k = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramc.c()));
          } while (k != 0);
          if (!c()) {
            break;
          }
          k = org.apache.thrift.c.a(this.i, paramc.i);
        } while (k != 0);
        k = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramc.d()));
      } while (k != 0);
      if (!d()) {
        break;
      }
      k = org.apache.thrift.c.a(this.j, paramc.j);
    } while (k != 0);
    return 0;
  }
  
  public void b(org.apache.thrift.protocol.f paramf)
  {
    e();
    paramf.a(b);
    if (this.g != null)
    {
      paramf.a(c);
      this.g.b(paramf);
      paramf.b();
    }
    if (this.h != null)
    {
      paramf.a(d);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (c()))
    {
      paramf.a(e);
      this.i.b(paramf);
      paramf.b();
    }
    if ((this.j != null) && (d()))
    {
      paramf.a(f);
      this.j.b(paramf);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public boolean b()
  {
    return this.h != null;
  }
  
  public boolean c()
  {
    return this.i != null;
  }
  
  public boolean d()
  {
    return this.j != null;
  }
  
  public void e()
  {
    if (this.g == null) {
      throw new org.apache.thrift.protocol.g("Required field 'common' was not present! Struct: " + toString());
    }
    if (this.h == null) {
      throw new org.apache.thrift.protocol.g("Required field 'category' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof c)) {
      return false;
    }
    return a((c)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("HttpLog(");
    localStringBuilder.append("common:");
    if (this.g == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("category:");
      if (this.h != null) {
        break label166;
      }
      localStringBuilder.append("null");
      label65:
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("httpApi:");
        if (this.i != null) {
          break label178;
        }
        localStringBuilder.append("null");
      }
      label103:
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("passport:");
        if (this.j != null) {
          break label190;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.g);
      break;
      label166:
      localStringBuilder.append(this.h);
      break label65;
      label178:
      localStringBuilder.append(this.i);
      break label103;
      label190:
      localStringBuilder.append(this.j);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.common.logger.thrift.mfs.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */