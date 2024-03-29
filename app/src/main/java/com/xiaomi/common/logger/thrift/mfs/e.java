package com.xiaomi.common.logger.thrift.mfs;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class e
  implements Serializable, Cloneable, org.apache.thrift.b<e, e.a>
{
  public static final Map<e.a, org.apache.thrift.meta_data.b> a;
  private static final k b = new k("Location");
  private static final org.apache.thrift.protocol.c c = new org.apache.thrift.protocol.c("contry", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.c d = new org.apache.thrift.protocol.c("province", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.c e = new org.apache.thrift.protocol.c("city", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.c f = new org.apache.thrift.protocol.c("isp", (byte)11, (short)4);
  private String g;
  private String h;
  private String i;
  private String j;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(e.a.class);
    localEnumMap.put(e.a.a, new org.apache.thrift.meta_data.b("contry", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(e.a.b, new org.apache.thrift.meta_data.b("province", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(e.a.c, new org.apache.thrift.meta_data.b("city", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(e.a.d, new org.apache.thrift.meta_data.b("isp", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    a = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(e.class, a);
  }
  
  public e a(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public void a(f paramf)
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
  
  public boolean a()
  {
    return this.g != null;
  }
  
  public boolean a(e parame)
  {
    if (parame == null) {}
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
            bool2 = parame.a();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(parame.g))));
          bool3 = b();
          bool4 = parame.b();
        } while (((bool3) || (bool4)) && ((!bool3) || (!bool4) || (!this.h.equals(parame.h))));
        bool5 = c();
        bool6 = parame.c();
      } while (((bool5) || (bool6)) && ((!bool5) || (!bool6) || (!this.i.equals(parame.i))));
      bool7 = d();
      bool8 = parame.d();
    } while (((bool7) || (bool8)) && ((!bool7) || (!bool8) || (!this.j.equals(parame.j))));
    return true;
  }
  
  public int b(e parame)
  {
    int k;
    if (!getClass().equals(parame.getClass())) {
      k = getClass().getName().compareTo(parame.getClass().getName());
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
                    k = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parame.a()));
                  } while (k != 0);
                  if (!a()) {
                    break;
                  }
                  k = org.apache.thrift.c.a(this.g, parame.g);
                } while (k != 0);
                k = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parame.b()));
              } while (k != 0);
              if (!b()) {
                break;
              }
              k = org.apache.thrift.c.a(this.h, parame.h);
            } while (k != 0);
            k = Boolean.valueOf(c()).compareTo(Boolean.valueOf(parame.c()));
          } while (k != 0);
          if (!c()) {
            break;
          }
          k = org.apache.thrift.c.a(this.i, parame.i);
        } while (k != 0);
        k = Boolean.valueOf(d()).compareTo(Boolean.valueOf(parame.d()));
      } while (k != 0);
      if (!d()) {
        break;
      }
      k = org.apache.thrift.c.a(this.j, parame.j);
    } while (k != 0);
    return 0;
  }
  
  public e b(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void b(f paramf)
  {
    e();
    paramf.a(b);
    if ((this.g != null) && (a()))
    {
      paramf.a(c);
      paramf.a(this.g);
      paramf.b();
    }
    if ((this.h != null) && (b()))
    {
      paramf.a(d);
      paramf.a(this.h);
      paramf.b();
    }
    if ((this.i != null) && (c()))
    {
      paramf.a(e);
      paramf.a(this.i);
      paramf.b();
    }
    if ((this.j != null) && (d()))
    {
      paramf.a(f);
      paramf.a(this.j);
      paramf.b();
    }
    paramf.c();
    paramf.a();
  }
  
  public boolean b()
  {
    return this.h != null;
  }
  
  public e c(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.i != null;
  }
  
  public e d(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.j != null;
  }
  
  public void e() {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof e)) {
      return false;
    }
    return a((e)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    int k = 0;
    StringBuilder localStringBuilder = new StringBuilder("Location(");
    int m = 1;
    if (a())
    {
      localStringBuilder.append("contry:");
      if (this.g == null)
      {
        localStringBuilder.append("null");
        m = 0;
      }
    }
    else
    {
      if (b())
      {
        if (m == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("province:");
        if (this.h != null) {
          break label187;
        }
        localStringBuilder.append("null");
        label83:
        m = 0;
      }
      if (!c()) {
        break label225;
      }
      if (m == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("city:");
      if (this.i != null) {
        break label199;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      label124:
      if (d())
      {
        if (k == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("isp:");
        if (this.j != null) {
          break label213;
        }
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.g);
        break;
        label187:
        localStringBuilder.append(this.h);
        break label83;
        label199:
        localStringBuilder.append(this.i);
        k = 0;
        break label124;
        label213:
        localStringBuilder.append(this.j);
      }
      label225:
      k = m;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.common.logger.thrift.mfs.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */